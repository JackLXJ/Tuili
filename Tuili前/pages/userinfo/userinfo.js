var app = getApp()

Page ({
    data: {
        user_info: null,
        zan: 0,
        collect: 0
    },

    onLoad : function (options) {
        console.log(options)
        let that = this;
        that.setData ({
            zan: options.zan,
            collect: options.collect
        })
        that.get_userinfo()
    },

    get_userinfo: function () {
        let that = this;
        var openid = wx.getStorageSync("openid")
        wx.request({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "findUserByOpenid",
                openid: openid
            },
            success: function (res) {
                if (res.statusCode == 200) {
                    console.log(res.data)
                    that.setData({
                        user_info: res.data
                    })
                }
            }
        })
    }
})
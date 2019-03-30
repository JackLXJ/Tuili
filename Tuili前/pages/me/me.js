var app = getApp()

Page ({
    data: {
        userinfo: null,
        collect: 0,
        zan: 0,
        zan_data: null,
        collect_data: null
    },

    onShow : function () {
        this.get_userinfo()
        this.get_zan_collect()
    },

    // onLoad : function () {
    //     // console.log("dasdasdasdasdasd")
    //     this.get_userinfo()
    //     this.get_zan_collect()
    // }, 

    get_zan_collect () {
        let that = this;
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "getAllZanCollect",
                openid: wx.getStorageSync("openid"),
                way: "zan"
            },
            success : function (res) {
                if (res.statusCode == 200) {
                    that.setData ({zan: res.data.length, zan_data: res.data})
                }
            }
        })
        wx.request({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "getAllZanCollect",
                openid: wx.getStorageSync("openid"),
                way: "collect"
            },
            success: function (res) {
                if (res.statusCode == 200) {
                    that.setData({ collect: res.data.length, collect_data: res.data })
                }
            }
        })
    },

    go_collect : function (e) {
        var problem_ids = ""
        for (var i=0; i<this.data.collect_data.length; i++) {
            // console.log(this.data.collect_data[i])
            problem_ids += this.data.collect_data[i].problem_id + "|"
        }

        // console.log(this.data.collect_data)
        wx.navigateTo({
            url: '/pages/zancollect/zancollect?data=' + problem_ids
        })
    },

    go_zan : function (e) {
        var problem_ids = ""
        for (var i = 0; i < this.data.zan_data.length; i++) {
            // console.log(this.data.zan_data[i])
            problem_ids += this.data.zan_data[i].problem_id + "|"
        }
        wx.navigateTo({
            url: "/pages/zancollect/zancollect?data=" + problem_ids
        })
    },

    go_user_info : function (e) {
        let that = this
        console.log(e)
        console.log('/pages/userinfo/userinfo?zan=' + that.data.zan + "&collect=" + that.data.collect)
        wx.navigateTo({
            url: '/pages/userinfo/userinfo?zan=' + that.data.zan + "&collect=" + that.data.collect,
        })
    },

    get_userinfo : function () {
        console.log("难道没有请求到么")
        let that = this;
        var openid = wx.getStorageSync("openid")
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "findUserByOpenid",
                openid: openid
            },
            success : function (res) {
                if (res.statusCode == 200) {
                    that.setData({
                        userinfo: res.data
                    })
                }
            }
        })
    }
})
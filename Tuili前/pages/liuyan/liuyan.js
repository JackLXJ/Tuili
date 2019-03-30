var app = getApp()
var util = require("../../utils/util.js")

Page ({
    data: {
        userinfo: null,
        liuyan_data: null,
        input_value: ""
    },

    onShow : function () {
        wx.setNavigationBarTitle({
            title: '留言板',
        })
        this.get_userinfo()
        this.get_all_liuyan()
    },

    get_all_liuyan: function () {
        let that = this;
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Comment",
            data: {
                status: "getAllLiuyan",
            },
            success : function (res) {
                // console.log(res)
                var data = res.data
                for (let i in data) {
                    var to_time = util.tsFormatTime(data[i].liuyan_time * 1000, "Y-M-D h:m:s");
                    data[i].liuyan_time = to_time;
                }
                that.setData({
                    liuyan_data: data,
                })
            }
        })
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
                    that.setData({
                        userinfo: res.data
                    })
                }
            }
        })
    },

    add_liuyan : function (e) {
        
        // console.log(e)
        wx.showToast({
            title: '留言成功',
        })
        let that = this;
        // console.log(that.data.userinfo)
        // console.log(that.data.userinfo.user_image)
        // console.log(that.data.userinfo)
        var liuyan = e.detail.value.liuyan
        // console.log(liuyan)
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Comment",
            data: {
                status: "addLiuyan",
                liuyan: liuyan,
                user_name: that.data.userinfo.user_name,
                user_image: that.data.userinfo.user_image,
                openid: wx.getStorageSync("openid")
            },
            header: { 'content-type': 'application/x-www-form-urlencoded;charset=utf-8'},
            success : function () {
                that.setData ({
                    input_value: ""
                })
                that.get_all_liuyan()
            }
        })
    }
})
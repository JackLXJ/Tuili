const app = getApp();
Page({
    data: {
        //判断小程序的API，回调，参数，组件等是否在当前版本可用。
        canIUse: wx.canIUse('button.open-type.getUserInfo')
    },

    // onReady : function () {
    //     if (wx.getStorageSync("openid")) {
    //         wx.navigateTo({
    //             url: '/pages/welcome/welcome',
    //         })
    //     }
    // },

    onLoad: function () {
        var that = this;

        // 查看是否授权
        wx.getSetting({
            success: function (res) {
                if (res.authSetting['scope.userInfo']) {
                    wx.showToast({
                        title: '欢迎回来！',
                    })
                    setTimeout(function () {
                        wx.hideToast()
                    }, 3000)
                    wx.getUserInfo({
                        success: function (res) {
                            //从数据库获取用户信息
                            that.queryUsreInfo();
                            //用户已经授权过
                            wx.navigateTo({
                                url: '/pages/welcome/welcome'
                            })
                        }
                    });
                }
            }
        })
        this.set_data()
    },

    set_data : function () {
        wx.login({
            success : function(res) {
                var code = res.code
                console.log("这个是openid")
                console.log(res)
                wx.request({
                    url: 'https://api.weixin.qq.com/sns/jscode2session',
                    data: {
                        "appid": "XXXXXX",
                        "secret": "XXXXXX",
                        "js_code": code,
                        "grant_type": "authorization_code"
                    },
                    success: function (res) {
                        wx.setStorageSync("openid", res.data.openid)
                    }
                })
            }
        })
    },

    bindGetUserInfo: function (e) {
        
        if (e.detail.userInfo) {
            //用户按了允许授权按钮
            var that = this;
            // console.log(e.detail.userInfo.nickName)
            //插入登录的用户的相关信息到数据库
            wx.request({
                url: app.globalData.domain_url + "/Tuili/User",
                data: {
                    status: "addUser",
                    openid: wx.getStorageSync('openid'),
                    user_name: e.detail.userInfo.nickName,
                    user_image: e.detail.userInfo.avatarUrl,
                    province: e.detail.userInfo.province,
                    city: e.detail.userInfo.city
                },
                header: {
                    'content-type': 'application/json'
                },
                success: function (res) {
                    //从数据库获取用户信息
                    that.queryUsreInfo();
                    console.log("插入小程序登录用户信息成功！");
                }
            });
            //授权成功后，跳转进入小程序首页
            wx.navigateTo({
                url: "/pages/welcome/welcome"
            })
        } else {
            //用户按了拒绝按钮
            wx.showModal({
                title: '警告',
                content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
                showCancel: false,
                confirmText: '返回授权',
                success: function (res) {
                    if (res.confirm) {
                        console.log('用户点击了“返回授权”')
                    }
                }
            })
        }                        
    },
    //获取用户信息接口
    queryUsreInfo: function () {
        wx.request({
            url: app.globalData.domain_url + '/Tuili/User',
            data: {
                status: "findUserByOpenid",
                openid: wx.getStorageSync("openid")
            },
            header: {
                'content-type': 'application/json'
            },
            success: function (res) {
                console.log(res.data);
                getApp().globalData.userInfo = res.data;
            }
        })
    },

})

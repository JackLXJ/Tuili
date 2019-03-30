var util = require("../../utils/util.js")
var app = getApp()


Page ({
    data: {
        haibao_urls: [
            "XXXXXX/uploads/images/haibao/haibao_image/1.jpg",
            "XXXXXX/uploads/images/haibao/haibao_image/2.jpg",
            "XXXXXX/uploads/images/haibao/haibao_image/3.png"
        ],
        detective_data: null,
        detective_length: 0,
        win_height: 0,
        storage_data: null,
        zan_status: [],
        collect_status: [],
        zan: 0,
        collect: 0,
        categories: ["400-420", "360-400", "320-360", "280-320", "240-280", "200-240", "160-200", "120-160", "80-120","40-80", "0-40"],
        activeCategoryId: "400-420"
    },

    // onShow : function () {
    //     let that = this;
    //     that.setData({
    //         storage_data: wx.getStorageSync("storage_data")
    //     })
    //     console.log(wx.getStorageSync("storage_data"))
    //     this.get_win_height();
    //     this.get_haibao_urls();
    //     this.get_data();
    // },

    onLoad : function () {
        let that = this;
        that.setData ({
            storage_data: wx.getStorageSync("storage_data")
        })
        console.log(wx.getStorageSync("storage_data"))
        this.get_win_height();        
        this.get_data();
    },

    reload_data : function () {
        let that = this;
        var left_right = that.data.activeCategoryId.split("-");
        // console.log(left_right)
        wx.request({
            url: app.globalData.domain_url + "/Tuili/Articles?status=getAllArticles",
            data: {
                left: parseInt(left_right[0])+10,
                right: left_right[1] - left_right[0]
            },
            success: function (res) {
                // console.log(res.data.slice(0,10))
                if (res.statusCode == 200) {
                    that.setData({
                        detective_data: res.data,
                        detective_length: 40,
                    })
                }
            }
        })
    },

    add_zan_count : function (id) {
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Storage?status=addZanCount&id=" + id,
        })
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "addZanCollect",
                openid: wx.getStorageSync("openid"),
                problem_id: id,
                way: "zan"
            }
        })
        this.reload_data() 
    },

    cut_zan_count : function (id) {
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Storage?status=cutZanCount&id=" + id
        })
        wx.request({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "cutZanCollect",
                openid: wx.getStorageSync("openid"),
                problem_id: id,
                way: "zan"
            }
        })
        this.reload_data()
    },

    add_collect_count : function (id) {
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Storage?status=addCollectCount&id=" + id,
        })
        wx.request({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "addZanCollect",
                openid: wx.getStorageSync("openid"),
                problem_id: id,
                way: "collect"
            }
        })
        this.reload_data()
    },

    cut_collect_count : function (id) {
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Storage?status=cutCollectCount&id=" + id
        })
        wx.request({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "cutZanCollect",
                openid: wx.getStorageSync("openid"),
                problem_id: id,
                way: "collect"
            }
        })
        this.reload_data()
    },

    add_watch_count : function (id) {
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Articles?status=addWatchCount&id=" + id
        })
        this.reload_data()
    },

    change_zan_status : function (e) {
        console.log(e)
        let that = this;
        var temp_id = e.currentTarget.id;
        var data_list = this.data.storage_data;
        for (let i in data_list) {
            if (i == temp_id) {
                if (data_list[i-1].zan_status == 0) {
                    this.add_zan_count(i)
                    data_list[i-1].zan_status = 1
                    // data_list[i-1].zan_count = data_list[i-1].zan_count + 1
                    that.setData ({
                        zan: 1
                    })
                    // that.get_data()
                    wx.showToast({
                        title: '谢谢您的赞！',
                        image: "/images/icons/smile.png"
                    })
                }else {
                    this.cut_zan_count(i)
                    data_list[i-1].zan_status = 0
                    // data_list[i-1].zan_count = data_list[i-1].zan_count - 1
                    that.setData({
                        zan: 1
                    })
                    wx.showToast({
                        title: '取消赞干嘛？',
                        image: "/images/icons/angry.png"
                    })
                }
            }
        }
        wx.setStorageSync("storage_data", data_list)
        that.setData ({
            storage_data: data_list
        })
    },

    change_collect_status : function (e) {
        let that = this;
        var temp_id = e.currentTarget.id;
        var data_list = this.data.storage_data;
        for (let i in data_list) {
            if (i == temp_id) {
                if (data_list[i - 1].collect_status == 0) {
                    this.add_collect_count(i)
                    data_list[i - 1].collect_status = 1
                    // data_list[i - 1].collect_count = data_list[i - 1].collect_count + 1
                    that.setData({  
                        collect: 1
                    })
                    wx.showToast({
                        title: '谢谢您的收藏！',
                        image: "/images/icons/smile.png"
                    })
                } else {
                    this.cut_collect_count(i)
                    data_list[i - 1].collect_status = 0
                    // data_list[i - 1].collect_count = data_list[i - 1].collect_count - 1
                    that.setData({
                        collect: 1
                    })
                    wx.showToast({
                        title: '取消收藏干嘛？',
                        image: "/images/icons/angry.png"
                    })
                }
            }
        }
        wx.setStorageSync("storage_data", data_list)
        that.setData({
            storage_data: data_list
        })
    },

    get_win_height : function () {
        let that = this;
        wx.getSystemInfo({
            success: function(res) {
                that.setData ({
                    win_height: res.windowHeight
                })
            },
        })
    },

    // get_data : function () {
    //     // console.log(util)
    //     let that = this;
    //     var data = util.get_data();
    //     // console.log(data)
    //     that.setData ({
    //         detective_data: data.data,
    //         detective_length: data.data.length
    //     })
    // },

    look_detail : function (e) {
        this.add_watch_count(e.currentTarget.id)
        if (e.currentTarget.id) {
            wx.navigateTo ({
                url: '../detDetail/detDetail?id=' + e.currentTarget.id,
            })
        }
    },

    // onReachBottom : function (e) {
    //     console.log(1)
    // },

    // onReachBottom : function (e) {
    //     wx.showToast({
    //         title: '成功',
    //         icon: 'success',
    //         duration: 2000
    //     })
    //     let that = this;
    //     let flag = that.data.page
    //     var data = that.data.detective_data
    //     var temp_data = null
    //     wx.request({
    //         url: app.globalData.domain_url + "/Tuili/Articles?status=getAllArticles",
    //         success: function (res) {
    //             // console.log(res.data.slice(0,10))
    //             if (res.statusCode == 200) {
    //                 temp_data = data.concat(res.data.slice((flag - 1) * 10, flag * 10))
    //             }
    //             that.setData ({
    //                 page: flag-1,
    //                 detective_data: temp_data
    //             })
    //         },
    //     })
    //     wx.hideToast()
    // },

    change_data : function (e) {
        wx.showLoading({
            title: '正在加载数据',
        })
        let that = this
        // let flag = app.globalData.page
        var left_right = e.currentTarget.id.split("-")

        wx.request({
            url: app.globalData.domain_url + "/Tuili/Articles?status=getAllArticles",
            data: {
                left: parseInt(left_right[0])+10,
                right: left_right[1] - left_right[0]
            },  
            success: function (res) {
                // console.log(res.data.slice(0,10))
                if (res.statusCode == 200) {
                    that.setData({
                        detective_data: res.data,
                        detective_length: 40,
                    })
                }
            }
        })

        that.setData({ activeCategoryId: e.currentTarget.id})
        setTimeout(function () {
            wx.hideLoading()
        }, 1000)
    },

    get_data: function () {
        let that = this;
        wx.request({
            url: app.globalData.domain_url + "/Tuili/Articles?status=getAllArticles",
            data: {
                left: 410,
                right: 20
            },
            success: function (res) {
                console.log(res.data)
                if (res.statusCode == 200) {
                    that.setData({
                        detective_data: res.data,
                        detective_length: 40,
                    })
                }
            }
        })
    },


    // upper: function () {
    //     wx.showNavigationBarLoading()
    //     this.refresh();
    //     console.log("upper");
    //     setTimeout(function () { wx.hideNavigationBarLoading(); wx.stopPullDownRefresh(); }, 2000);
    // },
    // lower: function (e) {
    //     wx.showNavigationBarLoading();
    //     var that = this;
    //     setTimeout(function () { wx.hideNavigationBarLoading(); that.get_data(); }, 1000);
    //     console.log("lower")
    // },

    // refresh: function () {
    //     wx.showToast({
    //         title: '刷新中',
    //         icon: 'loading',
    //         duration: 3000
    //     });
    //     var data = util.get_data();
    //     console.log("loaddata2");
    //     var detective_data = data.data;
    //     this.setData({
    //         detective_data: detective_data,
    //         detective_length: detective_data.length
    //     });
    //     setTimeout(function () {
    //         wx.showToast({
    //             title: '刷新成功',
    //             icon: 'success',
    //             duration: 2000
    //         })
    //     }, 3000)

    // },

    // //使用本地 fake 数据实现继续加载效果
    // nextLoad: function () {
    //     wx.showToast({
    //         title: '加载中',
    //         icon: 'loading',
    //         duration: 4000
    //     })
    //     var next = util.get_data();
    //     console.log("continueload");
    //     var next_data = next.data;
    //     this.setData({
    //         detective_data: this.data.detective_data.concat(next_data),
    //         detective_data: this.data.detective_length + next_data.length
    //     });
    //     setTimeout(function () {
    //         wx.showToast({
    //             title: '加载成功',
    //             icon: 'success',
    //             duration: 2000
    //         })
    //     }, 3000)
    // }
})
var app = getApp()

Page ({

    data: {
        detective_data: null,
        ids: "",
        detective_length: 0,
        win_height: 0,
        storage_data: null,
        zan_status: [],
        collect_status: [],
        zan: 0,
        collect: 0,
        collect_data: null,
        zan_data: null
    },

    // onShow : function () {
    //     let that = this;
    //     this.get_zan_collect()
    //     that.setData({
    //         storage_data: wx.getStorageSync("storage_data")
    //     })
    //     that.setData({ ids: options.data })
    //     this.find_detective_byid(options.data)
    // },

    onLoad : function (options) {
        let that = this;
        this.get_zan_collect()
        that.setData({
            storage_data: wx.getStorageSync("storage_data")
        })
        that.setData ({ids: options.data})
        this.find_detective_byid(options.data)
        // this.re_load()
        // var ids = options.data.split("|").slice(0, -1)
        // this.find_detective_byid(options.data)
        // for (var i=0; i<ids.length; i++) {
        //     // console.log(ids[i])
        //     this.find_detective_byid(ids[i])
        // }

        // console.log(options.data.split("|").slice(0,-1))
    },

    // re_load : function () {
    //     let that = this;
    //     that.find_detective_byid(that.data.ids)
    // },

    get_zan_collect() {
        let that = this;
        wx.request({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "getAllZanCollect",
                openid: wx.getStorageSync("openid"),
                way: "zan"
            },
            success: function (res) {
                if (res.statusCode == 200) {
                    that.setData({ zan: res.data.length, zan_data: res.data })
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

    go_collect: function (e) {
        var problem_ids = ""
        for (var i = 0; i < this.data.collect_data.length; i++) {
            // console.log(this.data.collect_data[i])
            problem_ids += this.data.collect_data[i].problem_id + "|"
        }

        // console.log(this.data.collect_data)
        wx.navigateTo({
            url: '/pages/zancollect/zancollect?data=' + problem_ids
        })
    },

    go_zan: function (e) {
        var problem_ids = ""
        for (var i = 0; i < this.data.zan_data.length; i++) {
            // console.log(this.data.zan_data[i])
            problem_ids += this.data.zan_data[i].problem_id + "|"
        }
        wx.navigateTo({
            url: "/pages/zancollect/zancollect?data=" + problem_ids
        })
    },

    find_detective_byid : function (ids) {
        let that = this;
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Articles",
            data: {
                status: "findByIds",
                ids: ids
            },
            success : function (res) {
                // console.log(res)
                that.setData({
                    detective_data: res.data
                })
            }
        })
    },

    look_detail: function (e) {
        this.add_watch_count(e.currentTarget.id)
        if (e.currentTarget.id) {
            wx.navigateTo({
                url: '../detDetail/detDetail?id=' + e.currentTarget.id,
            })
        }
    },

    add_watch_count: function (id) {
        let that = this;
        wx.request({
            url: app.globalData.domain_url + "/Tuili/Articles?status=addWatchCount&id=" + id
        })
        // that.re_load()
    },

    add_zan_count: function (id) {
        wx.request({
            url: app.globalData.domain_url + "/Tuili/Storage?status=addZanCount&id=" + id,
        })
        wx.request({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "addZanCollect",
                openid: wx.getStorageSync("openid"),
                problem_id: id,
                way: "zan"
            }
        })
        // this.go_zan()
    },

    cut_zan_count: function (id) {
        wx.request({
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
        // this.go_zan()
    },

    add_collect_count: function (id) {
        wx.request({
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
        // this.go_collect()
    },

    cut_collect_count: function (id) {
        wx.request({
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
        // this.go_collect()
    },

    change_zan_status: function (e) {
        let that = this;
        var temp_id = e.currentTarget.id;
        var data_list = this.data.storage_data;
        for (let i in data_list) {
            if (i == temp_id) {
                if (data_list[i - 1].zan_status == 0) {
                    this.add_zan_count(i)
                    data_list[i - 1].zan_status = 1
                    // data_list[i-1].zan_count = data_list[i-1].zan_count + 1
                    that.setData({
                        zan: 1
                    })
                    // that.get_data()
                    wx.showToast({
                        title: '谢谢您的赞！',
                        image: "/images/icons/smile.png"
                    })
                } else {
                    this.cut_zan_count(i)
                    data_list[i - 1].zan_status = 0
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
        that.setData({
            storage_data: data_list
        })
    },

    change_collect_status: function (e) {
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

    get_win_height: function () {
        let that = this;
        wx.getSystemInfo({
            success: function (res) {
                that.setData({
                    win_height: res.windowHeight
                })
            },
        })
    },
}) 
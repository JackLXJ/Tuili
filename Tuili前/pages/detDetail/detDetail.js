var util = require("../../utils/util.js")
var app = getApp()



Page ({
    data: {
        detective_id: 0,
        detective_content: null,
        option_data: null,
        comment: null,
        is_watch: 0,
        openid: "",
        all_comment: null,
        user_info: null,
        input_value: ""
    },

    onLoad : function (options) {
        // console.log(options)
        let that = this;
        that.setData ({
            detective_id: options.id
        })
        // this.find_user_by_openid()
        this.find_by_id(options.id)
        this.find_option_by_id(options.id)
        this.get_all_comment()
        this.authorize()
        // this.find_user_by_openid()
    },

    // find_user_by_openid : function() {
    //     let that = this;
    //     wx.request ({
    //         url: app.globalData.domain_url + "/Tuili/User",
    //         data: {
    //             status: "findUserByOpenid",
    //             openid: wx.getStorageSync("openid")
    //         },
    //         success : function (res) {
    //             // console.log(res.data)
    //         }

    //     })
    //     // console.log(user_info)
    // },

    login : function () {
        wx.navigateTo({
            url: '/pages/authorize/authorize',
        })
    },

    form_submit : function (e) {

        let that = this;
        wx.request({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {
                status: "findUserByOpenid",
                openid: wx.getStorageSync("openid")
            },
            success: function (res) {
                wx.showToast({
                    title: '评论成功',
                })
                var user_info = res.data
                // console.log(user_info)
                var content = e.detail.value.comment_
                var user_name = user_info.user_name
                var user_image = user_info.user_image
                // console.log(wx.getStorageSync('openid'))
                // console.log(this.data.detective_id)
                wx.request({
                    url: app.globalData.domain_url + '/Tuili/Comment',
                    data: {
                        status: "addComment",
                        content: content,
                        user_name: user_name,
                        user_image: user_image,
                        openid: wx.getStorageSync('openid'),
                        problem_id: that.data.detective_id
                    },
                    header: { 'content-type': 'application/x-www-form-urlencoded;charset=utf-8'},
                    success: function (res) {
                        that.add_comment_count()
                        that.find_by_id(that.data.detective_id)
                        that.get_all_comment()
                        that.setData({
                            is_watch: 1
                        })
                    }
                })
                that.setData ({input_value: ""})
            }

        })


        
        // console.log("我要看答案啊！！！")
        // console.log(e)
    },

    get_all_comment : function () {
        let that = this;
        wx.request({
            url: app.globalData.domain_url + '/Tuili/Comment',
            data: {
                status: "findAllCommentByPid",
                pid: that.data.detective_id
            },
            success : function (res) {
                var comment_data = res.data;
                for (let i in comment_data) {
                    var to_time = util.tsFormatTime(comment_data[i].comment_time * 1000, "Y-M-D h:m:s");
                    comment_data[i].comment_time = to_time;
                }
                that.setData ({
                    all_comment: comment_data
                })


                // console.log(res.data[0])
                // console.log(util.tsFormatTime(res.data[0].comment_time * 1000, "Y-M-D h:m:s"))
                // that.setData ({
                //     all_comment: res.data
                // })
            }
        })
        // console.log(this.data.all_comment)
    },

    authorize : function () {
        let that = this;
        var openid = wx.getStorageSync("openid")
        that.setData ({
            openid: wx.getStorageSync("openid")
        })
        if (!openid) {
            wx.navigateTo({
                url: "/pages/authorize/authorize",
            })
        }
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Comment",
            data: {
                status: "findCommentById",
                openid: wx.getStorageSync("openid"),
                problem_id: this.data.detective_id
            },
            success : function (res) {
                // console.log(res)
                if (res.data) {
                    that.setData ({
                        is_watch: 1
                    })
                }
            }
        })
    },

    add_comment_count : function () {
        // console.log("正在添加评论")
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Articles",
            data: {
                status: "addCommentCount",
                id: this.data.detective_id
            },
            success : function (res) {
                // console.log(res)
            }
        })
    },



    find_by_id : function (id) {
        let that = this;
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Articles?status=findById&id=" + id,
            success : function (res) {
                // console.log(res)
                // console.log(id)
                that.setData ({
                    detective_content: res.data
                })
            }
        })
        
    },

    find_option_by_id : function (id) {
        let that = this;
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/Articles?status=findOptionById&id=" + id,
            success : function (res) {
                // console.log(res)
                that.setData ({
                    option_data: res.data
                })
            }
        })
    }
    

})
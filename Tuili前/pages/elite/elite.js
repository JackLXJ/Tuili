var app = getApp()
var util = require("../../utils/util.js")

Page ({
    data: {
        movie_data: null
    },

    onShow : function () {
        this.set_movie_data()
    },

    set_movie_data : function () {
        let that = this;
        that.setData ({
            movie_data: util.get_data().data 
        })
    },

    go_detail : function (e) {
        console.log(e)
        var id = e.currentTarget.id;
        wx.navigateTo({
            url: '/pages/eliteDetail/eliteDetail?id=' + id
        })
    }
})
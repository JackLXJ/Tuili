var app = getApp()
var util = require("../../utils/util.js")

Page ({
    data: {
        movie_data: null
    },

    onLoad : function (options) {
        // console.log(options)
        let that = this;
        that.setData({ movie_data: util.get_data().data[options.id - 1]})
    }
})
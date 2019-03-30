var app = getApp()
var util = require("../../utils/util.js")


Page ({
    data: {
        sponsor_data: null
    },

    onLoad : function () {
        let that = this;
        wx.request ({
            url: app.globalData.domain_url + "/Tuili/User",
            data: {status: "getAllSponsor"},
            success : function (res) {
                var data = res.data
                for (let i in data) {
                    var to_time = util.tsFormatTime(data[i].time * 1000, "Y-M-D");
                    data[i].time = to_time;
                }
                that.setData({
                    sponsor_data: data,
                })
            }
        })
    }
})
Page ({
    data: {
        system_info: null
    },


    onLoad : function () {
        let that = this
        wx.getSystemInfo({
            success: function(res) {
                console.log(res)
                that.setData ({
                    system_info: res
                })
            },
        })
    }
})    
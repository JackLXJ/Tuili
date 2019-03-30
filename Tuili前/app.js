//app.js

App({
  onLaunch: function () {
      wx.playBackgroundAudio({
          dataUrl: 'XXXXXX/uploads/music/SCARSONG.mp3',
      })



    // 展示本地存储能力
    this.get_storage()
    let that = this;
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId

      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
            //   wx.setStorageSync("userinfo", res.userinfo)

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },

  get_storage : function () {
      let that = this;
      wx.request({
          url: 'XXXXXXX/Articles?status=getStorage',
          success : function (res) {
              if (!wx.getStorageSync("storage_data")) {
                  wx.setStorageSync("storage_data", res.data)
              }
          }
      })
  },

  globalData: {
    userInfo: null,
      domain_url: "XXXXXX",
    page: 39
  }
})
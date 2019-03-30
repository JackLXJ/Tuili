var app = getApp();
Page({
    data: {
        all_banners: [],
        banners: [],
        swiperMaxNumber: 3,
        swiperCurrent: 0,
        height: wx.getSystemInfoSync().windowHeight,
        contents: [
            "首先要把一切不可能的结论都排除，那其余的，不管多么离奇，难以置信，也必然是无可辩驳的事实。或许剩下的是几种解释，如果这样，那就要一一地加以证实，直到最后只剩下一种具有充分根据证明的解释。", "把离奇与神秘混为一谈是错误的，最平淡无奇的犯罪案件往往是最神秘的，因为它没有任何可以作为推理依据的新奇或特别之处。倘若遇害人的尸体只是在路边上发现，既没有非同寻常的情节，也没有耸人听闻的细节，那么要侦破这起谋杀案必定困难得多。", "犯罪行为都有其相似之处，假如你对一千个案件的来龙去脉都了如指掌，可却不能解决第一千零一桩案件的话，那才是怪事。"
            ]
    },

    getRandomArrayElements : function (arr, count) {
        let that = this;
        var shuffled = arr.slice(0), i = arr.length, min = i - count, temp, index;
        while(i-- > min) {
            index = Math.floor((i + 1) * Math.random());
            temp = shuffled[index];
            shuffled[index] = shuffled[i];
            shuffled[i] = temp;
        }
        that.setData({ banners: shuffled.slice(min)})
    },

    onLoad: function () {
        wx.setNavigationBarTitle({title: "Welcome"})
        let that = this
        this.getRandomArrayElements(that.data.all_banners, 3)
        // console.log(that.data.banners)
    },
    
    swiperchange: function (e) {
        //console.log(e.detail.current)
        this.setData({
            swiperCurrent: e.detail.current
        })
    },
    goToIndex: function (e) {
        wx.switchTab({
            url: '/pages/detective/detective',
        })
    }
});

Page({
  /**
   * 页面的初始数据
   */
  data: {
    loading: false,
    contact: '',
    contant: '',
    userinfo:[]
  },

  formSubmit: function (e) {
    let userInfo = wx.getStorageSync('userInfo');
    if(userInfo){ // 用户登录
      // 更新userInfo的状态
      this.setData({
        userInfo: JSON.parse(userInfo)
      })}


    let _that = this;
    let content = e.detail.value.opinion;
    let contact = e.detail.value.contact;
    let regPhone = /^1[3578]\d{9}$/;
    let regEmail = /^[a-z\d_\-\.]+@[a-z\d_\-]+\.[a-z\d_\-]+$/i;
    this.setData({
      contant:content,
      contact
    })
    console.log("练习方式",this.data.contant)
    if (content == "") {
      wx.showModal({
        title: '提示',
        content: '反馈内容不能为空!',
      })
      return false
    }
    if (contact == "") {
      wx.showModal({
        title: '提示',
        content: '邮箱不能为空!',
      })
      return false
    }
    if (contact == "" && content == "") {
      wx.showModal({
        title: '提示',
        content: '反馈内容,邮箱不能为空!',
      })
      return false
    }
    if ((!regPhone.test(contact) && !regEmail.test(contact)) || (regPhone.test(contact) && regEmail.test(contact))) { //验证手机号或者邮箱的其中一个对
      wx.showModal({
        title: '提示',
        content: '您输入的邮箱有误!',
      })
      return false
    } else {
      this.setData({
        loading: true
      })
      let model, system, platform;
      wx.getSystemInfo({
        success: function (res) {
          model = res.model;
          system = res.system;
          platform = res.platform;
        }
      })
      wx.request({
        url: 'http://127.0.0.1:8001/suggest',
        data:{

          id:this.data.userInfo.userId,
          suggest:this.data.contant,
          email:this.data.contact

        },

        method: '',
        header: {
          "Content-Type": "application/json"
        },
        success: (res) => {
          var data = JSON.stringify(res.data);
          var jdata = JSON.parse(data);
        },
        fail: () => {
          console.log('获取验证码接口失败');
        }
      })
    }
  },
})
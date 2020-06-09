import Vue from 'vue'
import Vuex from 'vuex'
import user from '@/js/api/user';

export const UPDATE_USER_DATA = 'updateUserData'

Vue.use(Vuex)
export const global = new Vuex.Store({
  state: {
    userData: {
      userName: '',
      loginName: '',
      roleName: '',
      menuList: []
    },
    menuList: [],
  },
  mutations: {
    [UPDATE_USER_DATA](state) {
      user.userData(data => {
        state.userData = data['data']
        state.menuList = []
        state.userData.menuList.forEach(menu => {
          state.menuList.push(menu['menuCode'])
        })
      })
    }
  }
})

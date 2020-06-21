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
    menuTree: [],
  },
  mutations: {
    [UPDATE_USER_DATA](state) {
      user.userData().then(data => {
        state.userData = data['data']
        state.menuTree = []
        let menuTreeHelp = {}
        state.userData.menuList.forEach(menu => {
          menuTreeHelp[menu.id] = menu;
          if (menu.parentId !== 0) {
            let parentMenu = menuTreeHelp[menu.parentId]
            if (Object.prototype.hasOwnProperty.call(parentMenu, 'children')) {
              parentMenu.children.push(menu)
            } else {
              parentMenu['children'] = [menu]
            }
          }
        })
        Object.values(menuTreeHelp).forEach(menu => {
          if (menu.parentId === 0) {
            state.menuTree.push(menu)
          }
        })
      })
    }
  }
})

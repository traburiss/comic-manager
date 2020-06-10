import axios from 'axios';
import {Message} from 'element-ui';
import main from '@/main';
import loading from '@/js/common/loading';
import cookie from '@/js/common/cookie';

axios.defaults.baseURL = '/api';
axios.interceptors.response.use(res => {
  try {
    if (res.status === 200) {
      const data = res.data;
      if (data.code === 200) {
        return Promise.resolve(data);
      } else {
        Message.error(data.msg)
        return Promise.reject(data);
      }
    } else if (res.status === 401) {
      loading.stop()
      main.app.$cookies.remove(cookie.token, '/')
      main.app.$router.push('/login').then(() => {
        Message.error('你还未登陆，请先登陆')
      })
    } else {
      const data = res.data;
      if (data !== undefined && data !== null) {
        Message.error(data.msg)
        return Promise.reject(data);
      } else {
        Message.error(res.statusText)
        return Promise.reject({code: res.status, msg: res.statusText});
      }
    }
  } catch (e) {
    console.error(e)
    Message.error('未知错误，请稍后重试')
    return Promise.reject({code: -1, msg: '未知错误，请稍后重试'});
  }
})
export default {
  service(url, method, params) {
    return axios({
      method: method,
      url,
      data: params
    })
  },
  post(url, params) {
    return this.service(url, 'post', params)
  },
  get(url, params) {
    return this.service(url, 'get', params)
  }
}

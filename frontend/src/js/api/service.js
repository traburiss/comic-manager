import axios from "axios";
import {Message} from 'element-ui';
import main from "@/main";
import loading from "@/js/common/loading";
import cookie from "@/js/common/cookie";

axios.defaults.baseURL = '/api';
export default {
  post(url, params, success, error) {
    return axios({
      method: "post",
      url,
      data: params
    }).then(function (res) {
      try {
        const data = res.data;
        if (data.code === 200) {
          success(data)
        } else {
          if (error !== undefined) {
            error(data)
          } else {
            Message.error(data.msg)
          }
        }
      } catch (e) {
        console.error(e)
        Message.error('未知错误，请稍后重试')
      }
    }).catch(function (err) {
      try {
        if (err.response.status === 401) {
          loading.stop()
          main.app.$cookies.remove(cookie.token, "/")
          Message.error('你还未登陆，请先登陆')
          main.app.$router.push('/login')
        } else {
          if (err.response.data !== undefined && err.response.data !== null) {
            if (error !== undefined) {
              error(err.response.data)
            } else {
              Message.error(err.response.data.msg)
            }
          } else {
            if (error !== undefined) {
              error({code: err.response.status, msg: err.response.statusText})
            } else {
              Message.error(err.response.statusText)
            }
          }
        }
      } catch (e) {
        console.error(e)
        if (error !== undefined) {
          error('未知错误，请稍后重试')
        } else {
          Message.error('未知错误，请稍后重试')
        }
      }
    })
  }
}

import axios from "axios";
import {Message} from 'element-ui';

export default {
  post(url, params, success, error) {
    return axios({
      method: "post",
      url,
      data: params
    }).then(function (res) {
      const data = res.data;
      if (data.code === 200) {
        success(data)
      } else {
        if (error) {
          error(data)
        } else {
          Message.error(data.msg)
        }
      }
    }).catch(function (error) {
      if (error) {
        error({code: error.status, msg: error.message})
      } else {
        Message.error(error.message)
      }
    })
  }
}

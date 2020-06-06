import {Loading} from 'element-ui';

let loadingInstance

export default {
  start: (text) => {
    loadingInstance = Loading.service({
      text: text,
      lock: true,
      
    })
  },
  stop: () => {
    loadingInstance.close()
  }
}

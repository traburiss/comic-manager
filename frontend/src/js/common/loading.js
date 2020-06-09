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
    if (loadingInstance) {
      loadingInstance.close()
    }
  }
}

import service from './base/service';

export default {
  configList(params) {
    return service.get('/sys_cfg/list', params);
  },
  addConfig(data) {
    return service.post('/sys_cfg/add', data)
  },
  editConfig(data) {
    return service.post('/sys_cfg/edit', data)
  }
}

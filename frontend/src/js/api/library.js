import service from './base/service';

export default {
  libraryList(params) {
    return service.get('/library/list', params);
  },
  addLibrary(data) {
    return service.post('/library/add', data)
  },
  editLibrary(data) {
    return service.post('/library/edit', data)
  },
  removeLibrary(params) {
    return service.delete('/library/remove', params)
  },
  tagList(params) {
    return service.get('/library/tag/list', params)
  },
  tagAdd(data) {
    return service.post('/library/tag/add', data)
  },
  tagRemove(params) {
    return service.delete('/library/tag/remove', params)
  }
}

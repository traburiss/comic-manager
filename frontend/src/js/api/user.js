import service from './service';

export default {
  userData(success) {
    return service.get('/user/data', {}, success);
  },
}

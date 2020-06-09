import service from './service';

export default {
  loginService(loginName, passWord, success) {
    return service.post('/user/login', {
      loginName: loginName,
      passWord: passWord,
    }, success);
  },
  logoutService(success, error) {
    return service.post('/user/logout', {}, success, error);
  }
}

import service from './base/service';
import sha from "js-sha256";

export default {
  loginService(loginName, passWord) {
    return service.post('/user/login', {
      loginName: loginName,
      passWord: sha.sha256(passWord),
    });
  },
  logoutService() {
    return service.post('/user/logout', {});
  }
}

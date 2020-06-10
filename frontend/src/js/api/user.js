import service from './base/service';
import sha from "js-sha256";

export default {
  userData() {
    return service.get('/user/data', {});
  },
  editUserName(userName) {
    return service.post('/user/update/username', {userName: userName});
  },
  editPassword(pwd, newPwd) {
    return service.post('/user/update/password', {pwd: sha.sha256(pwd), newPwd: sha.sha256(newPwd)});
  },
}

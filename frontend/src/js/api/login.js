import service from "./service";

export default {
  login: loginRequest,
  logout: loginOut
}

function loginRequest(loginName, passWord, success) {
  return service.post('/user/login', {
    loginName: loginName,
    passWord: passWord,
  }, success);
}

function loginOut(success, error) {
  return service.post('/user/logout', {}, success, error);
}

import service from "./service";

export default {
  login: loginRequest
}

function loginRequest(loginName, passWord, success) {
  return service.post('api/login/login', {
    loginName: loginName,
    passWord: passWord,
  }, success);
}

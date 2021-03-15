package gmo.springmvc.service;

import gmo.springmvc.model.Login;

public interface LoginService {

  int register(Login login);
  
  boolean isLoginUserExists(Login login);

  Login validateLogin(Login login);
}

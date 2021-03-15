package gmo.springmvc.dao;

import gmo.springmvc.model.Login;

public interface LoginDao {

  int register(Login login);
  
  boolean isLoginUserExists(Login login);

  Login validateLogin(Login login);
}

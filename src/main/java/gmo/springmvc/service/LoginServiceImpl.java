package gmo.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import gmo.springmvc.dao.LoginDao;
import gmo.springmvc.model.Login;

public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginDao loginDao;

	public int register(Login user) {
		return loginDao.register(user);
	}

	public boolean isLoginUserExists(Login login) {
		return loginDao.isLoginUserExists(login);
	}

	public Login validateLogin(Login login) {
		return loginDao.validateLogin(login);
	}

}

package gmo.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gmo.springmvc.model.Login;
import gmo.springmvc.service.LoginService;

@Controller

public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		String identifier = request.getParameter("param");
		if ("0".equals(identifier)) {
			mav.addObject("identifier", "0");
		} else if ("1".equals(identifier)) {
			mav.addObject("identifier", "1");
		}
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST, params = "login")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		if (null == login.getUsername() || null == login.getPassword() || "".equals(login.getUsername())
				|| "".equals(login.getPassword())) {
			mav = new ModelAndView("login");
			mav.addObject("message", "ログイン情報を入力してください。");
			mav.addObject("identifier", "0");
		} else {
			Login userLogin = loginService.validateLogin(login);

			if (null != userLogin) {
				mav = new ModelAndView("welcome");
				mav.addObject("message", "ログイン成功");
			} else {
				mav = new ModelAndView("login");
				mav.addObject("message", "正しいユーザー名とパスワードを入力してください。");
			}
			mav.addObject("identifier", "0");
		}
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST, params = "register")
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		mav.addObject("identifier", "1");
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST, params = "registerNew")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		if (null == login.getUsername() || null == login.getPassword() || "".equals(login.getUsername())
				|| "".equals(login.getPassword())) {
			mav = new ModelAndView("login");
			mav.addObject("message", "ユーザー登録情報を入力してください。");
			mav.addObject("identifier", "1");
		} else {			
			boolean userExists = loginService.isLoginUserExists(login);
			if (userExists) {
				mav = new ModelAndView("login");
				mav.addObject("identifier", "1");
				mav.addObject("message", "ユーザーはすでに存在します。");
			} else {
				mav = new ModelAndView("welcome");
				int rowsInserted = loginService.register(login);
				if (rowsInserted > 0) {
					mav.addObject("message", "ユーザーが正常に登録されました。");
				}
			}
		}
		return mav;
	}

}

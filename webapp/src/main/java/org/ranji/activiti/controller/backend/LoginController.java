package org.ranji.activiti.controller.backend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.ranji.activiti.model.system.User;

/**
 * 
 * 项目名称：web
 * 类名称：LoginController
 * 创建人：RanJi
 * 创建时间: 2014-1-9 下午3:19:40
 * 修改人：RanJi
 * 修改时间：2014-1-9 下午3:19:40
 * 修改备注：
 * @version jdk1.5+
 */
@Controller
@RequestMapping(value="/backend")
public class LoginController {
	
	/**
	 * 跳转到后台登陆页面
	 * @return mv
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView toLogin(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/common/login");	//-- 设置后台登陆页面(login.jsp)的所在位置
		return mv;
	}
	
	/**
	 * 用户登陆
	 * @param user
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(User user,HttpSession session,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = 
				new UsernamePasswordToken(user.getUserName(),user.getPwd());
		token.setRememberMe(true);
		try {
			currentUser.login(token);
			session.setAttribute("userInfo", user);
			mv.setViewName("redirect:/backend/admin");
		} catch (AuthenticationException e) {
			mv.addObject("message", "login errors");
			mv.setViewName("redirect:/backend/login");
		}
		return mv;
	}
	
}

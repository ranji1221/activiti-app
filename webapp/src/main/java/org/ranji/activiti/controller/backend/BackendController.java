package org.ranji.activiti.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * 项目名称：web
 * 类名称：AdminController
 * 创建人：RanJi
 * 创建时间: 2014-1-9 下午3:19:49
 * 修改人：RanJi
 * 修改时间：2014-1-9 下午3:19:49
 * 修改备注：
 * @version jdk1.5+
 */
@Controller
public class BackendController {
	
	/**
	 * 测试的后台管理主页面
	 * @return mv
	 */
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView toBackendIndexPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/newbackend/index");	//-- 设置后台管理主页面(main.jsp)的所在位置
		return mv;
	}
}

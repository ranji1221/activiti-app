package org.ranji.activiti.controller.process;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 项目名称：web
 * 类名称：DesignerController
 * 创建人：RanJi
 * 创建时间: 2014-1-9 下午4:49:14
 * 修改人：RanJi
 * 修改时间：2014-1-9 下午4:49:14
 * 修改备注：
 * @version jdk1.5+
 */
@Controller
@RequestMapping(value="/process/designer")
public class DesignerController {
	
	/**
	 * 跳转到流程设计器页面
	 * @return mv
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView toBackendMainPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/process/designer/editor");	//-- 设置后台管理主页面(main.jsp)的所在位置
		return mv;
	}
	
}

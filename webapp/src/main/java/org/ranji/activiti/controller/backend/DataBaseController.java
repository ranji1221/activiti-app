package org.ranji.activiti.controller.backend;

import org.ranji.system.DataBaseService;
import org.ranji.system.DataBaseType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/database")
public class DataBaseController {
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView toDataBaseMainPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("backend/database/main");
		return mv;
	}
	
	@RequestMapping(value = "/getJSONStrDataBases", method = RequestMethod.POST)
	@ResponseBody
	public String getJSONStrDataBases(@RequestParam("nodeNameKey") String nodeNameKey,@RequestParam("tablesNameKey") String tablesNameKey,@RequestParam("columnsNameKey") String columnsNameKey) {
		String result = "";
		//System.out.println(nodeNameKey+":"+tablesNameKey+":"+columnsNameKey);
		DataBaseService dbService = 
				new DataBaseService(DataBaseType.MYSQL,"192.168.0.155","3306","root","root");	
		result = dbService.getJSONStrDataBases(nodeNameKey, tablesNameKey, columnsNameKey);
		//System.out.println(result);
		dbService.close();
		return result;
	}
}

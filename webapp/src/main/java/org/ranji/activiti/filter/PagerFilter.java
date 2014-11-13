package org.ranji.activiti.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.ranji.system.SystemContext;

/**
 * 实现分页的过滤器
 * @author RanJi
 */
public class PagerFilter implements Filter{
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		//-- page: 代表当前要显示的页，rows: 代表每页要显示的条目
		//-- jquery-easyui的分页插件就会自动提交这两个参数
		HttpServletRequest request = (HttpServletRequest)req;
		String currentPageCode = request.getParameter("page");
		String pageSizeValue = request.getParameter("rows");
		
		try{	
			//-- 1. offset（偏移量）2. pageSize(页面条数)
			if(currentPageCode != null && pageSizeValue != null) {
				int pageSize = Integer.parseInt(pageSizeValue);
				int pageCode = Integer.parseInt(currentPageCode);
				int offset = (pageCode-1)*pageSize;
				
				//-- 设置offset和pageSize
				SystemContext.setOffset(offset);
				SystemContext.setPageSize(pageSize);
			}
			chain.doFilter(req, res);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			SystemContext.removeOffset();
			SystemContext.removePageSize();
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}

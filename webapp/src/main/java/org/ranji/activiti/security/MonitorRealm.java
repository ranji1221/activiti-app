package org.ranji.activiti.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.ranji.activiti.model.system.User;
import org.ranji.activiti.service.system.prototype.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 项目名称：web
 * 类名称：MonitorRealm
 * 创建人：RanJi
 * 创建时间: 2014-1-3 上午10:32:04
 * 修改人：RanJi
 * 修改时间：2014-1-3 上午10:32:04
 * 修改备注：
 * @version jdk7
 */
public class MonitorRealm extends AuthorizingRealm{
	
	@Autowired
	private IUserService userService; 
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//-- 编写授权代码
		//-- 以下的代码是测试代码，假设所有的用户都会有"user:list"的权限
		//-- 在实际的开发中，我们会自己写好user-role-permission模块，然后从数据库中查询，用户的权限
		//-- 并可以赋予用户权限
		String userName = (String)principals.fromRealm(getName()).iterator().next();
		SimpleAuthorizationInfo info = null;
		if(userName != null && !"".equals(userName))
			info = new SimpleAuthorizationInfo();
		info.addStringPermission("user:list");
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		//-- 编写认证代码
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		//-- 1. 根据验证单的填写的名字从后台查找该用户
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userName", token.getUsername());
		List<User> users = userService.findAll(params);
		User user = null;
		if(users!=null && users.size()>0)user = users.get(0);

		//-- 2. 返回认证材料信息
		AuthenticationInfo authenInfo = null;
		if(user != null)
			authenInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPwd(),getName());
		return authenInfo;
	}
	
	public void clearCachedAuthorizationInfo(String principal){
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal,getName());
		clearCachedAuthenticationInfo(principals);
	}
}

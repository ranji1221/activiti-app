package org.ranji.activiti.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
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
 * @version jdk1.5+
 */
public class MonitorRealm extends AuthorizingRealm{
	
	@Autowired
	private IUserService userService; 
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		//-- 编写授权代码
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		//-- 编写认证代码
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		//-- 1. 根据验证单的填写的名字从后台查找该用户
		//User user = userService.findByName(token.getUsername());
		//-- 2. 返回认证材料信息
		AuthenticationInfo authenInfo = null;
		//if(user != null)
		//	authenInfo = new SimpleAuthenticationInfo(user.getUname(), user.getPwd(),getName());
		return authenInfo;
	}
	
	public void clearCachedAuthorizationInfo(String principal){
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal,getName());
		clearCachedAuthenticationInfo(principals);
	}
}

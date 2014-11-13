package org.ranji.activiti.persist.system.prototype;

import org.ranji.activiti.model.system.User;
import org.ranji.activiti.persist.common.prototype.IGenericDao;
/**
 * UserDao接口
 * @author RanJi
 * @since 2014-11-13
 * @version jdk7
 */
public interface IUserDao extends IGenericDao<User, Integer>{
	//-- 若有其他的Dao接口方法请自行添加即可，通用的Dao方法已全部实现
}

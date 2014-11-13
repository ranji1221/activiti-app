package org.ranji.captcha;

import java.util.Random;

/**
 * 
 * 项目名称：common
 * 类名称：CaptchaGenerator
 * 创建人：RanJi
 * 创建时间: 2014-1-10 上午10:39:03
 * 修改人：RanJi
 * 修改时间：2014-1-10 上午10:39:03
 * 修改备注：
 * @version jdk1.5+
 */
public class CaptchaGenerator {
	private static String range = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQISTUVWXYZ";
	/**
	 * 随机产生验证码的方法
	 * @return
	 */
	public static synchronized String randomGenerateCaptcha(){
		Random r = new Random();
		StringBuffer result = new StringBuffer();
		for(int i=0;i<4;i++)
			result.append(range.charAt(r.nextInt(range.length())));
		return result.toString();
	}
}

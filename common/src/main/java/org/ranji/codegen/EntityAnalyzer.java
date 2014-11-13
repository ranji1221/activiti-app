package org.ranji.codegen;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * 实体分析器
 * @author RanJi
 */
public class EntityAnalyzer {
	
	@SuppressWarnings("rawtypes")
	private Class entityClass;

	private static EntityAnalyzer entityAnalyzer;
	private EntityAnalyzer(String entityClass){
		try {
			this.entityClass = Class.forName(entityClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static EntityAnalyzer getInstance(String entityClass){
		if(entityAnalyzer==null)
			entityAnalyzer = new EntityAnalyzer(entityClass);
		return entityAnalyzer;
	}
	
	/**
	 * 判断属性名实体类是否含有某属性
	 * @param propertyName
	 * @return true or false
	 */
	public boolean hasSomeOneProperty(String propertyName){
		String toUpperInitialPropName = toUpperCaseInitial(propertyName);
		return ( hasSomeOneMethod("get"+toUpperInitialPropName) && hasSomeOneMethod("set"+toUpperInitialPropName)) || (hasSomeOneMethod("is"+toUpperInitialPropName) && hasSomeOneMethod("set"+toUpperInitialPropName));
	}
	/**
	 * 字符串首字母大写的方法
	 * @param str
	 * @return 新的字符串
	 */
	public String toUpperCaseInitial(String str){
		char[] chars = str.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		return new String(chars);
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public String toLowerCaseInitial(String str){
		char[] chars = str.toCharArray();
		chars[0] = Character.toLowerCase(chars[0]);
		return new String(chars);
	}
	
	/**
	 * 
	 * @param methodName
	 * @return
	 */
	public boolean hasSomeOneMethod(String methodName){
		Method[] methods = entityClass.getMethods();
		for(int i=0; i<methods.length; i++){
			Method m = methods[i];
			if(m.getName().equals(methodName)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public Properties getPropertiesForEntity(){
		Properties props = new Properties();
		try {
			Field[] fields = entityClass.getDeclaredFields();
			for(int i=0; i<fields.length; i++){
				Field field = fields[i];
				if(hasSomeOneProperty(field.getName())){
					props.setProperty(field.getName(), field.getType().getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return props;
	}
	/**
	 * 获取某实体类的包名
	 * @return
	 */
	public String getPackageName(){
		return entityClass.getPackage().getName();
	}
	
	/**
	 * 判断某实体类的某属性是否为基础类型
	 * @param propertyType
	 * @return
	 */
	public boolean isBasicType(String propertyType){
		return "java.lang.Integer".equals(propertyType) || "int".equals(propertyType) ||
				"java.lang.Long".equals(propertyType) || "long".equals(propertyType) ||
				"java.lang.Short".equals(propertyType) || "short".equals(propertyType) ||
				"java.lang.Byte".equals(propertyType) || "byte".equals(propertyType) ||
				"java.lang.Float".equals(propertyType) || "float".equals(propertyType) || 
				"java.lang.Double".equals(propertyType) || "double".equals(propertyType) || 
				"java.lang.Boolean".equals(propertyType) || "boolean".equals(propertyType) ||
				"java.lang.Character".equals(propertyType) || "char".equals(propertyType);
	}
	/**
	 * 判断某实体类的某属性是否为时期类型
	 * @param propertyType
	 * @return true or false
	 */
	public boolean isDateType(String propertyType){
		return "java.util.Date".equals(propertyType);
	}
	/**
	 * 判断某实体类的某属性是否为字符串类型
	 * @param propertyType
	 * @return true or false
	 */ 
	public boolean isStringType(String propertyType){
		return "java.lang.String".equals(propertyType);
	}
	
	public static void main(String[] args) {
		EntityAnalyzer ea = getInstance("org.ranji.codegen.User");
		
		/**
		 * 遍历属性
		 */
		Properties props = ea.getPropertiesForEntity();
		Iterator<Entry<Object, Object>> it = props.entrySet().iterator();
		while(it.hasNext()){
			Entry<Object,Object> entry = it.next();
			String entryKey = (String)entry.getKey();
			String entryVlaue = (String)entry.getValue();
			System.out.println(entryKey+"="+entryVlaue);
		}
	}
	
}

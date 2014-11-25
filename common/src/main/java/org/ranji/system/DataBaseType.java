package org.ranji.system;
/**
 * 用于区分数据库类型的枚举
 * @author RanJi
 *
 */
public enum DataBaseType {
	ORACLE(0),MYSQL(1),DB2(2),SYBASE(3),MSSQL(4);
	
	private int value;
	
	private DataBaseType(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}

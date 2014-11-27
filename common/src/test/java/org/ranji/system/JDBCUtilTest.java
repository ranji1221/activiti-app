package org.ranji.system;

import java.util.List;
import org.junit.Test;

public class JDBCUtilTest {
	
	@Test
	public void testConn()throws Exception{

		//-- 1. 创建dbService
		DataBaseService dbService = 
				new DataBaseService(DataBaseType.MYSQL,"192.168.0.111","3306","root","123456");	//-- MySQL数据库
				//new DataBaseService(DataBaseType.MSSQL,"192.168.0.108", "7788", "", "sa", "admin");		//-- MSSQL数据库
		
		//-- 2. 获取数据库(名称)
		List<String> dbNames = dbService.getDataBases();
		for (String dbName : dbNames) {
			System.out.println(dbName);
			int count = 0;
			for(String table : dbService.getTables(dbName)){
				System.out.println("--"+table);
				for(String column: dbService.getColumns(table,dbName)){
					System.out.println("----"+column);
				}
				count++;
			}
			System.out.println(dbName+"中共有"+count+"张表");
			System.out.println("==============================");
		}

		//-- n. 释放资源 --- 切记最后没有操作了再释放资源，否则会关闭内部的connection导致不能操作数据库
		dbService.close();
	}
	
	@Test
	public void testCreateDB(){
		//-- 1. 创建dbService (连接中的数据库名，可以传，也可以不传)
		DataBaseService dbService = 
				new DataBaseService(DataBaseType.MYSQL,"localhost","3306","root","123456");	//-- MySQL数据库
				//new DataBaseService(DataBaseType.MSSQL,"192.168.0.108", "7788", "", "sa", "admin");		//-- MSSQL数据库
		dbService.createDB("eee");
		dbService.close();
	}
	
	@Test
	public void testJSONStr(){
		DataBaseService dbService = 
				//new DataBaseService(DataBaseType.MYSQL,"192.168.0.108","3306","admin","admin");
				new DataBaseService(DataBaseType.MYSQL,"localhost","3306","root","123456");	//-- MySQL数据库
				//new DataBaseService(DataBaseType.MSSQL,"192.168.0.108", "7788", "", "sa", "admin");		//-- MSSQL数据库
				//new DataBaseService(DataBaseType.MYSQL,"192.168.0.155","3306","root","root");
				
		System.out.println(dbService.getJSONStrDataBases());
		
		//-- System.out.println(dbService.getJSONStrDataBase("activitiapp"));
		dbService.close();
	}
	
	
	@Test
	public void testExcuteSQL(){
		DataBaseService dbService = 
				new DataBaseService(DataBaseType.MYSQL,"localhost","3306","root","123456");	
		String sql = "CREATE TABLE tbl_ddd(age int)";
		dbService.excuteSQL(sql, "activitiapp");
		dbService.close();
		
	}
	
	/*public void dataBaseInfo(DatabaseMetaData dbMetaData)throws Exception{
		log.info("数据库产品名：" + dbMetaData.getDatabaseProductName());
		log.info("数据库是否支持事务：" + dbMetaData.supportsTransactions());
		log.info("数据库产品的版本号：" + dbMetaData.getDatabaseProductVersion());
		log.info("数据库的默认事务隔离级别：" + dbMetaData.getDefaultTransactionIsolation());
		log.info("是否支持批量更新：" + dbMetaData.supportsBatchUpdates());  
	    log.info("DBMS 的 URL:"+dbMetaData.getURL()); 
	    log.info("数据库的已知的用户名称 ：" + dbMetaData.getUserName());  
	    log.info("数据库是否处于只读模式：" + dbMetaData.isReadOnly()); 
	    
	    log.info("数据库是否支持为列提供别名:"+dbMetaData.supportsColumnAliasing());  
	    log.info("是否支持指定 LIKE 转义子句:"+dbMetaData.supportsLikeEscapeClause());  
	    log.info("是否为外连接提供受限制的支持:"+dbMetaData.supportsLimitedOuterJoins());  
	    log.info("是否允许一次打开多个事务:"+dbMetaData.supportsMultipleTransactions());  
	    log.info("是否支持 EXISTS 表达式中的子查询:"+dbMetaData.supportsSubqueriesInExists());  
	    log.info("是否支持 IN 表达式中的子查询:"+dbMetaData.supportsSubqueriesInIns());  
	    log.info("是否支持给定事务隔离级别:"+dbMetaData.supportsTransactionIsolationLevel(1));  
	    log.info("此数据库是否支持事务:"+dbMetaData.supportsTransactions());  
	    log.info("此数据库是否支持 SQL UNION:"+dbMetaData.supportsUnion());  
	    log.info("此数据库是否支持 SQL UNION ALL:"+dbMetaData.supportsUnionAll());  
	    log.info("此数据库是否为每个表使用一个文件:"+dbMetaData.usesLocalFilePerTable());  
	    log.info("此数据库是否将表存储在本地文件中:"+dbMetaData.usesLocalFiles());  
	    log.info("底层数据库的主版本号:"+dbMetaData.getDatabaseMajorVersion());  
	    log.info("底层数据库的次版本号:"+dbMetaData.getDatabaseMinorVersion());  
	      
	    log.info("JDBC 驱动程序的主版本号:"+dbMetaData.getJDBCMajorVersion());  
	    log.info("JDBC 驱动程序的次版本号:"+dbMetaData.getJDBCMinorVersion());  
	    log.info("JDBC 驱动程序的名称:"+dbMetaData.getDriverName());  
	    log.info("JDBC 驱动程序的 String 形式的版本号:"+dbMetaData.getDriverVersion());  
	      
	    log.info("可以在不带引号的标识符名称中使用的所有“额外”字符:"+dbMetaData.getExtraNameCharacters());  
	    log.info("用于引用 SQL 标识符的字符串:"+dbMetaData.getIdentifierQuoteString());  
	    log.info("允许用于类别名称的最大字符数:"+dbMetaData.getMaxCatalogNameLength());  
	    log.info("允许用于列名称的最大字符数:"+dbMetaData.getMaxColumnNameLength());  
	    log.info("允许在 GROUP BY 子句中使用的最大列数:"+dbMetaData.getMaxColumnsInGroupBy());  
	    log.info("允许在 SELECT 列表中使用的最大列数:"+dbMetaData.getMaxColumnsInSelect());  
	    log.info("允许在表中使用的最大列数:"+dbMetaData.getMaxColumnsInTable());  
	    log.info("数据库的并发连接的可能最大数:"+dbMetaData.getMaxConnections());  
	    log.info("允许用于游标名称的最大字符数:"+dbMetaData.getMaxCursorNameLength());  
	    log.info("在同一时间内可处于开放状态的最大活动语句数:"+dbMetaData.getMaxStatements());  
	}
	*/
	
}

package org.ranji.system;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 操作数据库元数据的服务类
 * @author RanJi
 *
 */
public class DataBaseService {
	
	private static Logger logger = Logger.getLogger(DataBaseService.class);
	
	private Connection con;
	
	private DataBaseService(DataBaseType dbType, String hostAddr, String port, String dbName, String userName, String password){
		String driverName = "";
		String jdbcURL = "";
		switch (dbType.getValue()) {
		case 0:
			driverName = "oracle.jdbc.driver.OracleDriver ";
			jdbcURL = "jdbc:oracle:thin:@"+hostAddr+":"+port;
			if(dbName !=null || !"".equals(dbName)) jdbcURL += ":"+dbName;
			break;
		case 1: 
			driverName = "com.mysql.jdbc.Driver";
			jdbcURL = "jdbc:mysql://"+hostAddr+":"+port;
			if(dbName !=null || !"".equals(dbName)) jdbcURL += "/"+dbName;
			break;
		case 2:
			driverName = "com.ibm.db2.jcc.DB2Driver";
			jdbcURL = "jdbc:db2://"+hostAddr+":"+port;
			if(dbName !=null || !"".equals(dbName)) jdbcURL += "/"+dbName;
			break;
		case 3:
			driverName = "com.sybase.jdbc3.jdbc.SybDriver";
			jdbcURL = "jdbc:sybase:Tds:"+hostAddr+":"+port;
			if(dbName !=null || !"".equals(dbName)) jdbcURL += "/"+dbName;
			break;
		case 4:
			driverName = "net.sourceforge.jtds.jdbc.Driver";   //--这里注意，连接MSSQL数据库没有使用官方驱动，而是使用了第三方的驱动
			jdbcURL = "jdbc:jtds:sqlserver://"+hostAddr+":"+port;
			if(dbName !=null || !"".equals(dbName)) jdbcURL += "/"+dbName;
			break;
		}
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(jdbcURL, userName, password);
		} catch (ClassNotFoundException e) {
			logger.info("连接数据库的驱动类："+driverName+" 没有找到！");
		} catch (SQLException e) {
			logger.info("对不起，数据库连接不成功,请检查输入的数据库IP地址、数据库名、用户名及密码是否正确！");
		}
		logger.info("连接数据库成功！");
	}
	
	public DataBaseService(DataBaseType dbType, String hostAddr, String port, String userName, String password){
		this(dbType, hostAddr, port, "", userName, password);
	}
	
	/**
	 * 内部使用的释放资源的方法
	 * @param rs
	 * @param sm
	 * @param con
	 */
	private void close(ResultSet rs, Statement sm, Connection con){
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(sm != null)
					try {
						sm.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally{
						if(con != null)
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
					}
			}
	}
	
	
	/**
	 * 获取有几个数据库（名称）
	 * @param con
	 * @return
	 */
	public List<String> getDataBases(){
		List<String> dataBases = new ArrayList<String>();
		ResultSet rs = null;
		if(con != null){
			try {
				DatabaseMetaData dbMetaData = con.getMetaData();
				rs = dbMetaData.getCatalogs();
				while(rs.next()){
					dataBases.add(rs.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(rs,null,null);
			}
		}
		return dataBases;
	}
	
	public List<String> getTables(String dataBaseName){
		List<String> tables = new ArrayList<String>();
		ResultSet rs = null;
		if(con != null){
			try {
				DatabaseMetaData dbMetaData = con.getMetaData();
				rs = dbMetaData.getTables(dataBaseName, null, null, new String[]{"TABLE","VIEW"});
				while(rs.next()){
					tables.add(rs.getString("TABLE_NAME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(rs,null,null);
			}
		}
		return tables;
	}
	
	public List<String> getColumns(String tableName,String dataBase){
		List<String> columns = new ArrayList<String>();
		ResultSet rs = null;
		if(con != null){
			try {
				DatabaseMetaData dbMetaData = con.getMetaData();
				rs = dbMetaData.getColumns(dataBase, null, tableName, null);
				while(rs.next()){
					columns.add(rs.getString("COLUMN_NAME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(rs,null,null);
			}
		}
		return columns;
	}
	
	
	public void createDB(String dbName){
		String sql = "CREATE DATABASE "+dbName;
		Statement stmt = null;
		if(con != null) {
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				logger.info("数据库"+dbName+"已经存在！");
			} finally{
				close(null,stmt,null);
			}
		}
		
	}
	
	public String getJSONStrDataBases(){
		StringBuilder dbStr = new StringBuilder("[");
		StringBuilder tableStr = new StringBuilder();
		StringBuilder columnStr = new StringBuilder();
		
		ResultSet dbRS = null;
		ResultSet tableRS = null;
		ResultSet columnRS = null;
		
		boolean dbFlag = false;
		boolean tableFlag = false;
		boolean columnFlag = false;
		
		if(con != null){
			try {
				DatabaseMetaData dbMetaData = con.getMetaData();
				dbRS = dbMetaData.getCatalogs();
				while(dbRS.next()){
					dbFlag = true;
					dbStr.append("{\"dbName\":");
					dbStr.append("\""+dbRS.getString(1)+"\",\"tables\":[");
					
					tableRS = dbMetaData.getTables(dbRS.getString(1), null, null, new String[]{"TABLE","VIEW"});
					while(tableRS.next()){
						tableFlag = true;
						tableStr.append("{\"tableName\":");
						tableStr.append("\""+tableRS.getString("TABLE_NAME")+"\",\"columns\":[");
						
						columnRS = dbMetaData.getColumns(dbRS.getString(1), null, tableRS.getString("TABLE_NAME"), null);
						while(columnRS.next()){
							columnFlag = true;
							columnStr.append("{\"column_name\":");
							columnStr.append("\""+columnRS.getString("COLUMN_NAME")+"\"},");
						}
						if(columnFlag){
							columnFlag = false;
							columnStr = columnStr.replace(columnStr.length()-1, columnStr.length(), "");
							tableStr.append(columnStr);
							columnStr = new StringBuilder();
						}
						tableStr.append("]");
						tableStr.append("},");
					}
					if(tableFlag){
						tableFlag = false;
						dbStr.append(tableStr);
						tableStr = new StringBuilder();
						dbStr = dbStr.replace(dbStr.length()-1, dbStr.length(), "]");
					}else 
						dbStr.append("]");
					dbStr.append("},");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(columnRS,null,null);
				close(tableRS,null,null);
				close(dbRS,null,null);
			}
		}
		if(dbFlag) 
			dbStr = dbStr.replace(dbStr.length()-1, dbStr.length(), "]");
		else
			dbStr.append("]");
		return dbStr.toString();
	}
	
	
	public String getJSONStrDataBase(String dbName){
		
		return "";
	}
	
	/**
	 * 外部使用的释放资源的方法 (最后被调用的方法,以便释放资源)
	 */
	public void close(){
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	
}

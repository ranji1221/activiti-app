package org.ranji.system;
/**
 * 系统常量
 * @author RanJi
 */
public class SystemContext {
	private static ThreadLocal<Integer> offset = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
	
	/**
	 * 获取偏移量
	 * @return
	 */
	public static int getOffset(){
		Integer os = (Integer)offset.get();
		if(os==null) return 0;
		return os.intValue();
	}
	public static void setOffset(int offsetValue){
		offset.set(offsetValue);
	}
	public static void removeOffset(){
		offset.remove();
	}
	/**
	 * 获取页大小
	 * @return
	 */
	public static int getPageSize(){
		Integer ps = pageSize.get();
		if(ps == null) return Integer.MAX_VALUE;
		return ps.intValue();
	}
	public static void setPageSize(int pageSizeValue){
		pageSize.set(pageSizeValue);
	}
	public static void removePageSize(){
		pageSize.remove();
	}
}

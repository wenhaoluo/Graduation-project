package scm.test;



import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static ComboPooledDataSource getdaSource() {
		return dataSource;
	}
	
	public static void main(String[] args) {
System.out.println(dataSource!=null);
	}
}

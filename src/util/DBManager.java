package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//오라클과 mysql 둘다 처리하는 DB매니저 정의
//싱글턴에서는 인스턴스가 1번만 생성되기 때문에 connection도 한번만 생성된다.
public class DBManager {
	
	String oracle_driver="oracle.jdbc.driver.OracleDriver";
	String oracle_url="jdbc:oracle:thin:@localhost:1521:XE";
	String oracle_user="javase";
	String oracle_pass="1234";
	
	String mysql_driver="com.mysql.jdbc.Driver";
	String mysql_url="jdbc:mysql://localhost:3306/javase?characterEncoding=utf-8";
	String mysql_user="root";
	String mysql_pass="1234";
	
	private static DBManager instance;//null
	private Connection connection;
	private Connection connection2;
	private DBManager() {
		connectOracle();
		//connectMysql();
	}
	
	public Connection getConnection() {
		return connection;
	}
	//오라클 접속
	public void connectOracle() {
		try {
			//드라이버 로드
			Class.forName(oracle_driver);
			
			connection=DriverManager.getConnection(oracle_url, oracle_user, oracle_pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//mysql 접속 
	public void connectMysql() {
		try {
			Class.forName(mysql_driver);
			Connection connection2=DriverManager.getConnection(mysql_url, mysql_user, mysql_pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static DBManager getInstance() {
		if(instance==null) {
			instance=new DBManager();
		}
		return instance;
	}
	
	public void release(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void release(PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void release(PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}

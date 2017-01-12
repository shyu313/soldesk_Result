package kr.co.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBOpen {

	/*public DBOpen() {
		System.out.println("---DBOpen °´Ã¼ »ý¼ºµÊ");
	}*/

	public Connection getConnetion() {

		// My-SQL DB
		String url = "umj64-006.cafe24.com/bardciel";
		String user = "bardciel";
		String password = "kobata11";
		String driver = "org.gjt.mm.mysql.Driver";
		
		//ORACLE
		/*String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user = "java1230";
		String password = "1234";
		String driver = "oracle.jdbc.driver.OracleDriver";*/

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("DB ¿¬°á ½ÇÆÐ: " + e);
		}

		return con;
	}
}

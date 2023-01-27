package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static void main(String[] args) {
		// @주소:포트:DB명
		final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		final String DB_USER = "mybatis";
		final String DB_PASSWORD = "mybatis";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// bytecode를 VM상으로 로딩하라고 명령할 수 있다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			String query = "select user_id, user_name, reg_date from users";
			// String을 statement로 바꾼다.
			stmt = conn.prepareStatement(query);
			// relation이 준비된다.
			rs = stmt.executeQuery();
			
			// ORM에 쓸 변수를 만든다.
			User user = null;
			// 커서가 valid row 밖으로 이동하면 false
			while(rs.next()) {
				// getInt는 number 타입. 1은 컬럼 번호.
				// getString은 varchar2 타입. 2는 컬럼 번호.
				user = new User(rs.getInt(1), rs.getString(2), rs.getDate(3));
				// 잘 됐는지 테스트한다.
				System.out.println(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 역순으로 제거한다.
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {}
		}
	}
}

package config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Configuration {
	// connection은 physical한 연결
	// session은 logical한 연결: 알고리즘상 연결이 있다고 취급
	private static SqlSessionFactory sqlSessionFactory;
	
	// static block이므로 한 번만 실행된다.
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/sqlMapConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// mapper pool을 만든다. 매퍼들은 데이터 타입으로 구분된다.
	public static <T> T getMapper(Class<T> arg) {
		// true는 auto-commit
		// mapper pool에서 arg 데이터 타입을 갖고 있는 mapper만 골라낸다.
		// jdbc에서 connection이라 불렀던 것을 mybatis에서는 session이라 부른다.
		return sqlSessionFactory.openSession(true).getMapper(arg);
	}
}

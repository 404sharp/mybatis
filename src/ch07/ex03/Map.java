package ch07.ex03;

import org.apache.ibatis.annotations.Insert;

import ch07.domain.User;

// mapper interface
public interface Map {
	// userName은 nullable이므로 jdbcType을 선언해야 한다.
	@Insert("""
			insert into users
			values(#{userId}, #{userName, jdbcType=VARCHAR}, #{regDate})
			""")
	int insertUser(User user);
}

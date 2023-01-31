package ch07.ex02;

import org.apache.ibatis.annotations.Select;

import ch07.domain.User;

// mapper interface
public interface Map {
	@Select("""
			select user_id userId, user_name userName, reg_date regDate
			from users
			where user_id = #{userId}
			""")
	// 이 userId값이 위쪽 #{userId}의 값으로 쓰인다.
	User selectUser(int userId);
}

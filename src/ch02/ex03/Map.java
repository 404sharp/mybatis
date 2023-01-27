package ch02.ex03;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Param;

import ch02.domain.User;

// mapper interface
public interface Map {
	// parameter가 도메인
	int insertUser(User user);
	
	// parameter가 도메인이 아님
	int insertUser2(@Param("userId") int userId,
			@Param("userName") String userName,
			@Param("regDate") LocalDate regDate);
	
	int insertUser3(int userId, String userName, LocalDate regDate);
}

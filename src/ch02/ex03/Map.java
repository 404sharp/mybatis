package ch02.ex03;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Param;

import ch02.domain.User;

// mapper interface
public interface Map {
	// parameter가 도메인
	// N개의 파라미터라면 객체 하나에 담아서 넘겨주는 게 좋다.
	// DTO(Data Transfer Object): 데이터를 전달하는(파라미터로 쓰는) 게 목적
	int insertUser(User user);
	
	// parameter가 도메인이 아님
	int insertUser2(@Param("userId") int userId,
			@Param("userName") String userName,
			@Param("regDate") LocalDate regDate);
	
	int insertUser3(int userId, String userName, LocalDate regDate);
}

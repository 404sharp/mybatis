package ch02.ex02;

import java.time.LocalDate;

import ch02.domain.User;

// mapper interface
public interface Map {
	// userId는 where절에 쓸 키다.
	User selectUser(int userId);
	// overloading 불가, 이름을 다르게 지어야 한다.
	User selectUser2(String userName);
	User selectUser3(LocalDate regDate);
}

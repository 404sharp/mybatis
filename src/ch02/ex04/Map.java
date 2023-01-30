package ch02.ex04;

import ch02.domain.User;

// mapper interface
public interface Map {
	// insert update delete는 리턴 타입이 int이다. 실패하면 0
	int updateUser(User user);
}

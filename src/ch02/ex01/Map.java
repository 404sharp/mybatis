package ch02.ex01;

import java.util.List;

import ch02.domain.User;

// mapper interface
public interface Map {
	// User가 없다면 size가 0인 List가 리턴된다.
	// select는 List 또는 도메인 타입이 리턴 타입이다.
	List<User> selectUsers();
}

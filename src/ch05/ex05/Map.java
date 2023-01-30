package ch05.ex05;

import ch05.domain.User;

// mapper interface
public interface Map {
	// parameter name이 없는 상황
	User selectUser(String userName);
}

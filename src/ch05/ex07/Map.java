package ch05.ex07;

import java.util.List;

import ch05.domain.User;

// mapper interface
public interface Map {
	// parameter name이 없는 상황2 (상황1은 ex05)
	List<User> selectUsers(int[] userIds);
	List<User> selectUsers2(List<String> userNames);
}

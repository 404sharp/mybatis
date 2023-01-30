package ch05.ex06;

import java.util.List;

import ch05.domain.User;

// mapper interface
public interface Map {
	List<User> selectUsers(Search search);
}

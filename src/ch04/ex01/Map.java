package ch04.ex01;

import java.util.List;

import ch04.domain.User;

// mapper interface
public interface Map {
	List<User> selectUsers();
}

package ch02.ex01;

import java.util.List;

import ch02.domain.User;

// mapper interface
public interface Map {
	List<User> selectUsers();
}

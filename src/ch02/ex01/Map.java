package ch02.ex01;

import java.util.List;

import ch02.domain.User;

// mapper
public interface Map {
	List<User> selectUsers();
}

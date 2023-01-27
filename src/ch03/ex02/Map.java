package ch03.ex02;

import java.util.List;

import ch03.domain.User;

// mapper interface
public interface Map {
	List<User> selectUsers();
}

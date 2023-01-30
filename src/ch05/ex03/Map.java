package ch05.ex03;

import java.util.List;

import ch05.domain.Search;
import ch05.domain.User;

// mapper interface
public interface Map {
	List<User> selectUsers(Search search);
}

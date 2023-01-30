package ch05.ex02;

import ch05.domain.Search;
import ch05.domain.User;

// mapper interface
public interface Map {
	User selectUser(Search search);
}

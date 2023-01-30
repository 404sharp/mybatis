package ch05.ex01;

import ch05.domain.Post;
import ch05.domain.Search;
import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		// Map.class는 ch05.ex01.Map
		Map mapper = Configuration.getMapper(Map.class);
		
		User user = mapper.selectUser(new Search("john", null));
		// sqlMap.xml에서 isEmpty()를 썼으므로 null을 쓰면 안 된다.
//		user = mapper.selectUser(new Search("john", new Post("정의", null)));
		// 대신에 empty String("")을 쓴다.
		user = mapper.selectUser(new Search("john", new Post("정의", "")));
//		user = mapper.selectUser(new Search("john", new Post(null, "고리")));
		
		System.out.println(user);
	}
}

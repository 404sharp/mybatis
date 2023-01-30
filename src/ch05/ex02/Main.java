package ch05.ex02;

import ch05.domain.Post;
import ch05.domain.Search;
import ch05.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		// null 대신 new Post를 쓴 이유는 sqlMap.xml에 bind된 post.xxx 때문
		User user = mapper.selectUser(new Search("john", new Post(null, null)));
		user = mapper.selectUser(new Search("john", new Post("정의", null)));
		user = mapper.selectUser(new Search("john", new Post(null, "고리")));
		
		System.out.println(user);
	}
}

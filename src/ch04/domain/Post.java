package ch04.domain;

public class Post {
	// column name과 member variable name이 다르다. 일부러 그렇게 했다.
	private String title;
	private String content;
	
	@Override
	public String toString() {
		return String.format("%s %s", title, content);
	}
}

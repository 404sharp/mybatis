package ch03.domain;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

// 직접 별명을 지정할 수 있다.
@Alias("myUser")
public class User {
	private int userId;
	private String userName;
	private LocalDate regDate;
	private Address address;
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", userId, userName, regDate, address);
	}
}

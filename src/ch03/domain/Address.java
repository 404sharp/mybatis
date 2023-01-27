package ch03.domain;

// 테이블 이름은 복수형, 클래스 이름은 단수형
public class Address {
	private String address;
	
	@Override
	public String toString() {
		return address;
	}
}

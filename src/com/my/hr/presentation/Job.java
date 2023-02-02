package com.my.hr.presentation;

public enum Job {
	// 객체지향으로 표현하면 "회원"이 덧붙어야 한다. ex. 회원목록, 회원추가, ...
	// 하지만 중복을 제거하기 위해 "회원"을 뺐다. trade-off
	EXIT("종료"), LIST("목록"), ADD("추가"), FIX("수정"), DEL("삭제");
	
	private String label;
	
	private Job(String label) {
		this.label = label;
	}
	
	public static int length() {
		return values().length;
	}
	
	public static Job valueOf(int ordinal) {
		return values()[ordinal];
	}
	
	public static String labels() {
		Job[] jobs = values();
		String labels = "";
		String last = "";
		
		for(Job job: jobs) {
			if(job.ordinal() == 0) last = job.ordinal() + "." + job.label;
			else labels += job.ordinal() + "." + job.label + ", ";
		}
		labels += last;
		
		return labels;
	}
}

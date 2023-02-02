package com.my.hr.presentation;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;
import com.my.hr.domain.NoneException;
import com.my.hr.service.LaborerService;

public class LaborerIo {
	private LaborerService laborerService;
	private String menu;
	
	public LaborerIo(LaborerService laborerService) {
		this.laborerService = laborerService;
		this.menu = Job.labels();
	}
	
	public void play() {
		Job job = null;
		
		while((job = choose(menu)) != Job.EXIT) {
			switch(job) {
			case LIST -> listLaborers();
			case ADD -> addLaborer();
			case FIX -> fixLaborer();
			case DEL -> delLaborer();
			}
		}
	}
	
	private Job choose(String menu) {
		int choice = 0;
		boolean isGood = false;
		
		do {
			choice = Console.inNum(menu);
			if(choice < 0 || choice > Job.length() - 1)
				Console.err("메뉴 번호를 입력하세요.");
			else isGood = true;
		} while(!isGood);
		
		return Job.valueOf(choice);
	}
	
	private void listLaborers() {
		List<Laborer> laborers = laborerService.getLaborers();
		
		if(laborers.size() > 0) {
			System.out.println("ID 이름    입사일");
			System.out.println("------------------");
			// callback
			laborers.forEach(Console::info);
		} else Console.info("노동자가 없습니다.");
	}
	
	private void addLaborer() {
		String laborerName = Console.inStr("노동자명을 입력하세요.", 5);
		
		if(!laborerName.equals("0")) {
			LocalDate hireDate = Console.inDate("입사일을 입력하세요.");
			laborerService.addLaborer(laborerName, hireDate);
			Console.info("노동자를 추가했습니다."); // web app에서는 목록 갱신으로 해결
		} else Console.info("추가 취소합니다.");
	}
	
	private void fixLaborer() {
		// 이때는 유저가 당황하지 않게 "노동자"ID라고 표현한다.
		int laborerId = Console.inNum("노동자ID를 입력하세요.");
		
		if(laborerId != 0) {
			String laborerName = Console.inStr("노동자명을 입력하세요.", 5);
			LocalDate hireDate = Console.inDate("입사일을 입력하세요.");
			
			try {
				laborerService.fixLaborer(new Laborer(laborerId, laborerName, hireDate));
				// 단순히 "수정했습니다"라고 하면 객체지향이 아니다.
				// 목적어 "노동자를"을 붙여야 한다.
				Console.info("노동자를 수정했습니다.");
			} catch(NoneException e) {
				Console.err(e.getMessage());
			}
		} else Console.info("수정 취소합니다.");
	}
	
	private void delLaborer() {
		int laborerId = Console.inNum("노동자ID를 입력하세요.");
		
		if(laborerId != 0) {
			try {
				laborerService.delLaborer(laborerId);
				Console.info("노동자를 삭제했습니다.");
			} catch(NoneException e) {
				Console.err(e.getMessage());
			}
		} else Console.info("삭제 취소합니다.");
	}
}

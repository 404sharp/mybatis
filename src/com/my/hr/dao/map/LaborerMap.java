package com.my.hr.dao.map;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.my.hr.domain.Laborer;

// mapper interface
public interface LaborerMap {
	List<Laborer> selectLaborers();
	int insertLaborer(@Param("laborerName") String laborerName,
			@Param("hireDate") LocalDate hireDate);
	int updateLaborer(Laborer laborer);
	int deleteLaborer(int laborerId);
}

package ch06.dao.map;

import java.util.List;

import ch06.domain.Employee;

// data 이름+Map
public interface EmployeeMap {
	List<Employee> selectEmployees();
}

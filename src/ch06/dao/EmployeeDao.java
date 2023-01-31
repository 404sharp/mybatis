package ch06.dao;

import java.util.List;

import ch06.domain.Employee;

// DAO와 mapper는 비슷하다.
public interface EmployeeDao {
	List<Employee> selectEmployees();
}

package com.curso.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.curso.jdbc.models.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setId(rs.getInt(1));
		employee.setNombre(rs.getString("nombre"));
		employee.setApellido(rs.getString("apellido"));
		employee.setAge(rs.getInt("age"));
		employee.setSalario(rs.getDouble("salario"));
		
		
		return employee;
	}

}

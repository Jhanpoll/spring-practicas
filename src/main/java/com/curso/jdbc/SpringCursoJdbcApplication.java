package com.curso.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.h2.tools.RunScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.curso.jdbc.mappers.EmployeeRowMapper;
import com.curso.jdbc.models.entity.Employee;

@SpringBootApplication
public class SpringCursoJdbcApplication implements ApplicationRunner {
	@Autowired
	private JdbcTemplate template;

	private static final Logger log = LoggerFactory.getLogger(SpringCursoJdbcApplication.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		

		// FIN DEL BLOQUE 2

		/*
		 * INICIO DE BLOQUE 1 TEMPLORAL COMENTADO
		 * 
		 * 
		 * Double maxSalary =
		 * template.queryForObject("select MAX(salario) from employee", Double.class);
		 * int countEmployee = template.queryForObject("select count(1) from employee",
		 * int.class);
		 * 
		 * 
		 * int newEmployee = template.
		 * update("insert into employee(nombre,apellido,age,salario) values(?,?,?,?)"
		 * ,"jesus3","chero3","27",1700); int newEmployeeTwo = template.
		 * update("insert into employee(nombre,apellido,age,salario)values(?,?,?,?)",
		 * "jesus4","chero4",28,1800);
		 * 
		 * log.info("MAX salary {}", maxSalary); log.info("la cantidad es {}",
		 * countEmployee); log.info("fila nueva es {}", newEmployee);
		 * log.info("fila de newEmployeeTwo es {}",newEmployeeTwo);
		 * 
		 * 
		 * FIN DE BLOQUE 1 TEMPLORAL COMENTADO
		 */

	}

	public static void main(String[] args) {
		
		SpringApplication.run(SpringCursoJdbcApplication.class, args);

		
	}
			
}

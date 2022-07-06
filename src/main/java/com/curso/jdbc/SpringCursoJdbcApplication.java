package com.curso.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.curso.jdbc.mappers.EmployeeRowMapper;
import com.curso.jdbc.models.entity.Address;
import com.curso.jdbc.models.entity.Employee;

@SpringBootApplication
public class SpringCursoJdbcApplication implements ApplicationRunner {
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	JdbcstoreProcedure jdbcStoreProcedure;

	private static final Logger log = LoggerFactory.getLogger(SpringCursoJdbcApplication.class);
	
	private  void insertAddresses(List<Address>addresses) {
		int[] rowAddressesImpacted = template.batchUpdate("insert into address(street,pc,employee_id,number) "
				+ "values (?,?,?,?)", new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						// TODO Auto-generated method stub
						Address address = addresses.get(i);
						ps.setString(1, address.getStreet());
						ps.setInt(2, address.getPc());
						ps.setInt(3, address.getEmployee_id());
						ps.setString(4, address.getNumber());
					}

					@Override
					public int getBatchSize() {
						// TODO Auto-generated method stub
						return addresses.size();
					}
				});
		for (int rowAd : rowAddressesImpacted) {
			log.info("row addressess impacted : "+ rowAd);
		}
		
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		KeyHolder holder = new GeneratedKeyHolder();
		int rowsImpacted = template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement statement = con.prepareStatement("insert into address(street,pc,employee_id,number) "
						+ "values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, "calle san pedro");
				statement.setInt(2,26);
				statement.setInt(3,11);
				statement.setString(4, "23");
				return statement;
			}
		}, holder);
		
		log.info("rows impacted: "+rowsImpacted);
		log.info("generated keyholder: "+ holder.getKey().intValue() );
		
		jdbcStoreProcedure.ejecutarStoreProcedure();
		
		/*
		insertAddresses(Arrays.asList(new Address("calle san pedro",21,4,"23"),
				new Address("calle san pedro",21,10,"23"),
				new Address("calle san pedro",21,12,"23")
				));
			
		/*
		List<String> queryForList = template.queryForList("select nombre from employee where age>?",new Object[] {29},String.class);
		
		for (String name : queryForList) {
			log.info("nombre : "+name);
		}
		 */
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

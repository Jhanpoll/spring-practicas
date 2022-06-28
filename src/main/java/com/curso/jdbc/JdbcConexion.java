package com.curso.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConexion {
	
	public static void main(String[] args) {
		
		try {
			// conectando con bd H2
			//connection = DriverManager.getConnection("jdbc:h2:~/test");
			
			// CONECTANDOME CON LA BD MYSQL
			System.out.println("connecting...");
			
			 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_spring_jdbc","root","CHERO123");
			System.out.println("conected");
			/*
			System.out.println("executing script");
			RunScript.execute(connection, new FileReader("src/main/resources/prueba.sql"));
			System.out.println("insert new person");
			PreparedStatement rowStatement = connection.prepareStatement("insert into person(nombre,apellido,nickname)"
					+ "values(?,?,?)");
			
			rowStatement.setString(1,"jesus");
			rowStatement.setString(2,"chero");
			rowStatement.setString(3,"javalover");
			int row = rowStatement.executeUpdate();
			System.out.println("row impacted : "+ row);
			rowStatement.close();
			System.out.println("closing..");
			connection.close();
			System.out.println("closed");
			*/
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

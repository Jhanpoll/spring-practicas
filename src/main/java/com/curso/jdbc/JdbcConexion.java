package com.curso.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.tools.RunScript;

public class JdbcConexion {
	
	public static void main(String[] args) {
		
		try {
			// conectando con bd H2
			Connection connection = DriverManager.getConnection("jdbc:h2:~/test");
			
			// CONECTANDOME CON LA BD MYSQL
			System.out.println("connecting...");
			
			 //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_spring_jdbc","root","CHERO123");
			System.out.println("conected");
			
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
			
			rowStatement.setString(1,"jhanpoll");
			rowStatement.setString(2,"arge");
			rowStatement.setString(3,"c#lover");
			
			row = rowStatement.executeUpdate();
			
			System.out.println("row impacted : "+ row);
			
			rowStatement.close();
			
			/*realizar una query : select * from tabla*/
			PreparedStatement queryStatement = connection.prepareStatement("select * from person");
			ResultSet executeQuery = queryStatement.executeQuery();
			while(executeQuery.next()) {
				System.out.printf("\nid[%d] nombre[%s] apellid[%s] nickname[%s]", executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3),executeQuery.getString(4));
				
			}
			
			/*eliminar registros*/
			
			PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM person");
			int rowDelete = deleteStatement.executeUpdate();
			System.out.println("");
			System.out.println("row deleted : "+rowDelete);
			deleteStatement.close();
			
			System.out.println("closing..");
			connection.close();
			System.out.println("closed");
			
		} catch (SQLException | FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

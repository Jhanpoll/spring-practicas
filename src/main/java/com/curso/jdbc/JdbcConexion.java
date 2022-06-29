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
			
			boolean execute = rowStatement.execute();
			System.out.println("is insertion : "+ (execute==false));
			int updateCount = rowStatement.getUpdateCount();
			System.out.println("row impacted : "+ updateCount);
			
			rowStatement.close();
			
			/*realizar una query : select * from tabla*/
			PreparedStatement queryStatement = connection.prepareStatement("select * from person");
			boolean execute2 = queryStatement.execute();
			ResultSet resultSet = queryStatement.getResultSet();
			System.out.println("is resulset : " + execute2);
			//ResultSet executeQuery = queryStatement.executeQuery();
			while(resultSet.next()) {
				System.out.printf("\nid[%d] nombre[%s] apellid[%s] nickname[%s]", resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
				
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

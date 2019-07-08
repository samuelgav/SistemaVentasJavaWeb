package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Connection cx=null;
	private static final String DATABASE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DATABASE_DRIVER="oracle.jdbc.driver.OracleDriver";	
	private static final String DATABASE_USERNAME="facturacion";
	private static final String DATABASE_PASSWORD="123";
	
	public static Connection getConnection() {
		try {
			Class.forName(DATABASE_DRIVER);
			cx=DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
		} catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
		return cx;
	} 
	
}

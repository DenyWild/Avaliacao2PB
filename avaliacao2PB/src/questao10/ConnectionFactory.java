package questao10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	 private Connection connection;
		
		public ConnectionFactory() throws SQLException{

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/questao10?useTimezone=true&serverTimezone=UTC", "root", "root");
			

			this.connection = connection;
		}
		
		public Connection recuperaConexao() throws SQLException {
			
			return this.connection = connection;
			
		}

	
}

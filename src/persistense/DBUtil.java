package persistense;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String JDBC_URl = "jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=av3LabBanco;namedPipes=true";
	private static String JDBC_USER = "root";
	private static String JDBC_PASS = "";
	private static DBUtil instancia = null;
	private Connection con;
	
	private DBUtil() throws ClassNotFoundException { 
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
	}
	
	public static DBUtil getInstance() throws DAOException {
		if (instancia == null) { 
			try {
				instancia = new DBUtil();
			} catch (ClassNotFoundException e) {
				throw new DAOException(e);
			}
		}
		return instancia;
	}

	public Connection getConnection() throws DAOException {
		try {
			if (con == null || con.isClosed()) { 
				con = DriverManager.getConnection(JDBC_URl, JDBC_USER, JDBC_PASS);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return con;
	}
}

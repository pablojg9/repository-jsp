package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static final String url = "jdbc:postgresql://localhost:5432/bancojsp";
    private static final String user = "postgres";
    private static final String password = "arma1234";

    private static Connection connection = null;

    static {
        connect();
    }

    public SingleConnection() {
        connect();

    }

    private static void connect(){
        try {
            if (connection == null)
            {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
                System.out.println("O banco foi conectado com sucesso!");
                System.out.println("sout");
                System.out.println("sout");
                System.out.println("sout");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Connection getConnection() {
        return connection;
    }
}

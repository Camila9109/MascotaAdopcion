package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection connection;
    static String bd="railway";
    static String port = "7534";
    static String login = "root";
    static String password = "gUZeAssu4aba3lakIOpd";
    static String ip = "containers-us-west-20.railway.app";
    
   public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://"+ DBConnection.ip +":" + DBConnection.port + "/" + DBConnection.bd;
            connection=DriverManager.getConnection(url,this.login,this.password);
            System.out.println("conexion establecida");
        } catch (Exception ex) {
           System.out.println("error en la conexion");
           }
    }
   public Connection getConnection(){
       return connection;
   } 
   public void desconectar(){
       connection=null;
   }
}

package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class ConnectionToDB {
    public Connection connection = null;
    public Statement statement = null;

    public ConnectionToDB(){
        try{
            try{
                String url = "jdbc:mysql://127.0.0.1:3306/Project?user=root&password=Rocky-2811";
                connection = DriverManager.getConnection(url);
                statement = connection.createStatement();
                System.out.println(1);
            }
            catch(SQLSyntaxErrorException e){
                if(e.getLocalizedMessage().equals("Unknown database 'project'")){
                    String url = "jdbc:mysql://127.0.0.1:3306/?user=root&password=Rocky-2811";    
                    connection = DriverManager.getConnection(url);
                    statement = connection.createStatement();
                    statement.executeUpdate("create database Project");
                    statement.executeUpdate("use Project");
                    statement.executeUpdate("create table loginUser (username varchar(20), password varchar(20))");
                    statement.executeUpdate("insert into loginUser values ('admin', 'admin')");
                    System.out.println(2);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

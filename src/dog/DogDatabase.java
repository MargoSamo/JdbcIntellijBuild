package dog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DogDatabase {

    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost/dogs?allowPublicKeyRetrieval=true&useSSL=false";
            String username = "root";
            String password = "mariSQL66441";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            String sqlCommand = "CREATE TABLE breeds (Id INT PRIMARY KEY AUTO_INCREMENT, BreedName VARCHAR(20), Age INT)";

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();

                statement.executeUpdate(sqlCommand);

                System.out.println("Database has been created!");
            }
        }
        catch(Exception exception){
            System.out.println("Connection failed...");
            exception.printStackTrace();
        }
    }
}

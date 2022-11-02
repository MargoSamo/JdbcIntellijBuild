package dog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class HabitDatabase {
    public static void main(String[] args) {

        try{
            String url = "jdbc:mysql://localhost/habittwo?allowPublicKeyRetrieval=true&useSSL=false";
            String username = "root";
            String password = "mariSQL66441";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                /*PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO history (id, habit_name) VALUES (?, ?)");
                    stmt.setInt(1, 3);
                    stmt.setString(2, "yoga");
                    stmt.addBatch();
                stmt.executeBatch();*/

                PreparedStatement stmt1 = conn.prepareStatement(
                        "INSERT INTO history_records (history_id, records) VALUES (?, ?)");
                stmt1.setInt(1, 3);
                stmt1.setString(2, "FAILED");
                stmt1.addBatch();
                stmt1.executeBatch();
            }
        }
        catch(Exception exception){
            System.out.println("Connection failed...");
            exception.printStackTrace();
        }
    }
}

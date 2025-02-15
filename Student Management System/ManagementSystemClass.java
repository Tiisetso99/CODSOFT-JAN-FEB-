import java.sql.*;

class ManagementSystemClass{

    public class databaseConnection{

        private static Connection connection;

        public static Connection getConnection(){
            if (connection != null){
                try{
                    String url = "jdbc:mysql://localhost:33060/student_management_system_db";
                    String user = "root";
                    String password = "ilovemygfV22!";

                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("Database connected.");
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

    }

private Connection connection;

// establish connection to MYSQL database

public ManagementSystemClass(){

    this.connection = databaseConnection.getConnection();

    //try {
        
    //    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system_db", "root", "ilovemygfV22!");
    //    createTable();

    //} catch (SQLException e) {

    //    e.printStackTrace();

    //} 
}
 //private void createTable() throws SQLException{
 //   String query = "CREATE TABLE IF NOT EXISTS student_details (enrollNumber INT PRIMARY KEY, name VARCHAR(200), surname VARCHAR(200), email VARCHAR(200), phoneNumber VARCHAR (15), grade VARCHAR(10))";
 //   try(Statement statement = connection.createStatement()){
 //       statement.execute(query);
 //   }
 //}
public void addStudent (int enrollNumber, String name, String surname,  String email, String phoneNumber, String grade){

    if(this.connection ==null){
        System.out.println("Database connection failed...");
        return;
    }
    else{
        System.out.println("Connected to database");
    }

    String query = "INSERT INTO student_details (enrollNumber, name, surname,  email, phoneNumber, grade ) VALUES (?, ?, ?, ?, ?, ?)";
    try(PreparedStatement psment = connection.prepareStatement(query)){
        psment.setInt(1, enrollNumber);
        psment.setString(2, name);
        psment.setString(3, surname);
        psment.setString(4, email);
        psment.setString(5, phoneNumber);
        psment.setString(6, grade);
        psment.executeUpdate();

    } catch(SQLException e){
        System.err.println("Error adding student details");
    }

}

public void deleteStudent (int enrollNumber){
    String query = "DELETE FROM student_details WHERE enrollNumber =?";
    try(PreparedStatement psment = connection.prepareStatement(query)){
        psment.setInt(1, enrollNumber);
        psment.executeUpdate();

    } catch(SQLException e){
        System.err.println("Error deleting student details");
    }
}

public StudentClass findStudent (int enrollNumber){
    String query = "SELECT * FROM student_details WHERE enrollNumber = ?";
    try (PreparedStatement psment = connection.prepareStatement(query)){
        psment.setInt(1, enrollNumber);
        ResultSet resultSet = psment.executeQuery();
        if(resultSet.next()){
            return new StudentClass(
                
                resultSet.getString("name"), 
                resultSet.getString("surname"),
                resultSet.getInt("enrollNumber"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getString("grade"));
        }
    } catch(SQLException e){
        System.err.println("Error finding student details");
    }
    return null;
}

public void showStudents(){
    String query = "SELECT * FROM student_details";
    try(Statement sment = connection.createStatement(); 
    ResultSet resultSet = sment.executeQuery(query)){
        while(resultSet.next()){
            System.out.println("Enroll Number: " + resultSet.getInt("enrollNumber") + 
                               ", Name: " + resultSet.getString("name") + 
                               ", Surname: " + resultSet.getString("surname") + 
                               ", Email: " + resultSet.getString("email") +
                               ", Phone Number: " + resultSet.getString("phoneNumber") + 
                               ", Grade: " + resultSet.getString("grade"));
        }
    }catch(SQLException e){
       System.err.println("Error retriving student details");
    }
    
}

}
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqLiteDatabaseManager {

    public static User getUser(String login, String password) {
        Connection dbConn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        TypeOfUser typeOfUser = null;
        try {
            dbConn = DriverManager.getConnection("jdbc:sqlite:" +
                    SqLiteDatabaseManager.class.getClassLoader().getResource("data/GraidDB.db").getFile());


            for (TypeOfUser userType : TypeOfUser.values()) {
                String query = "SELECT * FROM " + userType.name() + "s WHERE Login = ? AND Password = ?";
                preparedStatement = dbConn.prepareStatement(query);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);

                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    typeOfUser = userType;
                    break;
                }
            }

            if (typeOfUser != null) {
                String firstName = resultSet.getString("First_Name");
                String lastName = resultSet.getString("Last_Name");
                String email = resultSet.getString("E_mail");

                return new User(firstName, lastName, email, typeOfUser);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (dbConn != null) {
                    dbConn.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}

package java112.labs4;
  
import java.io.*;
import java.sql.*;
  
/**
 *
 *@author     Eric Knapp
 *
 */
public class JDBCSelectEmployees {
  
    public void runSample() {
  
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
  
        try {
            Class.forName("org.mariadb.jdbc.Driver");
  
            connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost/student?serverTimezone=America/Chicago", "student", "student");
  
            statement = connection.createStatement();
  
            String name = "Rubble";
            String queryString = "SELECT emp_id, first_name, last_name"
                    + " FROM employees " + "WHERE last_name like '"
                    + name + "%'";
            String selectAll = "SElECT * FROM employees";
  
            System.out.println("queryString: " + selectAll);
  
            resultSet = statement.executeQuery(selectAll);
  
            System.out.println();
  
            while (resultSet.next()) {
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(" Row: " + employeeId + " "
                            + firstName + " " + lastName);
            }
  
            System.out.println();
  
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            String nameOne = resultSetMetaData.getColumnName(1);
            String typeOne = resultSetMetaData.getColumnTypeName(1);
            String labelOne = resultSetMetaData.getColumnLabel(1);
            System.out.println(" Column count : " + columns);
            System.out.println(" Column 1 name : " + nameOne);
            System.out.println(" Column 1 type : " + typeOne);
            System.out.println(" Column 1 label name : " + labelOne);
  
            System.out.println();
  
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
  
                if (statement != null) {
                    statement.close();
                }
  
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

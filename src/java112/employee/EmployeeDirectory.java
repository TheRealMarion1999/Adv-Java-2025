package java112.employee;

import java.util.ArrayList;
import java.util.Properties;
import java.io.*;
import java.sql.*;

/**
 * Handles SQL interactions with Employee Database
 * 
 * @author TheRealMarion1999
 */
public class EmployeeDirectory {
    private Properties properties;

    /**
     * Empty Constructor
     */
    public EmployeeDirectory() {

    }
    /**
     * Constructor for the class
     * @param properties a properties file
     */
    public EmployeeDirectory(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * Connects to the database
     * 
     * @return returns the connection
     */
    private Connection connectToDatabase() {
        final String DRIVER = properties.getProperty("driver");
        final String URL = properties.getProperty("url");
        final String USERNAME = properties.getProperty("username");
        final String PASSWORD = properties.getProperty("password");
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            //if (connection == null) {
            //    System.out.println("Connection Startup");
            //}
            connection = DriverManager.getConnection(
                    URL, USERNAME, PASSWORD);      
            //if (connection != null) {
            //    System.out.println("Connection complete");
            //}
            return connection;
  
        } catch (ClassNotFoundException classNotFound) {
            System.err.println("Class Error");
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            System.err.println("SQL Error");
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        return connection;
    }

    /**
     * assesses the search type and defers terms to the correct search function
     * @param searchType Type of search defined in the EmployeeSearch form
     * @param searchTerm Terms of search defined in the EmployeeSearch form
     * @return returns a search object containing a list of search results
     */
    public Search searchDatabase(String searchType, String searchTerm) {
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);
        switch (searchType) {
            case "ID":
                searchByID(searchTerm, search);
                break;
            case "firstName":
                searchByFirstName(searchTerm, search);
                break;
            case "lastName":
                searchByLastName(searchTerm, search);
                break;
            default:
                break;
        }
        return search;
    }

    /**
     * adds an employee to the database
     * @param firstName employee's first name
     * @param lastName employee's last name
     * @param employeeSsn employee's social security number
     * @param department employee's department
     * @param roomNumber employee's room number
     * @param phoneNumber employee's phone number
     */
    public int addEmployee(
        String firstName,
        String lastName,
        String employeeSsn,
        String department,
        String roomNumber,
        String phoneNumber) {
        String queryString = "INSERT INTO employees (first_name, last_name, ssn, dept, room, phone) " + 
        "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectToDatabase(); PreparedStatement preppedQuery = connection.prepareStatement(queryString)) {
            preppedQuery.setString(1, firstName);
            preppedQuery.setString(2, lastName);
            preppedQuery.setString(3, employeeSsn);
            preppedQuery.setString(4, department);
            preppedQuery.setString(5, roomNumber);
            preppedQuery.setString(6, phoneNumber);
            return preppedQuery.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
    
    /**
     * searches the database and modifies the search object passed by searchDatabase
     * @param searchTerm search term passed from searchDatabase
     * @param search search object passed from searchDatabase
     */
    private void searchByID(String searchTerm, Search search) {
        String sql = "SELECT * FROM employees WHERE emp_id = ?";
        try (Connection connection = connectToDatabase(); PreparedStatement prepQuery = connection.prepareStatement(sql)) {
            prepQuery.setString(1, searchTerm);
            ArrayList<Employee> employees = new ArrayList<Employee>();
            try (ResultSet resultSet = prepQuery.executeQuery();) {
                createSearchList(resultSet, employees, search);
            }
            if (employees.size() > 0) {
                search.setEmployeesFound(true);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


    /**
     * searches the database and modifies the search object passed by searchDatabase
     * @param searchTerm search term passed from searchDatabase
     * @param search search object passed from searchDatabase
     */
    private void searchByFirstName(String searchTerm, Search search) {
        String sql = "SELECT * FROM employees WHERE first_name LIKE ?";
        try (Connection connection = connectToDatabase(); PreparedStatement prepQuery = connection.prepareStatement(sql)){
            prepQuery.setString(1, searchTerm);
            ArrayList<Employee> employees = new ArrayList<Employee>();
            try (ResultSet resultSet = prepQuery.executeQuery();) {
                createSearchList(resultSet, employees, search);
            }
            if (employees.size() > 0) {
                search.setEmployeesFound(true);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * searches the database and modifies the search object passed by searchDatabase
     * @param searchTerm search term passed from searchDatabase
     * @param search search object passed from searchDatabase
     */
    private void searchByLastName(String searchTerm, Search search) {
        String sql = "SELECT * FROM employees WHERE last_name LIKE ?";
        try (Connection connection = connectToDatabase(); PreparedStatement prepQuery = connection.prepareStatement(sql)){
            prepQuery.setString(1, searchTerm);
            ArrayList<Employee> employees = new ArrayList<Employee>();
            try (ResultSet resultSet = prepQuery.executeQuery();) {
                createSearchList(resultSet, employees, search);
            }
            if (employees.size() > 0) {
                search.setEmployeesFound(true);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * populates the Search object's array list
     * @param resultSet ResultSet passed from a search function 
     * @param employees an Arraylist that will be added to the Seach object
     * @param search the search object passed from searchDatabase
     * @throws SQLException if there is an SQL error
     * @throws SQLTimeoutException if there is a timeout during SQL procedures
     */
    private void createSearchList(ResultSet resultSet, ArrayList employees, Search search) throws SQLException, SQLTimeoutException {
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getNString("emp_id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setEmployeeSsn(resultSet.getString("ssn"));
            employee.setDepartment(resultSet.getString("dept"));
            employee.setRoomNumber(resultSet.getString("room"));
            employee.setPhoneNumber(resultSet.getString("phone"));
            employees.add(employee);
        }
        resultSet.close();
        search.setResults(employees);
    }
}
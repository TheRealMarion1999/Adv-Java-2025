package java112.employee;

import java.util.ArrayList;

/**
 * A Javabean that stores search information to be output by EmployeeSearchResults
 * 
 * @author TheRealMarion1999
 */

public class Search {
    private String searchType;
    private String searchTerm;
    private ArrayList<Employee> results;
    private boolean employeesFound;

    /**Standard empty constructor for a java bean */
    public Search() {

    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setSearchType(String value) {
        searchType = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setSearchTerm(String value) {
        searchTerm = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setResults(ArrayList value) {
        results = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setEmployeesFound(boolean value) {
        employeesFound = value;
    }
    
    /**
     * standard getter for a java bean
     * 
     * @return returns the search Type
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * standard getter for a javabean
     * @return returns the search term
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * standard getter for a javabean
     * @return returns the list of employees
     */
    public ArrayList getResults() {
        return results;
    }

    /**
     * standard getter for a javabean
     * @return returns if employees have been found
     */
    public boolean getEmployeesFound() {
        return employeesFound;
    }

    @Override
    public String toString() {
        return "Search Object:" + 
                "\n search type: " + searchType +
                "\n search term: " + searchTerm + 
                "\n results: " + results + 
                "\n employees found" + employeesFound;
    }
}
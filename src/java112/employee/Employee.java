package java112.employee;

/**
 * Java Bean for tracking employee data
 * 
 * @author TheRealMarion1999
 */

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String employeeSsn;
    private String department;
    private String roomNumber;
    private String phoneNumber;

    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setEmployeeId(String value) {
        employeeId = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setFirstName(String value) {
        firstName = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setLastName(String value) {
        lastName = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setEmployeeSsn(String value) {
        employeeSsn = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setDepartment(String value) {
        department = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setRoomNumber(String value) {
        roomNumber = value;
    }
    /**
     * standard setter for a java bean
     * @param value the input value
     */
    public void setPhoneNumber(String value) {
        phoneNumber = value;
    }
    /**
     * standard getter for a java bean
     * 
     * @return returns the employee's ID
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * standard getter for a java bean
     * 
     * @return returns the employee's first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * standard getter for a java bean
     * 
     * @return employee's last name
     */
    public String getLastName() {
        return lastName;
    }

        /**
     * standard getter for a java bean
     * 
     * @return returns employee's social security number
     */
    public String getEmployeeSsn() {
        return employeeSsn;
    }

        /**
     * standard getter for a java bean
     * 
     * @return returns employee's department
     */
    public String getDepartment() {
        return department;
    }

        /**
     * standard getter for a java bean
     * 
     * @return returns employee's room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * standard getter for a java bean
     * 
     * @return returns the employee's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee Object:" + 
                "\n ID: " + employeeId +
                "\n First Name: " + firstName + 
                "\n Last Name: " + lastName + 
                "\n SSN: " + employeeSsn +
                "\n Department: " + department +
                "\n Room Number: " + roomNumber +
                "\n Phone Number: " + phoneNumber;
    }
}
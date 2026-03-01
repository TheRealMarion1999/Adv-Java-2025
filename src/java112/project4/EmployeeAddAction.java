package java112.project4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java112.employee.EmployeeDirectory;
import java112.utilities.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "EmployeeAddAction", 
    urlPatterns = { "/employeeAddAction" }
)
public class EmployeeAddAction extends HttpServlet {
    /**
     * Run on server startup. Does Nothing.
     * @throws ServletException if there is a Servlet failure
     */
    public void init()
        throws ServletException {
            
    }

    /**
     *  Handles HTTP POST requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String ssn = request.getParameter("ssn");
        String department = request.getParameter("department");
        String roomNum = request.getParameter("room#");
        String phoneNum = request.getParameter("phone#");
        String url = "/java112/employeeAdd.jsp";

        EmployeeDirectory empDir = (EmployeeDirectory) context.getAttribute("Dir");
        int success = empDir.addEmployee(firstName, lastName, ssn, department, roomNum, phoneNum);
        session.setAttribute("success", success);
        response.sendRedirect(url);
    }
}
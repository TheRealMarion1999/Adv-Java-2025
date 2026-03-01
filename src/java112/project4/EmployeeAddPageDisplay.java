package java112.project4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java112.utilities.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "EmployeeAdd", 
    urlPatterns = { "/employeeAdd" }
)
public class EmployeeAddPageDisplay extends HttpServlet {
    public void init()
        throws ServletException {

    }
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = request.getSession();

        String url = "/employeeAdd.jsp";

        //session.setAttribute("success", false);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
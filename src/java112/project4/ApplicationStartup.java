package java112.project4;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java112.employee.EmployeeDirectory;
import java112.utilities.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "applicationStartup", 
    urlPatterns = { "/project4-startup" },
    loadOnStartup = 1
)
/**
 * Servlet which runs on startup, initializes the properties file and sets up the EmployeeDirectory
 */
public class ApplicationStartup  extends HttpServlet implements PropertiesLoader {
    private Properties properties;
    /**
     * Run on startup. loads properties, initializes EmployeeDirectory and adds it to the Servlet Context.
     */
    public void init() {
        properties = loadProperties("/project4.properties");
        EmployeeDirectory main = new EmployeeDirectory(properties);
        ServletContext context = getServletContext();
        context.setAttribute("Dir", main);
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
        //ServletContext context = getServletContext();
    }
}
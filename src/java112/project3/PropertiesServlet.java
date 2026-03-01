package java112.project3;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java112.utilities.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "project3PropertiesServlet", 
    urlPatterns = { "/project3-properties" }
)
public class PropertiesServlet extends HttpServlet implements PropertiesLoader{
    private Properties properties;
    public void init()
        throws ServletException {
        properties = loadProperties("/project3.properties");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        PropertiesBean propBean = new PropertiesBean();
        for (String key : properties.stringPropertyNames()) {
            request.setAttribute(key.toString(), properties.get(key).toString());
        }
        request.setAttribute("properties", propBean);
        String url = "/properties.jsp";
 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
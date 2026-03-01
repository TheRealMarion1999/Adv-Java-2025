package java112.project2;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java112.utilities.*;
import javax.servlet.annotation.*;


@WebServlet(
    name = "ProjectServlet", 
    urlPatterns = { "/project2Properties" }
)
public class PropertiesServlet extends HttpServlet implements PropertiesLoader {
    private Properties properties;
    public void init()
        throws ServletException {
        properties = loadProperties("/project2.properties");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        response.setContentType("text/html");
        
        out.print("<table>");
        //this is gross! But I needed a way to work with a keyset on properties and strings wouldn't do it!
        //for (Object key : properties.keySet()) {
            //out.print("<tr>" + "<td>" + key + "</td><td>" + properties.get(key) + "</td></tr>");
        //}
        for (String key : properties.stringPropertyNames()) {
            out.print("<tr>" + "<td>" + key + "</td><td>" + properties.get(key) + "</td></tr>");
        }
        out.print("</table>");


        out.print("</BODY>");
        out.print("</HTML>");
        out.close();

    }
}
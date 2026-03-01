package java112.project2;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java112.utilities.*;
import javax.servlet.annotation.*;


@WebServlet(
    name = "FirstServlet", 
    urlPatterns = { "/project2First" }
)
public class FirstServlet extends HttpServlet implements PropertiesLoader {
    private Properties properties;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>FirstServlet</h1>");
        out.print("<h2>Name: Marion Niesen</h2>");
        out.print("<h3>Class: Java 112</h2>");
        out.print("<img src=\"images/raccooon.png\" alt=\"Girl in a jacket\">");
        out.print("<br><a href=\"/java112\">back to homepage</a>");
        System.out.println("Is this logging?");
        log("Is this logging?");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
        
    }
    //"Use a loop",  it says... like I know how to do that here...!
    //but actually, couldn't I do it the same way that it's done with php?
    //that was based on the size of an SQL table though, so possibly not the same thing. Worth a shot though...
}
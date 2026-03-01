package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java112.utilities.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "Lab32Servlet", 
    urlPatterns = { "/Lab3-2" }
)
public class lab32 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.print("<HTML>");
    out.print("<HEAD><TITLE>Sample Output</TITLE></HEAD>");
    out.print("<BODY>");
    out.print("<h1>Server Name</h1>");
    out.print("<p>" + request.getServerName() + "</p>");
    out.print("<p>" + request.getLocalName() + "</p>");
    out.print("<p>" + request.getContextPath() + "</p>");
    out.print("<p>" + request.getScheme() + "</p>");
    out.print("</BODY>");
    out.print("</HTML>");
    out.close();
}
}
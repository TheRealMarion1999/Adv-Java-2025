package java112.project3;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java112.utilities.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "requestServlet", 
    urlPatterns = { "/request-servlet" }
)
/**
 * standard servlet
 * 
 * @author TheRealMarion1999
 */
public class HttpRequestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        HttpRequestData theBean = new HttpRequestData();
        theBean.setRemoteComp(request.getRemoteHost());
        theBean.setRemoteCompAddress(request.getRemoteAddr());
        theBean.setHttpMethod(request.getMethod());
        theBean.setRequestURI(request.getRequestURI());
        theBean.setRequestURL(request.getRequestURL() + "");
        theBean.setRequestProtocol(request.getProtocol());
        theBean.setServerName(request.getServerName());
        theBean.setServerLocale(request.getLocale() + "");
        theBean.setServerPort(request.getServerPort() + "");
        theBean.setQueryString(request.getQueryString());
        theBean.setQueryParameter(request.getParameter("queryParameter"));
        theBean.setUserAgent(request.getHeader("User-Agent"));
        //response.setContentType("text/html");
        request.setAttribute("bean", theBean);
        /**
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>TrivialServlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<p>" + theBean.getRemComp() + "</p>");
        out.print("<p>" + theBean.getRemCompAdd() + "</p>");
        out.print("<p>" + theBean.getReqURI() + "</p>");
        out.print("<p>" + theBean.getReqURL() + "</p>");
        out.print("<p>" + theBean.getReqProtocol() + "</p>");
        out.print("<p>" + theBean.getServerName() + "</p>");
        out.print("<p>" + theBean.getServerLocale() + "</p>");
        out.print("<p>" + theBean.getServerPort() + "</p>");
        out.print("<p>" + theBean.getUserAgent() + "</p>");
        out.print("<p>" + theBean.getQueryString() + "</p>");
        out.print("<p>" + theBean.getQueryParam() + "</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
        */
 
        String url = "/httpRequestData.jsp";
 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
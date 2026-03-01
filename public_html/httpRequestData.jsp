<!DOCTYPE html>
 
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>
            Dusplic by Free Css Templates
        </title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="default.css" rel="stylesheet" type="text/css" />
    </head>
 
  <body>
    <%@ include file="temp-header.jsp" %>
        <div id="content">
            <div id="posts">
                <!--Figure out how to make this variable!!!-->
                <%@ include file="post.jsp" %>
                <div class="post">
                    <h2 class="title">
                        Sample Tags
                    </h2>
                    <h3 class="posted">
                        Posted on January 1st, 2007 by Author
                    </h3>
                    <div class="story">
                      <h3>Bean Data</h3>
                      
                      <br />
                        <ul>
                            <li>
                                <p>Remote Computer Access: ${bean.remoteComp}</p>
                            </li>
                            <li>
                                <p>Remote Computer Address: ${bean.remoteCompAddress}</p>
                            </li>
                            <li>
                                <p>HTTP Method: ${bean.httpMethod}</p>
                            </li>
                            <li>
                                <p>Request URI: ${bean.requestURI}</p>
                            </li>
                            <li>
                                <p>Request URL: ${bean.requestURL}</p>
                            </li>
                            <li>
                                <p>Request Protocol: ${bean.requestProtocol}</p>
                            </li>
                            <li>
                                <p>Server Name: ${bean.serverName}</p>
                            </li>
                            <li>
                                <p>Server Port: ${bean.serverPort}</p>
                            </li>
                            <li>
                                <p>Server Locale: ${bean.serverLocale}</p>
                            </li>
                            <li>
                                <p>Query String: ${bean.queryString}</p>
                            </li>
                            <li>
                                <p>Query Parameter: ${bean.queryParameter}</p>
                            </li>
                            <li>
                                <p>User Agent: ${bean.userAgent}</p>
                            </li>
                            <li>
                                <a href="/java112">Home</a>
                            </li>
                        </ul>
                    </div>
                    <%@ include file="meta.jsp" %>
                </div>
            </div>
            <%@ include file="archives.jsp" %>
            <%@ include file="categories.jsp" %>
            <%@ include file="blogroll.jsp" %>
            <%@ include file="pages.jsp" %>
            <%@ include file="search.jsp" %>
        </div>
  </body>
</html>

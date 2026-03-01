<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
-->
<html xmlns="http://www.w3.org/1999/xhtml">
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
            <c:import url="temp-header.jsp"></c:import>
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
                        <p>
                            An ordered list:
                        </p>
                        <ol>
                            <li>
                                <a href="linkingDemo.html">GWUH??</a>
                            </li>
                            <li>
                                <a href="myFirstJSP.jsp">BUH??????????????</a>
                            </li>
                            <li>
                                <a href="request-servlet?queryParameter=beans">This is where Project 3 is.</a>
                            </li>
                            <li>
                                <a href="project3-properties">This is where Project 3 Properties are.</a>
                            </li>
                        </ol>
                        <h3>
                            Project 4:
                        </h3>
                        <ul>
                            <li><a href="employeeAdd">Add Employee</a></li>
                            <li><a href="employeeSearch">Search Employee</a></li>
                        </ul>
                        <blockquote>
                            <p>
                                “Et pulvinar pede ligula a sapien. Donec fermentum condimentum nisi. Proin iaculis mauris id lorem viverra molestie. Duis vel orci. Nam consequat. Morbi nec lacus.”
                            </p>
                        </blockquote>
                    </div>
                    <div class="meta">
                        <p>
                            Filed under <a href="#" class="category">Uncategorized</a> | <a href="#" class="comment">1 Comment »</a><br />
                            <!--This theme is free for distriubtion,  so long as  link to openwebdesing.org and dubaiapartments.biz  stay on the theme--> Courtesy <a href="http://www.openwebdesign.org" target="_blank">Open Web Design</a><a href="http://www.dubaiapartments.biz" target="_blank"><img src="spacer.gif" width="5" height="5" border="0" /></a>Thanks to <a href="http://www.dubaiapartments.biz/" target="_blank">Dubai Hotels</a>
                        </p>
                    </div>
                </div>
            </div>
            <c:import url="archives.jsp"></c:import>
            <c:import url="categories.jsp"></c:import>
            <c:import url="blogroll.jsp"></c:import>
            <c:import url="pages.jsp"></c:import>
            <c:import url="boxedSearch.jsp"></c:import>
        </div>
        <div id="footer">
            <p>
                Copyright © 2006 Dusplic. Designed by <a href="http://www.freecsstemplates.org/"><strong>Free CSS Templates</strong></a> | <a href="http://validator.w3.org/check/referer" title="This page validates as XHTML 1.0 Transitional">Valid <abbr title="eXtensible HyperText Markup Language">XHTML</abbr> | Courtesy</a> <a href="http://www.openwebdesign.org" target="_blank">Open Web Design</a>
            </p>
        </div>
    </body>
</html>

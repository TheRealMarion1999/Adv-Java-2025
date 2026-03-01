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
                        Project 4
                    </h2>
                    <h3 class="posted">
                        Add Employee
                    </h3>
                    <c:if test="${not empty success}">
                        <c:if test="${success == 0}">
                            <p>The employee was not successfully added</p>
                        </c:if>
                        <c:if test="${success >= 1}">
                            <p>The employee was added successfully.</p>
                        </c:if>
                        <c:remove var="success" scope="session"/>
                    </c:if>
                    <form method="POST" action="employeeAddAction">
                        <input type="text" id="first" name="first" placeholder="first name" required maxlength="25">
                        <input type="text" id="last" name="last" placeholder="last name" required maxlength="30">
                        <input type="tel" id="ssn" name="ssn" placeholder="ssn" required maxlength="10">
                        <input type="text" id="department" name="department" placeholder="department" required maxlength="10">
                        <input type="number" id="room#" name="room#" placeholder="room number" required maxlength="10">
                        <input type="tel" id="phone#" name="phone#" placeholder="phone number" required maxlength="10">
                        <button type="submit">submit</button>
                    </form>
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
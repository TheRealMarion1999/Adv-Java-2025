<html>
    <%@ include file="head.jsp" %>
    <%@ include file="temp-header.jsp" %>
    <div id="content">
        <div id="posts">
            <div class="story">
                <table>
                    <!--Kind of less elegant than the other way imo-->
                    <tr>
                        <th>Property Name</th>
                        <th>Property Data</th>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>${myName}</td>
                    </tr>
                    <tr>
                        <td>E-Mail</td>
                        <td>${myEmail}</td>
                    </tr>
                    <tr>
                        <td>Course Name</td>
                        <td>${courseTitle}</td>
                    </tr>
                    <tr>
                        <td>Course Meeting Times</td>
                        <td>${courseMeetingTimes}</td>
                    </tr>
                    <tr>
                        <td>Course Professor</td>
                        <td>${courseProfessor}</td>
                    </tr>
                    <tr>
                        <td>Multi Line Description</td>
                        <td>${multiLineDescription}</td>
                    </tr>
                </table>
            </div>
            <%@ include file="meta.jsp" %>

        </div>
        <%@ include file="archives.jsp" %>
        <%@ include file="categories.jsp" %>
        <%@ include file="blogroll.jsp" %>
        <%@ include file="pages.jsp" %>
        <%@ include file="search.jsp" %>
    </div>

</html>
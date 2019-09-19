<%--
  Created by IntelliJ IDEA.
  User: SarojThapa
  Date: 9/18/2019
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
<head>
    <title>Number Quiz</title>
</head>
<body>
    <div>
    <h1>The Number Quiz</h1>
        <br />
        <p>Your Current score is <c:out value="${quiz.score}"></c:out></p>
        <p>Guess the next number in the sequence</p>
        <br/>
       <p> <c:out value="${question}"></c:out></p>
        <form method="post" action="check">
        <p>Your answer: <input type="text" name="answer"></p>
         <br/>
          <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

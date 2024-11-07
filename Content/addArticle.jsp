<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Add Article</title></head>
<body>
    <h2>Add New Article</h2>
    <form action="addArticle" method="post">
        Title: <input type="text" name="title"><br>
        Content: <textarea name="content"></textarea><br>
        Author: <input type="text" name="author"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>

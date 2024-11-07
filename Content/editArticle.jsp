<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Edit Article</title></head>
<body>
    <h2>Edit Article</h2>
    <form action="editArticle" method="post">
        <input type="hidden" name="id" value="${article.id}">
        Title: <input type="text" name="title" value="${article.title}"><br>
        Content: <textarea name="content">${article.content}</textarea><br>
        Author: <input type="text" name="author" value="${article.author}"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Articles List</title></head>
<body>
    <h2>Articles List</h2>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Content</th>
            <th>Author</th>
            <th>Created At</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="article" items="${articles}">
            <tr>
                <td>${article.title}</td>
                <td>${article.content}</td>
                <td>${article.author}</td>
                <td>${article.createdAt}</td>
                <td>
                    <a href="editArticle?id=${article.id}">Edit</a>
                    <a href="deleteArticle?id=${article.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="addArticle.jsp">Add New Article</a>
</body>
</html>

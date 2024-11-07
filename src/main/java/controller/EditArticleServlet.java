package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDAO;
import model.Article;

@WebServlet("/editArticle")
public class EditArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleDAO articleDAO = new ArticleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            Article article = articleDAO.getArticleById(id);
            request.setAttribute("article", article);
            request.getRequestDispatcher("editArticle.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");

        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);

        try {
            articleDAO.updateArticle(article);
            response.sendRedirect("listArticles");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

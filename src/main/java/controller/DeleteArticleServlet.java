package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDAO;

@WebServlet("/deleteArticle")
public class DeleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleDAO articleDAO = new ArticleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            articleDAO.deleteArticle(id);
            response.sendRedirect("listArticles");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}

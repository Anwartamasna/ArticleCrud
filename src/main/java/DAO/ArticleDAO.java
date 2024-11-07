package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Article;
import model.DatabaseUtil;

public class ArticleDAO {

    public List<Article> getAllArticles() throws SQLException {
        List<Article> articles = new ArrayList<>();
        Connection connection = DatabaseUtil.getConnection();
        String sql = "SELECT * FROM articles";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Article article = new Article();
            article.setId(resultSet.getInt("id"));
            article.setTitle(resultSet.getString("title"));
            article.setContent(resultSet.getString("content"));
            article.setAuthor(resultSet.getString("author"));
            article.setCreatedAt(resultSet.getString("created_at"));
            articles.add(article);
        }
        return articles;
    }

    public void addArticle(Article article) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "INSERT INTO articles (title, content, author) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, article.getTitle());
        statement.setString(2, article.getContent());
        statement.setString(3, article.getAuthor());
        statement.executeUpdate();
    }

    public void updateArticle(Article article) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "UPDATE articles SET title = ?, content = ?, author = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, article.getTitle());
        statement.setString(2, article.getContent());
        statement.setString(3, article.getAuthor());
        statement.setInt(4, article.getId());
        statement.executeUpdate();
    }

    public void deleteArticle(int id) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "DELETE FROM articles WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

	public Article getArticleById(int id) throws SQLException {
    Article article = null;
    Connection connection = DatabaseUtil.getConnection();
    String sql = "SELECT * FROM articles WHERE id = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1, id);
    ResultSet resultSet = statement.executeQuery();

    if (resultSet.next()) {
        article = new Article();
        article.setId(resultSet.getInt("id"));
        article.setTitle(resultSet.getString("title"));
        article.setContent(resultSet.getString("content"));
        article.setAuthor(resultSet.getString("author"));
        article.setCreatedAt(resultSet.getString("created_at"));
    }
    return article;
}

}


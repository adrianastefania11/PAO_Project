package Repositories;
import Entities.Autor;
import Entities.Props.PublishingHouse;
import config.DatabaseConnection;
import Entities.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BookRepos {
    public void addBook(Book book) {
        String query = "insert into Book values (null, ?, ?, ?, ?,?,?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, book.getTitle());
            statement.setInt(2, Book.getIsbn());
            statement.setInt(3, Book.getNumber());
            statement.setString(4, String.valueOf(book.getAutor()));
            statement.setString(5,String.valueOf(book.getPublishingHouse()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateNumber(Book book, int number) {
        String query = "update `book` set `number` = ? where `isbn` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setFloat(1, number);
            statement.setInt(2, book.getIsbn());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteBook(Book book) {
        String query = "delete from `book` where `isbn` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setInt(1, book.getIsbn());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public Map<Integer, Book> getAllBooks() {
        Map map = new HashMap<Integer, Book>();
        String query = "select * from book;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                int id = resultSet.getInt(1);
                book.setIsbn(id);
                book.setTitle(resultSet.getString(2));
                book.setAutor((Autor) resultSet.getObject(3));
                book.setPublishingHouse((PublishingHouse) resultSet.getObject(4));
                book.setNumber(resultSet.getInt(5));
                map.put(id, book);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }




}

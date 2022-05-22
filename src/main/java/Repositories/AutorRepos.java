package Repositories;
import Entities.Autor;
import Entities.Book;
import config.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class AutorRepos {

    public void addAutor(Autor autor) {
        String query = "insert into Autor values (null, ?, ?, );";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, autor.getName());
            statement.setString(2,String.valueOf(autor.getBooks()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateName(Autor autor, String nume) {
        String query = "update `autor` set `nume` = ? where `name` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, autor.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteAutor(Autor autor) {
        String query = "delete from `Autor` where `name` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, autor.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Autor> getAllAutors() {
        Map map = new HashMap<Integer, Autor>();
        String query = "select * from autor;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Autor autor = new Autor();
                int id = resultSet.getInt(1);
                autor.setId(id);
                autor.setName(resultSet.getString(2));
                autor.setBooks((Set<Book>) resultSet.getObject(3));
                map.put(id, autor);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;

    }


}

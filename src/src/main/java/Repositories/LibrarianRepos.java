package Repositories;
import Entities.library.Librarian;
import config.DatabaseConnection;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibrarianRepos {
    public void addLibrarian(Librarian librarian) {
        String query = "insert into Librarian values (null, ?, ?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, librarian.getName());
            statement.setArray(2, (Array) librarian.getMembers());

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateName(Librarian librarian, String nume) {
        String query = "update `Librarian` set `nume` = ? where `name` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, librarian.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteLibrarian(Librarian librarian) {
        String query = "delete from `Librarian` where `name` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, librarian.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

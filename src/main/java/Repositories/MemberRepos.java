package Repositories;
import Entities.Book;
import Entities.library.Member;
import config.DatabaseConnection;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemberRepos {
    public void addMember(Member member) {
        String query = "insert into Member values (null, ?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, member.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateName(Member member, String nume) {
        String query = "update `Member` set `nume` = ? where `name` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, member.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteMember(Member member) {
        String query = "delete from `Member` where `name` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, member.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, Member> getAllMembers() {
        Map<Integer, Member> map = new HashMap<>();
        String query = "select * from Member;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Member member = new Member();
                int id = resultSet.getInt(1);
                member.setId(id);
                member.setName(resultSet.getString(2));
                member.setAllBooksRead((List<Book>) resultSet.getArray(3));
                map.put(id, member);

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;

    }


}

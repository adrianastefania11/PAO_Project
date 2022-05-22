package Repositories;


import Entities.Props.PublishingHouse;

import config.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class PublishingHouseRepos {


    public void addPublishingHouse(PublishingHouse publishingHouse) {
        String query = "insert into PublishingHouse values (null, ?);";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, publishingHouse.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateName(PublishingHouse publishingHouse, String nume) {
        String query = "update `PublishingHouse` set `nume` = ? where `name` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, publishingHouse.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deletePublishingHouse(PublishingHouse publishingHouse) {
        String query = "delete from `PublishingHouse` where `name` = ?;";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, publishingHouse.getName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Map<Integer, PublishingHouse> getAllPublisingHouses() {
        Map map = new HashMap<Integer, PublishingHouse>();
        String query = "select * from PublishingHouse;";
        try{
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PublishingHouse publishingHouse = new PublishingHouse();
                int id = resultSet.getInt(1);
                publishingHouse.setId(id);
                publishingHouse.setName(resultSet.getString(2));
                map.put(id, publishingHouse);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return map;

    }
}

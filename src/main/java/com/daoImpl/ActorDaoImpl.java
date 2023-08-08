package com.highradius.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.highradius.Dao.ActorDao;
import com.highradius.pojo.Actor;
import com.highradius.connection.DBConnection;
import com.highradius.exceptions.CustomException;

public class ActorDaoImpl implements ActorDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    /**
     * The method for getting all actors from the database.
     */
    @Override
    public List<Actor> getAllActors() throws CustomException {
        String sql = "SELECT actor_id, first_name, last_name FROM actor";
        connection = DBConnection.getConnection();
        List<Actor> actors = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Actor actor = new Actor();
                actor.setActorId(resultSet.getInt("actor_id"));
                actor.setFirstName(resultSet.getString("first_name"));
                actor.setLastName(resultSet.getString("last_name"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            throw new CustomException("An SQL error occurred while fetching actors: " + e.getMessage());
        } catch (Exception e) {
            throw new CustomException("An error occurred while fetching actors: " + e.getMessage());
        } finally {
            closeResources();
        }
        return actors;
    }
    
    /**
     * The method to check whether the actor is in database or not
     */
    @Override
    public boolean exist(Actor actor) throws CustomException {
        boolean found = false;
        String sql = "SELECT * FROM actor WHERE first_name=? AND last_name=?";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, actor.getFirstName());
            preparedStatement.setString(2, actor.getLastName());
            ResultSet resultSet = preparedStatement.executeQuery();
            found = resultSet.next();
        } catch (SQLException e) {
            throw new CustomException("An SQL error occurred while checking if actor exists: " + e.getMessage());
        } catch (Exception e) {
            throw new CustomException("An error occurred while checking if actor exists: " + e.getMessage());
        } finally {
            closeResources();
        }
        return found;
    }
    /**
     * The method for adding a actor into the database.
     */
    @Override
    public int addActor(Actor actor) throws CustomException {
        int result;
        String sql = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, actor.getFirstName());
            preparedStatement.setString(2, actor.getLastName());
            result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Data added successfully.");
            } else {
                throw new CustomException("Failed to add actor. Please check the provided data.");
            }
        } catch (SQLException e) {
            throw new CustomException("An SQL error occurred while adding actor: " + e.getMessage());
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException("An error occurred while adding actor: " + e.getMessage());
        } finally {
            closeResources();
        }
        return result;
    }
    	/**
    	 * The method for updating a actor in the database.
    	 */
    @Override
    public int updateActor(Actor actor) throws CustomException {
        int result;
        String sql = "UPDATE actor SET first_name=?, last_name=? WHERE actor_id=?";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, actor.getFirstName());
            preparedStatement.setString(2, actor.getLastName());
            preparedStatement.setInt(3, actor.getActorId());
            result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Data updated successfully.");
            } else {
                throw new CustomException("Failed to update actor. Please check the provided data.");
            }
        } catch (SQLException e) {
            throw new CustomException("An SQL error occurred while updating actor: " + e.getMessage());
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException("An error occurred while updating actor: " + e.getMessage());
        } finally {
            closeResources();
        }
        return result;
    }
    
    /**
     * The method for deleting  a actor record from the database.
     */
    @Override
    public int deleteActor(Actor actor) throws CustomException {
        int result;
        String sql = "DELETE FROM actor WHERE actor_id=?";
        connection = DBConnection.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, actor.getActorId());
            result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Data deleted successfully.");
            } else {
                throw new CustomException("Failed to delete actor. Please check the provided data.");
            }
        } catch (SQLException e) {
            throw new CustomException("An SQL error occurred while deleting actor: " + e.getMessage());
        } catch (CustomException e) {
            throw e;
        } catch (Exception e) {
            throw new CustomException("An error occurred while deleting actor: " + e.getMessage());
        } finally {
            closeResources();
        }
        return result;
    }
    	/**
    	 * The method for keeping all the resources like closing connection.
    	 */
    // Close the prepared statement and connection
    private void closeResources() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("An error occurred while closing resources: " + e.getMessage());
        }
    }
}
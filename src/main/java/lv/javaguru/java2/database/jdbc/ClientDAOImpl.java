package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ClientDAO;
import lv.javaguru.java2.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ingsaf on 23/03/17.
 */
public class ClientDAOImpl extends DAOImpl implements ClientDAO {


    public Client save(Client client) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into CLIENT values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getSts());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                client.setIdClient(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ClientDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return client;
    }

    public Optional<Client> getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from CLIENT where IdClient = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Client client = null;
            if (resultSet.next()) {
                client = new Client();
                client.setIdClient(resultSet.getLong("IdClient"));
                client.setFirstName(resultSet.getString("FirstName"));
                client.setLastName(resultSet.getString("LastName"));
                client.setSts(resultSet.getString("Sts"));
            }
            return Optional.ofNullable(client);
        } catch (Throwable e) {
            System.out.println("Exception while execute ClientDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Client> getAll() throws DBException {
        List<Client> clients = new ArrayList<Client>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from CLIENT");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setIdClient(resultSet.getLong("IdClient"));
                client.setFirstName(resultSet.getString("FirstName"));
                client.setLastName(resultSet.getString("LastName"));
                client.setSts(resultSet.getString("Sts"));
                clients.add(client);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ClientDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return clients;
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from CLIENT where IdClient = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ClientDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Client client) throws DBException {
        if (client == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update CLIENT set FirstName = ?, LastName = ?, Sts = ? " +
                            "where IdClient = ?");
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getSts());
            preparedStatement.setLong(4, client.getIdClient());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ClientDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}

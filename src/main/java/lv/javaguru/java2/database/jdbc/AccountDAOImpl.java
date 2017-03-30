package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.AccountDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ingsaf on 23/03/17.
 */
public class AccountDAOImpl extends DAOImpl implements AccountDAO {


    public Account save(Account account) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into ACCOUNT values (default, ?, ?, 0.0, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setLong(2, account.getIdClient());
            preparedStatement.setString(3, account.getSts());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                account.setIdClient(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute AccountDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return account;
    }

    public Optional<Account> getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from ACCOUNT where IdAccount = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = null;
            if (resultSet.next()) {
                account = new Account();
                account.setIdAccount(resultSet.getLong("IdAccount"));
                account.setIdClient(resultSet.getLong("IdClient"));
                account.setAccountNumber(resultSet.getString("accountNumber"));
                account.setBalance(resultSet.getDouble("balance"));
                account.setSts(resultSet.getString("sts"));

            }
            return Optional.ofNullable(account);
        } catch (Throwable e) {
            System.out.println("Exception while execute AccountDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Account> getAll() throws DBException {
        List<Account> accounts = new ArrayList<Account>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ACCOUNT");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setIdAccount(resultSet.getLong("IdAccount"));
                account.setIdClient(resultSet.getLong("IdClient"));
                account.setAccountNumber(resultSet.getString("accountNumber"));
                account.setBalance(resultSet.getDouble("balance"));
                account.setSts(resultSet.getString("sts"));
                accounts.add(account);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list AccountDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return accounts;
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from ACCOUNT where IdAccount = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute AccountDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(Account account) throws DBException {
        if (account == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update ACCOUNT set idClient = ?, AccountNumber = ?, Balance = ? , Sts = ?  " +
                            "where IdAccount = ?");
            preparedStatement.setLong(1, account.getIdClient());
            preparedStatement.setString(2, account.getAccountNumber());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setString(4, account.getSts());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute AccountDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}

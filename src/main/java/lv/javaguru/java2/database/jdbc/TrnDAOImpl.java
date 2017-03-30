package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TrnDAO;
import lv.javaguru.java2.domain.Trn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ingsaf on 30/03/17.
 */
public class TrnDAOImpl extends DAOImpl implements TrnDAO {

    @Override
    public Trn save(Trn trn) throws DBException {

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into TRN values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setString(2, trn.getSts());
            preparedStatement.setString(3, trn.getRem());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                trn.setIdTrn(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute TrnDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return trn;
    }

    @Override
    public Optional<Trn> getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from TRN where IdTrn = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Trn trn = null;
            if (resultSet.next()) {
                trn = new Trn();
                trn.setIdTrn(resultSet.getLong("IdTrn"));
                trn.setDt(resultSet.getDate("Dt"));
                trn.setSts(resultSet.getString("Sts"));
                trn.setRem(resultSet.getString("Rem"));
            }
            return Optional.ofNullable(trn);
        } catch (Throwable e) {
            System.out.println("Exception while execute TrnDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void delete(Long id) throws  DBException{
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from TRN where IdTrn = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute TrnDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Trn trn) throws DBException {
        if (trn == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update TRN set Dt = ?, Sts = ?, Rem = ? " +
                            "where IdTrn = ?");
            preparedStatement.setDate(1, new java.sql.Date(trn.getDt().getTime()));
            preparedStatement.setString(2, trn.getSts());
            preparedStatement.setString(3, trn.getRem());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute TrnDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Trn> getAll() throws DBException {
        List<Trn> trns = new ArrayList<Trn>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from TRN");

            ResultSet resultSet = preparedStatement.executeQuery();
            Trn trn = null;
            while (resultSet.next()) {
                trn = new Trn();
                trn.setIdTrn(resultSet.getLong("IdTrn"));
                trn.setDt(resultSet.getDate("Dt"));
                trn.setSts(resultSet.getString("Sts"));
                trn.setRem(resultSet.getString("Rem"));
                trns.add(trn);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list TrnDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return trns;
    }
}

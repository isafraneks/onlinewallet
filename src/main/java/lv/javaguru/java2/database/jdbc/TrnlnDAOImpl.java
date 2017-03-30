package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TrnlnDAO;
import lv.javaguru.java2.domain.Trnln;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ingsaf on 30/03/17.
 */
public class TrnlnDAOImpl extends DAOImpl implements TrnlnDAO {
    @Override
    public Trnln save(Trnln trnln) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into TRNLN values (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, trnln.getIdTrn());
            preparedStatement.setLong(2, trnln.getLnTrn());
            preparedStatement.setLong(3, trnln.getIdAccount());
            preparedStatement.setDouble(4, trnln.getDr());
            preparedStatement.setDouble(5, trnln.getCr());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            //if (rs.next()){
            //    trnln.setIdTrn(rs.getLong(1));
            //}
        } catch (Throwable e) {
            System.out.println("Exception while execute TrnlnDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return trnln;
    }

    @Override
    public Optional<Trnln> getByIdLn(Long id, Long ln) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from TRNLN where IdTrn = ? AND LnTrn = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, ln);
            ResultSet resultSet = preparedStatement.executeQuery();
            Trnln trnln = null;
            if (resultSet.next()) {
                trnln = new Trnln();
                trnln.setIdTrn(resultSet.getLong("IdTrn"));
                trnln.setLnTrn(resultSet.getLong("LnTrn"));
                trnln.setIdAccount(resultSet.getLong("IdAccount"));
                trnln.setDr(resultSet.getDouble("Dr"));
                trnln.setCr(resultSet.getDouble("Cr"));
            }
            return Optional.ofNullable(trnln);
        } catch (Throwable e) {
            System.out.println("Exception while execute TrnlnDAOImpl.getByIdLn()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long id, Long ln) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from TRNLN where IdTrn = ? AND LnTrn = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, ln);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute TrnlnDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Trnln trnln) throws DBException {
        if (trnln == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update TRNLN set IdAccount = ?, Dr = ?, Cr = ? " +
                            "where IdTrn = ? AND LnTrn = ?");
            preparedStatement.setLong(1, trnln.getIdAccount());
            preparedStatement.setDouble(2, trnln.getDr());
            preparedStatement.setDouble(3, trnln.getCr());
            preparedStatement.setLong(4, trnln.getIdTrn());
            preparedStatement.setLong(5, trnln.getLnTrn());

            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute TrnlnDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Trnln> getAllByIdTrn(long idTrn) throws DBException {
        List<Trnln> trnlns = new ArrayList<Trnln>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from TRNLN WHERE IdTrn = ?");
            preparedStatement.setLong(1, idTrn);

            ResultSet resultSet = preparedStatement.executeQuery();
            Trnln trnln = null;
            while (resultSet.next()) {
                trnln = new Trnln();
                trnln.setIdTrn(resultSet.getLong("IdTrn"));
                trnln.setLnTrn(resultSet.getLong("LnTrn"));
                trnln.setIdAccount(resultSet.getLong("IdAccount"));
                trnln.setDr(resultSet.getDouble("Dr"));
                trnln.setCr(resultSet.getDouble("Cr"));
                trnlns.add(trnln);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list TrnlnDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return trnlns;
    }

}

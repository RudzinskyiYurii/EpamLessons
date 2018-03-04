package JDBCLesson.service;

import JDBCLesson.DAO.implementation.SexDaoImpl;
import JDBCLesson.model.SexEntity;

import java.sql.SQLException;
import java.util.List;

public class SexService {
    public List<SexEntity> findAll() throws SQLException {
        return new SexDaoImpl().findAll();
    }

    public SexEntity findById(String id) throws SQLException{
        return new SexDaoImpl().findById(id);
    }

    public int create(SexEntity entity) throws SQLException{
        return new SexDaoImpl().create(entity);
    }

    public int update(SexEntity entity) throws SQLException{
        return new SexDaoImpl().update(entity);
    }

    public int delete(String id) throws SQLException{
        return new SexDaoImpl().delete(id);
    }
}

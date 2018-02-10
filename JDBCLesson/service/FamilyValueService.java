package JDBCLesson.service;

import JDBCLesson.DAO.implementation.FamilyValueDaoImpl;
import JDBCLesson.model.FamilyValueEntity;

import java.sql.SQLException;
import java.util.List;

public class FamilyValueService {
    public List<FamilyValueEntity> findAll() throws SQLException {
        return new FamilyValueDaoImpl().findAll();
    }

    public FamilyValueEntity findById(Integer id) throws SQLException{
        return new FamilyValueDaoImpl().findById(id);
    }

    public int create(FamilyValueEntity entity) throws SQLException{
        return new FamilyValueDaoImpl().create(entity);
    }

    public int update(FamilyValueEntity entity) throws SQLException{
        return new FamilyValueDaoImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException{
        return new FamilyValueDaoImpl().delete(id);
    }
}

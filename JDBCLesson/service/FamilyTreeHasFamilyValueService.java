package JDBCLesson.service;

import JDBCLesson.DAO.implementation.FamilyTreeHasFamilyValueDaoImpl;
import JDBCLesson.model.FamilyTreeHasFamilyValueEntity;
import JDBCLesson.model.PK_FamilyTreeHasFamilyValue;

import java.sql.SQLException;
import java.util.List;

public class FamilyTreeHasFamilyValueService {
    public List<FamilyTreeHasFamilyValueEntity> findAll() throws SQLException {
        return new FamilyTreeHasFamilyValueDaoImpl().findAll();
    }

    public FamilyTreeHasFamilyValueEntity findById(PK_FamilyTreeHasFamilyValue id) throws SQLException{
        return new FamilyTreeHasFamilyValueDaoImpl().findById(id);
    }

    public int create(FamilyTreeHasFamilyValueEntity entity) throws SQLException{
        return new FamilyTreeHasFamilyValueDaoImpl().create(entity);
    }

    public int update(FamilyTreeHasFamilyValueEntity entity) throws SQLException{
        return new FamilyTreeHasFamilyValueDaoImpl().update(entity);
    }

    public int delete(PK_FamilyTreeHasFamilyValue id) throws SQLException{
        return new FamilyTreeHasFamilyValueDaoImpl().delete(id);
    }
}

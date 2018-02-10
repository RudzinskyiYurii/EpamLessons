package JDBCLesson.service;

import JDBCLesson.DAO.implementation.FamilyCompanionDaoImpl;
import JDBCLesson.model.FamilyCompanionEntity;

import java.sql.SQLException;
import java.util.List;

public class FamilyCompanionService {
    public List<FamilyCompanionEntity> findAll() throws SQLException {
        return new FamilyCompanionDaoImpl().findAll();
    }

    public FamilyCompanionEntity findById(Integer id) throws SQLException{
        return new FamilyCompanionDaoImpl().findById(id);
    }

    public int create(FamilyCompanionEntity entity) throws SQLException{
        return new FamilyCompanionDaoImpl().create(entity);
    }

    public int update(FamilyCompanionEntity entity) throws SQLException{
        return new FamilyCompanionDaoImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException{
        return new FamilyCompanionDaoImpl().delete(id);

    } public List<FamilyCompanionEntity> findByName(String name) throws SQLException {
        return new FamilyCompanionDaoImpl().findByName(name);
    }

}

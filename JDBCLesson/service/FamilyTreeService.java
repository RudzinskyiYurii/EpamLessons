package JDBCLesson.service;

import JDBCLesson.DAO.implementation.FamilyTreeDaoImpl;
import JDBCLesson.model.FamilyTreeEntity;
import JDBCLesson.model.FamilyTreeEntity;

import java.sql.SQLException;
import java.util.List;

public class FamilyTreeService {
    public List<FamilyTreeEntity> findAll() throws SQLException {
        return new FamilyTreeDaoImpl().findAll();
    }

    public FamilyTreeEntity findById(Integer id) throws SQLException{
        return new FamilyTreeDaoImpl().findById(id);
    }

    public int create(FamilyTreeEntity entity) throws SQLException{
        return new FamilyTreeDaoImpl().create(entity);
    }

    public int update(FamilyTreeEntity entity) throws SQLException{
        return new FamilyTreeDaoImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException{
        return new FamilyTreeDaoImpl().delete(id);
    }
    public List<FamilyTreeEntity> findByName(String name) throws SQLException {
        return new FamilyTreeDaoImpl().findByName(name);
    }
}

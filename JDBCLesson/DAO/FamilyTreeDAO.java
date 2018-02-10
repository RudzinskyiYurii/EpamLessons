package JDBCLesson.DAO;

import JDBCLesson.model.FamilyTreeEntity;

import java.sql.SQLException;
import java.util.List;

public interface FamilyTreeDAO extends GeneralDAO<FamilyTreeEntity, Integer> {
    List<FamilyTreeEntity> findByName(String name) throws SQLException;

}

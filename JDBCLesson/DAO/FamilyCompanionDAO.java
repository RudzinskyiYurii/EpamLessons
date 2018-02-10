package JDBCLesson.DAO;

import JDBCLesson.model.FamilyCompanionEntity;
import JDBCLesson.model.FamilyTreeEntity;

import java.sql.SQLException;
import java.util.List;

public interface FamilyCompanionDAO extends GeneralDAO<FamilyCompanionEntity, Integer> {
    List<FamilyCompanionEntity> findByName(String name) throws SQLException;
}

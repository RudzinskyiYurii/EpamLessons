package JDBCLesson.DAO.implementation;

import JDBCLesson.DAO.FamilyTreeHasFamilyValueDAO;
import JDBCLesson.model.FamilyTreeHasFamilyValueEntity;
import JDBCLesson.model.PK_FamilyTreeHasFamilyValue;
import JDBCLesson.persistant.ConnectionManager;
import JDBCLesson.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeHasFamilyValueDaoImpl implements FamilyTreeHasFamilyValueDAO {
    private static final String FIND_ALL = "SELECT * FROM family_tree_has_family_value";
    private static final String DELETE = "DELETE FROM family_tree_has_family_value WHERE family_tree_id=? AND family_value_id=?";
    private static final String CREATE = "INSERT family_tree_has_family_value(family_tree_id, family_value_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE family_tree_has_family_value SET family_tree_id=?, family_value_id=?";

    @Override
    public List<FamilyTreeHasFamilyValueEntity> findAll() throws SQLException {
        List<FamilyTreeHasFamilyValueEntity> works = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    works.add((FamilyTreeHasFamilyValueEntity) new Transformer(FamilyTreeHasFamilyValueEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return works;
    }

    @Override
    public FamilyTreeHasFamilyValueEntity findById(PK_FamilyTreeHasFamilyValue pk_familyTreeHasFamilyValue) throws SQLException {
        return null;
    }

    @Override
    public int create(FamilyTreeHasFamilyValueEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getPk().getFamTreeID());
            ps.setInt(2,entity.getPk().getFamValueID());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(FamilyTreeHasFamilyValueEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getPk().getFamTreeID());
            ps.setInt(2,entity.getPk().getFamValueID());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(PK_FamilyTreeHasFamilyValue id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id.getFamTreeID());
            ps.setInt(2,id.getFamValueID());
            return ps.executeUpdate();
        }
    }
}

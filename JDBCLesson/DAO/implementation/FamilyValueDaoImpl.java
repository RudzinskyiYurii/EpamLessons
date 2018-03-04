package JDBCLesson.DAO.implementation;

import JDBCLesson.DAO.FamilyValueDAO;
import JDBCLesson.model.FamilyValueEntity;
import JDBCLesson.persistant.ConnectionManager;
import JDBCLesson.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyValueDaoImpl implements FamilyValueDAO {
    private static final String FIND_ALL = "SELECT * FROM family_value";
    private static final String DELETE = "DELETE FROM family_value WHERE id=?";
    private static final String CREATE = "INSERT family_value(id, name, approximate_value, max_value, min_value, " +
                            "catalog_value_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE family_value SET name=?, approximate_value=?, max_value=?, " +
                            "min_value=?, catalog_value_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM family_value WHERE id=?";



    @Override
    public List<FamilyValueEntity> findAll() throws SQLException {
        List<FamilyValueEntity> value = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    value.add((FamilyValueEntity)new Transformer(FamilyValueEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return value;
    }

    @Override
    public FamilyValueEntity findById(Integer id) throws SQLException {
        FamilyValueEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(FamilyValueEntity)new Transformer(FamilyValueEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(FamilyValueEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getID());
            ps.setString(2,entity.getValueName());
            ps.setInt(3,entity.getApproxValue());
            ps.setInt(4,entity.getMaxValue());
            ps.setInt(5,entity.getMinValue());
            ps.setInt(6,entity.getCatalogID());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(FamilyValueEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,entity.getValueName());
            ps.setInt(2,entity.getApproxValue());
            ps.setInt(3,entity.getMaxValue());
            ps.setInt(4,entity.getMinValue());
            ps.setInt(5,entity.getCatalogID());
            ps.setInt(6,entity.getID());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            return ps.executeUpdate();
        }
    }
}

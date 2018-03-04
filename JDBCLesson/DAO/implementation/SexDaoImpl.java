package JDBCLesson.DAO.implementation;

import JDBCLesson.DAO.SexDAO;
import JDBCLesson.model.SexEntity;
import JDBCLesson.persistant.ConnectionManager;
import JDBCLesson.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SexDaoImpl implements SexDAO {
    private static final String FIND_ALL = "SELECT * FROM sex";
    private static final String DELETE = "DELETE FROM sex WHERE dept_no=?";
    private static final String CREATE = "INSERT sex(sex) VALUES (?)";
    private static final String UPDATE = "UPDATE sex SET sex=? WHERE sex=?";
    private static final String FIND_BY_ID = "SELECT * FROM sex WHERE sex=?";



    @Override
    public List<SexEntity> findAll() throws SQLException {
        List<SexEntity> sex = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    sex.add((SexEntity)new Transformer(SexEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return sex;
    }

    @Override
    public SexEntity findById(String id) throws SQLException {
        SexEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(SexEntity)new Transformer(SexEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(SexEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setString(1,entity.getSex());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(SexEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,entity.getSex());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(String id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setString(1,id);
            return ps.executeUpdate();
        }
    }
}

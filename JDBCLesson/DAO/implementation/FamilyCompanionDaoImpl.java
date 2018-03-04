package JDBCLesson.DAO.implementation;

import JDBCLesson.DAO.FamilyCompanionDAO;
import JDBCLesson.model.FamilyCompanionEntity;
import JDBCLesson.persistant.ConnectionManager;
import JDBCLesson.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyCompanionDaoImpl implements FamilyCompanionDAO{
    private static final String FIND_ALL = "SELECT * FROM family_companion";
    private static final String DELETE = "DELETE FROM family_companion WHERE id=?";
    private static final String CREATE = "INSERT family_companion (id, surname, name, date_of_birth, date_of_death, " +
            "place_of_birth, place_of_death, marriage_date, sex_sex) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE family_companion SET surname=?, name=?, date_of_birth=?, " +
            "date_of_death=?, place_of_birth=?, place_of_death=?, marriage_date=?, sex_sex=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM family_companion WHERE id=?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM family_companion WHERE name=?";


    @Override
    public List<FamilyCompanionEntity> findAll() throws SQLException {
        List<FamilyCompanionEntity> familyTrees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    familyTrees.add((FamilyCompanionEntity) new Transformer(FamilyCompanionEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return familyTrees;
    }

    @Override
    public FamilyCompanionEntity findById(Integer id) throws SQLException {
        FamilyCompanionEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(FamilyCompanionEntity)new Transformer(FamilyCompanionEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(FamilyCompanionEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getID());
            ps.setString(2,entity.getFamTreeSurname());
            ps.setString(3,entity.getFamTreeName());
            ps.setDate(4,entity.getDateOfBirth());
            ps.setDate(5,entity.getDateOfDeath());
            ps.setString(6,entity.getPlaceOfBirth());
            ps.setString(7,entity.getPlaceOfDeath());
            ps.setDate(8,entity.getMarriageDate());
            ps.setString(9,entity.getSex());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(FamilyCompanionEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,entity.getFamTreeSurname());
            ps.setString(2,entity.getFamTreeName());
            ps.setDate(3,entity.getDateOfBirth());
            ps.setDate(4,entity.getDateOfDeath());
            ps.setString(5,entity.getPlaceOfBirth());
            ps.setString(6,entity.getPlaceOfDeath());
            ps.setDate(7,entity.getMarriageDate());
            ps.setString(8,entity.getSex());
            ps.setInt(9,entity.getID());
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

    @Override
    public List<FamilyCompanionEntity> findByName(String name) throws SQLException {
        List<FamilyCompanionEntity> familyTrees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_FIRST_NAME)) {
            ps.setString(1,name);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    familyTrees.add((FamilyCompanionEntity) new Transformer(FamilyCompanionEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return familyTrees;
    }
}

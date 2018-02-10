package JDBCLesson.DAO.implementation;

import JDBCLesson.DAO.FamilyTreeDAO;
import JDBCLesson.model.FamilyTreeEntity;
import JDBCLesson.persistant.ConnectionManager;
import JDBCLesson.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeDaoImpl implements FamilyTreeDAO {
    private static final String FIND_ALL = "SELECT * FROM family_tree";
    private static final String DELETE = "DELETE FROM family_tree WHERE id=?";
    private static final String CREATE = "INSERT family_tree (id, name, surname, date_of_birth, date_of_death, " +
                        "place_of_birth, place_of_death, card_number, family_tree_id, sex_sex, family_companion_id ) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE family_tree SET name=?, surname=?, date_of_birth=?, " +
                        "date_of_death=?, place_of_birth=?, place_of_death=?, card_number=?, family_tree_id=?," +
                        " sex_sex=?, family_companion_id=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM family_tree WHERE id=?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM family_tree WHERE name=?";


    @Override
    public List<FamilyTreeEntity> findAll() throws SQLException {
        List<FamilyTreeEntity> familyTrees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    familyTrees.add((FamilyTreeEntity) new Transformer(FamilyTreeEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return familyTrees;
    }

    @Override
    public FamilyTreeEntity findById(Integer id) throws SQLException {
        FamilyTreeEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(FamilyTreeEntity)new Transformer(FamilyTreeEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(FamilyTreeEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getID());
            ps.setString(2,entity.getFamTreeName());
            ps.setString(3,entity.getFamTreeSurname());
            ps.setDate(4,entity.getDateOfBirth());
            ps.setDate(5,entity.getDateOfDeath());
            ps.setString(6,entity.getPlaceOfBirth());
            ps.setString(7,entity.getPlaceOfDeath());
            ps.setString(8,entity.getCardNumber());
            ps.setInt(9,entity.getFamTreeID());
            ps.setString(10,entity.getSex());
            ps.setInt(11,entity.getFamCompanionID());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(FamilyTreeEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1,entity.getFamTreeName());
            ps.setString(2,entity.getFamTreeSurname());
            ps.setDate(3,entity.getDateOfBirth());
            ps.setDate(4,entity.getDateOfDeath());
            ps.setString(5,entity.getPlaceOfBirth());
            ps.setString(6,entity.getPlaceOfDeath());
            ps.setString(7,entity.getCardNumber());
            ps.setInt(8,entity.getFamTreeID());
            ps.setString(9,entity.getSex());
            ps.setInt(10,entity.getFamCompanionID());
            ps.setInt(11,entity.getID());
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
    public List<FamilyTreeEntity> findByName(String name) throws SQLException {
        List<FamilyTreeEntity> familyTrees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_FIRST_NAME)) {
            ps.setString(1,name);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    familyTrees.add((FamilyTreeEntity) new Transformer(FamilyTreeEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return familyTrees;
    }


}

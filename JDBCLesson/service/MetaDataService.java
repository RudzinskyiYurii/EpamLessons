package JDBCLesson.service;

import JDBCLesson.DAO.implementation.MetaDataDaoImpl;
import JDBCLesson.model.Metadata.TableMetaData;

import java.sql.SQLException;
import java.util.List;

public class MetaDataService {
    public List<String> findAllTableName() throws SQLException {
        return new MetaDataDaoImpl().findAllTableName();
    }

    public List<TableMetaData> getTablesStructure() throws SQLException {
        return new MetaDataDaoImpl().getTablesStructure();
    }

}

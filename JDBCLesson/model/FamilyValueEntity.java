package JDBCLesson.model;

import JDBCLesson.model.Annotation.Column;
import JDBCLesson.model.Annotation.PrimaryKey;
import JDBCLesson.model.Annotation.Table;

@Table(name = "family_value")
public class FamilyValueEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer ID;

    @Column(name = "name", length = 45)
    private String valueName;

    @Column(name = "approximate_value")
    private Integer approxValue;

    @Column(name = "max_value")
    private Integer maxValue;

    @Column(name = "min_value")
    private Integer minValue;

    @Column(name = "catalog_value_id")
    private Integer catalogID;


    public FamilyValueEntity(Integer id, String valueName, Integer approxValue, Integer maxValue, Integer minValue,
                             Integer catalogID){
        this.ID = id;
        this.valueName = valueName;
        this.approxValue = approxValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.catalogID = catalogID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public Integer getApproxValue() {
        return approxValue;
    }

    public void setApproxValue(Integer approxValue) {
        this.approxValue = approxValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(Integer catalogID) {
        this.catalogID = catalogID;
    }

    @Override
    public String toString() {

        return String.format("%d %s %d %d %d %d ", ID, valueName, approxValue, maxValue, minValue, catalogID);
    }
}

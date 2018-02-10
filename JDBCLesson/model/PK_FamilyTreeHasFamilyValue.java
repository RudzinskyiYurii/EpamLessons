package JDBCLesson.model;

import JDBCLesson.model.Annotation.Column;

public class PK_FamilyTreeHasFamilyValue {

    @Column(name = "family_tree_id")
    private Integer famTreeID;

    @Column(name = "family_value_id")
    private Integer famValueID;

    public PK_FamilyTreeHasFamilyValue(Integer famTreeID, Integer famValueID){
        this.famTreeID = famTreeID;
        this.famValueID = famValueID;

    }

    public Integer getFamTreeID() {
        return famTreeID;
    }

    public void setFamTreeID(Integer famTreeID) {
        this.famTreeID = famTreeID;
    }

    public Integer getFamValueID() {
        return famValueID;
    }

    public void setFamValueID(Integer famValueID) {
        this.famValueID = famValueID;
    }


}

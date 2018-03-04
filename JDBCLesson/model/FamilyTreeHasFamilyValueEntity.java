package JDBCLesson.model;

import JDBCLesson.model.Annotation.PrimaryKeyComposite;
import JDBCLesson.model.Annotation.Table;

@Table(name = "family_tree_has_family_value")
public class FamilyTreeHasFamilyValueEntity {
    @PrimaryKeyComposite
    private PK_FamilyTreeHasFamilyValue pk;

    public FamilyTreeHasFamilyValueEntity(PK_FamilyTreeHasFamilyValue pk){
        this.pk = pk;
    }

    public PK_FamilyTreeHasFamilyValue getPk() {
        return pk;
    }

    public void setPk(PK_FamilyTreeHasFamilyValue pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return String.format("%d %d ", pk.getFamTreeID(), pk.getFamValueID());
    }
}

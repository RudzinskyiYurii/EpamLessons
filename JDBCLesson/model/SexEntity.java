package JDBCLesson.model;

import JDBCLesson.model.Annotation.Column;
import JDBCLesson.model.Annotation.PrimaryKey;
import JDBCLesson.model.Annotation.Table;

@Table(name = "sex")
public class SexEntity {
    @PrimaryKey
    @Column(name = "sex", length = 10)
    private String sex;

    public SexEntity(String sex){
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {

        return String.format("%-10s ",  sex);
    }
}

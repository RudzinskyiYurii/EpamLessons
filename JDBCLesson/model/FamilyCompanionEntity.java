package JDBCLesson.model;

import JDBCLesson.model.Annotation.Column;
import JDBCLesson.model.Annotation.PrimaryKey;
import JDBCLesson.model.Annotation.Table;

import java.sql.Date;

@Table(name = "family_companion")
public class FamilyCompanionEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer ID;

    @Column(name = "name", length = 45)
    private String famTreeName;

    @Column(name = "surname", length = 45)
    private String famTreeSurname;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    @Column(name = "place_of_birth", length = 45)
    private String placeOfBirth;

    @Column(name = "place_of_death", length = 45)
    private String placeOfDeath;

    @Column(name = "marriage_date")
    private Date marriageDate;

    @Column(name = "sex_sex", length = 10)
    private String sex;



    public FamilyCompanionEntity (Integer id, String surname, String name, Date birthDate, Date deathDate, String birthPlace,
                             String deathPlace, Date marriageDate, String sex){
        this.ID = id;
        this.famTreeName = name;
        this.famTreeSurname = surname;
        this.dateOfBirth = birthDate;
        this.dateOfDeath = deathDate;
        this.placeOfBirth = birthPlace;
        this.placeOfDeath = deathPlace;
        this.marriageDate = marriageDate;
        this.sex = sex;

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFamTreeName() {
        return famTreeName;
    }

    public void setFamTreeName(String famTreeName) {
        this.famTreeName = famTreeName;
    }

    public String getFamTreeSurname() {
        return famTreeSurname;
    }

    public void setFamTreeSurname(String famTreeSurname) {
        this.famTreeSurname = famTreeSurname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public Date getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(Date marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {

        return String.format("%d %s %s %s %s %s %s %s %-10s ", ID, famTreeSurname, famTreeName, dateOfBirth.toString(),
                dateOfDeath.toString(), placeOfBirth, placeOfDeath, marriageDate.toString(),  sex);
    }
}

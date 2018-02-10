package JDBCLesson.viewAndContoller;


import JDBCLesson.model.*;
import JDBCLesson.model.Metadata.TableMetaData;
import JDBCLesson.persistant.ConnectionManager;
import JDBCLesson.service.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all table");
        menu.put("B", "   B - Select structure of DB");

        menu.put("1", "   1 - Table: Family_tree");
        menu.put("11", "  11 - Create for Family_tree");
        menu.put("12", "  12 - Update Family_tree");
        menu.put("13", "  13 - Delete from Family_tree");
        menu.put("14", "  14 - Select Family_tree");
        menu.put("15", "  15 - Find Family_tree by ID");
        menu.put("16", "  16 - Find Family_tree by Name");

        menu.put("2", "   2 - Table: Family_companion");
        menu.put("21", "  21 - Create for Family_companion");
        menu.put("22", "  22 - Update Family_companion");
        menu.put("23", "  23 - Delete from Family_companion");
        menu.put("24", "  24 - Select Family_companion");
        menu.put("25", "  25 - Find Family_companion by ID");
        menu.put("26", "  26 - Find Family_companion by Name");

        menu.put("3", "   3 - Table: Family_value");
        menu.put("31", "  31 - Create for Family_value");
        menu.put("32", "  32 - Update Family_value");
        menu.put("33", "  33 - Delete from Family_value");
        menu.put("34", "  34 - Select Family_value");
        menu.put("35", "  35 - Find Family_value by ID");

        menu.put("4", "   4 - Table: Family_tree_has_family_value");
        menu.put("41", "  41 - Create for Family_tree_has_family_value");
        menu.put("42", "  42 - Update Family_tree_has_family_value");
        menu.put("43", "  43 - Delete from Family_tree_has_family_value");
        menu.put("44", "  44 - Select Family_tree_has_family_value");

        menu.put("5", "   5 - Table: Sex");
        menu.put("51", "  51 - Create for Sex");
        menu.put("52", "  52 - Update Sex");
        menu.put("53", "  53 - Delete from Sex");
        menu.put("54", "  54 - Select Sex");

        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);
        methodsMenu.put("B", this::takeStructureOfDB);

        methodsMenu.put("11", this::createForFamilyTree);
        methodsMenu.put("12", this::updateFamilyTree);
        methodsMenu.put("13", this::deleteFromFamilyTree);
        methodsMenu.put("14", this::selectFamilyTree);
        methodsMenu.put("15", this::findFamilyTreeByID);
        methodsMenu.put("16", this::findFamilyTreeByName);

        methodsMenu.put("21", this::createForFamilyCompanion);
        methodsMenu.put("22", this::updateFamilyCompanion);
        methodsMenu.put("23", this::deleteFromFamilyCompanion);
        methodsMenu.put("24", this::selectFamilyCompanion);
        methodsMenu.put("25", this::findFamilyCompanionByID);
        methodsMenu.put("26", this::findFamilyCompanionByName);

        methodsMenu.put("31", this::createForFamilyValue);
        methodsMenu.put("32", this::updateFamilyValue);
        methodsMenu.put("33", this::deleteFromFamilyValue);
        methodsMenu.put("34", this::selectFamilyValue);
        methodsMenu.put("35", this::findFamilyValueByID);

        methodsMenu.put("41", this::createForFamilyTreeHasFamilyValue);
        methodsMenu.put("42", this::updateFamilyTreeHasFamilyValue);
        methodsMenu.put("43", this::deleteFromFamilyTreeHasFamilyValue);
        methodsMenu.put("44", this::selectFamilyTreeHasFamilyValue);

        methodsMenu.put("51", this::createForSex);
        //methodsMenu.put("52", this::updateS);
        methodsMenu.put("53", this::deleteFromSex);
        methodsMenu.put("54", this::selectSex);
    }

    private void selectAllTable() throws SQLException {
        selectFamilyTree();
        selectFamilyCompanion();
        selectFamilyValue();
        selectFamilyTreeHasFamilyValue();
        selectSex();
    }

    private void takeStructureOfDB() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        MetaDataService metaDataService = new MetaDataService();
        List<TableMetaData> tables = metaDataService.getTablesStructure();
        System.out.println("TABLE OF DATABASE: "+connection.getCatalog());

        for (TableMetaData table: tables ) {
            System.out.println(table);
        }
    }

//----------------------------------------------------------------------------------------------

    private void deleteFromFamilyTree() throws SQLException {
        System.out.println("Input ID for Family_tree: ");
        Integer id = input.nextInt();
        FamilyTreeService familyTreeService = new FamilyTreeService();
        int count = familyTreeService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForFamilyTree() throws SQLException {
        System.out.println("Input ID for Family_tree: ");
        Integer id = input.nextInt();
        System.out.println("Input name for Family_tree: ");
        String name = input.nextLine();
        System.out.println("Input surname for Family_tree: ");
        String surname = input.nextLine();
        System.out.println("Input birthday for Family_tree (1999-01-23): ");
        String birthday = input.nextLine();
        Date birthDate = Date.valueOf(birthday);
        System.out.println("Input date of death for Family_tree (1999-01-23): ");
        String dateOfDeath = input.nextLine();
        Date deathDate = Date.valueOf(dateOfDeath);
        System.out.println("Input place of birth for Family_tree: ");
        String placeOfBirth = input.nextLine();
        System.out.println("Input place of death for Family_tree: ");
        String placeOfDeath = input.nextLine();
        System.out.println("Input card number for Family_tree: ");
        String cardNumber = input.nextLine();
        System.out.println("Input family tree id for Family_tree: ");
        Integer famTreeID = input.nextInt();
        System.out.println("Input sex for Family_tree: ");
        String sex = input.nextLine();
        System.out.println("Input family companion id for Family_tree: ");
        Integer famCompanionID = input.nextInt();
        FamilyTreeEntity entity = new FamilyTreeEntity(id, name, surname, birthDate, deathDate, placeOfBirth, placeOfDeath,
                cardNumber, famTreeID, sex, famCompanionID);

        FamilyTreeService FamilyTreeService = new FamilyTreeService();
        int count = FamilyTreeService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFamilyTree() throws SQLException {
        System.out.println("Input ID for Family_tree: ");
        Integer id = input.nextInt();
        System.out.println("Input name for Family_tree: ");
        String name = input.nextLine();
        System.out.println("Input surname for Family_tree: ");
        String surname = input.nextLine();
        System.out.println("Input birthday for Family_tree (1999-01-23): ");
        String birthday = input.nextLine();
        Date birthDate = Date.valueOf(birthday);
        System.out.println("Input date of death for Family_tree (1999-01-23): ");
        String dateOfDeath = input.nextLine();
        Date deathDate = Date.valueOf(dateOfDeath);
        System.out.println("Input place of birth for Family_tree: ");
        String placeOfBirth = input.nextLine();
        System.out.println("Input place of death for Family_tree: ");
        String placeOfDeath = input.nextLine();
        System.out.println("Input card number for Family_tree: ");
        String cardNumber = input.nextLine();
        System.out.println("Input family tree id for Family_tree: ");
        Integer famTreeID = input.nextInt();
        System.out.println("Input sex for Family_tree: ");
        String sex = input.nextLine();
        System.out.println("Input family companion id for Family_tree: ");
        Integer famCompanionID = input.nextInt();
        FamilyTreeEntity entity = new FamilyTreeEntity(id, name, surname, birthDate, deathDate, placeOfBirth, placeOfDeath,
                cardNumber, famTreeID, sex, famCompanionID);

        FamilyTreeService FamilyTreeService = new FamilyTreeService();
        int count = FamilyTreeService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectFamilyTree() throws SQLException {
        System.out.println("\nTable: FamilyTree");
        FamilyTreeService familyTreeService = new FamilyTreeService();
        List<FamilyTreeEntity> familyTrees = familyTreeService.findAll();
        for (FamilyTreeEntity entity : familyTrees) {
            System.out.println(entity);
        }
    }

    private void findFamilyTreeByID() throws SQLException {
        System.out.println("Input ID for Family_tree: ");
        Integer id = input.nextInt();
        FamilyTreeService familyTreeService = new FamilyTreeService();
        FamilyTreeEntity entity = familyTreeService.findById(id);
        System.out.println(entity);
    }

    private void findFamilyTreeByName() throws SQLException {
        System.out.println("Input name for Family_tree: ");
        String name = input.nextLine();
        FamilyTreeService familyTreeService = new FamilyTreeService();
        List<FamilyTreeEntity> familyTrees = familyTreeService.findByName(name);
        for (FamilyTreeEntity entity : familyTrees) {
            System.out.println(entity);
        }
    }


    //------------------------------------------------------------------------

    private void deleteFromFamilyCompanion() throws SQLException {
        System.out.println("Input ID for Family_companion: ");
        Integer id = input.nextInt();
        input.nextLine();
        FamilyCompanionService familyCompanionService = new FamilyCompanionService();
        int count = familyCompanionService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForFamilyCompanion() throws SQLException {
        System.out.println("Input ID for Family_companion: ");
        Integer id = input.nextInt();
        System.out.println("Input name for Family_companion: ");
        String name = input.nextLine();
        System.out.println("Input surname for Family_companion: ");
        String surname = input.nextLine();
        System.out.println("Input birthday for Family_companion (1999-01-23): ");
        String birthday = input.nextLine();
        Date birthDate = Date.valueOf(birthday);
        System.out.println("Input date of death for Family_companion (1999-01-23): ");
        String dateOfDeath = input.nextLine();
        Date deathDate = Date.valueOf(dateOfDeath);
        System.out.println("Input place of birth for Family_companion: ");
        String placeOfBirth = input.nextLine();
        System.out.println("Input place of death for Family_companion: ");
        String placeOfDeath = input.nextLine();
        System.out.println("Input marriage date for Family_companion (1999-01-23): ");
        String dateOfMarriage = input.nextLine();
        Date marriageDate = Date.valueOf(dateOfMarriage);
        System.out.println("Input sex for Family_tree: ");
        String sex = input.nextLine();
        FamilyCompanionEntity entity = new FamilyCompanionEntity(id, name, surname, birthDate, deathDate, placeOfBirth, placeOfDeath,
                marriageDate, sex);

        FamilyCompanionService familyCompanionService = new FamilyCompanionService();
        int count = familyCompanionService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFamilyCompanion() throws SQLException {
        System.out.println("Input ID for Family_companion: ");
        Integer id = input.nextInt();
        System.out.println("Input name for Family_companion: ");
        String name = input.nextLine();
        System.out.println("Input surname for Family_companion: ");
        String surname = input.nextLine();
        System.out.println("Input birthday for Family_companion (1999-01-23): ");
        String birthday = input.nextLine();
        Date birthDate = Date.valueOf(birthday);
        System.out.println("Input date of death for Family_companion (1999-01-23): ");
        String dateOfDeath = input.nextLine();
        Date deathDate = Date.valueOf(dateOfDeath);
        System.out.println("Input place of birth for Family_companion: ");
        String placeOfBirth = input.nextLine();
        System.out.println("Input place of death for Family_companion: ");
        String placeOfDeath = input.nextLine();
        System.out.println("Input marriage date for Family_companion (1999-01-23): ");
        String dateOfMarriage = input.nextLine();
        Date marriageDate = Date.valueOf(dateOfMarriage);
        System.out.println("Input sex for Family_tree: ");
        String sex = input.nextLine();
        FamilyCompanionEntity entity = new FamilyCompanionEntity(id, name, surname, birthDate, deathDate, placeOfBirth, placeOfDeath,
                marriageDate, sex);

        FamilyCompanionService familyCompanionService = new FamilyCompanionService();
        int count = familyCompanionService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectFamilyCompanion() throws SQLException {
        System.out.println("\nTable: Family_companions");
        FamilyCompanionService familyCompanionService = new FamilyCompanionService();
        List<FamilyCompanionEntity> familyCompanions = familyCompanionService.findAll();
        for (FamilyCompanionEntity entity : familyCompanions) {
            System.out.println(entity);
        }
    }

    private void findFamilyCompanionByID() throws SQLException {
        System.out.println("Input ID for Family_companion: ");
        Integer id = input.nextInt();
        input.nextLine();
        FamilyCompanionService familyCompanionService = new FamilyCompanionService();
        FamilyCompanionEntity entity = familyCompanionService.findById(id);
        System.out.println(entity);
    }

    private void findFamilyCompanionByName() throws SQLException {
        System.out.println("Input name for Family_companion: ");
        String name = input.nextLine();
        FamilyCompanionService familyCompanionService = new FamilyCompanionService();
        List<FamilyCompanionEntity> familyCompanions = familyCompanionService.findByName(name);
        for (FamilyCompanionEntity entity : familyCompanions) {
            System.out.println(entity);
        }
    }

    //------------------------------------------------------------------------

    private void deleteFromFamilyValue() throws SQLException {
        System.out.println("Input ID for Family_value: ");
        Integer id = input.nextInt();
        input.nextLine();
        FamilyValueService familyValueService = new FamilyValueService();
        int count = familyValueService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForFamilyValue() throws SQLException {
        System.out.println("Input ID for Family_value: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input name for Family_value: ");
        String valName = input.nextLine();
        System.out.println("Input approximate value for Family_value: ");
        Integer approxValue = input.nextInt();
        System.out.println("Input max value for Family_value: ");
        Integer maxValue = input.nextInt();
        System.out.println("Input min value for Family_value: ");
        Integer minValue = input.nextInt();
        System.out.println("Input catalog id value for Family_value: ");
        Integer catalogID = input.nextInt();
        FamilyValueEntity entity = new FamilyValueEntity(id, valName, approxValue, maxValue, minValue, catalogID);

        FamilyValueService familyValueService = new FamilyValueService();
        int count = familyValueService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFamilyValue() throws SQLException {
        System.out.println("Input ID for Family_value: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input name for Family_value: ");
        String valName = input.nextLine();
        System.out.println("Input approximate value for Family_value: ");
        Integer approxValue = input.nextInt();
        System.out.println("Input max value for Family_value: ");
        Integer maxValue = input.nextInt();
        System.out.println("Input min value for Family_value: ");
        Integer minValue = input.nextInt();
        System.out.println("Input catalog id value for Family_value: ");
        Integer catalogID = input.nextInt();
        FamilyValueEntity entity = new FamilyValueEntity(id, valName, approxValue, maxValue, minValue, catalogID);

        FamilyValueService familyValueService = new FamilyValueService();
        int count = familyValueService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectFamilyValue() throws SQLException {
        System.out.println("\nTable: Family_value");
        FamilyValueService familyValueService = new FamilyValueService();
        List<FamilyValueEntity> familyValues = familyValueService.findAll();
        for (FamilyValueEntity entity : familyValues) {
            System.out.println(entity);
        }
    }

    private void findFamilyValueByID() throws SQLException {
        System.out.println("Input ID for Family_value: ");
        Integer id = input.nextInt();
        input.nextLine();
        FamilyValueService familyValueService = new FamilyValueService();
        FamilyValueEntity entity = familyValueService.findById(id);
        System.out.println(entity);
    }



    //------------------------------------------------------------------------

    private void updateFamilyTreeHasFamilyValue() throws SQLException {
        System.out.println("Input family_tree_id for Family_tree_has_family_value: ");
        Integer familyTreeID = input.nextInt();
        System.out.println("Input family_value_id for Family_tree_has_family_value: ");
        Integer familyValueID = input.nextInt();
        PK_FamilyTreeHasFamilyValue pk = new PK_FamilyTreeHasFamilyValue(familyTreeID, familyValueID);
        FamilyTreeHasFamilyValueEntity familyTreeHasFamilyValueEntity = new FamilyTreeHasFamilyValueEntity(pk);

        FamilyTreeHasFamilyValueService familyTreeHasFamilyValueService = new FamilyTreeHasFamilyValueService();
        int count = familyTreeHasFamilyValueService.update(familyTreeHasFamilyValueEntity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromFamilyTreeHasFamilyValue() throws SQLException {
        System.out.println("Input family_tree_id for Family_tree_has_family_value: ");
        Integer familyTreeID = input.nextInt();
        System.out.println("Input family_value_id for Family_tree_has_family_value: ");
        Integer familyValueID = input.nextInt();
        PK_FamilyTreeHasFamilyValue pk = new PK_FamilyTreeHasFamilyValue(familyTreeID, familyValueID);

        FamilyTreeHasFamilyValueService familyTreeHasFamilyValueService = new FamilyTreeHasFamilyValueService();
        int count = familyTreeHasFamilyValueService.delete(pk);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForFamilyTreeHasFamilyValue() throws SQLException {
        System.out.println("Input family_tree_id for Family_tree_has_family_value: ");
        Integer familyTreeID = input.nextInt();
        System.out.println("Input family_value_id for Family_tree_has_family_value: ");
        Integer familyValueID = input.nextInt();
        PK_FamilyTreeHasFamilyValue pk = new PK_FamilyTreeHasFamilyValue(familyTreeID, familyValueID);
        FamilyTreeHasFamilyValueEntity familyTreeHasFamilyValueEntity = new FamilyTreeHasFamilyValueEntity(pk);

        FamilyTreeHasFamilyValueService familyTreeHasFamilyValueService = new FamilyTreeHasFamilyValueService();
        int count = familyTreeHasFamilyValueService.create(familyTreeHasFamilyValueEntity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void selectFamilyTreeHasFamilyValue() throws SQLException {
        System.out.println("\nTable: Family_tree_has_family_value");
        FamilyTreeHasFamilyValueService familyTreeHasFamilyValueService = new FamilyTreeHasFamilyValueService();
        List<FamilyTreeHasFamilyValueEntity> famTreeValues = familyTreeHasFamilyValueService.findAll();
        for (FamilyTreeHasFamilyValueEntity entity : famTreeValues) {
            System.out.println(entity);
        }
    }


    //------------------------------------------------------------------------

    private void deleteFromSex() throws SQLException {
        System.out.println("Input sex for Sex: ");
        String sex = input.nextLine();

        SexService sexService = new SexService();
        int count = sexService.delete(sex);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForSex() throws SQLException {
        System.out.println("Input sex for Sex: ");
        String sex = input.nextLine();
        SexEntity sexEntity = new SexEntity(sex);

        SexService sexService = new SexService();
        int count = sexService.create(sexEntity);
        System.out.printf("There are created %d rows\n", count);
    }


    private void selectSex() throws SQLException {
        System.out.println("\nTable: Sex");
        SexService sexService = new SexService();
        List<SexEntity> sexes = sexService.findAll();
        for (SexEntity entity : sexes) {
            System.out.println(entity);
        }
    }

    //-------------------------------------------------------------------------

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}

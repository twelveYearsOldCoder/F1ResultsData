package com.example.cwrk_v2;

import java.sql.*;

public class DBActions {

    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String User = "sa";
    private static final String Pass = "";
    private Connection conn = null;
    private Statement stmt = null;
    public DBActions() throws ClassNotFoundException, SQLException {
        //fortwnw tin vivliothiki
        Class.forName("org.h2.Driver");
        //open a connections
        conn = DriverManager.getConnection(DB_URL, User, Pass);

        //execute a query
        stmt = conn.createStatement();
    }
    public void createTables() throws SQLException {
        String sql = "CREATE TABLE users (\n" +
                "\tuName varchar(100) NOT NULL,\n" +
                "\tuPass varchar(100) NOT NULL,\n" +
                "\tuID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\tisAdmin INT NOT NULL\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE drivers (\n" +
                "\tdID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,\n" +
                "\tdName varchar(255) NOT NULL\n" +
                "\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE races (\n" +
                "\trID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "\ttrackName varchar(255) NOT NULL,\n" +
                "\tdate INT NOT NULL,\n" +
                "\tp1 INT NOT NULL,\n" +
                "\tp2 INT NOT NULL,\n" +
                "\tp3 INT NOT NULL,\n" +
                "\tp4 INT NOT NULL,\n" +
                "\tp5 INT NOT NULL,\n" +
                "\tp6 INT NOT NULL,\n" +
                "\tp7 INT NOT NULL,\n" +
                "\tp8 INT NOT NULL,\n" +
                "\tp9 INT NOT NULL,\n" +
                "\tp10 INT NOT NULL,\n" +
                "\tp11 INT NOT NULL,\n" +
                "\tp12 INT NOT NULL,\n" +
                "\tp13 INT NOT NULL,\n" +
                "\tp14 INT NOT NULL,\n" +
                "\tp15 INT NOT NULL,\n" +
                "\tp16 INT NOT NULL,\n" +
                "\tp17 INT NOT NULL,\n" +
                "\tp18 INT NOT NULL,\n" +
                "\tp19 INT NOT NULL,\n" +
                "\tp20 INT NOT NULL\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk0 FOREIGN KEY (p1) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk1 FOREIGN KEY (p2) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk2 FOREIGN KEY (p3) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk3 FOREIGN KEY (p4) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk4 FOREIGN KEY (p5) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk5 FOREIGN KEY (p6) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk6 FOREIGN KEY (p7) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk7 FOREIGN KEY (p8) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk8 FOREIGN KEY (p9) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk9 FOREIGN KEY (p10) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk10 FOREIGN KEY (p11) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk11 FOREIGN KEY (p12) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk12 FOREIGN KEY (p13) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk13 FOREIGN KEY (p14) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk14 FOREIGN KEY (p15) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk15 FOREIGN KEY (p16) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk16 FOREIGN KEY (p17) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk17 FOREIGN KEY (p18) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk18 FOREIGN KEY (p19) REFERENCES drivers(dID);\n" +
                "ALTER TABLE races ADD CONSTRAINT races_fk19 FOREIGN KEY (p20) REFERENCES drivers(dID);";

        int row= stmt.executeUpdate(sql);
    }
    public void populateTables() throws SQLException {
        String sql = "insert into users (uName, uPass, isAdmin) values ('admin', '1234', 1);";
        int row= stmt.executeUpdate(sql);

    }

    public void userLogIn(String username, String password) throws SQLException {
        ResultSet res = stmt.executeQuery("SELECT * FROM users");

        while (res.next()) {
            String uID = (res.getObject("uID").toString());
            String uName = (res.getObject("uName").toString());
            String uPass = (res.getObject("uPass").toString());
            if (username.equals(uName)&& password.equals(uPass)){
                System.out.println("Succefully loged in "+ uName);
            }
            }
    }







    public void cleanUp() throws SQLException {
// This part might also be repeated in every method



// close statements and connection
        stmt.close();
        conn.close();
    }
    public void insertPrepared(String uName, String uPass) throws SQLException {



        String sql = "INSERT INTO car (brand, years) VALUES (?,?)";



        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, uName);
        pst.setString(2, uPass);
        pst.executeUpdate();



    }

}
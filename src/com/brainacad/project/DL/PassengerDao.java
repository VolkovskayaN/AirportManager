package com.brainacad.project.DL;


import com.brainacad.project.BL.Passenger;

import java.sql.*;

public class PassengerDao {
//TODO rewrite crud operations with editing flight number and class
    private String sqlSelect;
    private String sqlInsert;
    private String sqlDelete;
    private String sqlUpdate;
    private Connection connection;




    public PassengerDao(Connection connection) {
        this.connection = connection;
        this.sqlSelect = "SELECT * FROM PassengerList  ";
        this.sqlInsert = "INSERT INTO PassengerList" +
                "'flightNumber','firstName'," +
                "'lastName'," +
                "'nationality'," +
                "'passport'," +
                "'dateOfBirth'," +
                "'sex', 'salonClass'" + "VALUES(?,?,?,?,?,?,?,?)";
        this.sqlDelete = "DELETE FROM PassengerList ";
        this.sqlUpdate =  "UPDATE PassengerList SET " +
                "'flightNumber'," +
                "'firstName'," +
                "'lastName'," +
                "'nationality'," +
                "'passport'," +
                "'dateOfBirth'," +
                "'sex', " +
                "'salonClass'" + "VALUES(?,?,?,?,?,?,?,?)";


    }
    public void searchByFlightNumber(String flNumber){
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect+"where flightNumber = ?");
            ps.setString(1,flNumber);
            ResultSet rs = ps.executeQuery();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + "\t\t");
            }
            System.out.println();



            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount();i++) {
                    System.out.print(rs.getString(i) + "\t\t\t");
                }
                System.out.println();
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//TODO use this method in main
    public void searchByFirstName(String fName) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + "where firstName = ?");
            ps.setString(1, fName);
            ResultSet rs = ps.executeQuery();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + "\t\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t\t\t");
                }
                System.out.println();
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //TODO implement in main
    public void searchByLastName(String lName) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + "where lastName = ?");
            ps.setString(1, lName);
            ResultSet rs = ps.executeQuery();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + "\t\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t\t\t");
                }
                System.out.println();
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //TODO implement in main
    public void searchByPassport(String passport) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + "where passport = ?");
            ps.setString(1, passport);
            ResultSet rs = ps.executeQuery();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + "\t\t");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t\t\t");
                }
                System.out.println();
            }
            ps.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertPassenger(Passenger pass) throws SQLException {
        try {
            PreparedStatement ps = this.connection.prepareStatement(this.sqlInsert);
            ps.setString(1, pass.getFlightNumber());
            ps.setString(2, pass.getFirstName());
            ps.setString(3, pass.getSecondName());
            ps.setString(4, pass.getNationality());
            ps.setString(5, pass.getPassport());
            ps.setString(6, pass.getDateOfBirth());
            ps.setString(7, pass.getSex());
            ps.setString(8, pass.getClassOfSalon());

            ps.executeUpdate();
            System.out.println("Insert OK!!!");
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void viewPassengerList() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            ResultSetMetaData md = rs.getMetaData();
            for (int i = 1; i <= md.getColumnCount(); i++) {
                System.out.print(md.getColumnName(i) + "\t\t");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + "\t\t\t");
                }
                System.out.println();
            }
            statement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deletePassenger(int id) throws SQLException {
        try {
            PreparedStatement ps = this.connection.prepareStatement(this.sqlDelete + " where id = ? ");
            ps.setInt(1,id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The user was deleted successfully!");
            } else System.out.println("The user was not deleted! Try once again. ");
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //TODO solve the problem with syntax in line 110
    public void updateInfo(Passenger pass,int id){
        try {
            PreparedStatement ps = this.connection.prepareStatement( this.sqlUpdate + " WHERE id = ? " );
            ps.setString(1, pass.getFlightNumber());
            ps.setString(2, pass.getFirstName());
            ps.setString(3, pass.getSecondName());
            ps.setString(4, pass.getNationality());
            ps.setString(5, pass.getPassport());
            ps.setString(6, pass.getDateOfBirth());
            ps.setString(7, pass.getSex());
            ps.setString(8, pass.getClassOfSalon());
            ps.setInt(9,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

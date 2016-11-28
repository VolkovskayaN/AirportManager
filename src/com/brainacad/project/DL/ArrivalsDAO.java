package com.brainacad.project.DL;


import com.brainacad.project.BL.Arrivals;

import java.sql.*;

public class ArrivalsDAO {
    private String sqlSelect;
    private String sqlInsert;
    private String sqlDelete;
    private String sqlUpdate;

    private Connection connection;
   public ArrivalsDAO(Connection connection){
        this.connection =connection;
        this.sqlSelect = "SELECT * FROM Arrivals ";
        this.sqlInsert = "INSERT INTO Arrivals" +
                "('flightNumber'," +
                "'date'," +
                "'time'," +
                "'cityOfArrival'," +
                "'terminal'," +
                "'flightStatus')" + "VALUES(?,?,?,?,?,?)";
        this.sqlDelete = "DELETE FROM Arrivals ";

        this.sqlUpdate =  "UPDATE Departures SET flightNumber = ?, date = ?, time = ?, cityOfArrival = ?, terminal = ?, flightStatus = ?";
    }

    public void updateInfoAboutArrival(Arrivals arrival){
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlUpdate + "WHERE id = ?");
            ps.setString(1,arrival.getFlightNumber());
            ps.setString(2,arrival.getDate());
            ps.setString(3,arrival.getTime());
            ps.setString(4,arrival.getCityOfArrival());
            ps.setString(5,arrival.getTerminal());
            ps.setString(6,arrival.getFlightStatus());
            ps.setInt(7,arrival.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByFlightNumber(String flNumber) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + "where flightNumber = ?");
            ps.setString(1, flNumber);
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
    //TODO call in main
    public void searchByPortOfArrival(String portOfArrival) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + "WHERE cityOfArrival = ?");
            ps.setString(1, portOfArrival);
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
    public void viewArrivals() {
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

    public void insertArrival(Arrivals arrival){
        try {
            PreparedStatement ps =this.connection.prepareStatement(sqlInsert);
            ps.setString(1,arrival.getFlightNumber());
            ps.setString(2,arrival.getDate());
            ps.setString(3,arrival.getTime());
            ps.setString(4,arrival.getCityOfArrival());
            ps.setString(5,arrival.getTerminal());
            ps.setString(6,arrival.getFlightStatus());
            ps.executeUpdate();
            System.out.println("Insert OK!!!");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteArrival(int id){
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(this.sqlDelete + " where id = ? ");
            ps.setInt(1,id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The arrival was deleted successfully!");
            } else System.out.println("The arrival was not deleted! Try once again. ");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

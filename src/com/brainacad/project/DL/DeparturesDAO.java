package com.brainacad.project.DL;


import com.brainacad.project.BL.Departures;

import java.sql.*;

public class DeparturesDAO {
    private final Connection connection;
    private String sqlSelect;
    private String sqlInsert;
    private String sqlDelete;
    private String sqlUpdate;


    public DeparturesDAO(Connection connection) {
        this.connection = connection;
        this.sqlSelect = "SELECT * FROM Departures";
        this.sqlInsert = "INSERT INTO Departures" +
                " 'flightNumber'," +
                " 'date', " +
                "'time'," +
                "'cityOfDeparture'," +
                "'terminal', 'flightStatus'" +
                " VALUES(?,?,?,?,?,?)";
        this.sqlDelete = "DELETE FROM Departures";
        this.sqlUpdate = "UPDATE Departures SET flightNumber = ?, date = ?, time = ?, cityOfDeparture = ?, terminal = ?, flightStatus = ?";
    }


    public void updateInfoAboutDeparture(Departures departure) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlUpdate + "WHERE id = ?");
            ps.setString(1, departure.getFlightNumber());
            ps.setString(2, departure.getDate());
            ps.setString(3, departure.getTime());
            ps.setString(4, departure.getCityOfDeparture());
            ps.setString(5, departure.getTerminal());
            ps.setString(6, departure.getFlightStatus());
            ps.setInt(7, departure.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void viewDepartures() {
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


    public void insertDeparture(Departures departure) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, departure.getFlightNumber());
            ps.setString(2, departure.getDate());
            ps.setString(3, departure.getTime());
            ps.setString(4, departure.getCityOfDeparture());
            ps.setString(5, departure.getTerminal());
            ps.setString(6, departure.getFlightStatus());
            ps.executeUpdate();
            System.out.println("Insert OK!!!");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteDeparture(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(sqlDelete + "where id=?");
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The arrival was deleted successfully!");
            } else System.out.println("The arrival was not deleted! Try once again. ");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByFlightNumber(String flNumber) {

        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + " WHERE flightNumber = ?");
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
    public void searchByPortOfDeparture(String portOfDeparture) {

        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + " WHERE cityOfDeparture = ?");
            ps.setString(1, portOfDeparture);
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


}



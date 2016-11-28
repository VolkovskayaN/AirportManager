package com.brainacad.project.DL;


import com.brainacad.project.BL.Flight;

import java.sql.*;

public class PriceListDAO {
    private String sqlSelect;
    private String sqlDelete;
    private String sqlInsert;
    private String sqlUpdate;


    private Connection connection;

    public PriceListDAO(Connection connection) {
        this.connection = connection;

        this.sqlSelect = "SELECT * FROM PriceList";
        this.sqlDelete = "DELETE FROM PriceList ";
        this.sqlInsert = "INSERT INTO PriceList (flightNumber,departurePort, arrivalPort,classOfSalon,price) VALUES(?,?,?,?,?)  ";
        this.sqlUpdate = "UPDATE PriceList SET flightNumber=? , departurePort=?, arrivalPort=?, classOfSalon=?, price=?";


    }

    public void updateInfoAboutFlight(Flight flight) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlUpdate + "WHERE id = ?");
            ps.setString(1, flight.getFlightNumber());
            ps.setString(2, flight.getDeparturePort());
            ps.setString(3, flight.getArrivalPort());
            ps.setString(4, flight.getClassOfSalon());
            ps.setString(5, flight.getPrice());
            ps.setInt(6, flight.getId());
            ps.executeUpdate();
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

    public void searchByPortOfArrival(String portOfArrival) {

        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + " WHERE ArrivalPort = ?");
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


    public void searchByPortOfDeparture(String portOfDeparture) {

        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + " WHERE DeparturePort = ?");
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


    //TODO call in main
    public void searchByPrice(String price) {

        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlSelect + " WHERE Price = ?");
            ps.setString(1, price);
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



    public void insertFlight(Flight flight) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(sqlInsert);
            ps.setString(1, flight.getFlightNumber());
            ps.setString(2, flight.getDeparturePort());
            ps.setString(3, flight.getArrivalPort());
            ps.setString(4, flight.getClassOfSalon());
            ps.setString(5, flight.getPrice());
            ps.executeUpdate();
            System.out.println("Insert OK!!!");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deleteFlight(int id) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(this.sqlDelete + " where id = ? ");
            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("The flight was deleted successfully!");
            } else System.out.println("The flight was not deleted! ");
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void viewPriceList() {
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

}

package com.brainacad.project.UI;


import com.brainacad.project.BL.Arrivals;
import com.brainacad.project.BL.Departures;
import com.brainacad.project.BL.Flight;
import com.brainacad.project.DL.ArrivalsDAO;
import com.brainacad.project.DL.DeparturesDAO;
import com.brainacad.project.DL.PriceListDAO;
import com.brainacad.project.BL.Passenger;
import com.brainacad.project.DL.PassengerDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:Data.db");
    }

    public static void main(String... args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter login:");
        String login = in.nextLine();
        System.out.println("Enter password:");
        String password = in.nextLine();
        if (Objects.equals(login, "admin") && Objects.equals(password, "admin")) {
            System.out.println("You have the access of the administrator.");
            System.out.println("Available operations:");
            System.out.println("1.View PassengerList  " +
                    "2.View Arrivals  " +
                    "3.View Departures  " +
                    "4.View PriceList");
            System.out.println("5.Insert Passenger  " +
                    "6.Insert Arrival  " +
                    "7.Insert Departure  " +
                    "8.Insert flight into PriceList");
            System.out.println("9.Delete Passenger  " +
                    "10.Delete Arrival  " +
                    "11.Delete Departure  " +
                    "12.Delete flight from PriceList");
            System.out.println("13.Update Passenger  " +
                    "14.Update Arrival  " +
                    "15.Update Departure  " +
                    "16.Update flight in the PriceList");
            System.out.println("17.Search Passenger by Flight Number  " +
                    "18.Search Arrival by Flight Number " +
                    "19.Search Departure by Flight Number  " +
                    "20.Search flight in PriceList by Flight Number");
            System.out.println("21.Search Passenger by First Name  " +
                    "22.Search Passenger by Second Name " +
                    "23.Search Passenger by Passport " +
                    "24.Search Arrival by port of arrival");
            System.out.println("25.Search Departure by  port of departure  " +
                    "26.Search flight from PriceList by  price " +
                    "27.Search flight from PriceList by  port of arrival " +
                    "28.Search flight from PriceList by  port of departure");
            System.out.println("Enter number of an operation: ");
            Scanner op = new Scanner(System.in);
            int i = op.nextInt();

            switch (i) {
                // Viewing a PassengerList
                case 1:
                    System.out.println("Passenger List:");
                    try (Connection connection = getConnection()) {

                        PassengerDao passengerDao = new PassengerDao(connection);

                        passengerDao.viewPassengerList();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Viewing Arrivals
                case 2:
                    System.out.println("Arrivals:");
                    try (Connection connection = getConnection()) {

                        ArrivalsDAO arrivalsDao = new ArrivalsDAO(connection);

                        arrivalsDao.viewArrivals();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Viewing Departures
                case 3:
                    System.out.println("Departures:");
                    try (Connection connection = getConnection()) {

                        DeparturesDAO departuresDao = new DeparturesDAO(connection);

                        departuresDao.viewDepartures();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                //Viewing PriceList
                case 4:
                    System.out.println("PriceList");
                    try (Connection connection = getConnection()) {

                        PriceListDAO priceListDao = new PriceListDAO(connection);

                        priceListDao.viewPriceList();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //      Inserting a passenger
                case 5:
                    Passenger passenger = new Passenger();
                    Scanner in1 = new Scanner(System.in);
                    System.out.println("Enter flight number name:");
                    String flightNumber = in1.nextLine();
                    passenger.setFlightNumber(flightNumber);
                    System.out.println("Enter first name:");
                    String name = in1.nextLine();
                    passenger.setFirstName(name);

                    System.out.println("Enter second name:");
                    String secondName = in1.nextLine();
                    passenger.setSecondName(secondName);

                    System.out.println("Enter nationality:");
                    String nation = in1.nextLine();
                    passenger.setNationality(nation);
                    System.out.println("Enter passport:");
                    String passport = in1.nextLine();
                    passenger.setPassport(passport);
                    System.out.println("Enter date of birth:");
                    String dOb = in1.nextLine();
                    passenger.setDateOfBirth(dOb);
                    System.out.println("Enter sex:");
                    String sex = in1.nextLine();
                    passenger.setSex(sex);
                    System.out.println("Enter class of salon name:");
                    String classOfSalon = in1.nextLine();
                    passenger.setClassOfSalon(classOfSalon);

                    try (Connection connection = getConnection()) {

                        PassengerDao passengerDao = new PassengerDao(connection);

                        passengerDao.insertPassenger(passenger);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Inserting an arrival
                case 6:
                    Arrivals arrival = new Arrivals();
                    Scanner in6 = new Scanner(System.in);
                    System.out.println("Enter flight number name:");
                    String flightNumber1 = in6.nextLine();
                    arrival.setFlightNumber(flightNumber1);
                    System.out.println("Enter date:");
                    String date = in6.nextLine();
                    arrival.setDate(date);

                    System.out.println("Enter  time:");
                    String time = in6.nextLine();
                    arrival.setTime(time);

                    System.out.println("Enter city of Arrival:");
                    String city = in6.nextLine();
                    arrival.setCityOfArrival(city);
                    System.out.println("Enter terminal:");
                    String terminal = in6.nextLine();
                    arrival.setTerminal(terminal);
                    System.out.println("Enter flight status:");
                    String flStatus = in6.nextLine();
                    arrival.setFlightStatus(flStatus);


                    try (Connection connection = getConnection()) {

                        ArrivalsDAO arrivalsDAO = new ArrivalsDAO(connection);

                        arrivalsDAO.insertArrival(arrival);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;


                //Inserting a departure
                case 7:
                    Departures departure = new Departures();
                    Scanner dep = new Scanner(System.in);
                    System.out.println("Enter flight number name:");
                    String flNumber1 = dep.nextLine();
                    departure.setFlightNumber(flNumber1);
                    System.out.println("Enter date:");
                    String dateDp = dep.nextLine();
                    departure.setDate(dateDp);

                    System.out.println("Enter  time:");
                    String timeDp = dep.nextLine();
                    departure.setTime(timeDp);

                    System.out.println("Enter city of Departure:");
                    String cityDp = dep.nextLine();
                    departure.setCityOfDeparture(cityDp);
                    System.out.println("Enter terminal:");
                    String terminalDp = dep.nextLine();
                    departure.setTerminal(terminalDp);
                    System.out.println("Enter flight status:");
                    String flStatusDp = dep.nextLine();
                    departure.setFlightStatus(flStatusDp);

                    try (Connection connection = getConnection()) {

                        DeparturesDAO departuresDAO = new DeparturesDAO(connection);

                        departuresDAO.insertDeparture(departure);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Inserting a flight into PriceList
                case 8:
                    Flight flight = new Flight();
                    Scanner fl = new Scanner(System.in);
                    System.out.println("Enter flight number name:");
                    String flNumberP = fl.nextLine();
                    flight.setFlightNumber(flNumberP);

                    System.out.println("Enter city of Departure:");
                    String cityDp1 = fl.nextLine();
                    flight.setDeparturePort(cityDp1);

                    System.out.println("Enter city of Arrival:");
                    String cityAr = fl.nextLine();
                    flight.setArrivalPort(cityAr);
                    System.out.println("Enter class of salon:");
                    String salonClass = fl.nextLine();
                    flight.setClassOfSalon(salonClass);
                    System.out.println("Enter price:");
                    String price = fl.nextLine();
                    flight.setPrice(price);

                    try (Connection connection = getConnection()) {

                        PriceListDAO priceListDAO = new PriceListDAO(connection);

                        priceListDAO.insertFlight(flight);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                //Deleting a passenger

                case 9:
                    try (Connection connection = getConnection()) {
                        PassengerDao passengerDao = new PassengerDao(connection);

                        System.out.println("Enter id of a passenger:");
                        Scanner in4 = new Scanner(System.in);
                        int id = in4.nextInt();
                        passengerDao.deletePassenger(id);
                        connection.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Deleting an arrival
                case 10:
                    try (Connection connection = getConnection()) {
                        ArrivalsDAO passengerDao = new ArrivalsDAO(connection);

                        System.out.println("Enter id of an arrival:");
                        Scanner delArr = new Scanner(System.in);
                        int id = delArr.nextInt();
                        passengerDao.deleteArrival(id);
                        connection.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Deleting a departure
                case 11:
                    try (Connection connection = getConnection()) {
                        DeparturesDAO depDAO = new DeparturesDAO(connection);

                        System.out.println("Enter id of a departure:");
                        Scanner delDp = new Scanner(System.in);
                        int id = delDp.nextInt();
                        depDAO.deleteDeparture(id);
                        connection.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Deleting flight from PriceList
                case 12:
                    try (Connection connection = getConnection()) {
                        PriceListDAO plDAO = new PriceListDAO(connection);

                        System.out.println("Enter id of a flight:");
                        Scanner delPL = new Scanner(System.in);
                        int id = delPL.nextInt();
                        plDAO.deleteFlight(id);
                        connection.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;


                //Updating a passenger
                case 13:

                    Scanner in8 = new Scanner(System.in);
                    Passenger passenger1 = new Passenger();

                    System.out.println("Enter id of passenger");
                    Scanner in7 = new Scanner(System.in);
                    int id = in7.nextInt();
                    passenger1.setId(id);
                    System.out.println("Enter flight number name:");
                    String flightNumber2 = in8.nextLine();
                    passenger1.setFlightNumber(flightNumber2);
                    System.out.println("Enter first name:");
                    String name1 = in8.nextLine();
                    passenger1.setFirstName(name1);

                    System.out.println("Enter second name:");
                    String secondName1 = in8.nextLine();
                    passenger1.setSecondName(secondName1);

                    System.out.println("Enter nationality:");
                    String nation1 = in8.nextLine();
                    passenger1.setNationality(nation1);
                    System.out.println("Enter passport:");
                    String passport1 = in8.nextLine();
                    passenger1.setPassport(passport1);
                    System.out.println("Enter date of birth:");
                    String dOb1 = in8.nextLine();
                    passenger1.setDateOfBirth(dOb1);
                    System.out.println("Enter sex:");
                    String sex1 = in8.nextLine();
                    passenger1.setSex(sex1);
                    System.out.println("Enter class of salon name:");
                    String classOfSalon1 = in8.nextLine();
                    passenger1.setClassOfSalon(classOfSalon1);
                    System.out.println("Enter id of a passenger:");
                    int idPass = in8.nextInt();
                    passenger1.setId(idPass);
                    try (Connection connection = getConnection()) {

                        PassengerDao passDao = new PassengerDao(connection);
                        passDao.updateInfo(passenger1, id);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Updating an arrival
                case 14:
                    Arrivals arrival1 = new Arrivals();
                    Scanner updateArr = new Scanner(System.in);

                    System.out.println("Enter flight number name:");
                    String flightNumberArr = updateArr.nextLine();
                    arrival1.setFlightNumber(flightNumberArr);
                    System.out.println("Enter date:");
                    String dateArr = updateArr.nextLine();
                    arrival1.setDate(dateArr);

                    System.out.println("Enter  time:");
                    String timeArr = updateArr.nextLine();
                    arrival1.setTime(timeArr);

                    System.out.println("Enter city of Arrival:");
                    String cityArr = updateArr.nextLine();
                    arrival1.setCityOfArrival(cityArr);
                    System.out.println("Enter terminal:");
                    String terminalArr = updateArr.nextLine();
                    arrival1.setTerminal(terminalArr);
                    System.out.println("Enter flight status:");
                    String flStatusArr = updateArr.nextLine();
                    arrival1.setFlightStatus(flStatusArr);
                    System.out.println("Enter id of an arrival:");
                    int idAr = updateArr.nextInt();
                    arrival1.setId(idAr);


                    try (Connection connection = getConnection()) {

                        ArrivalsDAO arrDao = new ArrivalsDAO(connection);

                        arrDao.updateInfoAboutArrival(arrival1);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Updating a departure
                case 15:
                    Departures departure1 = new Departures();
                    Scanner updateDp = new Scanner(System.in);

                    System.out.println("Enter flight number :");
                    String flNumbDep = updateDp.nextLine();
                    departure1.setFlightNumber(flNumbDep);

                    System.out.println("Enter date:");
                    String dateDep = updateDp.nextLine();
                    departure1.setDate(dateDep);

                    System.out.println("Enter  time:");
                    String timeDep = updateDp.nextLine();
                    departure1.setTime(timeDep);

                    System.out.println("Enter city of Departure:");
                    String cityDep = updateDp.nextLine();
                    departure1.setCityOfDeparture(cityDep);
                    System.out.println("Enter terminal:");
                    String terminalDep = updateDp.nextLine();
                    departure1.setTerminal(terminalDep);
                    System.out.println("Enter flight status:");
                    String flStatusDep = updateDp.nextLine();
                    departure1.setFlightStatus(flStatusDep);

                    System.out.println("Enter id of departure:");
                    int idDP = updateDp.nextInt();
                    departure1.setId(idDP);

                    try (Connection connection = getConnection()) {

                        DeparturesDAO departuresDao = new DeparturesDAO(connection);

                        departuresDao.updateInfoAboutDeparture(departure1);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Updating flight in PriceList
                case 16:
                    Flight flightPL = new Flight();
                    Scanner updatePl = new Scanner(System.in);

                    System.out.println("Enter flight number name:");
                    String flNumberPL = updatePl.nextLine();
                    flightPL.setFlightNumber(flNumberPL);

                    System.out.println("Enter city of Departure:");
                    String cityDpPl = updatePl.nextLine();
                    flightPL.setDeparturePort(cityDpPl);

                    System.out.println("Enter city of Arrival:");
                    String cityArrPL = updatePl.nextLine();
                    flightPL.setArrivalPort(cityArrPL);
                    System.out.println("Enter class of salon:");
                    String salonPl = updatePl.nextLine();
                    flightPL.setClassOfSalon(salonPl);
                    System.out.println("Enter price:");
                    String pricePL = updatePl.nextLine();
                    flightPL.setPrice(pricePL);
                    System.out.println("Enter id of flight:");
                    int idPl = updatePl.nextInt();
                    flightPL.setId(idPl);


                    try (Connection connection = getConnection()) {

                        PriceListDAO plDAO = new PriceListDAO(connection);

                        plDAO.updateInfoAboutFlight(flightPL);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;


                //Searching passenger by flight number
                case 17:
                    Scanner in9 = new Scanner(System.in);
                    System.out.println("Enter flight number:");
                    String flNumber = in9.nextLine();
                    try (Connection connection = getConnection()) {

                        PassengerDao pass = new PassengerDao(connection);

                        pass.searchByFlightNumber(flNumber);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching arrival by flight number
                case 18:
                    Scanner searchArr = new Scanner(System.in);
                    System.out.println("Enter flight number:");
                    String arrNumber = searchArr.nextLine();
                    try (Connection connection = getConnection()) {

                        ArrivalsDAO arr = new ArrivalsDAO(connection);

                        arr.searchByFlightNumber(arrNumber);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                //Searching departure by flight number
                case 19:
                    try (Connection connection = getConnection()) {

                        DeparturesDAO departuresDao = new DeparturesDAO(connection);

                        Scanner in10 = new Scanner(System.in);
                        System.out.println("Enter flight number:");
                        String depNumber = in10.nextLine();
                        departuresDao.searchByFlightNumber(depNumber);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching flight from PriceList by flight number
                case 20:
                    try (Connection connection = getConnection()) {

                        PriceListDAO plDao = new PriceListDAO(connection);

                        Scanner searchFl = new Scanner(System.in);
                        System.out.println("Enter flight number:");
                        String flNumb = searchFl.nextLine();
                        plDao.searchByFlightNumber(flNumb);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching passenger by first name
                case 21:
                    Scanner in21 = new Scanner(System.in);
                    System.out.println("Enter first name:");
                    String fName = in21.nextLine();
                    try (Connection connection = getConnection()) {

                        PassengerDao pass = new PassengerDao(connection);

                        pass.searchByFirstName(fName);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching passenger by second name
                case 22:
                    Scanner in22 = new Scanner(System.in);
                    System.out.println("Enter second name:");
                    String sndName = in22.nextLine();
                    try (Connection connection = getConnection()) {

                        PassengerDao pass = new PassengerDao(connection);

                        pass.searchByLastName(sndName);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching passenger by passport
                case 23:
                    Scanner in23 = new Scanner(System.in);
                    System.out.println("Enter passport:");
                    String passportP = in23.nextLine();
                    try (Connection connection = getConnection()) {

                        PassengerDao pass = new PassengerDao(connection);
                        pass.searchByPassport(passportP);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching arrival by port of arrival
                case 24:
                    Scanner in24 = new Scanner(System.in);
                    System.out.println("Enter port of arrival:");
                    String arrPort = in24.nextLine();
                    try (Connection connection = getConnection()) {

                        ArrivalsDAO arr = new ArrivalsDAO(connection);

                        arr.searchByPortOfArrival(arrPort);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching departure by flight number
                case 25:
                    try (Connection connection = getConnection()) {

                        DeparturesDAO departuresDao = new DeparturesDAO(connection);

                        Scanner in10 = new Scanner(System.in);
                        System.out.println("Enter flight number:");
                        String depNumber = in10.nextLine();
                        departuresDao.searchByPortOfDeparture(depNumber);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching flight from PriceList by price
                case 26:
                    try (Connection connection = getConnection()) {

                        PriceListDAO plDao = new PriceListDAO(connection);

                        Scanner searchFl = new Scanner(System.in);
                        System.out.println("Enter price:");
                        String flPassport = searchFl.nextLine();
                        plDao.searchByPrice(flPassport);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching flight from PriceList by port of arrival
                case 27:
                    try (Connection connection = getConnection()) {

                        PriceListDAO plDao = new PriceListDAO(connection);

                        Scanner searchFl = new Scanner(System.in);
                        System.out.println("Enter port of arrival:");
                        String arrivalPort = searchFl.nextLine();
                        plDao.searchByPortOfArrival(arrivalPort);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching flight from PriceList by port of departure
                case 28:
                    try (Connection connection = getConnection()) {

                        PriceListDAO plDao = new PriceListDAO(connection);

                        Scanner searchFl = new Scanner(System.in);
                        System.out.println("Enter port of departure:");
                        String departurePort = searchFl.nextLine();
                        plDao.searchByPortOfDeparture(departurePort);
                        connection.close();
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                    break;



                default:
                    System.out.println("You have entered wrong operation!");


            }


        } else {
            System.out.println("You have access of user.");
            System.out.println("Available operations:");
            System.out.println("1.View PassengerList  " +
                    "2.View Arrivals  " +
                    "3.View Departures  " +
                    "4.View PriceList");

            System.out.println("5.Search Passenger by Flight Number  " +
                    "6.Search Arrival by Flight Number " +
                    "7.Search Departure by Flight Number  " +
                    "8.Search flight in PriceList by Flight Number");
            System.out.println("9.Search Passenger by First Name  " +
                    "10.Search Passenger by Second Name " +
                    "11.Search Passenger by Passport " +
                    "12.Search Arrival by port of arrival");
            System.out.println("13.Search Departure by  port of departure  " +
                    "14.Search flight from PriceList by  price " +
                    "15.Search flight from PriceList by  port of arrival " +
                    "16.Search flight from PriceList by  port of departure");
            System.out.println("Enter number of an operation: ");
            Scanner op = new Scanner(System.in);
            int i = op.nextInt();
            switch (i) {
                // Viewing a PassengerList
                case 1:
                    System.out.println("Passenger List:");
                    try (Connection connection = getConnection()) {

                        PassengerDao passengerDao = new PassengerDao(connection);

                        passengerDao.viewPassengerList();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Viewing Arrivals
                case 2:
                    System.out.println("Arrivals:");
                    try (Connection connection = getConnection()) {

                        ArrivalsDAO arrivalsDao = new ArrivalsDAO(connection);

                        arrivalsDao.viewArrivals();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Viewing Departures
                case 3:
                    System.out.println("Departures:");
                    try (Connection connection = getConnection()) {

                        DeparturesDAO departuresDao = new DeparturesDAO(connection);

                        departuresDao.viewDepartures();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                //Viewing PriceList
                case 4:
                    System.out.println("PriceList");
                    try (Connection connection = getConnection()) {

                        PriceListDAO priceListDao = new PriceListDAO(connection);

                        priceListDao.viewPriceList();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                //Searching passenger by flight number
                case 5:
                    Scanner in9 = new Scanner(System.in);
                    System.out.println("Enter flight number:");
                    String flNumber = in9.nextLine();
                    try (Connection connection = getConnection()) {

                        PassengerDao pass = new PassengerDao(connection);

                        pass.searchByFlightNumber(flNumber);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching arrival by flight number
                case 6:
                    Scanner searchArr = new Scanner(System.in);
                    System.out.println("Enter flight number:");
                    String arrNumber = searchArr.nextLine();
                    try (Connection connection = getConnection()) {

                        ArrivalsDAO arr = new ArrivalsDAO(connection);

                        arr.searchByFlightNumber(arrNumber);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                //Searching departure by flight number
                case 7:
                    try (Connection connection = getConnection()) {

                        DeparturesDAO departuresDao = new DeparturesDAO(connection);

                        Scanner in10 = new Scanner(System.in);
                        System.out.println("Enter flight number:");
                        String depNumber = in10.nextLine();
                        departuresDao.searchByFlightNumber(depNumber);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching flight from PriceList by flight number
                case 8:
                    try (Connection connection = getConnection()) {

                        PriceListDAO plDao = new PriceListDAO(connection);

                        Scanner searchFl = new Scanner(System.in);
                        System.out.println("Enter flight number:");
                        String flNumb = searchFl.nextLine();
                        plDao.searchByFlightNumber(flNumb);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching passenger by first name
                case 9:
                    Scanner in21 = new Scanner(System.in);
                    System.out.println("Enter first name:");
                    String fName = in21.nextLine();
                    try (Connection connection = getConnection()) {

                        PassengerDao pass = new PassengerDao(connection);

                        pass.searchByFirstName(fName);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching passenger by second name
                case 10:
                    Scanner in22 = new Scanner(System.in);
                    System.out.println("Enter second name:");
                    String sndName = in22.nextLine();
                    try (Connection connection = getConnection()) {

                        PassengerDao pass = new PassengerDao(connection);

                        pass.searchByLastName(sndName);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching passenger by passport
                case 11:
                    Scanner in23 = new Scanner(System.in);
                    System.out.println("Enter passport:");
                    String passportP = in23.nextLine();
                    try (Connection connection = getConnection()) {

                        PassengerDao pass = new PassengerDao(connection);
                        pass.searchByPassport(passportP);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching arrival by port of arrival
                case 12:
                    Scanner in24 = new Scanner(System.in);
                    System.out.println("Enter port of arrival:");
                    String arrPort = in24.nextLine();
                    try (Connection connection = getConnection()) {

                        ArrivalsDAO arr = new ArrivalsDAO(connection);

                        arr.searchByPortOfArrival(arrPort);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching departure by flight number
                case 13:
                    try (Connection connection = getConnection()) {

                        DeparturesDAO departuresDao = new DeparturesDAO(connection);

                        Scanner in10 = new Scanner(System.in);
                        System.out.println("Enter flight number:");
                        String depNumber = in10.nextLine();
                        departuresDao.searchByPortOfDeparture(depNumber);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching flight from PriceList by price
                case 14:
                    try (Connection connection = getConnection()) {

                        PriceListDAO plDao = new PriceListDAO(connection);

                        Scanner searchFl = new Scanner(System.in);
                        System.out.println("Enter price:");
                        String flPassport = searchFl.nextLine();
                        plDao.searchByPrice(flPassport);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching flight from PriceList by port of arrival
                case 15:
                    try (Connection connection = getConnection()) {

                        PriceListDAO plDao = new PriceListDAO(connection);

                        Scanner searchFl = new Scanner(System.in);
                        System.out.println("Enter port of arrival:");
                        String arrivalPort = searchFl.nextLine();
                        plDao.searchByPortOfArrival(arrivalPort);
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                //Searching flight from PriceList by port of departure
                case 16:
                    try (Connection connection = getConnection()) {

                        PriceListDAO plDao = new PriceListDAO(connection);

                        Scanner searchFl = new Scanner(System.in);
                        System.out.println("Enter port of departure:");
                        String departurePort = searchFl.nextLine();
                        plDao.searchByPortOfDeparture(departurePort);
                        connection.close();
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }
                    break;



                default:
                    System.out.println("You have entered wrong operation!");


            }


        }
    }
}

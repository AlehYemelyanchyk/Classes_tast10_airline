package by.epam.ayem.module4.service;

/*10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
        Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
        Найти и вывести:
        а) список рейсов для заданного пункта назначения;
        b) список рейсов для заданного дня недели;
        с) список рейсов для заданного дня недели, время вылета для которых больше заданного.*/

import by.epam.ayem.module4.model.Airline;
import by.epam.ayem.module4.model.Airport;
import by.epam.ayem.module4.model.DaysOfWeek;

public class AirlineService {

    public void addFlights(Airport airport, String destination, int flightNumber, String aircraftType,
                           String departureTime, DaysOfWeek dayOfWeek) {
        airport.getAirlines().add(new Airline(destination, flightNumber, aircraftType, departureTime, dayOfWeek));
    }

    public void showFlightsByDestination(Airport airport, String destination) {
        for (Airline airline : airport.getAirlines()) {
            if (airline.getDestination().equalsIgnoreCase(destination)) {
                System.out.println(airline.toString());
                return;
            }
        }
        System.out.println("Flights are not found");
    }

    public boolean isDayOfWeek(String str) {

        DaysOfWeek[] days = DaysOfWeek.values();
        for (int i = 0; i < days.length; i++) {
            if (days[i].toString().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void showFlightsByDayOfWeek(Airport airport, DaysOfWeek dayOfWeek) {

        boolean found = false;

        for (Airline airline : airport.getAirlines()) {
            if (airline.getDayOfWeek().toString().equals(dayOfWeek.toString())) {
                System.out.println(airline.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Flights are not found");
        }
    }

    public void showFlightsByDayOfWeekAndTime(Airport airport, DaysOfWeek dayOfWeek, int hour, int min) {

        boolean found = false;

        for (Airline airline : airport.getAirlines()) {
            if (airline.getDayOfWeek().toString().equalsIgnoreCase(dayOfWeek.toString())) {
                String strTime = airline.getDepartureTime();
                String[] strTimeArray = strTime.split(":");
                int hourDep = Integer.valueOf(strTimeArray[0]);
                int minDep = Integer.valueOf(strTimeArray[1]);

                if (hourDep >= hour) {
                    if (hourDep > hour || minDep > min) {
                        System.out.println(airline.toString());
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Flights are not found");
        }
    }
}

/*10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
        Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
        Найти и вывести:
        а) список рейсов для заданного пункта назначения;
        b) список рейсов для заданного дня недели;
        с) список рейсов для заданного дня недели, время вылета для которых больше заданного.*/

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private String name;
    private List<Airline> airlines;

    public Airport(String name) {
        this.name = name;
        this.airlines = new ArrayList<>();
    }

    public void addFlights(String destination, int flightNumber, String aircraftType, String departureTime, DaysOfWeek dayOfWeek) {
        airlines.add(new Airline(destination, flightNumber, aircraftType, departureTime, dayOfWeek));
    }

    public void showFlightsByDestination(String destination) {

        for (Airline airline : airlines) {
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

    public void showFlightsByDayOfWeek(DaysOfWeek dayOfWeek) {

        boolean found = false;

        for (Airline airline : airlines) {
            if (airline.getDayOfWeek().toString().equals(dayOfWeek.toString())) {
                System.out.println(airline.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Flights are not found");
        }
    }

    public void showFlightsByDayOfWeek(DaysOfWeek dayOfWeek, int hour, int min) {

        boolean found = false;

        for (Airline airline : airlines) {
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

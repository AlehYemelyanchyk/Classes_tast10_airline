package by.epam.ayem.module4;

/*10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
        Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
        Найти и вывести:
        а) список рейсов для заданного пункта назначения;
        b) список рейсов для заданного дня недели;
        с) список рейсов для заданного дня недели, время вылета для которых больше заданного.*/

import by.epam.ayem.module4.model.Airport;
import by.epam.ayem.module4.model.DaysOfWeek;
import by.epam.ayem.module4.service.AirlineService;

import java.time.DayOfWeek;
import java.util.Scanner;

public class AirlineMain {

    public static void main(String[] args) {
        Airport heathrow = new Airport("Heathrow");
        AirlineService airlineService = new AirlineService();

        airlineService.addFlights(heathrow, "Moscow", 45845,
                "Airbus A-380", "8:30", DaysOfWeek.MONDAY);

        airlineService.addFlights(heathrow, "Minsk", 35486,
                "Airbus A-1000", "10:00", DaysOfWeek.MONDAY);

        airlineService.addFlights(heathrow, "Moscow", 78545,
                "Boeing 747", "8:50", DaysOfWeek.WEDNESDAY);

        airlineService.addFlights(heathrow, "Warsaw", 78545,
                "Boeing 747", "10:30", DaysOfWeek.FRIDAY);

        airlineService.addFlights(heathrow, "Minsk", 54865,
                "Airbus A-380", "8:30", DaysOfWeek.FRIDAY);

        airlineService.addFlights(heathrow, "Moscow", 75845,
                "Airbus A-380", "18:30", DaysOfWeek.SUNDAY);

        boolean quit = false;
        int choice;
        Scanner sc = new Scanner(System.in);

        while (!quit) {

            printMenu();

            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Enter a number:");
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter a destination: ");
                    String destination = sc.nextLine();
                    airlineService.showFlightsByDestination(heathrow, destination);
                    break;
                case 2:
                    System.out.println("Enter a day of the week: ");
                    String day = sc.nextLine().toUpperCase();
                    if (airlineService.isDayOfWeek(day)) {
                        DayOfWeek.valueOf(day);
                    } else {
                        break;
                    }
                    airlineService.showFlightsByDayOfWeek(heathrow, DaysOfWeek.valueOf(day));
                    break;
                case 3:
                    System.out.println("Enter a day of the week: ");
                    String day2 = sc.nextLine().toUpperCase();
                    if (airlineService.isDayOfWeek(day2)) {
                        DayOfWeek.valueOf(day2);
                    } else {
                        break;
                    }
                    System.out.println("Enter hour:");
                    int hour = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter minutes:");
                    int min = sc.nextInt();
                    sc.nextLine();
                    airlineService.showFlightsByDayOfWeekAndTime(heathrow, DaysOfWeek.valueOf(day2), hour, min);
                    break;
                case 0:
                    quit = true;
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nWelcome to the airport!"
                + "\n1. Search flights by destination."
                + "\n2. Search flights by day of the week."
                + "\n3. Search flights by day of the week with time."
                + "\n0. Quit."
                + "\nEnter a number:");
    }

}

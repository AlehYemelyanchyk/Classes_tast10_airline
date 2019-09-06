package by.epam.ayem.module4;

/*10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами.
Задать критерии выбора данных и вывести эти данные на консоль.
        Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
        Найти и вывести:
        а) список рейсов для заданного пункта назначения;
        b) список рейсов для заданного дня недели;
        с) список рейсов для заданного дня недели, время вылета для которых больше заданного.*/

public class Airline {

    private String destination;
    private int flightNumber;
    private String aircraftType;
    private String departureTime;
    private DaysOfWeek dayOfWeek;

    public Airline(String destination, int flightNumber, String aircraftType, String departureTime, DaysOfWeek dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Airline: London - " + destination + ". Flight number " + flightNumber + ", " + aircraftType
                + ". Departure time: " + departureTime + ", " + dayOfWeek + ".";
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public DaysOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DaysOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}



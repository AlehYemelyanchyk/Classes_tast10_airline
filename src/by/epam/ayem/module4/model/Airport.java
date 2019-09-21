package by.epam.ayem.module4.model;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private String name;
    private final List<Airline> airlines;

    public Airport(String name) {
        this.name = name;
        this.airlines = new ArrayList<>();
    }

    public List<Airline> getAirlines() {
        return airlines;
    }
}



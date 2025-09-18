package com.gridnine.testing;

import com.gridnine.testing.filters.FilterArrivalDateBeforeDeparture;
import com.gridnine.testing.filters.FilterDepartureUpToCurrentTime;
import com.gridnine.testing.filters.FilterTimeOnGroundBetweenDepartures;
import com.gridnine.testing.interfaces.Filters;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.Service;
import com.gridnine.testing.testList.FlightBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Filters> listFilters1 = new ArrayList<>();
        List<Filters> listFilters2 = new ArrayList<>();
        List<Filters> listFilters3 = new ArrayList<>();
        List<Flight> flightList = FlightBuilder.createFlights();
        for (Flight variable : flightList) {
            listFilters1.add(new FilterDepartureUpToCurrentTime(variable.getSegments()));
            listFilters2.add(new FilterArrivalDateBeforeDeparture(variable.getSegments()));
            listFilters3.add(new FilterTimeOnGroundBetweenDepartures(variable.getSegments()));
        }
        System.out.println("\nИсходный тестовый список");
        for (Flight variable : flightList) {
            System.out.println(variable);
        }
        System.out.println("\nУдалим из вышеуказанного списка вылет рейсов до текущего момента времени");
        for (Flight variable : new Service(listFilters1).filter()) {
            System.out.println(variable);
        }
        System.out.println("\nУдалим вылеты с сегментами с датой прилёта раньше даты вылета");
        for (Flight variable : new Service(listFilters2).filter()) {
            System.out.println(variable);
        }
        System.out.println("\nУдалим перелеты, где общее время, проведённое на земле, превышает два часа");
        for (Flight variable : new Service(listFilters3).filter()) {
            System.out.println(variable);
        }
    }
}
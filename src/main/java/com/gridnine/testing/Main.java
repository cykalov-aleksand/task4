package com.gridnine.testing;

import com.gridnine.testing.filters.FilterArrivalDateBeforeDeparture;
import com.gridnine.testing.filters.FilterDepartureUpToCurrentTime;
import com.gridnine.testing.filters.FilterTimeOnGroundBetweenDepartures;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.testList.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("\nИсходный тестовый список");
        for (Flight variable : flightList) {
            System.out.println(variable);
        }
        System.out.println("\nУдалим из вышеуказанного списка вылет рейсов до текущего момента времени");
        for (Flight variable : flightList) {
            if (!((new FilterDepartureUpToCurrentTime(variable.getSegments())).filter())) {
                System.out.println(variable);
            }
        }
        System.out.println("\nУдалим вылеты с сегментами с датой прилёта раньше даты вылета");
        for (Flight variable : flightList) {
            if (!(new FilterArrivalDateBeforeDeparture(variable.getSegments())).filter()) {
                System.out.println(variable);
            }
        }
        System.out.println("\nУдалим перелеты, где общее время, проведённое на земле, превышает два часа");
        for (Flight variable : flightList) {
            if (!((new FilterTimeOnGroundBetweenDepartures(variable.getSegments())).filter())) {
                System.out.println(variable);
            }
        }
    }
}
package com.gridnine.testing.model;



import com.gridnine.testing.interfaces.Filters;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Bean that represents a flight.
 */
public class Flight{

    private final List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    public List<Segment> getSegments() {
        return segments;
    }



}


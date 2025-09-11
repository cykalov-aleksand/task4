package com.gridnine.testing.filters;

import com.gridnine.testing.interfaces.Filters;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FilterDepartureUpToCurrentTime extends Flight implements Filters {
    public FilterDepartureUpToCurrentTime(List<Segment> segments) {
        super(segments);
    }
    @Override
    public boolean filter() {
        LocalDateTime dateTime = LocalDateTime.now();
        {
            for (Segment variable : this.getSegments()) {
              if(variable.getDepartureDate().truncatedTo(ChronoUnit.SECONDS).isBefore(dateTime.truncatedTo(ChronoUnit.SECONDS)))
                    return true;
                }
            }
            return false;
        }
    }


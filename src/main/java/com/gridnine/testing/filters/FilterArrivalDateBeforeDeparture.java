package com.gridnine.testing.filters;

import com.gridnine.testing.interfaces.Filters;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.util.List;

public class FilterArrivalDateBeforeDeparture extends Flight implements Filters {
    public FilterArrivalDateBeforeDeparture(List<Segment> segments) {
        super(segments);
    }

    @Override
    public boolean filter() {
        if (this.getSegments().size() >= 2) {
            for (int count = 0; count < this.getSegments().size() - 1; count++) {
                if (!this.getSegments().get(count).getArrivalDate().toLocalDate()
                        .isEqual(this.getSegments().get(count + 1).getDepartureDate()
                                .toLocalDate())) {
                    return true;
                }
            }
        }
        return false;
    }
}

package com.gridnine.testing.filters;

import com.gridnine.testing.interfaces.Filters;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.util.List;

public class FilterTimeOnGroundBetweenDepartures extends Flight implements Filters {
    public FilterTimeOnGroundBetweenDepartures(List<Segment> segments) {
        super(segments);

    }

    @Override
    public boolean filter() {
        long interval = 0;
        if (this.getSegments().size() >= 2) {
            for (int count = 0; count < this.getSegments().size() - 1; count++) {
                interval = interval + Duration.between(this.getSegments().get(count).getArrivalDate(),
                        this.getSegments().get(count + 1).getDepartureDate()).getSeconds();
                if (interval > 7200) {
                    return true;
                }
            }
        }
        return false;
    }
}

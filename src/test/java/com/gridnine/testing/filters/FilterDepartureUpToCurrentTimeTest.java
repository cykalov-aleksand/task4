package com.gridnine.testing.filters;

import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class FilterDepartureUpToCurrentTimeTest {
    @Test
    public void filterDepartureTrueTest(){
        List<Segment>flight=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().minusSeconds(1),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject=new FilterDepartureUpToCurrentTime(flight);
        boolean result=filterObject.filter();
        Assertions.assertTrue(result);
    }
    @Test
    public void filterDepartureFalseOneTest(){
        List<Segment>flight=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject=new FilterDepartureUpToCurrentTime(flight);
        boolean result=filterObject.filter();
        Assertions.assertFalse(result);
    }
    @Test
    public void filterDepartureFalseSecondTest(){

        List<Segment>flight=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject=new FilterDepartureUpToCurrentTime(flight);
        boolean result=filterObject.filter();
        Assertions.assertFalse(result);
    }
}

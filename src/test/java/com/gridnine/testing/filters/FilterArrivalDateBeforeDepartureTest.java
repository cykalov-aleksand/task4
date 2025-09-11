package com.gridnine.testing.filters;

import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class FilterArrivalDateBeforeDepartureTest {
    @Test
    public void filterArrivalDateBeforeDepartureTrueTest(){
        List<Segment> flight=List.of(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(1).plusHours(2)));
        FilterArrivalDateBeforeDeparture filterObject=new FilterArrivalDateBeforeDeparture(flight);
        boolean result=filterObject.filter();
        Assertions.assertTrue(result);
     }
    @Test
    public void filterArrivalDateBeforeDepartureFalseOneTest(){
        List<Segment> flight=List.of(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().minusDays(1),LocalDateTime.now().minusDays(1).plusHours(2)));
        FilterArrivalDateBeforeDeparture filterObject=new FilterArrivalDateBeforeDeparture(flight);
        boolean result=filterObject.filter();
        Assertions.assertFalse(result);
    }
@Test
public void filterArrivalDateBeforeDepartureFalseSecondTest(){
    List<Segment> flight=List.of(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(2)));
    FilterArrivalDateBeforeDeparture filterObject=new FilterArrivalDateBeforeDeparture(flight);
    boolean result=filterObject.filter();
    Assertions.assertFalse(result);
}
}
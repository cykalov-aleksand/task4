package com.gridnine.testing.filters;

import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class FilterTimeOnGroundBetweenDeparturesTest {
    @Test
    public void filterTimeOnGroundBetweenDeparturesOneTrueTest(){
        List<Segment> flight=List.of(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().plusHours(4).plusSeconds(1),LocalDateTime.now().plusHours(8)));
        FilterTimeOnGroundBetweenDepartures filterObject=new FilterTimeOnGroundBetweenDepartures(flight);
        boolean result=filterObject.filter();
        Assertions.assertTrue(result);
    }
    @Test
    public void filterTimeOnGroundBetweenDeparturesSecondTrueTest(){
        List<Segment> flight=List.of(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(2),LocalDateTime.now().plusHours(3)),
                new Segment(LocalDateTime.now().plusHours(4).plusSeconds(1),LocalDateTime.now().plusHours(8)));
        FilterTimeOnGroundBetweenDepartures filterObject=new FilterTimeOnGroundBetweenDepartures(flight);
        boolean result=filterObject.filter();
        Assertions.assertTrue(result);
    }
    @Test
    public void filterTimeOnGroundBetweenDeparturesOneFalseTest(){
        List<Segment> flight=List.of(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().plusHours(4).minusSeconds(1),LocalDateTime.now().plusHours(8)));
        FilterTimeOnGroundBetweenDepartures filterObject=new FilterTimeOnGroundBetweenDepartures(flight);
        boolean result=filterObject.filter();
        Assertions.assertFalse(result);
    }
    @Test
    public void filterTimeOnGroundBetweenDeparturesSecondFalseTest(){
        List<Segment> flight=List.of(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(2)));
        FilterTimeOnGroundBetweenDepartures filterObject=new FilterTimeOnGroundBetweenDepartures(flight);
        boolean result=filterObject.filter();
        Assertions.assertFalse(result);
    }
    @Test
    public void filterTimeOnGroundBetweenDeparturesThreeFalseTest(){
        List<Segment> flight=List.of(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(2),LocalDateTime.now().plusHours(3)),
                new Segment(LocalDateTime.now().minusHours(4),LocalDateTime.now().plusHours(5)));
        FilterTimeOnGroundBetweenDepartures filterObject=new FilterTimeOnGroundBetweenDepartures(flight);
        boolean result=filterObject.filter();
        Assertions.assertFalse(result);
    }
}

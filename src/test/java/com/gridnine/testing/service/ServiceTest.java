package com.gridnine.testing.service;

import com.gridnine.testing.filters.FilterDepartureUpToCurrentTime;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
   @Mock
Service listFilter;
    @Test
    public void filterOneElementFalseTest(){
        List<Segment>flight=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().minusSeconds(1),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject=new FilterDepartureUpToCurrentTime(flight);
        List<Segment>flight1=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject1=new FilterDepartureUpToCurrentTime(flight1);
        listFilter= new Service(List.of(filterObject,filterObject1));
             int ii=listFilter.filter().size();
               Assertions.assertEquals(ii,1);
    }
    @Test
    public void filterAllElementFalseTest(){
        List<Segment>flight=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject=new FilterDepartureUpToCurrentTime(flight);
        List<Segment>flight1=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject1=new FilterDepartureUpToCurrentTime(flight1);
        listFilter= new Service(List.of(filterObject,filterObject1));
        int ii=listFilter.filter().size();
        Assertions.assertEquals(ii,2);
    }
    @Test
    public void filterAllElementTrueTest(){
        List<Segment>flight=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().minusSeconds(1),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject=new FilterDepartureUpToCurrentTime(flight);
        List<Segment>flight1=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().minusSeconds(1),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject1=new FilterDepartureUpToCurrentTime(flight1);
        listFilter= new Service(List.of(filterObject,filterObject1));
        int ii=listFilter.filter().size();
        Assertions.assertEquals(ii,0);
    }
}

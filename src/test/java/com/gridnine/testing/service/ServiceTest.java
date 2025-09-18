package com.gridnine.testing.service;

import com.gridnine.testing.filters.FilterArrivalDateBeforeDeparture;
import com.gridnine.testing.filters.FilterDepartureUpToCurrentTime;
import com.gridnine.testing.filters.FilterTimeOnGroundBetweenDepartures;
import com.gridnine.testing.interfaces.Filters;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    FilterDepartureUpToCurrentTime filterDepartureUpToCurrentTime;
@Mock
Service listFilter;
    @Test
    public void filterFalseTest(){
        List<Segment>flight=List.of(new Segment(LocalDateTime.now().plusSeconds(1),LocalDateTime.now().plusHours(2)),
                new Segment(LocalDateTime.now().minusSeconds(0),LocalDateTime.now().plusHours(2)));
        FilterDepartureUpToCurrentTime filterObject=new FilterDepartureUpToCurrentTime(flight);

        //listFilter= (Service) List.of(filterObject);
       // Mockito.when(filterObject.filter()).thenReturn(false);
       // listFilter= (Service) List.of((filterObject));
       // Mockito.when((filterObject.filter())).thenReturn(false);
       listFilter= new Service(List.of(filterObject));
       int ii=listFilter.filter().size();
        System.out.println(ii);
        Assertions.assertEquals(ii,1);
    }
}

package com.gridnine.testing.service;

import com.gridnine.testing.interfaces.Filters;
import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class Service {
   private final   List<Filters>filters;

    public Service(List<Filters> filters) {
      this.filters = filters;
    }

    public List<Filters> getFilters() {
        return filters;
    }

    public List<Flight> filter(){
        List<Flight>result=new ArrayList<>();
       for (Filters variable:filters){
            if(!variable.filter()){
                result.add((Flight) variable);
            }
        }
        return result;
    }
}

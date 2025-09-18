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
        for(int i=0;i<this.filters.size();i++){
        //for (Filters variable:filters){
            if(!filters.get(i).filter()){
                result.add((Flight) filters.get(i));
            }
        }
        return result;
    }
}

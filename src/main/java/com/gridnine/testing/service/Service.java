package com.gridnine.testing.service;

import com.gridnine.testing.interfaces.Filters;
import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class Service {
   private final List<Filters>filters;

    public Service(List<Filters> filters) {
      this.filters = filters;
    }

       public List<Filters> filter(){
        List<Filters>result=new ArrayList<>();
        for (Filters variable:filters){
            if(!variable.filter()){
                result.add(variable);
            }
        }
        return result;
    }
}

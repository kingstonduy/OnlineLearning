/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DKD.learningspringframework.helloworld;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
interface DataService{
    int[] retrieveData();
}

@Component
@Primary
class MySQLDataService implements DataService
{
    public int[] retrieveData(){
        return new int[] {11,22,33,44,55};
    }
}


@Component
class MongoDbDataService implements DataService
{
    public int[] retrieveData(){
        return new int[] {1,2,3,4,5};
    }
}

@Component
public class BusinessCalculationService {
    DataService dataService;
    public BusinessCalculationService(DataService dataService)
    {
        super();
        this.dataService= dataService;
    }
    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

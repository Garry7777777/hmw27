package org.skypro;

import org.springframework.stereotype.Component;

@Component
public class Moto implements Transport{

    public void go(){
        System.out.println("Мото едет \n");
    }

}

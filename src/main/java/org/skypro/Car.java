package org.skypro;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class Car implements Transport{


    public Car() {
        System.out.println("Создан бин для Car");
    }

    public void go(){
        System.out.println("Автомобиль едет \n");
    }
    @PostConstruct
    public void init(){
        System.out.println("Car.init \n");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Car.destroy \n");
    }

}

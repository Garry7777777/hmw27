package org.skypro;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Moto implements Transport{
    public Moto() {System.out.println("Создан бин для Moto"); }

    public void go(){
        System.out.println("Мото едет \n");
    }
    @PostConstruct
    public void init(){
        System.out.println("Moto.init \n");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Moto.destroy \n");
    }

}

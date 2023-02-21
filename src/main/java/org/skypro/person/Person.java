package org.skypro.person;

import org.skypro.transport.Transport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

//    @Autowired
//    @Qualifier("moto")
    private Transport transport;

    public Person(@Qualifier("moto") Transport transport) { this.transport = transport; }

//    @Autowired
//    @Qualifier("moto")
//    public void setTransport(Transport transport) { this.transport = transport; }

    public void sitInTransport(){
        System.out.println("Владелец сел в транспорт");
        transport.go();
    }

}

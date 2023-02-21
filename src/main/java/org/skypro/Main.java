package org.skypro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Продолжаем работать с приложением, которое начали писать на прошлом уроке.
// 1. Создайте интерфейс Transport и объявите в нем метод go.
// 2. Создайте класс Moto.
// 3. Имплементируйте интерфейс Transport в классах Car и Moto. Метод go должен быть реализован в обоих классах.
//      Измените поле Car в классе Person на тип Transport.
// 4. Измените тип конфигурации приложения на способ XML + аннотации. В XML-файле должен быть только
//      тег context:component-scan, а класс Moto должен быть помечен аннотацией Component.
//      В методе main получите бин Moto и вызовите у него метод go.
// 5. Внедрите в класс Person бин типа Transport любым из доступных способов. В методе main получите бин Person
//      и вызовите у него метод, определенный в классе.
// 6. Добавьте в класс Car аннотацию Component и затем решите проблему двойственной инъекции в классе Person.
//       В методе main получите бин Person и вызовите у него метод, определенный в классе.
// 7. Установите бину класса Car scope singleton, а бину класса Moto — scope prototype, а также  определите
//      в каждом из этих классов init- и destroy-методы. В разных методах main создайте по два бина и сравните их.
// 8. Настройте конфигурацию без XML-файла одним из доступных способов. В методе main получите бин Person
//       и вызовите у него метод, определенный в классе.

public class Main
{
    public static void main( String[] args )
    {
        // задачи 1,2,3,4
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Transport  moto = context.getBean("moto", Moto.class);
        moto.go();

        // задача 5
        Person  person  = context.getBean("person", Person.class);
        person.sitInTransport();


        // задача 6
        Transport  car = context.getBean("car", Car.class);
        car.go();

        Person  person2  = context.getBean("person", Person.class);
        person2.sitInTransport();  // moto, not car

        // задача 7
        var  car2 = context.getBean("car", Car.class);
        var  car3 = context.getBean("car", Car.class);
        System.out.println(car2==car3);
        System.out.println(car2 + " == "+ car3);

        var moto2 = context.getBean("moto", Moto.class);
        var moto3 = context.getBean("moto", Moto.class);
        System.out.println(moto2==moto3);
        System.out.println(moto2 + " != "+ moto3);

        // задача 8
        AnnotationConfigApplicationContext contextConfig =
                new AnnotationConfigApplicationContext(Config.class);

//        var person3 = contextConfig.getBean("newPerson", Person.class);
        var person3 = contextConfig.getBean("person", Person.class);
        person3.sitInTransport();

        context.close(); System.out.println("-------------------------------------------");

    }
}

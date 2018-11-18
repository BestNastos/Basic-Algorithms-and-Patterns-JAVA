package ForGit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*          abstract Logistics
             createTransport()
                |        |
               Sea      Road
   createTransport()  createTransport()
     new Ship()         new Truck()


     interface Transportation
            deliver()
          |           |
         Car         Ship
        deliver()  deliver()
        "by road"  "by sea"


        “о, что нужно добавить, чтобы из фабричного метода
        сделать абстрактную фабрику, закомменчено
 */

public class FactoryMethod1 {
    public static void main(String[] args) throws IOException {

        Logistics logistics;

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Is weather fine?");
        String weather = r.readLine();

        if (weather.equals("yes")) logistics = new Sea();
        else logistics = new Road();

        Transportation transportation = logistics.createTransportation();
        transportation.deliver();
//        Schedule schedule = logistics.createSchedule();
//        schedule.showSchedule();
    }
}

abstract class Logistics{
    abstract Transportation createTransportation();
    //abstract Schedule createSchedule();
}

class Road extends Logistics {
    @Override
    Transportation createTransportation() {
        return new Truck();
    }

//    @Override
//    Schedule createSchedule() {
//        return new RoadSchedule();
//    }
}

class Sea extends Logistics {
    @Override
    Transportation createTransportation() {
        return new Ship();
    }

//    @Override
//    Schedule createSchedule() {
//        return new SeaSchedule();
//    }
}


interface Transportation{
   void deliver();
}

class Truck implements Transportation {
    @Override
    public void deliver() {
        System.out.println("delivering by road");
    }
}

class Ship implements Transportation {
    @Override
    public void deliver() {
        System.out.println("delivering by sea");
    }
}
//
//interface Schedule {
//    void showSchedule ();
//}
//
//class SeaSchedule implements Schedule{
//
//    @Override
//    public void showSchedule() {
//        System.out.println("Sea delivery schedule: Monday at 12.00");
//    }
//}
//
//class RoadSchedule implements Schedule{
//    @Override
//    public void showSchedule() {
//        System.out.println("Road delivery schedule: Tuesday at 10.00");
//    }
//}

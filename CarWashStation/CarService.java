package com.CarWashStation;

import com.CarWashStation.washStation.WashStation;

import java.util.*;

public class CarService {

    public void usageWashCar() {

        List<Car> cars = createCars();

        List<Car> carsQueue1 = createCarQueue(cars);

        //create second car queue, that contains all other car from list cars,
        //that are not in car queue 1
        List<Car> carsQueue2 = cars;
        carsQueue2.removeAll(carsQueue1);

        //creating two wash station that serviced two queues of cars
        WashStation washStation1 = new WashStation(carsQueue1, "1");
        washStation1.start();
        WashStation washStation2 = new WashStation(carsQueue2, "2");
        washStation2.start();
    }


    //creating random cars queue, but number of cars in this queue
    //should be not less then 4
    private List<Car> createCarQueue(List<Car> cars) {
        Set<Car> carsQueue = new HashSet<>();

        for (int i = 0; i < (new Random().nextInt(cars.size()) + 4); i++) {
            carsQueue.add(cars.get(new Random().nextInt(cars.size())));
        }

        return new LinkedList<>(carsQueue);
    }

    private List<Car> createCars() {
        List<Car> cars = new LinkedList<>();

        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");
        Car car4 = new Car("Car4");
        Car car5 = new Car("Car5");
        Car car6 = new Car("Car6");
        Car car7 = new Car("Car7");
        Car car8 = new Car("Car8");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        cars.add(car7);
        cars.add(car8);
        return cars;
    }
}

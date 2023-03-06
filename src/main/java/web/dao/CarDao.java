package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDao {
    private static int CAR_COUNT;
    private static final List<Car> carList;

    static {
        carList = new ArrayList<>();
        carList.add(new Car(++CAR_COUNT, "BMW", "3"));
        carList.add(new Car(++CAR_COUNT, "MERCEDES", "C"));
        carList.add(new Car(++CAR_COUNT, "JAGUAR", "E-TYPE"));
        carList.add(new Car(++CAR_COUNT, "AUDI", "A4"));
        carList.add(new Car(++CAR_COUNT, "LEXUS", "IS"));
    }

    public List<Car> index(Integer count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}

package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao {

    List<Car> listCars();

    void addCar(Car car);
}

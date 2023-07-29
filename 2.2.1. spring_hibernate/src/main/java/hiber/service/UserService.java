package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<Car> listCars();

    public void addCar(Car car);
    public User getUserByCarModelAndSeries(String model, int series);
}

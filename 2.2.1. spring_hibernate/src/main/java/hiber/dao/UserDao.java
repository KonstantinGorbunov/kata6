package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   List<Car> listCars();

   void addCar(Car car);

   User getUserByCarModelAndSeries(String model, int series);
}

package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      CarService carService = context.getBean(CarService.class);

      carService.addCar(new Car("bb1", 1));
      carService.addCar(new Car("bb2", 2));
      carService.addCar(new Car("bb3", 3));
      carService.addCar(new Car("bb4", 4));

      List<Car> listOfCars = carService.listCars();

      UserService userService = context.getBean(UserService.class);
      for(int i = 0; i < 4; i ++) {
         String i1 = Integer.toString(i + 1);
         userService.add(new User("User" + i1, "Lastname" + i1,  "user" + i1 + "@mail.ru", listOfCars.get(i)));

      }
      userService.listUsers().stream().forEach(System.out :: println);

      System.out.println(userService.getUserByCarModelAndSeries("bb3", 3));
      context.close();
   }
}

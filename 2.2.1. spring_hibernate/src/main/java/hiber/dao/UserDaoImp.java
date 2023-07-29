package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      Session session = sessionFactory.getCurrentSession();
      session.save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      Query<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<Car> listCars() {
      Query<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

   @Override
   public void addCar(Car car) {
      Session session = sessionFactory.getCurrentSession();
      session.save(car);

   }

   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      Session session = sessionFactory.getCurrentSession();
      Query query = session.createQuery("FROM User t WHERE t.car.model = :model and t.car.series = :series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      List<User> users = query.list();
      return users.get(0);

   }

}

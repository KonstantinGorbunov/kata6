package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private CarDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return dao.listCars();
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        dao.addCar(car);
    }

    public CarDao getDao() {
        return dao;
    }

    @Autowired
    public void setDao(CarDao dao) {
        this.dao = dao;
    }
}

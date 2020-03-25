package iwona.pl.modol4vaadin.service;


import iwona.pl.modol4vaadin.model.Car;
import iwona.pl.modol4vaadin.model.Color;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.annotation.HttpConstraint;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars;

    public CarServiceImpl() {
        this.cars = new ArrayList<>();
        cars.add(new Car(1L, "Ferrari", "599 GTB Fiorano", Color.RED));
        cars.add(new Car(2L, "Audi", "A6", Color.NAVY_BLUE));
        cars.add(new Car(3L, "Aston Martin", "DB5", Color.RED));
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override  //get
    public Optional<Car> carById(Long carId) {
        Optional<Car> findCarById = cars.stream()
                .filter(car -> car.getCarId() == carId).findFirst();
//        findCarById.orElseThrow(() -> new CarNotExist(carId));
        return findCarById;
    }

    @Override //get by color
    public List<Car> carByColor(String color) {
        return getAll().stream().filter(car1 -> color.equalsIgnoreCase(car1.getColor().name()))
                .collect(Collectors.toList());
    }

    @Override //post
    public boolean save(Car car) {
        return cars.add(car);
    }

      @Override //put
    public boolean changeCar(Car changedCar) {
        Optional<Car> findCar = cars.stream().filter(car -> car.getCarId() == changedCar.getCarId()).findFirst();
        if (findCar.isPresent()) {
            Car car = findCar.get();
            car.setBrand(changedCar.getBrand());
            car.setModel(changedCar.getModel());
            car.setColor(changedCar.getColor());
            cars.add(changedCar);
        }
        return false;
    }

    @Override //    patch
    public boolean changeColor(Long carId, Color color) {
        Optional<Car> first = cars.stream().filter(car -> car.getCarId() == carId).findFirst();
        if (first.isPresent()) {
            Car carColor = first.get();
            carColor.setColor(color);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeBrand(Long id, String newBrand) {
        Optional<Car> findBrand = cars.stream().filter(car -> car.getCarId() == id).findFirst();
        if (findBrand.isPresent()) {
            Car carBrand = findBrand.get();
            carBrand.setBrand(newBrand);
            return true;
        }
        return false;
//        throw new CarNotExist(id);
    }

    @Override //delete
    public boolean removeById(Long carId) {
        Car first = cars.stream().filter(car -> car.getCarId() == carId).findFirst().get();
        if (cars.remove(first)) {
            return true;
        }
//        throw new CarNotExist(carId);
        return false;
    }

    public long findMaxId() {
        Car car = Collections.max(cars, Comparator.comparing(Car::getCarId));
        return car.getCarId()+1;
    }

}

package iwona.pl.modol4vaadin.model;

import java.util.Objects;

public class Car {

    private Long carId;
    private String brand;
    private String model;
    private Color color;

//    public Car() {
//    }
//

    public Car(Long carId, String brand, String model) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
    }

    public Car(Long carId, String brand, String model, Color color) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Car car = (Car) obj;
            return Objects.equals(carId, car.carId);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
//                ", color=" + color +
                '}';
    }

}

package cars;

import java.util.ArrayList;

public class ShowRoom {
    private ArrayList<Car> cars = new ArrayList<Car>();

    public String addCar(Car car){
        this.cars.add(car);
        return car.name + " Added successfully";
    }

    public ArrayList<Car> getAllCars(){
        return cars;
    }

    public Car getSingleCar(int carId){
        return this.cars.get(carId);
    }

    public String removeCar(int carId){
        try {
            cars.remove(carId);
        }
        catch (Exception ex){
            return "Unable to remove specified car\n";
        }
        return "car removed successfully\n";
    }

    public String updateCar(int carIndex, Car newCar){
        if(this.cars.get(carIndex) != null){
            Car oldCar = this.cars.get(carIndex);
            oldCar.name = newCar.name;
            oldCar.manufacturer = newCar.manufacturer;
            oldCar.type = newCar.type;
            return "car updated successfully";
        }
        return "car not found";
    }
}


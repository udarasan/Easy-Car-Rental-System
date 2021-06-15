package lk.ijse.easycarrentalsystem.service;

import lk.ijse.easycarrentalsystem.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {

    void addCar(CarDTO dto);

    boolean regNoAlreadyExists(String id);

    void deleteCar(String id);

    CarDTO searchCar(String id);

    ArrayList<CarDTO> getAllUsers();

    void updateCar(CarDTO dto);
}

package lk.ijse.easycarrentalsystem.service;

import lk.ijse.easycarrentalsystem.dto.DriverDTO;
import lk.ijse.easycarrentalsystem.entity.Driver;

import java.util.ArrayList;
import java.util.List;

public interface DriverService {
    ArrayList<String> getAvailableDrivers();

    ArrayList<DriverDTO> getAllAvailableDriversDetails();

    int getAvailableDriverCount();
    int getOccupiedDriverCount();
}
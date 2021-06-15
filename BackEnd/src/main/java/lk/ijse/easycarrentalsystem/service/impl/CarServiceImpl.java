package lk.ijse.easycarrentalsystem.service.impl;

import lk.ijse.easycarrentalsystem.dto.CarDTO;
import lk.ijse.easycarrentalsystem.entity.Car;
import lk.ijse.easycarrentalsystem.exception.ValidateException;
import lk.ijse.easycarrentalsystem.repo.CarRepo;
import lk.ijse.easycarrentalsystem.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCar(CarDTO dto) {
        if (carRepo.existsById(dto.getRegistrationNo())) {
            throw new ValidateException("Customer Already Exist");
        }
        carRepo.save(mapper.map(dto, Car.class));
    }

    @Override
    public boolean regNoAlreadyExists(String id) {
        return false;
    }

    @Override
    public void deleteCar(String id) {

    }

    @Override
    public CarDTO searchCar(String id) {
        return null;
    }

    @Override
    public ArrayList<CarDTO> getAllUsers() {
        return null;
    }

    @Override
    public void updateCar(CarDTO dto) {

    }
}
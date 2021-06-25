package lk.ijse.easycarrentalsystem.service.impl;

import lk.ijse.easycarrentalsystem.dto.DriverDTO;
import lk.ijse.easycarrentalsystem.entity.Driver;
import lk.ijse.easycarrentalsystem.entity.User;
import lk.ijse.easycarrentalsystem.repo.DriverRepo;
import lk.ijse.easycarrentalsystem.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public ArrayList<String> getAvailableDrivers() {
    List<String> getAvailableDrivers=driverRepo.getAvailableDrivers();
    return mapper.map(getAvailableDrivers,new TypeToken<ArrayList<String>>(){}.getType());

    }

    @Override
    public ArrayList<DriverDTO> getAllAvailableDriversDetails() {
        List<Driver>allDrivers=driverRepo.getAllAvailableDriversDetails();
        return mapper.map(allDrivers,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }

    @Override
    public int getAvailableDriverCount() {
        return driverRepo.getAvailableDriverCount();
    }

    @Override
    public int getOccupiedDriverCount() {
        return driverRepo.getOccupiedDriverCount();
    }

    @Override
    public void saveDriver(DriverDTO dto) {
        driverRepo.save(mapper.map(dto, Driver.class));
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        List<Driver>allDrivers=driverRepo.findAll();
        return mapper.map(allDrivers,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }


}

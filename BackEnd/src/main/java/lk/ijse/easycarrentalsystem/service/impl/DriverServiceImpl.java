package lk.ijse.easycarrentalsystem.service.impl;

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
}

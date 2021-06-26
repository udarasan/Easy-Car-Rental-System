package lk.ijse.easycarrentalsystem.service.impl;

import lk.ijse.easycarrentalsystem.dto.DashboardDTO;
import lk.ijse.easycarrentalsystem.repo.*;
import lk.ijse.easycarrentalsystem.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DashboardServiceImpl implements DashBoardService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    RentalRequestRepo rentalRequestRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public DashboardDTO getDashboardDetails() {
        DashboardDTO dto = new DashboardDTO(
                userRepo.getRegisteredUsers(),
                rentalRequestRepo.getTotalBookings(),
                rentalRequestRepo.getActiveBookings(),
                carRepo.getAvailableCarCount(),
                carRepo.getReservedCarCount(),
                carRepo.getDamagedCarCount(),
                carRepo.getUnderMaintenanceCarCount(),
                driverRepo.getAvailableDriverCount(),
                driverRepo.getOccupiedDriverCount()
        );

        return dto;
    }
}

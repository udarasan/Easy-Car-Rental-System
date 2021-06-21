package lk.ijse.easycarrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DashboardDTO {
    int registeredUsers;
    int totalBookings;
    int activeBookings;
    int availableCars;
    int reservedCars;
    int carsNeedMaintenance;
    int carsUnderMaintenance;
    int availableDrivers;
    int occupiedDrivers;
}

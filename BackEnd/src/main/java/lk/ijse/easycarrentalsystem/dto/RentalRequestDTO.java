package lk.ijse.easycarrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalRequestDTO {

    private String requestId;
    private String nic;
    private String registerNO;
    private String did;
    private String pickupDate;
    private String pickupTime;
    private String pickupVenue;
    private String returnDate;
    private String returnTime;
    private String returnVenue;

    private String requestStatus;
    private String description;
}

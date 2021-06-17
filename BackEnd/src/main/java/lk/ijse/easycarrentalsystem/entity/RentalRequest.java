package lk.ijse.easycarrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalRequest {
    @Id
    private String requestId;
    private String nic;
    private String registrationNo;
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

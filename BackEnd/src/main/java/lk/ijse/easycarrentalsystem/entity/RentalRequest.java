package lk.ijse.easycarrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    /*@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "nic",referencedColumnName = "nic")
    private User user;

    @ManyToOne(targetEntity = Car.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "registrationNo",referencedColumnName = "registrationNo")
    private Car car;

    @ManyToOne(targetEntity = Driver.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "did",referencedColumnName = "did")
    private Driver driver;*/
}

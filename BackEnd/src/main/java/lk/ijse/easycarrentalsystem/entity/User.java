package lk.ijse.easycarrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private String nic;
    private String email;
    private String password;
    private String idPhoto;
    private String address;
    private String contact;

    @OneToMany(targetEntity = RentalRequest.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "nic",referencedColumnName = "nic")
    private List <RentalRequest> rentalRequests;
}

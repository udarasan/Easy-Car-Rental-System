package lk.ijse.easycarrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String pid;
    private double wavePayment;
    private double rentalPayment;
    private String date;

    @OneToOne(targetEntity = RentalRequest.class,cascade = CascadeType.ALL)
    private RentalRequest rentalRequest;



}

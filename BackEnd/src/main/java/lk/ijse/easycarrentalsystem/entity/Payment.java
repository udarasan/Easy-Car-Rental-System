package lk.ijse.easycarrentalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

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

}

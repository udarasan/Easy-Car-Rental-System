package lk.ijse.easycarrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private String pid;
    private double wavePayment;
    private double rentalPayment;
    private String date;

}

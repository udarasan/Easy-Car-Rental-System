package lk.ijse.easycarrentalsystem.service;

import lk.ijse.easycarrentalsystem.dto.CarDTO;
import lk.ijse.easycarrentalsystem.dto.PaymentDTO;
import lk.ijse.easycarrentalsystem.dto.UserDTO;

import java.util.ArrayList;

public interface PaymentService {

    void addPayment(PaymentDTO dto);
    void setCarIsAvailableYESandChangeMeterValue(String requestId,String kmValue);
}

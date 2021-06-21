package lk.ijse.easycarrentalsystem.service;

import lk.ijse.easycarrentalsystem.dto.PaymentDTO;

public interface PaymentService {

    void addPayment(PaymentDTO dto);

    void setCarIsAvailableYESandChangeMeterValue(String requestId,String kmValue);
}

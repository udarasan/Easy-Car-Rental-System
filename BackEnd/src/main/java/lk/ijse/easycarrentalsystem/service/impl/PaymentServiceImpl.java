package lk.ijse.easycarrentalsystem.service.impl;

import lk.ijse.easycarrentalsystem.dto.PaymentDTO;
import lk.ijse.easycarrentalsystem.entity.Payment;
import lk.ijse.easycarrentalsystem.repo.PaymentRepo;
import lk.ijse.easycarrentalsystem.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper mapper;



    @Override
    public void addPayment(PaymentDTO dto) {

        paymentRepo.save(mapper.map(dto,Payment.class));
    }

    @Override
    public void setCarIsAvailableYESandChangeMeterValue(String requestId, String kmValue) {
        paymentRepo.setCarIsAvailableYESandChangeMeterValue(requestId,kmValue);
    }
}


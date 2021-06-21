package lk.ijse.easycarrentalsystem.controller;

import lk.ijse.easycarrentalsystem.dto.PaymentDTO;
import lk.ijse.easycarrentalsystem.service.PaymentService;
import lk.ijse.easycarrentalsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/addPayment",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPayment(@RequestBody PaymentDTO dto){
        paymentService.addPayment(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }
    @PutMapping(path = "/updateOtherTable/{requestId}/{kmValue}")
    public ResponseEntity setCarIsAvailableYESandChangeMeterValue(@PathVariable String requestId, @PathVariable String kmValue){
        paymentService.setCarIsAvailableYESandChangeMeterValue(requestId, kmValue);
        return new ResponseEntity(new StandardResponse("201", "Done", "DONE"), HttpStatus.ACCEPTED);
    }
}

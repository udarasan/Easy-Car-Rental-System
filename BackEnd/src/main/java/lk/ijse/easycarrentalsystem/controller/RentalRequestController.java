package lk.ijse.easycarrentalsystem.controller;

import lk.ijse.easycarrentalsystem.dto.RentalRequestDTO;
import lk.ijse.easycarrentalsystem.dto.UserDTO;
import lk.ijse.easycarrentalsystem.exception.NotFoundException;
import lk.ijse.easycarrentalsystem.repo.RentalRequestRepo;
import lk.ijse.easycarrentalsystem.service.RentalRequestService;
import lk.ijse.easycarrentalsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/rentalRequest")
public class RentalRequestController {

    @Autowired
    private RentalRequestService service;

    @PostMapping(path = "/sendRequest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody RentalRequestDTO dto) {
        if (dto.getRequestId().trim().length() <= 0) {
            throw new NotFoundException("User NIC cannot be empty");
        }
        System.out.println(dto.getDid());
        service.addRentalRequest(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }
}

package lk.ijse.easycarrentalsystem.controller;

import lk.ijse.easycarrentalsystem.dto.RentalRequestDTO;
import lk.ijse.easycarrentalsystem.dto.UserDTO;
import lk.ijse.easycarrentalsystem.exception.NotFoundException;
import lk.ijse.easycarrentalsystem.repo.RentalRequestRepo;
import lk.ijse.easycarrentalsystem.service.RentalRequestService;
import lk.ijse.easycarrentalsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping(path = "/getRentalRequestByNIC/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRentalRequestByNIC(@PathVariable String id) {
        ArrayList<RentalRequestDTO> allRentalRequest = service.getRentalRequestByNIC(id);
        return new ResponseEntity(new StandardResponse("200", "Done", allRentalRequest), HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers() {
        ArrayList<RentalRequestDTO> allUsers = service.getAllRentalRequest();
        return new ResponseEntity(new StandardResponse("200", "Done", allUsers), HttpStatus.OK);
    }

    @PutMapping(path = "acceptRentalRequest/{requestStatus}/{requestId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity acceptRentalRequest(@PathVariable String requestStatus,@PathVariable String requestId) {
        service.acceptRentalRequest(requestStatus,requestId);
        return new ResponseEntity(new StandardResponse("200", "Done", "done"), HttpStatus.OK);
    }
    @PutMapping(path = "changeDriver/{did}/{requestId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeDriver(@PathVariable String did,@PathVariable String requestId) {
        service.changeDriver(did,requestId);
        return new ResponseEntity(new StandardResponse("200", "Done", "done"), HttpStatus.OK);
    }

}

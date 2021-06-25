package lk.ijse.easycarrentalsystem.controller;

import lk.ijse.easycarrentalsystem.dto.DriverDTO;
import lk.ijse.easycarrentalsystem.dto.UserDTO;
import lk.ijse.easycarrentalsystem.exception.NotFoundException;
import lk.ijse.easycarrentalsystem.service.DriverService;
import lk.ijse.easycarrentalsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/drivers")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAvailableDrivers() {
        ArrayList<String> allDriverIDs = driverService.getAvailableDrivers();
        return new ResponseEntity(new StandardResponse("200", "Done", allDriverIDs), HttpStatus.OK);
    }
    @GetMapping(path = ("/allAvailableDriversDetails"),produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAvailableDrivers() {
        ArrayList<DriverDTO> allAvailableDriversDetails = driverService.getAllAvailableDriversDetails();
        return new ResponseEntity(new StandardResponse("200", "Done", allAvailableDriversDetails), HttpStatus.OK);
    }

    @PostMapping(path = "/addDriver", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveDriver(@RequestBody DriverDTO dto) {
        driverService.saveDriver(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }
    @GetMapping(path = ("/allDrivers"),produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDrivers() {
        ArrayList<DriverDTO> allAvailableDriversDetails = driverService.getAllDrivers();
        return new ResponseEntity(new StandardResponse("200", "Done", allAvailableDriversDetails), HttpStatus.OK);
    }

}

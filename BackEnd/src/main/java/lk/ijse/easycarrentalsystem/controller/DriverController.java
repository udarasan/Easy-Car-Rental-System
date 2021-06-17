package lk.ijse.easycarrentalsystem.controller;

import lk.ijse.easycarrentalsystem.service.DriverService;
import lk.ijse.easycarrentalsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

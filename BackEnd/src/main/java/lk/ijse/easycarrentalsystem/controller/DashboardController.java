package lk.ijse.easycarrentalsystem.controller;

import lk.ijse.easycarrentalsystem.dto.DashboardDTO;
import lk.ijse.easycarrentalsystem.service.DashBoardService;
import lk.ijse.easycarrentalsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Dashboard")
@CrossOrigin
public class DashboardController {
    @Autowired
    DashBoardService dashboardService;

    @GetMapping(path = "/dashboardDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDashboardDetails() {
        DashboardDTO dashboardDetails = dashboardService.getDashboardDetails();
        return new ResponseEntity(new StandardResponse("200", "Done", dashboardDetails), HttpStatus.OK);
    }

}

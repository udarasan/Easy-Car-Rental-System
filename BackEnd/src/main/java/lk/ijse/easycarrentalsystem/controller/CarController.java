package lk.ijse.easycarrentalsystem.controller;

import lk.ijse.easycarrentalsystem.dto.CarDTO;
import lk.ijse.easycarrentalsystem.dto.UserDTO;
import lk.ijse.easycarrentalsystem.exception.NotFoundException;
import lk.ijse.easycarrentalsystem.service.CarService;
import lk.ijse.easycarrentalsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "api/v1/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/registerCar")
    public ResponseEntity addCar(@RequestBody CarDTO dto){
        if (dto.getRegistrationNo().trim().length() <= 0) {
            throw new NotFoundException("Car Reg No cannot be empty");
        }
        carService.addCar(dto);
        return new ResponseEntity(new StandardResponse("200","Done",dto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/uploadCarImage")
    public ResponseEntity uploadCarImage(@RequestPart("file") MultipartFile multipartFile, @RequestParam String registrationNo) {
        if (carService.regNoAlreadyExists(registrationNo)) {
            throw new RuntimeException("Duplicate NIC Entry!");
        }
        System.out.println(multipartFile.getOriginalFilename());
        try {
            // Let's get the project location
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            // Let's create a folder there for uploading purposes, if not exists
            File uploadsDir = new File(projectPath + "/uploads/CarImages");
            uploadsDir.mkdir();
            // It is time to transfer the file into the newly created dir
            multipartFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + multipartFile.getOriginalFilename()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filePath = "D:/java/Easy-Car-Rental-System/BackEnd/target/BackEnd-1.0.0/uploads/CarImages/" + multipartFile.getOriginalFilename();


        StandardResponse standardResponse = new StandardResponse("200", "Success!", filePath);
        return new ResponseEntity(standardResponse, HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCars() {
        ArrayList<CarDTO> allCars = carService.getAllCars();
        return new ResponseEntity(new StandardResponse("200", "Done", allCars), HttpStatus.OK);
    }
    @GetMapping(path = ("/getAvailableCars"),produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAvailableCars() {
        ArrayList<CarDTO> allAvailableCars = carService.getAvailableCars();
        return new ResponseEntity(new StandardResponse("200", "Done", allAvailableCars), HttpStatus.OK);
    }
}

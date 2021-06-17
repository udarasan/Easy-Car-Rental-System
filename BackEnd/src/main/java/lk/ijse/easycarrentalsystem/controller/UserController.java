package lk.ijse.easycarrentalsystem.controller;

import lk.ijse.easycarrentalsystem.dto.UserDTO;
import lk.ijse.easycarrentalsystem.exception.NotFoundException;
import lk.ijse.easycarrentalsystem.service.UserService;
import lk.ijse.easycarrentalsystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        if (dto.getNic().trim().length() <= 0) {
            throw new NotFoundException("User NIC cannot be empty");
        }
        service.addUser(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/uploadIdImage")
    public ResponseEntity uploadIdImage(@RequestPart("file") MultipartFile multipartFile, @RequestParam String nic) {
        /*if (service.nicAlreadyExists(nic)) {
            throw new RuntimeException("Duplicate NIC Entry!");
        }*/
        System.out.println(multipartFile.getOriginalFilename());
        try {
            // Let's get the project location
            //String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            // Let's create a folder there for uploading purposes, if not exists
            File uploadsDir = new File("D:/java/Easy-Car-Rental-System/FrontEnd/admin/asserts/img");
            uploadsDir.mkdir();
            // It is time to transfer the file into the newly created dir
            multipartFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + multipartFile.getOriginalFilename()));
        }/* catch (URISyntaxException e) {
            e.printStackTrace();
        }*/ catch (IOException e) {
            e.printStackTrace();
        }
        String filePath = multipartFile.getOriginalFilename();


        StandardResponse standardResponse = new StandardResponse("200", "Success!", filePath);
        return new ResponseEntity(standardResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers() {
        ArrayList<UserDTO> allUsers = service.getAllUsers();
        return new ResponseEntity(new StandardResponse("200", "Done", allUsers), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchUser(@PathVariable String id) {
        UserDTO userDTO = service.searchUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", userDTO), HttpStatus.OK);
    }


    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@RequestParam String id) {
        service.deleteUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(path = ("/updateUser"),consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUser(@RequestBody UserDTO dto) {
        if (dto.getNic().trim().length() <= 0) {
            throw new NotFoundException("No NIC provided to update");
        }
        service.updateUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }
}

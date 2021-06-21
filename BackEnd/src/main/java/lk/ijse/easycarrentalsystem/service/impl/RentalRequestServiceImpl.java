package lk.ijse.easycarrentalsystem.service.impl;

import lk.ijse.easycarrentalsystem.dto.RentalRequestDTO;
import lk.ijse.easycarrentalsystem.dto.UserDTO;
import lk.ijse.easycarrentalsystem.entity.RentalRequest;
import lk.ijse.easycarrentalsystem.entity.User;
import lk.ijse.easycarrentalsystem.exception.ValidateException;
import lk.ijse.easycarrentalsystem.repo.RentalRequestRepo;
import lk.ijse.easycarrentalsystem.repo.UserRepo;
import lk.ijse.easycarrentalsystem.service.RentalRequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentalRequestServiceImpl implements RentalRequestService {

    @Autowired
    private RentalRequestRepo rentalRequestRepo ;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addRentalRequest(RentalRequestDTO dto) {
        if (rentalRequestRepo.existsById(dto.getRequestId())) {
            throw new ValidateException("Customer Already Exist");
        }
        rentalRequestRepo.save(mapper.map(dto, RentalRequest.class));
    }

    @Override
    public boolean requestIDAlreadyExists(String requestId) {
        return false;
    }

    @Override
    public void deleteRentalRequest(String requestId) {
        if (!rentalRequestRepo.existsById(requestId)) {
            throw new ValidateException("No requestId for Delete..!");
        }
        rentalRequestRepo.deleteById(requestId);
    }

    @Override
    public RentalRequestDTO searchRentalRequest(String requestId) {
        Optional<RentalRequest> rentalRequest = rentalRequestRepo.findById(requestId);
        if (rentalRequest.isPresent()) {
            return mapper.map(rentalRequest.get(), RentalRequestDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RentalRequestDTO> getAllRentalRequest() {
        List<RentalRequest> all = rentalRequestRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<RentalRequestDTO>>() {
        }.getType());
    }

    @Override
    public void updateRentalRequest(RentalRequestDTO dto) {
        /*if (rentalRequestRepo.existsById(dto.get())) {
            rentalRequestRepo.save(mapper.map(dto, RentalRequest.class));

        }*/
    }

    @Override
    public ArrayList<RentalRequestDTO> getRentalRequestByNIC(String Id) {
        List<RentalRequest> all = rentalRequestRepo.getRentalRequestByNIC(Id);
        return mapper.map(all, new TypeToken<ArrayList<RentalRequestDTO>>() {
        }.getType());
    }

    @Override
    public void acceptRentalRequest(String requestStatus, String requestId) {
        rentalRequestRepo.acceptRentalRequest(requestStatus,requestId);
    }

    @Override
    public void changeDriver(String did, String requestId) {

        rentalRequestRepo.changeDriver(did,requestId);
    }


}

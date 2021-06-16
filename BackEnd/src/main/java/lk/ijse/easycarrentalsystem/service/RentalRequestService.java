package lk.ijse.easycarrentalsystem.service;

import lk.ijse.easycarrentalsystem.dto.RentalRequestDTO;

import java.util.ArrayList;

public interface RentalRequestService {

    void addRentalRequest(RentalRequestDTO dto);

    boolean requestIDAlreadyExists(String requestId);

    void deleteRentalRequest(String requestId);

    RentalRequestDTO searchRentalRequest(String requestId);

    ArrayList<RentalRequestDTO> getAllRentalRequest();

    void updateRentalRequest(RentalRequestDTO dto);
}

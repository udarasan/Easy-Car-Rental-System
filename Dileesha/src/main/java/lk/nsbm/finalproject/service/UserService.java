package lk.nsbm.finalproject.service;


import lk.nsbm.finalproject.dto.UserDTO;
import lk.nsbm.finalproject.dto.UserResponseDTO;

import java.util.ArrayList;

public interface UserService {
    void registerUser(UserDTO dto);

    ArrayList<UserDTO> getAllUsers();

    UserResponseDTO matchesEmail(String email, String password);

    boolean nicAlreadyExists(int nic);

    void deleteUser(int id);

    UserDTO searchUser(String id);

    void updateUser(UserDTO dto);

    int getAvailableEmployeeCount();

    void updatePassword(String Email,String password);
}

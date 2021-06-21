package lk.ijse.easycarrentalsystem.service.impl;

import lk.ijse.easycarrentalsystem.dto.UserDTO;
import lk.ijse.easycarrentalsystem.entity.User;
import lk.ijse.easycarrentalsystem.exception.ValidateException;
import lk.ijse.easycarrentalsystem.repo.UserRepo;
import lk.ijse.easycarrentalsystem.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo ;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addUser(UserDTO dto) {
        if (userRepo.existsById(dto.getNic())) {
            throw new ValidateException("Customer Already Exist");
        }
        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public boolean nicAlreadyExists(String nic) {
        return userRepo.existsById(nic);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepo.existsById(id)) {
            throw new ValidateException("No Customer for Delete..!");
        }
        userRepo.deleteById(id);
    }

    @Override
    public UserDTO searchUser(String id) {
        Optional<User> customer = userRepo.findById(id);
        if (customer.isPresent()) {
            return mapper.map(customer.get(), UserDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> all = userRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (userRepo.existsById(dto.getNic())) {
            userRepo.save(mapper.map(dto, User.class));

        }
    }

    @Override
    public void userStatusUpdate(String userStatus, String nic) {
        userRepo.userStatusUpdate(userStatus,nic);
    }

    @Override
    public String searchUserForLogin(String nic) {
        return userRepo.searchUserForLogin(nic);
    }

    @Override
    public int getRegisteredUsers() {
        return userRepo.getRegisteredUsers();
    }
}

package lk.nsbm.finalproject.service.impl;

import lk.nsbm.finalproject.dto.UserDTO;
import lk.nsbm.finalproject.dto.UserResponseDTO;
import lk.nsbm.finalproject.entity.User;
import lk.nsbm.finalproject.exception.ValidateException;
import lk.nsbm.finalproject.repo.UserRepo;
import lk.nsbm.finalproject.service.UserService;
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
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void registerUser(UserDTO dto) {
        if (userRepo.existsByEmail(dto.getEmail())){
            throw new ValidateException("This User Already Have An Account!");
        }

        userRepo.save(mapper.map(dto, User.class));
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> all = userRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public UserResponseDTO matchesEmail(String email, String password) {

        User all = userRepo.getUser(email);
        if (all.getPassword().equals(password)) {
            return mapper.map(all, UserResponseDTO.class);

        } else {
            throw new ValidateException("No User For This Email..!");
        }

    }



    @Override
    public boolean nicAlreadyExists(int id) {
        return userRepo.existsById(id);
    }

    @Override
    public void deleteUser(int id) {
        if (!userRepo.existsById(id)) {
            throw new ValidateException("No Customer for Delete..!");
        }
        userRepo.deleteById(id);
    }

    @Override
    public UserDTO searchUser(String id) {
        Optional<User> user = Optional.ofNullable(userRepo.findByEmail(id));
        if (user.isPresent()) {
            return mapper.map(user.get(), UserDTO.class);
        }else {
            throw new ValidateException("No User for This Email..!");
        }
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (userRepo.existsById(dto.getUserID())) {
            userRepo.save(mapper.map(dto, User.class));
        }
        else {
            throw new ValidateException("No User for This Email..!");
        }
    }

    @Override
    public int getAvailableEmployeeCount() {
        return userRepo.getAvailableEmployeeCount();
    }

    @Override
    public void updatePassword(String email, String password) {
        if (userRepo.existsByEmail(email)){

            userRepo.updatePassword(email,password);
        }else {
            throw new ValidateException("This User Already Have An Account!");
        }



    }
}

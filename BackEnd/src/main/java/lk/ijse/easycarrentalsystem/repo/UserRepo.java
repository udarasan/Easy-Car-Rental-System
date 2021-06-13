package lk.ijse.easycarrentalsystem.repo;

import lk.ijse.easycarrentalsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}

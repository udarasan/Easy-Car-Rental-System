package lk.ijse.easycarrentalsystem.repo;

import lk.ijse.easycarrentalsystem.entity.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRequestRepo extends JpaRepository<RentalRequest,String> {
}

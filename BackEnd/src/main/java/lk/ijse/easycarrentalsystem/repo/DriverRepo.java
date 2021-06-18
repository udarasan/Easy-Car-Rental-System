package lk.ijse.easycarrentalsystem.repo;

import lk.ijse.easycarrentalsystem.dto.DriverDTO;
import lk.ijse.easycarrentalsystem.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "select did from Driver where isAvailable='YES'",nativeQuery = true)
    List<String>getAvailableDrivers();
    @Query(value = "select * from Driver where isAvailable='YES'",nativeQuery = true)
    List<Driver>getAllAvailableDriversDetails();



}

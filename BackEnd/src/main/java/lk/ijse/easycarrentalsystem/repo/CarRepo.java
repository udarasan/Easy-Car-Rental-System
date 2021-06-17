package lk.ijse.easycarrentalsystem.repo;

import lk.ijse.easycarrentalsystem.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
    @Query(value = "select * from Car where isAvailable='YES'",nativeQuery = true)
    List<Car> getAvailableCars();
}

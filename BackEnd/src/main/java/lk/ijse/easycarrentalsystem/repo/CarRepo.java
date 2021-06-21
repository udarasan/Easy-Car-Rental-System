package lk.ijse.easycarrentalsystem.repo;

import lk.ijse.easycarrentalsystem.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {
    @Query(value = "select * from Car where isAvailable='YES'",nativeQuery = true)
    List<Car> getAvailableCars();

    @Modifying
    @Query(value = "update Car set underMaintenance ='YES',isAvailable ='NO' where registrationNo=?1",nativeQuery = true)
    void addMaintain(String requestId);

    @Query(value = "select * from Car where registrationNo=?1",nativeQuery = true)
    List<Car> getASpecificCar(String registrationNo);

    /*@Modifying
    @Query(value = "update Car set underMaintenance ='YES',isAvailable ='NO' where registrationNo=?1",nativeQuery = true)
    void addMaintain(String requestId,String registerNO);*/
    //dashborad
    @Query(value = "select count(registrationNo) from Car where isAvailable='Yes'", nativeQuery = true)
    int getAvailableCarCount();

    @Query(value = "select count(registrationNo) from RentalRequest where  requestStatus='Active'", nativeQuery = true)
    int getReservedCarCount();

    @Query(value = "select count(registrationNo) from Car where isDamaged='Yes'", nativeQuery = true)
    int getDamagedCarCount();

    @Query(value = "select count(registrationNo) from Car where underMaintenance='Yes'", nativeQuery = true)
    int getUnderMaintenanceCarCount();
}

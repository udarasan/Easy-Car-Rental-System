package lk.ijse.easycarrentalsystem.repo;

import lk.ijse.easycarrentalsystem.entity.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RentalRequestRepo extends JpaRepository<RentalRequest,String> {

    @Query(value = "select * from rentalrequest where nic=?1",nativeQuery = true)
    List<RentalRequest> getRentalRequestByNIC(String nic);

    @Modifying
    @Query(value = "update RentalRequest set requestStatus =?1 where requestId =?2",nativeQuery = true)
    void acceptRentalRequest(String requestStatus,String requestId);

    @Modifying
    @Query(value = "update RentalRequest set did =?1 where requestId =?2",nativeQuery = true)
    void changeDriver(String did,String requestId);

}

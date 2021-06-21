package lk.ijse.easycarrentalsystem.repo;

import lk.ijse.easycarrentalsystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepo extends JpaRepository<Payment,String> {

    @Modifying
    @Query(value = "update RentalRequest r,Car p,Driver d set r.requestStatus='Finished', p.isAvailable='YES',p.kmMeterValue=?2,d.isAvailable='YES' Where r.requestId=?1 and p.registrationNo=r.registrationNo and d.did=r.did" ,nativeQuery = true)
    void setCarIsAvailableYESandChangeMeterValue(String requestId,String kmValue);

}

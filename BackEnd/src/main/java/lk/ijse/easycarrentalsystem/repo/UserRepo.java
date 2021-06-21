package lk.ijse.easycarrentalsystem.repo;

import lk.ijse.easycarrentalsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,String> {

    @Modifying
    @Query(value = "update User set status =?1 where nic =?2",nativeQuery = true)
    void userStatusUpdate(String userStatus,String nic);

    @Query(value = "select password from User where status='accept' and nic =?1",nativeQuery = true)
    String searchUserForLogin(String nic);

    //dashboard
    @Query(value = "select count(nic) from User where status ='accept'",nativeQuery = true)
    int getRegisteredUsers();
}

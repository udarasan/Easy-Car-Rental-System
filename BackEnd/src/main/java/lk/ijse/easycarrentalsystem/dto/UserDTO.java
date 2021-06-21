package lk.ijse.easycarrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String nic;
    private String email;
    private String password;
    private String idPhoto;
    private String address;
    private String contact;
    private String status;
}

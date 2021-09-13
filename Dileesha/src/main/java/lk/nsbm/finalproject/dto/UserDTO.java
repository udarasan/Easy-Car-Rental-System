package lk.nsbm.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private int userID;
    private String fullName;
    private String email;
    private String contact;
    private String userType;
    private String password;

}

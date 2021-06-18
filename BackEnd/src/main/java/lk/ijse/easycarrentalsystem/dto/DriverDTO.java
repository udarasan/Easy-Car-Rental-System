package lk.ijse.easycarrentalsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private String did;
    private String name;
    private String contact;
    private String isAvailable;
}

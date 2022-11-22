package com.DemoCrud.CRUDStaff.DTO;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StaffDTO {
    private String name;
    private boolean gender;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private MultipartFile photo;
    private String email;
    private String phone;
    private Float salary;
    private String note;
    private String DepartId;

}

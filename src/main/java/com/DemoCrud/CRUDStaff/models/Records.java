package com.DemoCrud.CRUDStaff.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Records")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String type;
    @Column(length = 200)
    private String reason;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId")
    private Staffs staffs;

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }
}

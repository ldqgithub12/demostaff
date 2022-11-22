package com.DemoCrud.CRUDStaff.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Departs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Departs {
    @Id
    @Column(length = 10)
    private String id;
    @Column(length = 50)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "departs")
    private Set<Staffs> staffs;

    public Set<Staffs> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staffs> staffs) {
        this.staffs = staffs;
    }

    public Departs(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

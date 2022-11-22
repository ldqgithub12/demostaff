package com.DemoCrud.CRUDStaff.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Staffs")
public class Staffs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String name;
    private boolean gender;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(length = 500)
    private String photo;

    @Column(length = 100)
    private String email;

    @Column(length = 10)
    private String phone;
    private Float salary;
    @Column(length = 500)
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departId")
    private Departs departs;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "staffs")
    private Set<Records> records;

    public Staffs() {
    }

    public Staffs( String name, boolean gender, Date birthday, String photo, String email, String phone, Float salary, String note, Departs departs) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.photo = photo;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.note = note;
        this.departs = departs;
    }
    public Staffs(int id,String name, boolean gender, Date birthday, String photo, String email, String phone, Float salary, String note, Departs departs) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.photo = photo;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.note = note;
        this.departs = departs;
    }


    public Set<Records> getRecords() {
        return records;
    }

    public void setRecords(Set<Records> records) {
        this.records = records;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Departs getDeparts() {
        return departs;
    }

    public void setDeparts(Departs departs) {
        this.departs = departs;
    }

}

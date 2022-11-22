package com.DemoCrud.CRUDStaff.controller;

import com.DemoCrud.CRUDStaff.DTO.StaffDTO;
import com.DemoCrud.CRUDStaff.models.Departs;
import com.DemoCrud.CRUDStaff.models.Staffs;
import com.DemoCrud.CRUDStaff.repository.DepartRepository;
import com.DemoCrud.CRUDStaff.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/staffs")
public class StaffController {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    DepartRepository departRepository;
    @GetMapping("/list")
    public String viewStaff(Model model){
        model.addAttribute("listStaff",staffRepository.findAll());
        return "listStaff";
    }

    @GetMapping("/addStaff")
    public String addStaff(Model model){
        model.addAttribute("staffDTO",new StaffDTO());
        return "addstaff";
    }

    @PostMapping("/addStaff")
    public String addStaff(@ModelAttribute StaffDTO staffDTO){
        Staffs staffs = null;
        String image = "Logo.png";
        Path path = Paths.get("src/main/resources/uploads/");
        if (!staffDTO.getPhoto().isEmpty()){
            try {
                InputStream inputStream = staffDTO.getPhoto().getInputStream();
                Files.copy(inputStream,path.resolve(staffDTO.getPhoto().getOriginalFilename()),
                        StandardCopyOption.REPLACE_EXISTING);
                image = staffDTO.getPhoto().getOriginalFilename().toString();

            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        staffs = new Staffs(0,staffDTO.getName(),staffDTO.isGender(),staffDTO.getBirthday(),image,staffDTO.getEmail(),
                staffDTO.getPhone(),staffDTO.getSalary(),staffDTO.getNote(),new Departs(staffDTO.getDepartId(),""));
        Optional.ofNullable(staffRepository.save(staffs)).map(t->"listStaff").orElse("addstaff");
        return "addstaff";

    }

    @ModelAttribute("departs")
    public List<Departs> getAllDepart(){
        return departRepository.findAll();
    }

}

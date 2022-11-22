package com.DemoCrud.CRUDStaff.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ImageUploadController {
    @RequestMapping(value = "getImage/{photo}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo){
        if (!photo.equals("") || photo !=null){
            try {
                final String imagePath = "src/main/resources/uploads/"; //path
                Path filename = Paths.get(imagePath+photo);
                byte[] buffer = Files.readAllBytes(filename);
                ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
                return ResponseEntity.ok()
                        .contentLength(buffer.length)
                        .contentType(MediaType.parseMediaType("image/png"))
                        .body(byteArrayResource);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return ResponseEntity.badRequest().build();
    }
}

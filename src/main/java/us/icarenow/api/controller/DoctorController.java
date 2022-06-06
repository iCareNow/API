package us.icarenow.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.icarenow.api.model.entity.Doctor;
import us.icarenow.api.service.DoctorService;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("doctors")
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("doctors/{id}")
    public Doctor getOneDoctor(@PathVariable int id){
        Optional<Doctor> optional = doctorService.findById(id);
        if (optional.isPresent()){
//            Link link = linkTo(methodOn(PatientController.class).getOnePatient(id)).withSelfRel();
            return optional.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("doctors/{id}")
    public ResponseEntity<?> delete (@PathVariable int id ){
        boolean deleted = doctorService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("Deleted succesfuly", HttpStatus.OK);

        } else  {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND );
        }

    }
    @PostMapping("doctors")
    public String addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }



}

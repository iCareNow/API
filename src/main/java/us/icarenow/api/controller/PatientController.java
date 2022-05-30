package us.icarenow.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.icarenow.api.model.entity.Patient;
import us.icarenow.api.service.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("patients")
    public List<Patient> findAll(){
        return patientService.findAll();
    }
    @GetMapping("patients/{id}")
    public Patient getOnePatient(@PathVariable int id){
        Optional<Patient> optional = patientService.findById(id);
        if (optional.isPresent()){
//            Link link = linkTo(methodOn(PatientController.class).getOnePatient(id)).withSelfRel();
            return optional.get();
        } else {
            return null;
        }
    }
    @DeleteMapping("patients/{id}")
    public ResponseEntity<?> delete (@PathVariable int id ){
        boolean deleted = patientService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("Deleted succesfuly", HttpStatus.OK);

        } else  {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND );
        }

    }
    @PostMapping("patients")
    public String addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }
}

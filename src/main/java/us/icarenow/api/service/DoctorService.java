package us.icarenow.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.icarenow.api.model.entity.Doctor;
import us.icarenow.api.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public int lastId = 5;
    private List<Doctor> doctorList = new ArrayList<Doctor>() {{
        add(new Doctor(0,"Radu Baciu"));
        add(new Doctor(1,"Andreia Libenciuc"));
        add(new Doctor(2,"Alina Sastras"));
        add(new Doctor(3,"Flo"));
        add(new Doctor(4,"Andrei Mladin"));


    }};
    public List<Doctor> findAll(){
        return doctorList;
    }

    public Optional<Doctor> findById(int id){
        return doctorList.stream().filter(doctor -> doctor.getId() == id).findFirst();

    }
    /**
     * Delete patient with this id
     */
    public boolean delete(int id){
        int index = -1;
        for (int i = 0; i < doctorList.size(); i++){
            if (doctorList.get(i).getId() == id) {
                index = i;
            }
        }
        if (index == -1){
            return false ;
        } else {
            doctorList.remove(index);
            return true;
        }

    }
    public String addDoctor(Doctor doctor){

        int id=doctorList.size();
        doctorList.add(doctor);
        return "Patient added succesfully";

    }

}

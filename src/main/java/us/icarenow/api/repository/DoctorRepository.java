package us.icarenow.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.icarenow.api.model.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository <Doctor, Integer> {

}

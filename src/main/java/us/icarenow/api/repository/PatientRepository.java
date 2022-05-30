package us.icarenow.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import us.icarenow.api.model.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository <Patient, Integer> {

}

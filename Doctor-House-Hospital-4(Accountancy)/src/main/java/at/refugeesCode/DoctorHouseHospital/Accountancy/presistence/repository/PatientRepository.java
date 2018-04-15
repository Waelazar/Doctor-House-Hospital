package at.refugeesCode.DoctorHouseHospital.Accountancy.presistence.repository;

import at.refugeesCode.DoctorHouseHospital.Accountancy.presistence.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}

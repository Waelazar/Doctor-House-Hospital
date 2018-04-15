package at.refugeesCode.DoctorHouseHospital.Nursary.presistence.repository;

import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String>{
}

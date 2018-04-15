package at.refugeesCode.DoctorHouseHospital.Nursary.endpoint;

import at.refugeesCode.DoctorHouseHospital.Nursary.logic.Nurse;
import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.model.Patient;
import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.repository.PatientRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/patients")
public class Endpoint {

    private Patient patient;

    private PatientRepository patientRepository;

    public Endpoint(Patient patient) {
        this.patient = patient;
    }

    @PostMapping
    Patient recivePatient(@RequestBody Patient patient){
        Nurse nurse = new Nurse();
        Patient checkedPatient = nurse.check();
        patientRepository.save(checkedPatient);
        return patient;
    }
}

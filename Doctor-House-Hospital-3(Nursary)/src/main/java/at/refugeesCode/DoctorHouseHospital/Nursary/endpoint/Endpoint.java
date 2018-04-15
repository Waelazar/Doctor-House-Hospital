package at.refugeesCode.DoctorHouseHospital.Nursary.endpoint;

import at.refugeesCode.DoctorHouseHospital.Nursary.logic.Nurse;
import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.model.Patient;
import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patients")
public class Endpoint {

    private Patient patient;

    private PatientRepository patientRepository;

    public Endpoint(Patient patient) {
        this.patient = patient;
    }

    @GetMapping
    List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @PostMapping()
    void recivePatient(@RequestBody Patient recivedPatient){
        Nurse nurse = new Nurse();
        Patient checkedPatient = nurse.check(recivedPatient);
        patientRepository.save(checkedPatient);
    }
}

package at.refugeesCode.DoctorHouseHospital.Nursary.endpoint;

import at.refugeesCode.DoctorHouseHospital.Nursary.logic.Nurse;
import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.model.Patient;
import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/patients")
public class Endpoint {

    private Patient patient;

    private PatientRepository patientRepository;

    @Value("${Accountancy.Url}")
    private String accountancyUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public Endpoint(Patient patient, PatientRepository patientRepository) {
        this.patient = patient;
        this.patientRepository = patientRepository;
    }

    @GetMapping
    List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @PostMapping()
    Patient recivePatient(@RequestBody Patient recivedPatient){
        Nurse nurse = new Nurse();
        Patient checkedPatient = nurse.check(recivedPatient);
        restTemplate.postForEntity(accountancyUrl, checkedPatient, Patient.class);
        patientRepository.save(checkedPatient);
        return checkedPatient;
    }
}

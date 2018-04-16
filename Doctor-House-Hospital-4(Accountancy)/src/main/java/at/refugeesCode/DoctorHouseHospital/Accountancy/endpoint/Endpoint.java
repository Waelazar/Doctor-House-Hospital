package at.refugeesCode.DoctorHouseHospital.Accountancy.endpoint;

import at.refugeesCode.DoctorHouseHospital.Accountancy.logic.Calculator;
import at.refugeesCode.DoctorHouseHospital.Accountancy.presistence.model.Patient;
import at.refugeesCode.DoctorHouseHospital.Accountancy.presistence.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class Endpoint {

    private Patient patient;

    private PatientRepository patientRepository;

    public Endpoint(Patient patient, PatientRepository patientRepository) {
        this.patient = patient;
        this.patientRepository = patientRepository;
    }

    @GetMapping
    List<Patient> getAll(){
        return patientRepository.findAll();
    }

    @PostMapping
    void recivePatient(@RequestBody Patient recivedPatient){
        Calculator calculator = new Calculator();
        Patient price = calculator.calc(recivedPatient);
        patientRepository.save(price);
    }

}

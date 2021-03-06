package at.refugeesCode.DoctorHouseHospital.Accountancy.endpoint;

import at.refugeesCode.DoctorHouseHospital.Accountancy.logic.Calculator;
import at.refugeesCode.DoctorHouseHospital.Accountancy.presistence.model.Patient;
import at.refugeesCode.DoctorHouseHospital.Accountancy.presistence.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class Endpoint {

    private PatientRepository patientRepository;

    public Endpoint(PatientRepository patientRepository) {
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

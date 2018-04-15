package at.refugeesCode.DoctorHouseHospital.HospitalAdmission.endpoint;

import at.refugeesCode.DoctorHouseHospital.HospitalAdmission.model.Patient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class Endpoint {

    private Patient patient;

    private List<Patient> patientList = new ArrayList<>();

    public Endpoint(Patient patient) {
        this.patient = patient;
    }

    @GetMapping
    List<Patient> getPatientList(){
        return patientList;
    }

    @PostMapping
    Patient postPatient(@RequestBody Patient patient){
        patientList.add(patient);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8081/patients", patient ,Patient.class);
        return patient;
    }

}

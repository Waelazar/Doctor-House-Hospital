package at.refugeesCode.DoctorHouseHospital.DiagnoseRoom.endpoint;

import at.refugeesCode.DoctorHouseHospital.DiagnoseRoom.model.Docktor;
import at.refugeesCode.DoctorHouseHospital.DiagnoseRoom.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class Endpoint {

    private Patient patient;

    private Docktor doctor;

    @Value("${Nursery.Url}")
    private String nurseryUrl;
    private List<Patient> patientList = new ArrayList<>();

    public Endpoint(Patient patient, Docktor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    @GetMapping
    List<Patient> getPatientList(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(nurseryUrl, patient, Patient.class);
        return patientList;
    }

    @PostMapping
    void reciveOnePatient(@RequestBody Patient patient) {
        Patient check = doctor.check(patient);
        patientList.add(check);
    }

}

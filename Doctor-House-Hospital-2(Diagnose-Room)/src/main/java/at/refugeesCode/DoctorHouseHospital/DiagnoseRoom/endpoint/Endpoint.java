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

    private List<Patient> patientList = new ArrayList<>();

    public Endpoint(Patient patient, Docktor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    @GetMapping
    List<Patient> getPatientList(){
        return patientList;
    }

    @PostMapping
    Patient reciveOnePatient(@RequestBody Patient patient) {
        Patient checkedPatient = doctor.check(patient);
        patientList.add(checkedPatient);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8082/patients", checkedPatient, Patient.class);
        return checkedPatient;
    }
}

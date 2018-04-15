package at.refugeesCode.DoctorHouseHospital.DiagnoseRoom.endpoint;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class Endpoint {

    private Patient patient;

    private Doctor doctor;
    private List<Patient> patientList = new ArrayList<>();

    public Endpoint(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    @GetMapping
    List<Patient> getPatientList(){
        return patientList;
    }

    @PostMapping
    void reciveOnePatient(@RequestBody Patient patient) {
        Patient check = doctor.check(patient);
        patientList.add(check);
    }

}

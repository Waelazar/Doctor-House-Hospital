package at.refugeesCode.DoctorHouseHospital.HospitalAdmission.model;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Patient {

    private String id;
    private String name;
    private List<String> symptoms;

    public Patient() {
    }

    public Patient(String id, String name, List<String> symptoms) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

}

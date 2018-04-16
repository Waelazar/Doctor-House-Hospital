package at.refugeesCode.DoctorHouseHospital.Nursary.presistence.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;


@Document
@Component
public class Patient {

    private String id;

    private String name;

    private List<String> symptoms;

    private String illness;

    private String treatment;

    public Patient() {
    }

    public Patient(String id, String name, List<String> symptoms, String illness, String treatment) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.illness = illness;
        this.treatment = treatment;
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

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}

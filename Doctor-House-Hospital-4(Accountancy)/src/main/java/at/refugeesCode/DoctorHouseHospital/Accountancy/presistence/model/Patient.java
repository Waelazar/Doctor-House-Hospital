package at.refugeesCode.DoctorHouseHospital.Accountancy.presistence.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Patient {

    @Id
    private Long id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> symptoms;

    private String illness;

    private String treatment;

    private String Accountancy;

    public Patient() {
    }

    public Patient(Long id, String name, List<String> symptoms, String illness, String treatment, String accountancy) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.illness = illness;
        this.treatment = treatment;
        this.Accountancy = accountancy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAccountancy() {
        return Accountancy;
    }

    public void setAccountancy(String accountancy) {
        Accountancy = accountancy;
    }
}

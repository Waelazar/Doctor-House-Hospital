package at.refugeesCode.DoctorHouseHospital.Nursary.logic;

import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.model.Patient;
import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.repository.PatientRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nurse {

    private Patient patient;

    private PatientRepository patientRepository;
    public Patient check(){
        String illness = patient.getIllness();
        String treatment = getTreatment(illness);
        patient.setTreatment(treatment);
        return patient;
    }

    private String getTreatment(String illness) {
        Map<String, String> map = new HashMap<>();

        map.put("Feeding Tips", "colic");
        map.put("Cymbalta oral", "depression");
        map.put("Lexapro", "stress");
        map.put("Aspirin", "lupus");

        for (Map.Entry<String, String> entry: map.entrySet()){
            if(!illness.isEmpty() && entry.getValue().equalsIgnoreCase(illness)){
                entry.getKey();
            }
        }
        return "There is treatment";
    }

}

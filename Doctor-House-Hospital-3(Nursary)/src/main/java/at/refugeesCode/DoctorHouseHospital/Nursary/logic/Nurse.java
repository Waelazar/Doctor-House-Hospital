package at.refugeesCode.DoctorHouseHospital.Nursary.logic;

import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.model.Patient;
import at.refugeesCode.DoctorHouseHospital.Nursary.presistence.repository.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Nurse {

    private Patient patient;

    public Nurse(Patient patient) {
        this.patient = patient;
    }

    public Nurse() {
    }

    public Patient check(Patient recivedPatient){
        String illness = recivedPatient.getIllness();
        String treatment = getTreatment(illness);
        recivedPatient.setTreatment(treatment);
        return recivedPatient;
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

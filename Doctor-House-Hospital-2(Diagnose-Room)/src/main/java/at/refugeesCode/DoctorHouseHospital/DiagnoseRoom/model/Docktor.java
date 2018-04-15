package at.refugeesCode.DoctorHouseHospital.DiagnoseRoom.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Docktor {


    private Patient patient;

    public Docktor(Patient patient) {
        this.patient = patient;
    }

    public Patient check(Patient patient){
        List<String> symptoms = patient.getSymptoms();
        String getillness = getillnessname(symptoms);
        patient.setIllness(getillness);
        return patient;
    }

    private String getillnessname(List<String> symptoms){

        Map<String, List<String>> symptomsType = new HashMap<String, List<String>>();

        List<String> firstsymptons = Arrays.asList("inconsolable crying", "Loud");
        List<String> secondsymptons = Arrays.asList("Fatigue", "Irritability", "Restlessness");
        List<String> thirdymptons = Arrays.asList("Headaches", "Insomnia");


        symptomsType.put("colic", firstsymptons);
        symptomsType.put("depression" ,secondsymptons);
        symptomsType.put("stress", thirdymptons);

        for(Map.Entry<String, List<String>> entry : symptomsType.entrySet()){
            if(!symptoms.isEmpty() && entry.getValue().equals(symptoms)){
                return entry.getKey();
            }
        }
        return "it is lupus";
    }

}

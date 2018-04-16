package at.refugeesCode.DoctorHouseHospital.Accountancy.logic;

import at.refugeesCode.DoctorHouseHospital.Accountancy.presistence.model.Patient;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Calculator {

    private Patient patient;

    public Calculator(Patient patient) {
        this.patient = patient;
    }

    public Calculator() {
    }

    public Patient calc(Patient recivedPatient){
        String treatment = recivedPatient.getTreatment();
        String price = getPrice(treatment);
        recivedPatient.setAccountancy(price);
        return recivedPatient;
    }

    private String getPrice(String treatment) {
        Map<String, String> map = new HashMap<>();

        map.put("10€", "Feeding Tips");
        map.put("30€", "Cymbalta oral");
        map.put("20€", "Lexapro");
        map.put("15€", "Aspirin");

        for (Map.Entry<String, String> entry: map.entrySet()){
            if(!treatment.isEmpty() && entry.getValue().equalsIgnoreCase(treatment)){
                return entry.getKey();
            }
        }
        return "There is no such medicine";
    }
}

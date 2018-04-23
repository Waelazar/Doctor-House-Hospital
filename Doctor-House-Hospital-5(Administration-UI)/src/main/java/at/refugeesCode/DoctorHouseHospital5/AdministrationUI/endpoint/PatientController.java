package at.refugeesCode.DoctorHouseHospital5.AdministrationUI.endpoint;

import at.refugeesCode.DoctorHouseHospital5.AdministrationUI.model.CheckedPatient;
import at.refugeesCode.DoctorHouseHospital5.AdministrationUI.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/")
public class PatientController {

    private Patient patient;

    public PatientController(Patient patient) {
        this.patient = patient;
    }

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${Admission.Url}")
    private String admissionUrl;

    @Value("${Accountancy.Url}")
    private String accountancyUrl;

    @GetMapping
    String mainPage(){
        return "index";
    }

    @PostMapping
    String sendPatient(@RequestParam String id, @RequestParam String name, @RequestParam List<String> symptoms){
        patient.setId(id);
        patient.setName(name);
        patient.setSymptoms(symptoms);
        restTemplate.postForEntity(admissionUrl, patient, Patient.class);
        return "redirect:/";
    }

    @ModelAttribute("patientModel")
    Patient createPatient(){
        return new Patient();
    }

    @GetMapping("/invoice")
    String invoice(Model model){
        ResponseEntity<CheckedPatient[]> forEntity = restTemplate.getForEntity(accountancyUrl, CheckedPatient[].class);
        model.addAttribute("checkedPatient", forEntity.getBody());
        return "invoice";
    }
}

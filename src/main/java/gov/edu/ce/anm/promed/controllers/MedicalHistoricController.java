package gov.edu.ce.anm.promed.controllers;

import gov.edu.ce.anm.promed.domain.model.MedicalHistoric;
import gov.edu.ce.anm.promed.services.MedicalHistoricService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/histories/")
public class MedicalHistoricController {

    @Autowired
    private MedicalHistoricService medicalHistoricService;

    @GetMapping
    public List<MedicalHistoric> getAllHistories() {
        return medicalHistoricService.getAllHistories();
    }

    @GetMapping("{id}")
    public Optional<MedicalHistoric> getHistoricById(@PathVariable Long id) {
        return medicalHistoricService.getHistoricById(id);
    }

    @PostMapping
    public MedicalHistoric saveHistoric(@RequestBody MedicalHistoric medicalHistoric) {
        return medicalHistoricService.saveHistoric(medicalHistoric);
    }

    @PutMapping
    public MedicalHistoric updateHistoric(@RequestBody MedicalHistoric medicalHistoric) {
        return medicalHistoricService.updateHistoric(medicalHistoric);
    }

    @DeleteMapping("{id}")
    public void deleteHistoricById(@PathVariable Long id) {
        medicalHistoricService.deleteHistoricById(id);
    }
}

package gov.edu.ce.anm.promed.services;

import gov.edu.ce.anm.promed.domain.model.MedicalHistoric;
import gov.edu.ce.anm.promed.repositories.MedicalHistoricRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalHistoricService {

    @Autowired
    private MedicalHistoricRepository medicalHistoricRepository;

    @Transactional
    public List<MedicalHistoric> getAllHistories() {
        return medicalHistoricRepository.findAll();
    }

    @Transactional
    public Optional<MedicalHistoric> getHistoricById(Long id) {
        return medicalHistoricRepository.findById(id);
    }

    @Transactional
    public MedicalHistoric saveHistoric(MedicalHistoric medicalHistoric) {
        return medicalHistoricRepository.save(medicalHistoric);
    }

    @Transactional
    public MedicalHistoric updateHistoric(MedicalHistoric medicalHistoric) {
        return medicalHistoricRepository.save(medicalHistoric);
    }

    @Transactional
    public void deleteHistoricById(Long id) {
        medicalHistoricRepository.deleteById(id);
    }
}

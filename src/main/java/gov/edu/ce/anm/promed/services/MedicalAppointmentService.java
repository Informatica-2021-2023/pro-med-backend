package gov.edu.ce.anm.promed.services;

import gov.edu.ce.anm.promed.domain.model.Client;
import gov.edu.ce.anm.promed.domain.model.Doctor;
import gov.edu.ce.anm.promed.domain.model.MedicalAppointment;
import gov.edu.ce.anm.promed.domain.model.MedicalAppointmentPK;
import gov.edu.ce.anm.promed.repositories.AppUserRepository;
import gov.edu.ce.anm.promed.repositories.MedicalAppointmentRepository;

import jakarta.transaction.Transactional;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalAppointmentService {

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @Transactional
    public List<MedicalAppointment> getAllAppointments() {
        return medicalAppointmentRepository.findAll();
    }

    @Transactional
    public MedicalAppointment addMedicalAppointment(UUID doctorId, UUID clientId, @NotNull MedicalAppointment medicalAppointment) {
        medicalAppointment.setId(new MedicalAppointmentPK(((Client) appUserRepository.findById(clientId).get()),
                ((Doctor) appUserRepository.findById(doctorId).get())));
        return medicalAppointmentRepository.save(medicalAppointment);
    }

    @Transactional
    public MedicalAppointment updateMedicalAppointment(UUID doctorId, UUID clientId, @NotNull MedicalAppointment medicalAppointment) {
        medicalAppointment.setId(new MedicalAppointmentPK(((Client) appUserRepository.findById(clientId).get()),
                ((Doctor) appUserRepository.findById(doctorId).get())));
        return medicalAppointmentRepository.save(medicalAppointment);
    }
}

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

import java.time.LocalTime;

import java.util.*;

@Service
public class MedicalAppointmentService {

    private static final Integer BRASILIA_OFFSET = -3;

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

    public List<LocalTime> getAppointmentsSchedules() {
        return Arrays.asList(LocalTime.of(7,0), LocalTime.of(8,0), LocalTime.of(9,0),
                LocalTime.of(10,0), LocalTime.of(13,0), LocalTime.of(14,0),
                LocalTime.of(15,0), LocalTime.of(16,0), LocalTime.of(17,0));
    }

    public Integer getSchedulesOffset() {
        return BRASILIA_OFFSET;
    }

}

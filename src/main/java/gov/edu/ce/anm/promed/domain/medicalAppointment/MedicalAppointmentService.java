package gov.edu.ce.anm.promed.domain.medicalAppointment;

import gov.edu.ce.anm.promed.domain.medicalAppointment.MedicalAppointment;
import gov.edu.ce.anm.promed.domain.medicalAppointment.MedicalAppointmentPK;
import gov.edu.ce.anm.promed.domain.client.ClientRepository;
import gov.edu.ce.anm.promed.domain.doctor.DoctorRepository;
import gov.edu.ce.anm.promed.domain.medicalAppointment.MedicalAppointmentRepository;

import jakarta.transaction.Transactional;

import org.jetbrains.annotations.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.*;

@Service
public class MedicalAppointmentService {

    private static final Integer BRASILIA_OFFSET = -3;

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public List<MedicalAppointment> getAllAppointments() {
        return medicalAppointmentRepository.findAll();
    }

    @Transactional
    public MedicalAppointment addMedicalAppointment(UUID doctorId, UUID clientId, @NotNull MedicalAppointment medicalAppointment) {
        medicalAppointment.setId(new MedicalAppointmentPK((clientRepository.findById(clientId).get()),
                (doctorRepository.findById(doctorId).get())));
        return medicalAppointmentRepository.save(medicalAppointment);
    }

    @Transactional
    public MedicalAppointment updateMedicalAppointment(UUID doctorId, UUID clientId, @NotNull MedicalAppointment medicalAppointment) {
        medicalAppointment.setId(new MedicalAppointmentPK((clientRepository.findById(clientId).get()),
                doctorRepository.findById(doctorId).get()));
        return medicalAppointmentRepository.save(medicalAppointment);
    }

    public List<LocalTime> getAppointmentsSchedules() {
        return Arrays.asList(LocalTime.of(7, 0), LocalTime.of(8, 0), LocalTime.of(9, 0),
                LocalTime.of(10, 0), LocalTime.of(13, 0), LocalTime.of(14, 0),
                LocalTime.of(15, 0), LocalTime.of(16, 0), LocalTime.of(17, 0));
    }

    public Integer getSchedulesOffset() {
        return BRASILIA_OFFSET;
    }

}

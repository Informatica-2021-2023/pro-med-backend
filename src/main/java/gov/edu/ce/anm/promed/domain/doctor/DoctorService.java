package gov.edu.ce.anm.promed.domain.doctor;

import gov.edu.ce.anm.promed.domain.medicalAppointment.MedicalAppointmentService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.*;
import java.util.*;

@Repository
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @Transactional
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Transactional
    public Optional<Doctor> getDoctorById(UUID id) {
        return doctorRepository.findById(id);
    }

    @Transactional
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Transactional
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    @Transactional
    public void deleteDoctorById(UUID id) {
        doctorRepository.deleteById(id);
    }

    public Map<String, Instant> getSchedulesAsGlobalDates(LocalDate localDate) {
        Map<String, Instant> instants = new HashMap<>();
        List<ZonedDateTime> zones = new ArrayList<>();
        medicalAppointmentService.getAppointmentsSchedules().forEach(schedule -> {
            zones.add(ZonedDateTime.of(localDate, schedule, ZoneId.ofOffset("GMT",
                    ZoneOffset.ofHours(medicalAppointmentService.getSchedulesOffset()))));
        });

        for (int i = 0; i < zones.size(); i++) {
            instants.put(i + 1 + "st schedule: ", Instant.from(zones.get(i)));
        }
        return instants;
    }

    public Map<String, Boolean> checkDaySchedulesAvailability(UUID doctorId, LocalDate localDate) {
        Map<String, Boolean> appointments = new HashMap<>();
        Doctor doc = doctorRepository.findById(doctorId).get();
        getSchedulesAsGlobalDates(localDate).forEach((string, instant) -> {
            boolean isAppointmentAvailable = false;
            for (int i = 0; i < doc.getAppointments().size(); i++) {
                if (instant.equals(doc.getAppointments().get(i).getDate())) {
                    isAppointmentAvailable = true;
                }
            }
            appointments.put(string, isAppointmentAvailable);
        });
        return appointments;
    }
}

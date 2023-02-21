package gov.edu.ce.anm.promed.services;

import gov.edu.ce.anm.promed.domain.model.AppUser;
import gov.edu.ce.anm.promed.domain.model.Doctor;
import gov.edu.ce.anm.promed.repositories.AddressRepository;
import gov.edu.ce.anm.promed.repositories.AppUserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @Transactional
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Transactional
    public Optional<AppUser> getUserById(UUID id) {
        return appUserRepository.findById(id);
    }

    @Transactional
    public AppUser saveUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Transactional
    public AppUser updateUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Transactional
    public void deleteUserById(UUID id) {
        AppUser appUser = appUserRepository.findById(id).orElse(null);
        if (appUser != null) {
            addressRepository.delete(appUser.getAddress());
            appUserRepository.delete(appUser);
        }
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
        Doctor doc = (Doctor) appUserRepository.findById(doctorId).get();
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

package gov.edu.ce.anm.promed.api.admin;

import gov.edu.ce.anm.promed.domain.doctor.Doctor;
import gov.edu.ce.anm.promed.domain.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/doctors/")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("{id}")
    public Optional<Doctor> getDoctorById(@PathVariable UUID id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PutMapping
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("{id}")
    public void deleteDoctor(@PathVariable UUID id) {
        doctorService.deleteDoctorById(id);
    }

    @GetMapping("check-days")
    public Map<String, Boolean> checkDaySchedulesAvailability(@RequestParam("doctor_id") UUID id,
                                                              @RequestParam("date") LocalDate localDate) {
        return doctorService.checkDaySchedulesAvailability(id, localDate);
    }
}

package gov.edu.ce.anm.promed.controllers;

import gov.edu.ce.anm.promed.domain.model.MedicalAppointment;
import gov.edu.ce.anm.promed.services.MedicalAppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments/")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @GetMapping
    public List<MedicalAppointment> getAllAppointments() {
        return medicalAppointmentService.getAllAppointments();
    }

    @PostMapping("add")
    public MedicalAppointment addMedicalAppointment(@RequestParam("doctor_id") UUID doctorId,
                                                    @RequestParam("client_id") UUID clientId,
                                                    @RequestBody MedicalAppointment medicalAppointment) {
        return medicalAppointmentService.addMedicalAppointment(doctorId, clientId, medicalAppointment);
    }

    @PutMapping("update")
    public MedicalAppointment updateMedicalAppointment(@RequestParam("doctor_id") UUID doctorId,
                                                       @RequestParam("client_id") UUID clientId,
                                                       @RequestBody MedicalAppointment medicalAppointment) {
        return medicalAppointmentService.updateMedicalAppointment(doctorId, clientId, medicalAppointment);
    }

}

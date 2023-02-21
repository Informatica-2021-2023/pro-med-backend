package gov.edu.ce.anm.promed.controllers;

import gov.edu.ce.anm.promed.domain.model.AppUser;
import gov.edu.ce.anm.promed.services.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;

import java.util.*;

@RestController
@RequestMapping("/api/users/")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public List<AppUser> getUsers() {
        return appUserService.getAllUsers();
    }

    @GetMapping("{id}")
    public Optional<AppUser> getUserById(@PathVariable UUID id) {
        return appUserService.getUserById(id);
    }

    @PostMapping
    public AppUser saveUser(@RequestBody AppUser appUser) {
        return appUserService.saveUser(appUser);
    }

    @PutMapping
    public AppUser updateUser(@RequestBody AppUser appUser) {
        return appUserService.updateUser(appUser);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable UUID id) {
        appUserService.deleteUserById(id);
    }

    @GetMapping("global-dates")
    public Map<String, Instant> getSchedulesAsGlobalDates(@RequestParam("date") LocalDate localDate) {
        return appUserService.getSchedulesAsGlobalDates(localDate);
    }

    @GetMapping("check-days")
    public Map<String, Boolean> checkDaySchedulesAvailability(@RequestParam("doctor_id") UUID id, @RequestParam("date") LocalDate localDate) {
        return appUserService.checkDaySchedulesAvailability(id, localDate);
    }
}

package gov.edu.ce.anm.promed.controllers;

import gov.edu.ce.anm.promed.domain.model.AppUser;
import gov.edu.ce.anm.promed.services.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
}

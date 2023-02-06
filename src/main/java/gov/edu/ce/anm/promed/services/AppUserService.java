package gov.edu.ce.anm.promed.services;

import gov.edu.ce.anm.promed.domain.model.AppUser;
import gov.edu.ce.anm.promed.repositories.AddressRepository;
import gov.edu.ce.anm.promed.repositories.AppUserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AddressRepository addressRepository;

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
}

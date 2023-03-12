package gov.edu.ce.anm.promed.domain.admin;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Transactional
    public Optional<Admin> getAdminById(UUID id) {
        return adminRepository.findById(id);
    }

    @Transactional
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Transactional
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Transactional
    public void deleteAdminById(UUID id) {
        adminRepository.deleteById(id);
    }
}

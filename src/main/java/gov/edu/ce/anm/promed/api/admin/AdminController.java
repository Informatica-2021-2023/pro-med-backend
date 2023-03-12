package gov.edu.ce.anm.promed.api.admin;

import gov.edu.ce.anm.promed.domain.admin.Admin;
import gov.edu.ce.anm.promed.domain.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("{id}")
    public Optional<Admin> getAdminById(@PathVariable UUID id) {
        return adminService.getAdminById(id);
    }

    @PostMapping
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @PutMapping
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("{id}")
    public void deleteAdmin(@PathVariable UUID id) {
        adminService.deleteAdminById(id);
    }
}

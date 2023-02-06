package gov.edu.ce.anm.promed;

import gov.edu.ce.anm.promed.domain.enums.AppUserRole;
import gov.edu.ce.anm.promed.domain.enums.Gender;
import gov.edu.ce.anm.promed.domain.model.*;
import gov.edu.ce.anm.promed.repositories.AppUserRepository;
import gov.edu.ce.anm.promed.repositories.MedicalHistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.UUID;

@SpringBootApplication
public class ProMedApplication implements CommandLineRunner {

	@Autowired
	private AppUserRepository repo;

	@Autowired
	private MedicalHistoricRepository medRepo;

	@Override
	public void run(String... args) throws Exception {

		//tentar cadastrar um usuario para ver o JSON

		MedicalHistoric historic = new MedicalHistoric();
		historic.setId(null);
		historic.setBloodType("A+");
		historic.setPrescriptionDrugs("prescriptionDrugs");
		historic.setDrugAllergies("allergies");
		historic.setHospitalizationHistoric("priorHospitalization");
		historic.setSurgeriesHistoric("surgeriesHistoric");
		historic.setPriorDiseases("priorDiseases");
		historic.setExtraNotes("treatment");

		medRepo.save(historic);

		Instant instant = Instant.now();

		Address addressDoc = new Address(null, "Ceara", "Acopiara",
				"Miguel Galdino", "Vila Palmeira", 157);

		Address addressAdm = new Address(null, "Estados Unidos", "Washington",
				"Rua", "Vila Mugunzá", 171);

		Address addressCli = new Address(null, "URSS", "Comu",
				"Nismo", "Paulin", 157);

		Doctor doctor = new Doctor();
		doctor.setId(UUID.randomUUID());
		doctor.setEmail("doctor@email.com");
		doctor.setPassword("doc");
		doctor.setFullName("Docotr da Silva");
		doctor.setBirthDate(instant);
		doctor.setGender(Gender.OTHER);
		doctor.setPhoneNumber("88 99999-8888");
		doctor.setAddress(addressDoc);
		doctor.setCpf("111.222.333-44");
		doctor.setRg("12345678909");
		doctor.setRole(AppUserRole.DOCTOR);
		doctor.setSpecialization("Cardio");
		repo.save(doctor);

		Admin admin = new Admin();
		admin.setId(UUID.randomUUID());
		admin.setEmail("admin@email.com");
		admin.setPassword("admin");
		admin.setFullName("Admin da Silva");
		admin.setBirthDate(instant);
		admin.setGender(Gender.FEMALE);
		admin.setPhoneNumber("11 99999-0000");
		admin.setAddress(addressAdm);
		admin.setCpf("000.999.888-69");
		admin.setRg("12345678909");
		admin.setRole(AppUserRole.ADMIN);
		repo.save(admin);

		Client cli = new Client();
		cli.setId(UUID.randomUUID());
		cli.setEmail("client@email.com");
		cli.setPassword("client");
		cli.setFullName("Client da Silba");
		cli.setBirthDate(instant);
		cli.setGender(Gender.MALE);
		cli.setPhoneNumber("85 11111-8827");
		cli.setAddress(addressCli);
		cli.setCpf("444.555.666-69");
		cli.setRg("523563453454");
		cli.setRole(AppUserRole.CLIENT);
		cli.setMedicalHistoric(historic);
		repo.save(cli);

	}
	public static void main(String[] args) {
		SpringApplication.run(ProMedApplication.class, args);
	}

}

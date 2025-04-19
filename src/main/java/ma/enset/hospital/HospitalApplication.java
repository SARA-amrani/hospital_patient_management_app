package ma.enset.hospital;

import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.entities.StatusRDV;
import ma.enset.hospital.repository.MedecinRepository;
import ma.enset.hospital.repository.PatientRepository;
import ma.enset.hospital.repository.RendezvousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezvousRepository rendezvousRepository) {
        return args -> {
            //Ajouter des patients
            Stream.of("SARA","AYA","HOUDA")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        patientRepository.save(patient);
                    });
            //Ajouter des medecins
            Stream.of("NEZHA","OUSSAMA","RIM")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        medecinRepository.save(medecin);
                    });

             // Creation d'un rendez-vous
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("SARA");

            Medecin medecin = medecinRepository.findByNom("NEZHA");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            rendezvousRepository.save(rendezVous);

        };
    }
}

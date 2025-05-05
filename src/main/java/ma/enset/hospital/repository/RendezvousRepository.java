package ma.enset.hospital.repository;

import ma.enset.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<RendezVous, String> {
}

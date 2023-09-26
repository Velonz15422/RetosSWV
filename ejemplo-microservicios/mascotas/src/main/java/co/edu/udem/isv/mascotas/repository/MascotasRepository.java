package co.edu.udem.isv.mascotas.repository;

import co.edu.udem.isv.mascotas.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotasRepository extends JpaRepository<Mascota, Long> {
}

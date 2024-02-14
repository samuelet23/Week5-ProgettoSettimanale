package ProgettoSettimanale.GestionePrenotazioni.Repository;

import ProgettoSettimanale.GestionePrenotazioni.Class.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}

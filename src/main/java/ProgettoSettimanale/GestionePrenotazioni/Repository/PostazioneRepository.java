package ProgettoSettimanale.GestionePrenotazioni.Repository;

import ProgettoSettimanale.GestionePrenotazioni.Class.Edificio;
import ProgettoSettimanale.GestionePrenotazioni.Class.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.Type.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
        List<Postazione> findByEdificio(Edificio edificio);
        List<Postazione> findByEdificioAndTipo(Edificio edificio, TipoPostazione tipoPostazione);
    }



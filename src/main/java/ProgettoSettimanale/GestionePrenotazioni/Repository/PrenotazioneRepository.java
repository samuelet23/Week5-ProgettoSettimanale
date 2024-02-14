package ProgettoSettimanale.GestionePrenotazioni.Repository;

import ProgettoSettimanale.GestionePrenotazioni.Class.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.Class.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.Class.Utente;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    boolean existsPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);


}

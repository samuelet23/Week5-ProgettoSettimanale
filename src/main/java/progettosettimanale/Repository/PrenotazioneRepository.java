package progettosettimanale.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettosettimanale.Class.Prenotazione;
import progettosettimanale.Class.Utente;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    Prenotazione findByUtenteAndData(Utente utente, LocalDate data);


}

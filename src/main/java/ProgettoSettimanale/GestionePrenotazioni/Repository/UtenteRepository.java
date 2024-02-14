package ProgettoSettimanale.GestionePrenotazioni.Repository;

import ProgettoSettimanale.GestionePrenotazioni.Class.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.Class.Utente;
import ProgettoSettimanale.GestionePrenotazioni.Type.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {

    public List<Postazione> findByTipoPostazioneAndCitta(TipoPostazione tipoPostazione, String citta);


}

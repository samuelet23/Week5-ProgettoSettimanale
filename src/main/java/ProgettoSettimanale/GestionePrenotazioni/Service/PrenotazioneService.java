package ProgettoSettimanale.GestionePrenotazioni.Service;

import ProgettoSettimanale.GestionePrenotazioni.Class.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.Class.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.Class.Utente;
import ProgettoSettimanale.GestionePrenotazioni.Exception.CustomException;
import ProgettoSettimanale.GestionePrenotazioni.Repository.PostazioneRepository;
import ProgettoSettimanale.GestionePrenotazioni.Repository.PrenotazioneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public class PrenotazioneService {
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    private transient final Logger logger = LoggerFactory.getLogger("main_info");

    public Prenotazione prenotaPostazione(Utente utente, int idPostazione, LocalDate data, LocalDate dataFine) throws CustomException {
        Postazione postazione = postazioneService.findById(idPostazione);
        Prenotazione prenotazione = null;
        if (!checkNumMaxPartecipanti(postazione)){
            logger.error("La postazione ha raggiunto il numero massimo di partecipanti.");
            return null;
        }
        if (data.plusDays(1).equals(dataFine)){

            if (prenotazioneRepository.existsPostazioneAndData(postazione, data)) {
            logger.error("Postazione già prenotata per questa data");
            throw  new CustomException("Postazione già prenotata per questa data");
            }
            Prenotazione p = new Prenotazione();
            p.setUtente(utente);
            p.setPostazione(postazione);
            p.setData(data);
            logger.info("Prenotazione avvenuta con successo");
            prenotazione = p;
        } else {
            throw new CustomException("La prenotazione deve essere di un solo giorno");
        }
        return prenotazione;
    }

    public List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data){
      return prenotazioneRepository.findByUtenteAndData(utente,data);
    }
    

    public static boolean checkNumMaxPartecipanti(Postazione postazione){
       return postazione.getNumOccupanti() <= postazione.getNumMaxOccupanti();
    }


}

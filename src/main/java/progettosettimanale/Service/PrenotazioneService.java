package progettosettimanale.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettosettimanale.Class.Postazione;
import progettosettimanale.Class.Prenotazione;
import progettosettimanale.Class.Utente;
import progettosettimanale.Exception.CustomException;
import progettosettimanale.Repository.PrenotazioneRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void save(Prenotazione prenotazione){
        prenotazioneRepository.save(prenotazione);
    }

    public void update(Prenotazione prenotazione) throws CustomException {
        Prenotazione p;
        Optional<Prenotazione>  prenotazione1 = prenotazioneRepository.findById(prenotazione.getId());
        if (prenotazione1.isPresent()) {
            p = prenotazione1.get();
            p.setUtente(prenotazione.getUtente());
            p.setPostazione(prenotazione.getPostazione());
            p.setData(prenotazione.getData());

            prenotazioneRepository.save(p);
        }
        else throw new CustomException("Prenotazione non trovata");
    }

    public Prenotazione searchById(int id) throws CustomException {
        Prenotazione prenotazione;
        Optional<Prenotazione> prenotazioneOptional = prenotazioneRepository.findById(id);
        if (prenotazioneOptional.isPresent()) {
            prenotazione = prenotazioneOptional.get();
        } else{
            throw new CustomException("Prenotazione non trovata");
        }
        return prenotazione;
    }

    public void delete(int id ) throws CustomException {
        Prenotazione prenotazione = searchById(id);
        prenotazioneRepository.delete(prenotazione);
    }

    public Prenotazione findByUtenteAndData(Utente utente, LocalDate data){
       return prenotazioneRepository.findByUtenteAndData(utente, data);
    }

    public boolean checkUtente(Utente utente, LocalDate date){
        if (prenotazioneRepository.findByUtenteAndData(utente, date) == null) {
            return  true;
        }
        return false;
    }

}

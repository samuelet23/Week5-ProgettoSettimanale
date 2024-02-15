package progettosettimanale.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettosettimanale.Class.Prenotazione;
import progettosettimanale.Class.Utente;
import progettosettimanale.Exception.CustomException;
import progettosettimanale.Repository.UtenteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {


    private UtenteRepository utenteRepository;

    public void save(Utente utente){
        utenteRepository.save(utente);
    }

    public void update(Utente utente) throws CustomException {
        Utente u;
        Optional<Utente> utente1 = utenteRepository.findById(utente.getId());
        if (utente1.isPresent()) {
            u = utente1.get();
            u.setNome(utente.getNome());
            u.setCognome(utente.getCognome());
            u.setUsername(utente.getUsername());
            u.setEmail(utente.getEmail());
            u.setPrenotazioniInCorso(utente.getPrenotazioniInCorso());

            utenteRepository.save(u);
        }
        else throw new CustomException("Utente non trovato");
    }

    public Utente searchById(int id) throws CustomException {
        Utente utente;
        Optional<Utente> utenteOptional = utenteRepository.findById(id);
        if (utenteOptional.isPresent()) {
            utente = utenteOptional.get();
        } else{
            throw new CustomException("Utente non trovato");
        }
        return utente;
    }

    public void delete(int id ) throws CustomException {
        Utente utente = searchById(id);
        utenteRepository.delete(utente);
    }




}

package progettosettimanale.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettosettimanale.Class.Edificio;
import progettosettimanale.Class.Postazione;
import progettosettimanale.Exception.CustomException;
import progettosettimanale.Repository.PostazioneRepository;
import progettosettimanale.Type.TipoPostazione;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;


    public void save(Postazione postazione){
        postazioneRepository.save(postazione);
    }

    public void update(Postazione postazione) throws CustomException {
        Postazione p;
        Optional<Postazione> postazione1 = postazioneRepository.findById(postazione.getId());
        if (postazione1.isPresent()) {
            p = postazione1.get();
            p.setDescrizione(postazione.getDescrizione());
            p.setNumMaxOccupanti(postazione.getNumMaxOccupanti());
            p.setTipoPostazione(postazione.getTipoPostazione());
            p.setPrenotazioni(postazione.getPrenotazioni());
            p.setEdificio(postazione.getEdificio());
            postazioneRepository.save(p);
        }
        else throw new CustomException("Postazione non trovata");
    }

    public Postazione searchById(int id) throws CustomException {
        Postazione postazione;
        Optional<Postazione> postazioneOptional = postazioneRepository.findById(id);
        if (postazioneOptional.isPresent()) {
            postazione = postazioneOptional.get();
        } else{
            throw new CustomException("Postazione non trovata");
        }
        return postazione;
    }

    public void delete(int id ) throws CustomException {
        Postazione postazione = searchById(id);
        postazioneRepository.delete(postazione);
    }

    public List<Postazione> findByEdificio(Edificio edificio){
       return postazioneRepository.findByEdificio(edificio);
    }

    public List<Postazione> findByCittaAndTipoPostazione (TipoPostazione tipoPostazione, String citta){
      return postazioneRepository.findByCittaAndTipoPostazione (citta, tipoPostazione);
    }
}

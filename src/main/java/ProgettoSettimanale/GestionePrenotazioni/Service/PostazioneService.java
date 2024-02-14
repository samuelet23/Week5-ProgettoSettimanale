package ProgettoSettimanale.GestionePrenotazioni.Service;

import ProgettoSettimanale.GestionePrenotazioni.Class.Edificio;
import ProgettoSettimanale.GestionePrenotazioni.Class.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.Exception.CustomException;
import ProgettoSettimanale.GestionePrenotazioni.Repository.PostazioneRepository;
import ProgettoSettimanale.GestionePrenotazioni.Type.TipoPostazione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> findByEdificioAndTipoPostazione(Edificio edificio, TipoPostazione tipoPostazione){
       return  postazioneRepository.findByEdificioAndTipo(edificio, tipoPostazione);
    }

    public Postazione findById(int id)throws CustomException{
        Postazione p;
        try{
        Optional<Postazione> postazione = postazioneRepository.findById(id);
            if (postazione.isPresent()) {
               p = postazione.get();
            }else{
                throw new CustomException("La postazione cercata non esiste");
            }
        }
        catch (CustomException e){
            throw new CustomException(e.getMessage());
        }
        return p;
    }


}

package ProgettoSettimanale.GestionePrenotazioni.Service;

import ProgettoSettimanale.GestionePrenotazioni.Class.Edificio;
import ProgettoSettimanale.GestionePrenotazioni.Class.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.Type.TipoPostazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private transient PostazioneService postazioneService;

    public List<Postazione> getPostazioniByEdificio(Edificio edificio, TipoPostazione tipoPostazione){
        return postazioneService.findByEdificioAndTipoPostazione(edificio, tipoPostazione);
    }



}

package ProgettoSettimanale.GestionePrenotazioni.Service;

import ProgettoSettimanale.GestionePrenotazioni.Class.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.Repository.UtenteRepository;
import ProgettoSettimanale.GestionePrenotazioni.Type.TipoPostazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Postazione> findByTipoPostazioneAndCitta(TipoPostazione tipoPostazione, String citta){
      return utenteRepository.findByTipoPostazioneAndCitta(tipoPostazione, citta);
    }



}

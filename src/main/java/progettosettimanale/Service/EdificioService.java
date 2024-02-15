package progettosettimanale.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import progettosettimanale.Class.Edificio;
import progettosettimanale.Exception.CustomException;
import progettosettimanale.Repository.EdificioRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;


    public void save(Edificio edificio){
        edificioRepository.save(edificio);
    }

    public void updateEdificio(Edificio edificio) throws CustomException {
        Edificio e = null;
        Optional<Edificio> edificio1 = edificioRepository.findById(edificio.getId());
        if (edificio1.isPresent()) {
            e = edificio1.get();
        e.setCitta(edificio.getCitta());
        e.setNome(edificio.getNome());
        e.setIndirizzo(edificio.getIndirizzo());
        e.setPostazioni(edificio.getPostazioni());
        edificioRepository.save(e);
        }
        else throw new CustomException("Edificio non trovato");
    }

    public Edificio searchById(int id) throws CustomException {
        Edificio edificio = null;
        Optional<Edificio> edificioOptional = edificioRepository.findById(id);
        if (edificioOptional.isPresent()) {
           edificio = edificioOptional.get();
        } else{
            throw new CustomException("Edificio non trovato");
        }
        return edificio;
    }

    public void delete(int id ) throws CustomException {
        Edificio edificio = searchById(id);
        edificioRepository.delete(edificio);
    }

}

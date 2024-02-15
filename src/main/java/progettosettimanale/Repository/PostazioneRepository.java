package progettosettimanale.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import progettosettimanale.Class.Edificio;
import progettosettimanale.Class.Postazione;
import progettosettimanale.Type.TipoPostazione;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

        @Query("SELECT p FROM Postazione p WHERE p.edificio = :edificio ")
        List<Postazione> findByEdificio(Edificio edificio);


        @Query("SELECT p FROM Postazione p WHERE p.edificio.citta= :citta AND p.tipoPostazione = :tipoPostazione")
        List<Postazione> findByCittaAndTipoPostazione(String citta, TipoPostazione tipoPostazione);

}



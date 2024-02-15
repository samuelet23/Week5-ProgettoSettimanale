package progettosettimanale.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettosettimanale.Class.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {



}

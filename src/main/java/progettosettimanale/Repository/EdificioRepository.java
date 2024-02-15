package progettosettimanale.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import progettosettimanale.Class.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}

package progettosettimanale.Class;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@Component("utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utente_id")
    @SequenceGenerator(name = "utente_id", initialValue = 0, allocationSize = 1)
    private int id;

    private String username;

    private String nome;
    private String cognome;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioniInCorso;


}

package ProgettoSettimanale.GestionePrenotazioni.Class;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.ListResourceBundle;

@Entity
@Data
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utente_id")
    @SequenceGenerator(name = "utente_id", initialValue = 0, allocationSize = 1)
    private int id;

    @Column(unique = true)
    private String username;

    private String nome;
    private String cognome;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioniInCorso;

}

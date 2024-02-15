package progettosettimanale.Class;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Data
@Component("prenotazione")
public class Prenotazione {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "prenotazione_id")
    @SequenceGenerator(name = "prenotazione_id", initialValue = 0, allocationSize = 1)
    private int id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}

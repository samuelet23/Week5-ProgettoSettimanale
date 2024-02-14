package ProgettoSettimanale.GestionePrenotazioni.Class;

import ProgettoSettimanale.GestionePrenotazioni.Type.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "postazione_id")
    @SequenceGenerator(name = "postazione_id", initialValue = 0, allocationSize = 1)
    private int id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int numMaxOccupanti;
    private int numOccupanti;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edificio_id" )
    private Edificio edificio;

    @OneToOne
    private Utente utente;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
}

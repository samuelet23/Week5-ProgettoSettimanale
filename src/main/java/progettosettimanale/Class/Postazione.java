package progettosettimanale.Class;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import progettosettimanale.Type.TipoPostazione;

import java.util.List;

@Entity
@Data
@Component
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "postazione_id")
    @SequenceGenerator(name = "postazione_id", initialValue = 0, allocationSize = 1)
    private int id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int numMaxOccupanti;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edificio_id" )
    private Edificio edificio;


    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;


}

package progettosettimanale.Class;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edificio_id")
    @SequenceGenerator(name = "edificio_id", initialValue = 0, allocationSize = 1)
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

}

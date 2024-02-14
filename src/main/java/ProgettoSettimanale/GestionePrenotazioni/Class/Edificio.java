package ProgettoSettimanale.GestionePrenotazioni.Class;

import ProgettoSettimanale.GestionePrenotazioni.Service.PostazioneService;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Data
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edificio_id")
    @SequenceGenerator(name = "edificio_id", initialValue = 0, allocationSize = 1)
    private int id;
    private String name;
    private String indirizzo;
    private String citta;



}

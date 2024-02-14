package ProgettoSettimanale.GestionePrenotazioni.Bean;

import ProgettoSettimanale.GestionePrenotazioni.Class.Edificio;
import ProgettoSettimanale.GestionePrenotazioni.Class.Postazione;
import ProgettoSettimanale.GestionePrenotazioni.Class.Prenotazione;
import ProgettoSettimanale.GestionePrenotazioni.Class.Utente;
import ProgettoSettimanale.GestionePrenotazioni.Type.TipoPostazione;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;

@Configuration
public class AppConfig {

    @Bean("edificioA")
    public Edificio edificioA() {
        Edificio edificio = new Edificio();
        edificio.setName("Edificio A");
        edificio.setIndirizzo("Via Principale 123");
        edificio.setCitta("Roma");
        return edificio;
    }

    @Bean("edificioB")
    public Edificio edificioB() {
        Edificio edificio = new Edificio();
        edificio.setName("Edificio B");
        edificio.setIndirizzo("Via Secondaria 456");
        edificio.setCitta("Milano");
        return edificio;
    }

    @Bean("postazione1")
    public Postazione postazione1(Edificio edificioA) {
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Postazione Privata");
        postazione.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione.setNumMaxOccupanti(1);
        postazione.setEdificio(edificioA);
        return postazione;
    }

    @Bean("postazione2")
    public Postazione postazione2(Edificio edificioB) {
        Postazione postazione = new Postazione();
        postazione.setDescrizione("Postazione Open Space");
        postazione.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione.setNumMaxOccupanti(5);
        postazione.setEdificio(edificioB);
        return postazione;
    }

    @Bean("utente1")
    public Utente utente1() {
        Utente utente = new Utente();
        utente.setUsername("utente1");
        utente.setNome("Paolo");
        utente.setCognome("Bianchi");
        utente.setEmail("paolo@example.com");
        return utente;
    }

    @Bean("utente2")
    public Utente utente2() {
        Utente utente = new Utente();
        utente.setUsername("utente2");
        utente.setNome("Mario");
        utente.setCognome("Rossi");
        utente.setEmail("mario@example.com");
        return utente;
    }

    @Bean("prenotazione1")
    public Prenotazione prenotazione1(Postazione postazione1, Utente utente1) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setData(LocalDate.now());
        prenotazione.setPostazione(postazione1);
        prenotazione.setUtente(utente1);
        return prenotazione;
    }

    @Bean("prenotazione2")
    public Prenotazione prenotazione2(Postazione postazione2, Utente utente2) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setData(LocalDate.now().plusDays(1));
        prenotazione.setPostazione(postazione2);
        prenotazione.setUtente(utente2);
        return prenotazione;
    }


}

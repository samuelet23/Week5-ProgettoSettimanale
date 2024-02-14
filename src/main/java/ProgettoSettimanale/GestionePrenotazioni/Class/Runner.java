package ProgettoSettimanale.GestionePrenotazioni.Class;

import ProgettoSettimanale.GestionePrenotazioni.GestionePrenotazioniApplication;
import ProgettoSettimanale.GestionePrenotazioni.Repository.EdificioRepository;
import ProgettoSettimanale.GestionePrenotazioni.Repository.PostazioneRepository;
import ProgettoSettimanale.GestionePrenotazioni.Repository.PrenotazioneRepository;
import ProgettoSettimanale.GestionePrenotazioni.Repository.UtenteRepository;
import ProgettoSettimanale.GestionePrenotazioni.Service.PrenotazioneService;
import ProgettoSettimanale.GestionePrenotazioni.Type.TipoPostazione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    private static final Logger errorLogger =  LoggerFactory.getLogger("main_error");
    private static final Logger infoLogger =  LoggerFactory.getLogger("main_info");

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Override
    public void run(String... args) throws Exception {
        Edificio edificioA = new Edificio();
        edificioA.setName("Edificio A");
        edificioA.setIndirizzo("Via Principale 123");
        edificioA.setCitta("Città A");

        Edificio edificioB = new Edificio();
        edificioB.setName("Edificio B");
        edificioB.setIndirizzo("Via Secondaria 456");
        edificioB.setCitta("Città B");

        Postazione postazione1 = new Postazione();
        postazione1.setDescrizione("Postazione Privata");
        postazione1.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione1.setNumMaxOccupanti(1);
        postazione1.setEdificio(edificioA);

        Postazione postazione2 = new Postazione();
        postazione2.setDescrizione("Postazione Open Space");
        postazione2.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione2.setNumMaxOccupanti(5);
        postazione2.setEdificio(edificioB);

        Utente utente1 = new Utente();
        utente1.setUsername("utente1");
        utente1.setNome("Paolo");
        utente1.setNome("bianchi");
        utente1.setEmail("utente1@example.com");

        Utente utente2 = new Utente();
        utente2.setUsername("utente2");
        utente2.setNome("mario");
        utente2.setNome("rossi");
        utente2.setEmail("utente2@example.com");

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setData(LocalDate.now());
        prenotazione1.setPostazione(postazione1);
        prenotazione1.setUtente(utente1);

        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setData(LocalDate.now().plusDays(1));
        prenotazione2.setPostazione(postazione2);
        prenotazione2.setUtente(utente2);

        try {
        edificioRepository.save(edificioA);
        }catch (Exception e){
            errorLogger.error(e.getMessage());
        }
        edificioRepository.save(edificioB);
        postazioneRepository.save(postazione1);
        postazioneRepository.save(postazione2);
        utenteRepository.save(utente1);
        utenteRepository.save(utente2);
        prenotazioneRepository.save(prenotazione1);
        prenotazioneRepository.save(prenotazione2);



//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);
//
//        Edificio edificioA = ctx.getBean("edificioA", Edificio.class);
//        Edificio edificioB = ctx.getBean("edificioB", Edificio.class);
//        Postazione postazione1 = ctx.getBean("postazione1", Postazione.class);
//        Postazione postazione2 = ctx.getBean("postazione2", Postazione.class);
//        Utente utente1 = ctx.getBean("utente1", Utente.class);
//        Utente utente2 = ctx.getBean("utente2", Utente.class);
//        Prenotazione prenotazione1 = ctx.getBean("prenotazione1", Prenotazione.class);
//        Prenotazione prenotazione2 = ctx.getBean("prenotazione2", Prenotazione.class);
//
//        edificioRepository.save(edificioA);
//        edificioRepository.save(edificioB);
//        postazioneRepository.save(postazione1);
//        postazioneRepository.save(postazione2);
//        utenteRepository.save(utente1);
//        utenteRepository.save(utente2);
//        prenotazioneRepository.save(prenotazione1);
//        prenotazioneRepository.save(prenotazione2);

    }
}

package progettosettimanale;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import progettosettimanale.Class.Edificio;
import progettosettimanale.Class.Postazione;
import progettosettimanale.Class.Prenotazione;
import progettosettimanale.Class.Utente;
import progettosettimanale.Exception.CustomException;
import progettosettimanale.Repository.EdificioRepository;
import progettosettimanale.Repository.PostazioneRepository;
import progettosettimanale.Repository.PrenotazioneRepository;
import progettosettimanale.Repository.UtenteRepository;
import progettosettimanale.Service.EdificioService;
import progettosettimanale.Service.PostazioneService;
import progettosettimanale.Service.PrenotazioneService;
import progettosettimanale.Service.UtenteService;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    final static Logger logger = LoggerFactory.getLogger("progettosettimanale");


    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProgettoSettimanaleApplication.class);

        Edificio edificio1 = ctx.getBean("edificioA", Edificio.class);
        try{
        edificioService.save(edificio1);
            logger.info("Edificio aggiunto");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        Postazione postazione1 = ctx.getBean("postazione1", Postazione.class);
        try{
            postazioneService.save(postazione1);
            logger.info("Postazione aggiunta");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        Utente utente1 = ctx.getBean("utente1", Utente.class);
        try{
            utenteService.save(utente1);
            logger.info("Utente aggiunto");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        Prenotazione prenotazione1 = ctx.getBean("prenotazione1", Prenotazione.class);
        try{
            prenotazioneService.save(prenotazione1);
            logger.info("Prenotazione effetuata");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}

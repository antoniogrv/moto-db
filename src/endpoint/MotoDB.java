package endpoint;

import java.sql.SQLException;
import config.Config;
import db.DBConnectionPool;
import debug.DebugViewer;
import gui.MainViewer;

public class MotoDB extends Actor {

    /*
     * MotoDB è l'hub principale del software. Tenta di connettersi al database e di
     * aprire, in caso di successo, il frame principale, al quale poi sarà delegata
     * l'apertura dei frame delle rispettive operazioni.
     */

    public MotoDB() {
        if (Config.DEBUG_MODE)
            /*
             * Se la modalità di debug è attiva, apri il DebugFrame contenuto nel
             * DebugViewer.
             */
            new DebugViewer();

        try {
            /*
             * Prima di aprire il frame principale, tenta di connettersi al database. Se la
             * connessione viene rifiutata per qualasiasi motivi, l'esecuzione si
             * interrompre ma il frame di debug - se la modalità di debug è attiva,
             * chiaramente - rimane aperto; in alternativa, in caso di successo, apre il
             * MainFrame contenuto nel MainViewer.
             */
            debug(":Configurazione caricata con successo");
            DBConnectionPool.getConnection();
            debug(":Connessione al database avvenuta con successo");

            /*
             * Inizializza, crea e popola il frame principale. In modalità di debug, il
             * frame neo-creato sarà popolato da un testo predefinito impostabile nelle
             * configurazioni.
             */
            new MainViewer();
        } catch (SQLException e) {
            System.out.println("<MotoDB> E' risultato impossibile connettersi al database");
            System.out.println("<MotoDB> Attiva la modalità di debug, se non l'hai già fatto");
            debug("!Impossibile connettersi al database, verifica la configurazione");
        }

    }

}

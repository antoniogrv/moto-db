package endpoint;

import java.sql.SQLException;
import config.Config;
import db.DBConnectionPool;
import debug.DebugViewer;
import gui.MainViewer;

public class MotoDB extends Actor {

    public MotoDB() {
        if (Config.DEBUG_MODE)
            new DebugViewer();

        try {
            debug(":Configurazione caricata con successo");
            DBConnectionPool.getConnection();
            debug(":Connessione al database avvenuta con successo");
            new MainViewer();
        } catch (SQLException e) {
            System.out.println("<MotoDB> E' risultato impossibile connettersi al database");
            System.out.println("<MotoDB> Attiva la modalità di debug, se non l'hai già fatto");
            debug("!Impossibile connettersi al database, verifica la configurazione");
        }

    }

}

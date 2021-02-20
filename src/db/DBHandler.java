package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import endpoint.Actor;
import gui.MainViewer;

public class DBHandler extends Actor {

    private String query;
    private boolean requiresOutput;

    public DBHandler(String query) {
        this.query = query;
        this.requiresOutput = false;

        if (this.query.substring(0, 6).equalsIgnoreCase("SELECT")) {
            debug("?Rilevata una query di selezione, di cui è prevista la stampa");
            this.requiresOutput = true;
        } else
            debug("?Rilevata una query di aggiornamento, rimozione o inserimento, di cui non è prevista alcuna stampa");

        launchQuery();
    }

    private void launchQuery() {
        try {
            Statement stat = DBConnectionPool.getConnection().createStatement();

            debug(":Connessione al database rinvenuta senza problemi");
            debug("?Preparo lo statement...");

            ResultSet result;

            if (requiresOutput) {
                result = stat.executeQuery(this.query);

                MainViewer.display(":Query eseguita con successo!");
                MainViewer.display("Risultati della query:<br />");

                while (result.next()) {
                    MainViewer.display("Stampa...");
                }
            } else {
                stat.executeUpdate(this.query);

                MainViewer.display(":Query eseguita con successo!");
                MainViewer.display(":Controllare il database per verificare i cambiamenti.");
            }

        } catch (SQLException e) {
            debug("!Impossibile elaborare la query SQL. Ricontrolla la configurazione");
            MainViewer.display("!La query non ha generato alcun risultato.");
        }

    }

}

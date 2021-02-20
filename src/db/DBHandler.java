package db;

import java.sql.Connection;
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
            Connection connection = DBConnectionPool.getConnection();
            Statement stat = connection.createStatement();

            connection.setAutoCommit(true);

            debug(":Connessione al database rinvenuta senza problemi");
            debug("?Preparo lo statement...");

            ResultSet result;

            if (requiresOutput) {
                System.out.println("SELECT...");
                System.out.println(this.query);

                result = stat.executeQuery(this.query);

                MainViewer.display(":Query eseguita con successo!");
                MainViewer.display("Risultati della query:<br />");

                java.sql.ResultSetMetaData resultMetaData = result.getMetaData();
                int cols = resultMetaData.getColumnCount();

                result.last();

                int rows = result.getRow();

                debug(":Numero di righe selezionate: " + rows);

                result.first();
                result.previous();

                if (rows != 0) {
                    while (result.next()) {
                        String output = "— ";

                        for (int i = 1; i <= cols; i++)
                            output += result.getString(i) + " ";

                        MainViewer.display(output);
                    }
                } else
                    MainViewer.display("!Non è stato possibile trovare alcun risultato.");

                MainViewer.display("<br />");
            } else {
                System.out.println("DELETE, UPDATE, INSERT...");
                System.out.println(this.query);

                stat.executeUpdate(this.query);

                MainViewer.display(":Query eseguita con successo!");
                MainViewer.display("Controllare il database per verificare eventuali cambiamenti.<br />");
            }

        } catch (SQLException e) {
            debug("!Impossibile elaborare la query SQL. Ricontrolla la configurazione");
            MainViewer.display("!La query non ha generato alcun risultato.");
        } finally {
            debug("#In attesa di altre operazioni...");
        }

    }

}

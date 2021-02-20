package db;

import endpoint.Actor;
import gui.MainViewer;

public class DBHandler extends Actor {

    private String query;

    public DBHandler(String query) {
        this.query = query;

        debug(":Connessione al database rinvenuta senza problemi");
        MainViewer.display("Connessione al database...");
    }

}

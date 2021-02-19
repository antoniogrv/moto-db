package endpoint;

import config.Config;
import debug.DebugFrame;
import gui.MainViewer;

public class MotoDB extends Actor {

    public MotoDB() {
        if(Config.DEBUG_MODE)
            new DebugFrame();
        debug(":Configurazione caricata con successo");
        new MainViewer();
    }

}

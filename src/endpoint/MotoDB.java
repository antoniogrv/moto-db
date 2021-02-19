package endpoint;

import config.Config;
import debug.DebugFrame;

public class MotoDB extends Actor {

    public MotoDB() {
        if(Config.DEBUG_MODE)
            new DebugFrame();
        debug(":Applicazione avviata con successo");
    }

}

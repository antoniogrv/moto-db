package endpoint;

import config.Config;
import debug.DebugViewer;

public abstract class Actor {

    public final String Actor = getActor();

    protected String getActor() {
        return "«" + getClass().getSimpleName() + "» ";
    }

    public void debug(String message) {
        if (Config.DEBUG_MODE)
            DebugViewer.printMessage(message.charAt(0) + Actor + message.substring(1));
    }

}

package endpoint;

import config.Config;
import debug.DebugViewer;

public abstract class Actor {

    /*
     * Definisce gli 'attori' del software, e cioè tutti coloro che creano, eseguono
     * oppure visualizzano qualcosa. Gli attori vengono identificati in fase di
     * debug. L'utilità giace nella capacità dello sviluppatore di capire chi è
     * responsabile di cosa. Gli attori, dunque, permettono, nel caso di fallimento
     * di uno o più compartimenti del software, di identificare i responsabili e
     * agire preventivamente per risolvere il problema. Se la modalità di debug è
     * disattivata, l'utilità ultima di questa superclasse è vana.
     */

    public final String Actor = getActor();

    protected String getActor() {
        return "«" + getClass().getSimpleName() + "» ";
    }

    public void debug(String message) {
        if (Config.DEBUG_MODE)
            DebugViewer.DebugFrame.printMessage(message.charAt(0) + Actor + message.substring(1));
    }

}

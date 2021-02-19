package config;

import java.util.*;
import endpoint.*;

public class Config {
    /*
     * Modifica questo file per generare la tua GUI. Non modificare nessun altro
     * file.
     */

    public static void setConfigurations() {

        /*
         * Definire il nome del proprio progetto. Esempi: "scuola, centro estetico [..]"
         */
        PROJECT_NAME = "Il mio progetto";

        /*
         * [! CONFIGURAZIONE ESSENZIALE]
         * 
         * Definisci di seguente le credenziali di accesso al database.
         * 
         * E' possibile fornire anche le credenziali dell'utente root .. .. creato, in
         * genere, durante l'installazione di MySQL Workbench.
         * 
         * In ogni caso, è possibile connettersi a qualsiasi utente e database .. ..
         * ospitato sul proprio localhost.
         */
        DB_NAME = "db_example";
        DB_USERNAME = "user";
        DB_PASSWORD = "psw";

        /*
         * [! CONFIGURAZIONE ESSENZIALE]
         * 
         * Questo software, per funzionare correttamente, ha bisogno di query -- da qui
         * in poi definite come OPERAZIONI. Le operazioni fornite di seguito saranno
         * utilizzate per generare le interfacce grafiche.
         * 
         * Le operazioni vanno elaborate come stringhe letterali. Tuttavia, è necessario
         * aggiungere alcuni parametri (detti FLAGS) per assicurare la corretta
         * elaborazione delle query.
         * 
         * Si invita caldamente, prima di aggiungere un'operazione alla seguente lista,
         * di consultare la documentazione.
         */
        Operations.addAll(Arrays.asList(new Operation[] {
                /* Operazione .01 */
                new Operation("SELECT * FROM professori", "Seleziona tutti i professori della scuola."),
                /* Operazione .02 */
                new Operation("SELECT nome FROM studente WHERE matricola = matricola.value",
                        "Seleziona il nome dello studente selezionato tramite matricola.") }));

        /*
         * Attiva la modalità di debug. La modalità di debug abiliterà la generazion di
         * un frame shell-like per visualizzare costantemente le azioni degli attori del
         * software.
         * 
         * Si consiglia di disattivare l'opzione alla discussione del progetto.
         */
        DEBUG_MODE = true;

        /*
         * Impostazioni del frame di debug. Le dimensioni sono espresse in {Larghezza,
         * Altezza}.
         */
        DEBUG_VIEWER_FRAME_TITLE = PROJECT_NAME + " - Debug";
        DEBUG_VIEWER_FRAME_SIZE = new int[] { 500, 700 };

        /*
         * Colori del frame di debug.
         */
        DEBUG_VIEWER_FRAME_OUTER_BACKGROUND = "#202124";
        DEBUG_VIEWER_FRAME_INNER_BACKGROUND = "#191A1C";

        /*
         * Colori delle notifiche del frame di debug.
         */
        DEBUG_VIEWER_FRAME_COLOR_SUCCESS = "#81EE90";
        DEBUG_VIEWER_FRAME_COLOR_FAIL = "#F26F72";
        DEBUG_VIEWER_FRAME_COLOR_WAIT = "#E4D357";

        /*
         * Spaziatura esterna ed interna del frame di debug in pixel. Le dimensioni sono
         * espresse nell'ordine {Top, Left, Bottom, Right}.
         */
        DEBUG_VIEWER_FRAME_OUTER_PADDING = new int[] { 8, 8, 8, 8 };
        DEBUG_VIEWER_FRAME_INNER_PADDING = new int[] { 12, 12, 12, 12 };

        /*
         * Impostazioni del frame principale (da qui in poi MainViewer) di selezione
         * delle operazioni. Le dimensioni sono espresse in {Larghezza, Altezza}.
         */
        MAIN_VIEWER_FRAME_TITLE = PROJECT_NAME;
        MAIN_VIEWER_FRAME_SIZE = new int[] { 650, 550 };

        /*
         * Colori del MainViewer.
         */
        MAIN_VIEWER_FRAME_OUTER_BACKGROUND = "#1d1e21";
        MAIN_VIEWER_FRAME_INNER_BACKGROUND = "#191A1C";

        /*
         * Spaziatura esterna ed interna del frame di debug in pixel. Le dimensioni sono
         * espresse nell'ordine {Top, Left, Bottom, Right}.
         */
        MAIN_VIEWER_FRAME_OUTER_PADDING = new int[] { 8, 8, 8, 8 };
        MAIN_VIEWER_FRAME_INNER_PADDING = new int[] { 12, 12, 12, 12 };

        /*
         * Impostazioni del carattere dell'area dei risultati.
         */
        MAIN_VIEWER_FRAME_RESULT_FONT = "Open Sans";
        MAIN_VIEWER_FRAME_RESULT_FONT_SIZE = 14;

        /*
         * Colore di background dei bottoni laterali del MainFrame. Il flag 'HOVER' sta
         * ad indicare il colore di background del bottone selezionato dall'utente col
         * mouse.
         */
        MAIN_VIEWER_FRAME_BUTTON_BACKGROUND = "#191A1C";
        MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER = "#1d1e21";

        /*
         * Spaziatura interna dei singoli bottoni.
         */
        MAIN_VIEWER_FRAME_BUTTON_PADDING = new int[] { 10, -4, -4, -5 };

        /*
         * Impostazioni del carattere dei bottoni laterali del MainFrame.
         */
        MAIN_VIEWER_FRAME_BUTTON_FONT = "Open Sans";
        MAIN_VIEWER_FRAME_BUTTON_FONT_SIZE = 14;

        /*
         * Impostazioni della scrollbar interna del MainFrame.
         */
        SCROLLBAR_THUMB = MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;
        SCROLLBAR_THUMB_DARK_SHADOW = MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;
        SCROLLBAR_THUMB_SHADOW = MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;
        SCROLLBAR_THUMB_HIGHLIGHT = MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;
        SCROLLBAR_TRACK = MAIN_VIEWER_FRAME_INNER_BACKGROUND;
        SCROLLBAR_BORDER = MAIN_VIEWER_FRAME_INNER_BACKGROUND;

        /*
         * Testo predefinito che compare al lancio dell'applicazion.
         */

        MAIN_VIEWER_FRAME_DEFAULT_TEXT = "Bentornato!";

        /*
         * Spaziatura interna ed esterna dell'area di testo dei risultati nel MainFrame.
         */

        MAIN_VIEWER_FRAME_RESULT_OUTER_PADDING = new int[] { 15, 15, 15, 15 };
        MAIN_VIEWER_FRAME_RESULT_INNER_PADDING = new int[] { 5, 5, 5, 5 };

        /*
         * Impostazioni del frame principale (da qui in poi MainViewer) di selezione
         * delle operazioni. Le dimensioni sono espresse in {Larghezza, Altezza}.
         */
        QUERY_VIEWER_FRAME_TITLE = PROJECT_NAME + " - Operazione";
        QUERY_VIEWER_FRAME_SIZE = new int[] { 400, 400 };

        /*
         * Abilita la colorazione scura della GUI. Impostare a 'false' per usare la
         * modalità chiara. Nella 1.00 è disponibile esclusivamente la dark mode, dunque
         * cambiare la seguente impostazione non produrrà alcun effetto, per ora.
         */
        DARK_MODE = true;

        /*
         * Impostazione dell'icona per ogni frame dell'applicazione. Se si desidera
         * cambiare l'icona, si suggerisce di limitarsi a cambiare l'immagine .png ..
         * specifica nel path sottostante, e non cambiare il path stesso.
         */
        MOTODB_ICON_PATH = "./src/static/icon.png";

        /*
         * Se abilitato, riempirà l'area di testo dei risultati con un testo
         * predefinito. Utile per testare il layout. Il COUNT determina la quantità di
         * frasi da stampare a video.
         */
        LOREM_IPSUM = false;
        LOREM_IPSUM_COUNT = 50;
    }

    public static String PROJECT_NAME;

    public static String DB_NAME;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;

    public static boolean DEBUG_MODE;

    public static String DEBUG_VIEWER_FRAME_TITLE;
    public static int[] DEBUG_VIEWER_FRAME_SIZE;

    public static String DEBUG_VIEWER_FRAME_OUTER_BACKGROUND;
    public static String DEBUG_VIEWER_FRAME_INNER_BACKGROUND;

    public static int[] DEBUG_VIEWER_FRAME_OUTER_PADDING;
    public static int[] DEBUG_VIEWER_FRAME_INNER_PADDING;

    public static String DEBUG_VIEWER_FRAME_COLOR_SUCCESS;
    public static String DEBUG_VIEWER_FRAME_COLOR_FAIL;
    public static String DEBUG_VIEWER_FRAME_COLOR_WAIT;

    public static String MAIN_VIEWER_FRAME_TITLE;
    public static int[] MAIN_VIEWER_FRAME_SIZE;

    public static String MAIN_VIEWER_FRAME_OUTER_BACKGROUND;
    public static String MAIN_VIEWER_FRAME_INNER_BACKGROUND;

    public static int[] MAIN_VIEWER_FRAME_OUTER_PADDING;
    public static int[] MAIN_VIEWER_FRAME_INNER_PADDING;

    public static String MAIN_VIEWER_FRAME_BUTTON_BACKGROUND;
    public static String MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;

    public static String MAIN_VIEWER_FRAME_BUTTON_FONT;
    public static int MAIN_VIEWER_FRAME_BUTTON_FONT_SIZE;

    public static int[] MAIN_VIEWER_FRAME_BUTTON_PADDING;

    public static String MAIN_VIEWER_FRAME_RESULT_FONT;
    public static int MAIN_VIEWER_FRAME_RESULT_FONT_SIZE;

    public static String SCROLLBAR_THUMB;
    public static String SCROLLBAR_THUMB_SHADOW;
    public static String SCROLLBAR_THUMB_DARK_SHADOW;
    public static String SCROLLBAR_THUMB_HIGHLIGHT;
    public static String SCROLLBAR_TRACK;
    public static String SCROLLBAR_BORDER;

    public static String MAIN_VIEWER_FRAME_DEFAULT_TEXT;

    public static int[] MAIN_VIEWER_FRAME_RESULT_OUTER_PADDING;
    public static int[] MAIN_VIEWER_FRAME_RESULT_INNER_PADDING;

    public static String QUERY_VIEWER_FRAME_TITLE;
    public static int[] QUERY_VIEWER_FRAME_SIZE;

    public static boolean DARK_MODE;

    public static String MOTODB_ICON_PATH;

    public static boolean LOREM_IPSUM;
    public static int LOREM_IPSUM_COUNT;

    public static ArrayList<Operation> Operations = new ArrayList<Operation>();

}

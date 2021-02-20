package config;

import java.util.*;
import endpoint.*;

public class Config {
    /*
     * Modifica questo file per generare la tua GUI. Modificare un qualsiasi altro
     * file che non sia questo potrebbe compromettere il corretto funzionamento del
     * software.
     */

    /*
     * [!] CONFIGURAZIONI ESSENZIALI - Le successive quattro configurazioni (nome
     * del progetto, nome del database, nome utente del database, password del
     * database, lista di operazioni, debug mode, sono ritenute essenziali da
     * modificare per permette al software di funzione correttamente.
     * 
     * In particolare, sarà necessario riempire la lista delle operazioni OPERATIONS
     * in base alle proprie necessità, e seguendo scrupolosamente la documentazione.
     */

    /*
     * Definisci il nome del tuo progetto. Esempi: "scuola, centro estetico [..]"
     */
    public static final String PROJECT_NAME = "Il mio progetto";

    /*
     * Definisci di seguente le credenziali di accesso al database.
     * 
     * E' possibile fornire anche le credenziali dell'utente root .. .. creato, in
     * genere, durante l'installazione di MySQL Workbench.
     * 
     * In ogni caso, è possibile connettersi a qualsiasi utente e database .. ..
     * ospitato sul proprio localhost.
     */
    public static final String DB_NAME = "db_example";
    public static final String DB_USERNAME = "user";
    public static final String DB_PASSWORD = "psw";

    /*
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

    public static ArrayList<Operation> Operations = new ArrayList<Operation>(
            Arrays.asList(new Operation("SELECT * FROM professori", "Seleziona tutti i professori della scuola."),
                    new Operation("SELECT nome FROM studente WHERE matricola = matricola.value",
                            "Seleziona il nome dello studente selezionato tramite matricola.")));

    /*
     * Attiva o disattiva la modalità di debug.La modalità di debug abiliterà la*
     * generazion di un frame shell-like per visualizzare costantemente le azioni*
     * degli attori del software.** Si consiglia di disattivare l'opzione alla
     * discussione del progetto.
     */
    public static final boolean DEBUG_MODE = true;

    /*
     * [!] CONFIGURAZIONI NON ESSENZIALI
     * 
     * Se non sei interessato a cambiare l'aspetto del programma, ignora tutto ciò
     * che è configurato di seguente.
     */

    /*
     * Impostazioni del frame di debug. Le dimensioni sono espresse in {Larghezza,
     * Altezza}.
     */
    public static final String DEBUG_VIEWER_FRAME_TITLE = PROJECT_NAME + " - Debug";
    public static final int[] DEBUG_VIEWER_FRAME_SIZE = new int[] { 500, 700 };

    /*
     * Colori del frame di debug.
     */
    public static final String DEBUG_VIEWER_FRAME_OUTER_BACKGROUND = "#202124";
    public static final String DEBUG_VIEWER_FRAME_INNER_BACKGROUND = "#191A1C";

    /*
     * Colori delle notifiche del frame di debug.
     */
    public static final String DEBUG_VIEWER_FRAME_COLOR_SUCCESS = "#81EE90";
    public static final String DEBUG_VIEWER_FRAME_COLOR_FAIL = "#F26F72";
    public static final String DEBUG_VIEWER_FRAME_COLOR_WAIT = "#E4D357";

    /*
     * Spaziatura esterna ed interna del frame di debug in pixel. Le dimensioni sono
     * espresse nell'ordine {Top, Left, Bottom, Right}.
     */
    public static final int[] DEBUG_VIEWER_FRAME_OUTER_PADDING = new int[] { 8, 8, 8, 8 };
    public static final int[] DEBUG_VIEWER_FRAME_INNER_PADDING = new int[] { 12, 12, 12, 12 };

    /*
     * Impostazioni del frame principale (da qui in poi MainViewer) di selezione
     * delle operazioni. Le dimensioni sono espresse in {Larghezza, Altezza}.
     */
    public static final String MAIN_VIEWER_FRAME_TITLE = PROJECT_NAME;
    public static final int[] MAIN_VIEWER_FRAME_SIZE = new int[] { 650, 550 };

    /*
     * Colori del MainFrame.
     */
    public static final String MAIN_VIEWER_FRAME_OUTER_BACKGROUND = "#1d1e21";
    public static final String MAIN_VIEWER_FRAME_INNER_BACKGROUND = "#191A1C";

    /*
     * Spaziatura esterna ed interna del frame di debug in pixel. Le dimensioni sono
     * espresse nell'ordine {Top, Left, Bottom, Right}.
     */
    public static final int[] MAIN_VIEWER_FRAME_OUTER_PADDING = new int[] { 8, 8, 8, 8 };
    public static final int[] MAIN_VIEWER_FRAME_INNER_PADDING = new int[] { 12, 12, 12, 12 };

    /*
     * Impostazioni del carattere dell'area dei risultati.
     */
    public static final String MAIN_VIEWER_FRAME_RESULT_FONT = "Open Sans";
    public static final int MAIN_VIEWER_FRAME_RESULT_FONT_SIZE = 14;

    /*
     * Colore di background dei bottoni laterali del MainFrame. Il flag 'HOVER' sta
     * ad indicare il colore di background del bottone selezionato dall'utente col
     * mouse.
     */
    public static final String MAIN_VIEWER_FRAME_BUTTON_BACKGROUND = "#191A1C";
    public static final String MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER = "#1d1e21";

    /*
     * Spaziatura interna dei singoli bottoni.
     */
    public static final int[] MAIN_VIEWER_FRAME_BUTTON_PADDING = new int[] { 10, -4, -4, -5 };

    /*
     * Impostazioni del carattere dei bottoni laterali del MainFrame.
     */
    public static final String MAIN_VIEWER_FRAME_BUTTON_FONT = "Open Sans";
    public static final int MAIN_VIEWER_FRAME_BUTTON_FONT_SIZE = 14;

    /*
     * Impostazioni della scrollbar interna del MainFrame.
     */
    public static final String SCROLLBAR_THUMB = MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;
    public static final String SCROLLBAR_THUMB_DARK_SHADOW = MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;
    public static final String SCROLLBAR_THUMB_SHADOW = MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;
    public static final String SCROLLBAR_THUMB_HIGHLIGHT = MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER;
    public static final String SCROLLBAR_TRACK = MAIN_VIEWER_FRAME_INNER_BACKGROUND;
    public static final String SCROLLBAR_BORDER = MAIN_VIEWER_FRAME_INNER_BACKGROUND;

    /*
     * Testo predefinito che compare al lancio dell'applicazion.
     */

    public static final String MAIN_VIEWER_FRAME_DEFAULT_TEXT = "Bentornato!";

    /*
     * Spaziatura interna ed esterna dell'area di testo dei risultati nel MainFrame.
     */

    public static final int[] MAIN_VIEWER_FRAME_RESULT_OUTER_PADDING = new int[] { 15, 15, 15, 15 };
    public static final int[] MAIN_VIEWER_FRAME_RESULT_INNER_PADDING = new int[] { 5, 5, 5, 5 };

    /*
     * Impostazioni del frame principale (da qui in poi MainViewer) di selezione
     * delle operazioni. Le dimensioni sono espresse in {Larghezza, Altezza}.
     */
    public static final String QUERY_VIEWER_FRAME_TITLE = PROJECT_NAME + " - Operazione";
    public static final int[] QUERY_VIEWER_FRAME_SIZE = new int[] { 500, 500 };

    /*
     * Colori del QueryFrame.
     */
    public static final String QUERY_VIEWER_FRAME_OUTER_BACKGROUND = "#1d1e21";
    public static final String QUERY_VIEWER_FRAME_INNER_BACKGROUND = "#191A1C";

    /*
     * Impostazioni per la spaziatura interna ed esterna del QueryFrame generato dal
     * QueryViewer.
     */
    public static final int[] QUERY_VIEWER_FRAME_OUTER_PADDING = new int[] { 5, 5, 5, 5 };
    public static final int[] QUERY_VIEWER_FRAME_INNER_PADDING = new int[] { 15, 15, 15, 15 };

    /*
     * Spaziature dei componenti del QueryFrame. Questa sezione non include le
     * spaziature interne ed esterne del frame; include, invece: le spaziature dei
     * campi di testo interni ed esterni; le spaziature del bottone di invio; la
     * spaziatura della descrizione.
     */
    public static final int[] QUERY_VIEWER_INNER_FIELD_PADDING = new int[] { 0, 0, 0, 0 };
    public static final int[] QUERY_VIEWER_FIELD_INNER_ROW_PADDING = new int[] { 0, 0, 0, 0 };
    public static final int[] QUERY_VIEWER_FIELD_OUTER_ROW_PADDING = new int[] { 0, 0, 0, 0 };
    public static final int[] QUERY_VIEWER_FRAME_BUTTON_PADDING = new int[] { 0, 0, 0, 0 };
    public static final int[] QUERY_VIEWER_OUTER_FIELD_PADDING = new int[] { 0, 0, 0, 0 };
    public static final int[] QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING = new int[] { 0, 0, 0, 0 };

    /*
     * Famiglie dei caratteri usati nel QueryFrame.
     */

    public static final String QUERY_VIEWER_FIELD_LABEL_FONT = "Open Sans";
    public static final String QUERY_VIEWER_ENTER_BUTTON_FONT = "Open Sans";
    public static final String QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT = "Open Sans";

    /*
     * Colori dei caratteri usati nel QueryFrame.
     */

    public static final String QUERY_VIEWER_FIELD_LABEL_FONT_COLOR = "#ffffff";
    public static final String QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT_COLOR = "#ffffff";

    /*
     * Dimensione dei caratteri usati nel QueryFrame.
     */

    public static final int QUERY_VIEWER_FIELD_LABEL_FONT_SIZE = 15;
    public static final int QUERY_VIEWER_FRAME_ENTER_BUTTON_FONT_SIZE = 15;
    public static final int QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT_SIZE = 15;

    /*
     * Colori dei componenti del QueryFrame, dagli sfondi del frame a quello del
     * bottone di invio.
     */

    public static final String QUERY_VIEWER_FRAME_INNER_ROW_BACKGROUND = "#ffffff";
    public static final String QUERY_VIEWER_FRAME_ENTER_BUTTON_BACKGROUND = "#ffffff";
    public static final String QUERY_VIEWER_FRAME_BUTTON_BACKGROUND = "#ffffff";
    public static final String QUERY_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER = "#ffffff";
    public static final String QUERY_VIEWER_ROW_OUTER_ROW_BACKGROUND = "#ffffff";
    public static final String QUERY_VIEWER_FRAME_GRID_BACKGROUND = "#ffffff";
    public static final String QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_BACKGROUND = "#ffffff";
    public static final String QUERY_VIEWER_OUTER_FIELD_BACKGROUND = "#FFFFFF";

    /*
     * Label sul bottone di invio del QueryFrame.
     */
    public static final String QUERY_VIEWER_FRAME_ENTER_TEXT = "Esegui";

    /*
     * Abilita la colorazione scura della GUI. Impostare a 'false' per usare la
     * modalità chiara. Nella 1.00 è disponibile esclusivamente la dark mode, dunque
     * cambiare la seguente impostazione non produrrà alcun effetto, per ora.
     */
    public static final boolean DARK_MODE = true;

    /*
     * Impostazione dell'icona per ogni frame dell'applicazione. Se si desidera
     * cambiare l'icona, si suggerisce di limitarsi a cambiare l'immagine .png ..
     * specifica nel path sottostante, e non cambiare il path stesso.
     */
    public static final String MOTODB_ICON_PATH = "./src/static/icon.png";

    /*
     * Se abilitato, riempirà l'area di testo dei risultati con un testo
     * predefinito. Utile per testare il layout. Il COUNT determina la quantità di
     * frasi da stampare a video.
     */
    public static final boolean LOREM_IPSUM = false;
    public static final int LOREM_IPSUM_COUNT = 50;

}

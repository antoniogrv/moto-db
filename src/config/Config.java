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
        public static final String DB_NAME = "example_database";
        public static final String DB_USERNAME = "example_username";
        public static final String DB_PASSWORD = "example_password";

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
        public static ArrayList<Operation> Operations = new ArrayList<Operation>(Arrays.asList(
                        // Operazione 1
                        new Operation("SELECT * FROM example_table", "Seleziona tutti i dati di esempio."),
                        // Operazione 2
                        new Operation("SELECT nome FROM example_table WHERE id = {ID Esempio}",
                                        "Seleziona solo la colonna 'nome' dai dati d'esempio, in base all'ID."),
                        // Operazione 3
                        new Operation("SELECT id FROM example_table WHERE nome = \"{Nome}\" AND cognome = \"{Cognome}\"",
                                        "Seleziona solo la colonna 'id' dai dati d'esempio, in base al nome e al cognome."),
                        // Operazione 4
                        new Operation("DELETE FROM example_table", "Svuota la tabella d'esempio.")));

        /*
         * Attiva o disattiva la modalità di debug.La modalità di debug abiliterà la
         * generazion di un frame shell-like per visualizzare costantemente le azioni
         * degli attori del software.
         * 
         * Si consiglia di disattivare l'opzione alla discussione del progetto.
         */
        public static final boolean DEBUG_MODE = true;

        /*
         * [!] CONFIGURAZIONI NON ESSENZIALI
         * 
         * Se non sei interessato a cambiare l'aspetto del programma, ignora tutto ciò
         * che è elencato di seguente.
         */

        /*
         * Famiglie di caratteri usati nelle stampe a video. Include il colore e la
         * dimensione predefinita.
         */
        public static final String DEFAULT_FONT = "Open Sans";
        public static final String DEFAULT_FONT_COLOR = "#FFFFFF";
        public static final int DEFAULT_FONT_SIZE = 15;

        /*
         * Colori principali della Dark Mode.
         */
        public static final String DARK_OUTER = "#202124";
        public static final String DARK_INNER = "#191A1C";
        public static final String DARK_OUTER_LIGHTER = "#1D1E21";

        /*
         * Colori principali della Light Mode.
         */
        public static final String LIGHT_OUTER = "#DDDDDD";
        public static final String LIGHT_INNER = "#EEEEEE";
        public static final String LIGHT_OUTER_LIGHTER = "#FFFFFF";

        /*
         * Impostazioni del frame di debug. Le dimensioni dei frame sono sempre espresse
         * in {Larghezza, Altezza}.
         */
        public static final String DEBUG_VIEWER_FRAME_TITLE = PROJECT_NAME + " - Debug";
        public static final int[] DEBUG_VIEWER_FRAME_SIZE = new int[] { 500, 700 };

        /*
         * Colori del frame di debug.
         */
        public static final String DEBUG_VIEWER_FRAME_OUTER_BACKGROUND = DARK_OUTER;
        public static final String DEBUG_VIEWER_FRAME_INNER_BACKGROUND = DARK_INNER;

        /*
         * Configurazione del testo del frame di debug.
         */
        public static final String DEBUG_VIEWER_FRAME_FONT = "\"Inconsolata\", monospace";
        public static final int DEBUG_VIEWER_FRAME_FONT_SIZE = 17;

        /*
         * Colori delle notifiche del frame di debug.
         */
        public static final String DEBUG_VIEWER_FRAME_COLOR_SUCCESS = "#81EE90";
        public static final String DEBUG_VIEWER_FRAME_COLOR_FAIL = "#F26F72";
        public static final String DEBUG_VIEWER_FRAME_COLOR_WAIT = "#E4D357";
        public static final String DEBUG_VIEWER_FRAME_COLOR_NOTIFY = "#84A5FF";

        /*
         * Spaziatura esterna ed interna del frame di debug in pixel. Le dimensioni sono
         * espresse nell'ordine {Top, Left, Bottom, Right}.
         */
        public static final int[] DEBUG_VIEWER_FRAME_OUTER_PADDING = new int[] { 8, 8, 8, 8 };
        public static final int[] DEBUG_VIEWER_FRAME_INNER_PADDING = new int[] { 12, 12, 12, 12 };

        /*
         * Impostazioni del frame principale (da qui in poi MainFrame) di selezione
         * delle operazioni. Le dimensioni sono espresse in {Larghezza, Altezza}.
         */
        public static final String MAIN_VIEWER_FRAME_TITLE = PROJECT_NAME;
        public static final int[] MAIN_VIEWER_FRAME_SIZE = new int[] { 850, 550 };

        /*
         * Colori del MainFrame.
         */
        public static final String MAIN_VIEWER_FRAME_OUTER_BACKGROUND = DARK_OUTER_LIGHTER;
        public static final String MAIN_VIEWER_FRAME_INNER_BACKGROUND = DARK_INNER;

        /*
         * Spaziatura esterna ed interna del frame di debug in pixel. Le dimensioni sono
         * espresse nell'ordine {Top, Left, Bottom, Right}.
         */
        public static final int[] MAIN_VIEWER_FRAME_OUTER_PADDING = new int[] { 8, 8, 8, 8 };
        public static final int[] MAIN_VIEWER_FRAME_INNER_PADDING = new int[] { 12, 12, 12, 12 };

        /*
         * Impostazioni del carattere dell'area dei risultati.
         */
        public static final String MAIN_VIEWER_FRAME_RESULT_FONT = DEFAULT_FONT;
        public static final int MAIN_VIEWER_FRAME_RESULT_FONT_SIZE = DEFAULT_FONT_SIZE;

        /*
         * Colore di background dei bottoni laterali del MainFrame. Il flag 'HOVER' sta
         * ad indicare il colore di background del bottone selezionato dall'utente col
         * mouse.
         */
        public static final String MAIN_VIEWER_FRAME_BUTTON_BACKGROUND = DARK_INNER;
        public static final String MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER = DARK_OUTER_LIGHTER;

        /*
         * Spaziatura interna dei singoli bottoni nel MainFrame.
         */
        public static final int[] MAIN_VIEWER_FRAME_OUTER_BUTTON_PADDING = new int[] { 10, -4, -4, -5 };
        public static final int[] MAIN_VIEWER_FRAME_INNER_BUTTON_PADDING = new int[] { 2, 20, 2, 20 };

        /*
         * Impostazioni del carattere dei bottoni laterali del MainFrame.
         */
        public static final String MAIN_VIEWER_FRAME_BUTTON_FONT = DEFAULT_FONT;
        public static final int MAIN_VIEWER_FRAME_BUTTON_FONT_SIZE = DEFAULT_FONT_SIZE;

        /*
         * Impostazioni della scrollbar interna del MainFrame.
         */
        public static final String SCROLLBAR_THUMB = DARK_OUTER_LIGHTER;
        public static final String SCROLLBAR_THUMB_DARK_SHADOW = DARK_OUTER_LIGHTER;
        public static final String SCROLLBAR_THUMB_SHADOW = DARK_OUTER_LIGHTER;
        public static final String SCROLLBAR_THUMB_HIGHLIGHT = DARK_OUTER_LIGHTER;
        public static final String SCROLLBAR_TRACK = MAIN_VIEWER_FRAME_INNER_BACKGROUND;
        public static final String SCROLLBAR_BORDER = MAIN_VIEWER_FRAME_INNER_BACKGROUND;

        /*
         * Testi e impostazioni predefinite per i messaggi stampati a schermo. Si invita
         * a consultare la documentazione in caso di dubbio.
         */
        public static final String MAIN_VIEWER_FRAME_DEFAULT_TEXT = "Bentornato!<br />";

        public static final String MAIN_VIEWER_FRAME_NO_INPUT_TEXT = "Non sono ammessi campi non compilati!";

        public static final String DISPLAY_FAIL_FONT = DEFAULT_FONT;
        public static final String DISPLAY_FAIL_FONT_COLOR = DEBUG_VIEWER_FRAME_COLOR_FAIL;
        public static final int DISPLAY_FAIL_FONT_SIZE = DEFAULT_FONT_SIZE;

        public static final String DISPLAY_REGULAR_FONT = DEFAULT_FONT;
        public static final String DISPLAY_REGULAR_FONT_COLOR = DEFAULT_FONT_COLOR;
        public static final int DISPLAY_REGULAR_FONT_SIZE = DEFAULT_FONT_SIZE;

        public static final String DISPLAY_SUCCESS_FONT = DEFAULT_FONT;
        public static final String DISPLAY_SUCCESS_FONT_COLOR = DEBUG_VIEWER_FRAME_COLOR_SUCCESS;
        public static final int DISPLAY_SUCCESS_FONT_SIZE = DEFAULT_FONT_SIZE;

        public static final String DISPLAY_CODE_FONT = DEBUG_VIEWER_FRAME_FONT;
        public static final String DISPLAY_CODE_FONT_COLOR = "#AA60FF";
        public static final int DISPLAY_CODE_FONT_SIZE = 16;

        /*
         * Determina se stampare pubblicamente o meno la query elaborata dal QueryFrame,
         * a prescindere dalla modalità di debug
         */
        public static final boolean DISPLAY_QUERIES = true;

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
        public static final String QUERY_VIEWER_FRAME_OUTER_BACKGROUND = DARK_OUTER_LIGHTER;
        public static final String QUERY_VIEWER_FRAME_INNER_BACKGROUND = DARK_INNER;

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
        public static final int[] QUERY_VIEWER_FRAME_INNER_FIELD_PADDING = new int[] { 0, 0, 0, 0 };
        public static final int[] QUERY_VIEWER_FRAME_OUTER_FIELD_PADDING = new int[] { 0, 0, 0, 10 };
        public static final int[] QUERY_VIEWER_FRAME_ROW_PADDING = new int[] { 10, 5, 10, 5 };
        public static final int[] QUERY_VIEWER_FRAME_BUTTON_PADDING = new int[] { 2, 20, 2, 20 };
        public static final int[] QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING = new int[] { 5, 0, 5, 0 };

        /*
         * Famiglie dei caratteri usati nel QueryFrame.
         */
        public static final String QUERY_VIEWER_FRAME_INNER_FIELD_LABEL_FONT = DEFAULT_FONT;
        public static final String QUERY_VIEWER_FRAME_ENTER_BUTTON_FONT = DEFAULT_FONT;
        public static final String QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT = DEFAULT_FONT;

        /*
         * Colori dei caratteri usati nel QueryFrame.
         */
        public static final String QUERY_VIEWER_FRAME_INNER_FIELD_LABEL_FONT_COLOR = DEFAULT_FONT_COLOR;
        public static final String QUERY_VIEWER_FRAME_ENTER_BUTTON_FONT_COLOR = DEFAULT_FONT_COLOR;
        public static final String QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT_COLOR = DEFAULT_FONT_COLOR;

        /*
         * Dimensione dei caratteri usati nel QueryFrame.
         */
        public static final int QUERY_VIEWER_FRAME_INNER_FIELD_LABEL_FONT_SIZE = DEFAULT_FONT_SIZE;
        public static final int QUERY_VIEWER_FRAME_ENTER_BUTTON_FONT_SIZE = DEFAULT_FONT_SIZE;
        public static final int QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT_SIZE = DEFAULT_FONT_SIZE;

        /*
         * Colori dei componenti del QueryFrame, dagli sfondi del frame a quello del
         * bottone di invio.
         */
        public static final String QUERY_VIEWER_FRAME_ROW_BACKGROUND = DARK_OUTER_LIGHTER;
        public static final String QUERY_VIEWER_FRAME_BUTTON_BACKGROUND = DARK_OUTER;
        public static final String QUERY_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER = DARK_OUTER_LIGHTER;
        public static final String QUERY_VIEWER_FRAME_GRID_BACKGROUND = DARK_OUTER_LIGHTER;
        public static final String QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_BACKGROUND = DARK_OUTER_LIGHTER;
        public static final String QUERY_VIEWER_FRAME_OUTER_FIELD_BACKGROUND = DARK_OUTER_LIGHTER;

        /*
         * Label sul bottone di invio del QueryFrame.
         */
        public static final String QUERY_VIEWER_FRAME_ENTER_TEXT = "Esegui";

        /*
         * Numero minimo di righe nella griglia del QueryFrame. Un numero troppo basso
         * potrebbe compromettere il layout.
         */
        public static final int QUERY_VIEWER_FRAME_MIN_ROWS = 8;

        /*
         * Abilita la colorazione scura della GUI. Impostare a 'false' per usare la
         * modalità chiara. Nota: nella 1.00 non è disponibile una colorazione non-dark.
         * Ciò significa che cambiare il seguente parametro non produrrà, almeno per
         * ora, alcun effetto.
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
         * frasi da stampare a video. Nota: questa funzione non è inclusa nella versione
         * pubblica del software.
         */
        public static final boolean LOREM_IPSUM = false;
        public static final int LOREM_IPSUM_COUNT = 50;

}

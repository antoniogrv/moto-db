import java.util.*;

public class Config {
    /*
     * Modifica questo file per generare la tua GUI.
     */

    private Config() {
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
        DB_NAME = "db_name";
        DB_USERNAME = "db_username";
        DB_PASSWORD = "db_password";

        /*
         * [! CONFIGURAZIONE ESSENZIALE]
         * 
         * Questo software, per funzionare correttamente, ha bisogno di query -- da qui
         * in poi definite come OPERAZIONI. Le operazioni fornite di seguito saranno
         * utilizzate per generare le interfacce grafiche.
         * 
         * Le operazioni vanno elaborate come stringhe letterali. Tuttavia, è necessario
         * aggiungere alcuni parametri (detti FLAGS) .. .. per assicurare la corretta
         * elaborazione delle query.
         * 
         * Si invita caldamente, prima di aggiungere un'operazione alla seguente lista,
         * di consultare la documentazione.
         */
        Operations.addAll(
            Arrays.asList(
                new String[] { 
                    /* .01 */ "SELECT * FROM example_table", 
                    /* .02 */ "SELECT column FROM example_table"
                    /* ... */ 
                }
            )
        );

        /*
         * Attiva la modalità di debug. La modalità di debug abiliterà la generazion di
         * un frame shell-like .. .. per visualizzare costantemente le azioni degli
         * attori del software.
         * 
         * Si consiglia di disattivare l'opzione per la discussione del progetto.
         */
        DEBUG_MODE = true;

        /*
         * Abilita la colorazione scura della GUI. Impostare a 'false' per usare una
         * modalità chiara. Dark > Colori principali: [HEX: ..] Light > Colori
         * principali: [HEX: ..]
         */
        DARK_MODE = true;
    }

    public static String DB_NAME;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;

    public static boolean DARK_MODE;
    public static boolean DEBUG_MODE;

    public static ArrayList<String> Operations = new ArrayList<String>();

}

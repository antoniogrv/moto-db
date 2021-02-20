# MotoDB
## [Stable 1.00](https://github.com/v1enna/moto-db/archive/master.zip)

**MotoDB è un generatore di applicazioni grafiche in Java per il progetto del corso di Basi di Dati** della triennale di Informatica all’Università di Salerno. 
Il software, per funzionare, ha bisogno solo ed esclusivamente delle query delle operazioni desiderate nell'ambito della propria realtà d'interesse, e nient’altro. 
L'applicativo è stato ideato per tutte quelle persone che, per qualsiasi motivo, non abbiano voglia o tempo di creare il programma in Java richiesto al **Punto VII** dei requisiti 
officiali del progetto. In particolare, il modus operandi riflette le consegne del progetto richiesto dai docenti G. Tortora e M. Risi del dipartimento di Informatica per il superamento dell'esame di Basi di Dati.

Per qualsiasi dubbio è possibile consultare la [documentazione del progetto](https://github.com/v1enna/moto-db/wiki).

![Preview](https://i.gyazo.com/73db8d0a271f8773fc0554efd770fe1e.png)

Supponendo che l'utente abbia già a disposizione tutto il necessario, ossia la documentazione dal Punto I (*descrizione della realtà d'interesse*) 
al Punto VI (*definizione delle operazioni sulla realtà d'interesse*), **MotoDB permette di creare una GUI completa e funzionale in 10 minuti**, 
portando al completamento di tutte le richieste del progetto, rendendolo discutibile e consegnabile al corpo docente. Inoltre, se si desidera, il codice sorgente è completamente modificabile a proprio piacimento, 
per quanto ciò possa comportare il malfunzionamento dell'applicativo stesso.

Tutto ciò che viene richiesto all'utente è la **compilazione di pochissime righe di configurazione** in uno dei file del programma, 
oltre che la **formattazione delle query delle operazioni** per adattarsi alla logica del programma. Se si ha la minima idea di cosa si sta facendo e si è in grado di muoversi con agilità in un ambiente Java,
la propria GUI personalizzata sarà pronta in tempo zero. 

## Download e installazione

Per ottenere MotoDB è sufficiente scaricare l'[ultima versione stabile](https://github.com/v1enna/moto-db/archive/master.zip). In alternativa, gli utenti più esperti possono direttamente clonare la respository dal branch `master` tramite `git clone https://github.com/v1enna/moto-db.git` 
per avere immediatamente a disposizione l'intero codice sorgente. Si noti che l'identificativo (oltre che un breve changelog) della versione stabile più recente del software è presente sulla destra di questa pagina, 
alla voce *Releases*.

Il contenuto dell'archivio è una cartella al cui interno è presente il programma Java da importare su un IDE o eseguire da terminale. 
In particolare, il programma è stato ideato per essere lanciato con facilità su [Eclipse](https://www.eclipse.org/) e [Visual Studio Code](https://code.visualstudio.com/).

L'archivio si presenta come segue:


```html
<moto-db-master.zip>
  <moto-db-master>
    <lib>
      // Driver MySQL
    <src>
      // Programma Java
    <sql>
      // Demo SQL
    .classpath
    .gitignore
```

Il file `.gitignore` è ininfluente e può essere eliminato.

#### Eclipse IDE

Una volta spacchettato l'archivio, creare un progetto tramite **File > New > Java Project** e denominarlo come si preferisce. 
Non è suggerito inserire un `module-info.java`, come spesso viene richiesto automaticamente dal programma (dunque cliccare su **Don't Create**). L'IDE creerà un nuovo workspace sulla sinistra in cui sarà presente, in genere, solo la la directory `src`.
E' sufficiente, adesso, copiare ed incollare il contenuto di `moto-db-master`(e cioè le cartelle `lib`, `src`, `sql`, `.classpath`, `.gitginore`) *dentro la radice del progetto* su Eclipse, e non dentro `src`.
Infatti, la cartella `src` dell'archivio di MotoDB deve sovrascrivere completamente la cartella `src` di default.
E' altresì fondamentale non incolllare i file in `src`, ma nella `root` del progetto, che in genere coincide col nome del progetto Java definito alla creazione.

Al momento della copia del programma, Eclipse potrebbe chiedere se si desiderà copiare o collegare i file: procedere su **Copy files and folders** e **Overwrite all**. Si presti attenzione a questo passaggio: importare scorettamente i file causerà il malfunzionamento del programma.


#### Visual Studio Code

MotoDB è stato creato su Visual Studio Code. Per compilare i file è stato usato il [Java Extension Pack](https://code.visualstudio.com/docs/languages/java).
A prescindere dall'estensione utilizzata, è sufficiente copiare ed incollare l'intera cartella presente nell'archivio in una directory o un workspace. 
Non sono necessarie ulteriori configurazioni per compilare correttamente il programma.


Un'installazione corretta su entrambi gli ambienti ha un aspetto del genere:

![Import](https://i.gyazo.com/e9aa38b23bda39b8c24751b63ba64c1f.png)


## Configurazione

Una volta importati i file, provare a compilare (premendo `F5` su Visual Studio Codice o `Run` su Eclipse) il file `src/<default package>/App.java`.

Per avviare MotoDB basta compilare ed eseguire la classe **App** contenuta nel file `App.java`. Se l'installazione è andata a buon fine, si aprirà una finestra di debug. 
Al primissimo avvio, MotoDB avviserà dell'incapacità di connettersi al database, elecando i dati (username, password, dbname) che sta utilizzando (di default, sono valori esemplificativi).
E' tutto normale: per usare correttamente MotoDB, è necessario compilare alcune righe del file di configurazione situato in `config/Config.java`. 

### Connessione al database

Della classe **Config**, piuttosto vasta e complessa, si devono modificare obbligatoriamente i dati di connessione al database.

```java
 public static final String PROJECT_NAME = "Il mio progetto"; // Modificare questo campo è opzionale!
        
 public static final String DB_NAME = "example_database"; // Obbligatorio
 public static final String DB_USERNAME = "example_username"; // Obbligatorio
 public static final String DB_PASSWORD = "example_password"; // Obbligatorio
```

**Si invita a non usare l'utente di root della MySQL Workbench** ma, piuttosto, **generare un utente nello script di creazione del database** tramite `CREATE USER` e `GRANT PERMISSIONS`.
E' possibile trovare un esempio funzionante nella [documentazione](https://github.com/v1enna/moto-db/wiki).

Una volta inseriti i dati, ricompilare App e accertarsi che la finestra di debug notifichi l'avvenuta connessione al database. 
In tal caso, dovrebbe aprirsi il frame principale che prevede l'interazione con l'utente. 

### Operazioni

Inizialmente, l'applicativo è popolato con operazioni di demo che, chiaramente, restituiranno errori all'esecuzione, poiché l'utente non dispone delle tabelle e dei dati sfruttate nelle operazioni stesse.
In ogni caso, se si desidera provare la demo di MotoDB consultare la [documentazione](https://github.com/v1enna/moto-db/wiki).

L'ultimo passaggio della configurazione è la definizione delle Operazioni. Ci si troverà dinanzi ad una situazione del genere:

```java
public static ArrayList<Operation> Operations = new ArrayList<Operation>(Arrays.asList(

   // Operazione 1
   new Operation("SELECT * FROM example_table", 
       "Seleziona tutti i dati di esempio."),

   // Operazione 2
   new Operation("SELECT nome FROM example_table WHERE id = {ID Esempio}",
      "Seleziona solo la colonna 'nome' dai dati d'esempio, in base all'ID."),

   // Operazione 3
   new Operation("SELECT id FROM example_table WHERE nome = \"{Nome}\" AND cognome = \"{Cognome}\"",
       "Seleziona solo la colonna 'id' dai dati d'esempio, in base al nome e al cognome."),

   // Operazione 4
   new Operation("DELETE FROM example_table", 
       "Svuota la tabella d'esempio.")
       
));
```

MotoDB genera automaticamente le interfacce grafiche e le routine di esecuzione delle query in base alle operazioni che vengono aggiunte alla lista *Operations*.
In particolare, `Operations` è un `ArrayList<Operation>` che viene popolato all'istante della sua dichiarazione. All'arraylist viene passata un `Array` sottoforma di `List` (`Arrays.asList` è difatti un casting) 
che permette di aggiungere - senza particolari difficoltà - nuove istanze di `Operation`.

```java
public static ArrayList<Operation> = new ArrayList<Operation>(Arrays.asList(
  // Le mie operazioni
  new Operation(query, description),
  new Operation(query, description)
  ..
);
```

**Operation** è la classe di definizione delle operazioni ed è costruita da una stringa che rappresenta la query, e una stringa che rappresenta la descrizione dell'operazione.

```java
new Operation(String query, String description)
```

Ad esempio, se nella mia realtà d'interesse ho un'operazione del tipo "*Seleziona tutti gli studenti della scuola*", e cioè `"SELECT * FROM studenti"`, allora avrò una situazione del genere:

```java
public static ArrayList<Operation> Operations = new ArrayList<Operation>(Arrays.asList(

  // Operazione 1
  new Operation("SELECT * FROM studenti",
      "Seleziona tutti gli studenti della scuola.")

));
```

Sia query che descrizione devono essere necessariamente stringhe, ma il contenuto di tali stringhe può in effetti essere qualsiasi cosa. Ciò significa che se l'utente (e cioè la persona che sta convertendo le operazioni della sua realtà di interesse in Operations di MotoDB) commette un errore di formattazione, la finestra di debug o la console lo avvertiranno prontamente.
E' chiaramente consigliato adottare una spaziatura comoda e pulita, magari rispettando gli esempi proposti, ma non è strettamente necessario per far funzionare il software. Ovviamente, nel caso di un errore di sintassi, MotoDB fallirà la compilazione quasi istantaneamente, poiché **il file di configurazione viene caricato all'avvio** di App.


Si noti che dopo ogni Operation, eccetto che per l'ultima della lista, è necessaria una virgola.

```java
public static ArrayList<Operation> Operations = new ArrayList<Operation>(Arrays.asList(

  // Operazione 3
  new Operation("SELECT id FROM example_table WHERE nome = \"{Nome}\" AND cognome = \"{Cognome}\"",
      "Seleziona solo la colonna 'id' dai dati d'esempio, in base al nome e al cognome."), // <--- Non è l'ultima operazione, virgola

  // Operazione 4
  new Operation("DELETE FROM example_table", 
      "Svuota la tabella d'esempio.") // <-- Ultima operazione, nessuna virgola

));

```

### Alias

Ora che è chiaro come, grossomodo, vengono definite le Operations, è fondamentale parlare di **Alias**.

Un **Alias** è un valore richiesto in input. Poniamo una casistica comune:
- Si ha un'operazione del tipo "*Seleziona tutti gli studenti nella classe (sezione, anno) indicata"*
- Il database è fornito di una tabella `studenti` e di una tabella `classi`
- La tabella `classi` ha come campi `sezione` ed `anno`
- `anno` è un intero, mentre `sezione` è una stringa (cioè `varchar`, `char` e così via)
- `studenti` e `classi` sono collegate, e cioè che `anno` e `sezione` in una generica tupla di studente si riferiscano effettivamente ad una tupla esistente in `classi`
- La tabella `studenti` ha come campi `matricola`, `nome`, `cognome`, `sezione`, `anno`

La query richiesta sarà dunque `"SELECT * FROM studenti WHERE sezione = InputUtente1 AND anno = InputUtente2`".

Il senso del programma è proprio questo: **lanciare delle query in funzione di determinati dati in input da parte dell'utente**. 
Ora, **MotoDB utilizza gli *Alias* per determinare cosa sarà richiesto all'utente**. La logica di parsing si occuperà di generare gli input e la query; ciò che è richiesto all'utente è di sostituire i valori che vuole vengano richiesti all'utente con degli Alias.

![Preview](https://i.gyazo.com/cdf457b01f0ede8a1be300eeb5ad17b2.png)

Un'Alias ha un aspetto del genere: `{InputUtente}`. 

- Un Alias comincia e finisce con una parentesi graffa, *sempre*.
- Il contenuto interno di un Alias può essere qualsiasi cosa. Il testo in questione sarà mostrato a schermo quando l'utente proverà ad effettuare quell'operazione. Un Alias può essere vuoto, come `{}`, ma si consiglia ugualmente di aggiungere un testo informativo.

Considerato questo, la query da inserire nella `new Operation()` sarà `"SELECT * FROM studenti WHERE sezione = '{Sezione}' AND anno = {Anno}"`.
Questa query genererà una finestra grafica in cui verranno richiesti due campi in input, cioè la sezione e l'anno.

```java
  new Operation("SELECT * FROM studenti WHERE sezione = '{Sezione}' AND anno = {Anno}",
      "Seleziona tutti gli studenti nella classe (sezione, anno) indicata");
```

Una GUI generata con questa query e la descrizione fornita in precedenza avrà un'aspetto di questo tipo:
```html
 Seleziona tutti gli studenti nella classe (sezione, anno) indicata
 
 Sezione: [input]
 Anno: [input]
 
 Bottone [Esegui]
```

Ma, come abbiamo detto prima, il **contenuto di un Alias può essere qualsiasi testo**. Ad esempio, se la query fosse stata `"SELECT * FROM studenti WHERE sezione = '{La SeZiOnE}' AND anno = {Sono un Alias}` si sarebbe generata una GUI del genere:
```html
 Seleziona tutti gli studenti nella classe (sezione, anno) indicata
 
 La SeZiOnE: [input]
 Sono un Alias: [input]
 
 Bottone [Esegui]
```

Infine, si invita a notare l'utilizzo di apici e doppi apici. Come abbiamo detto, `sezione` è un carattere, mentre `anno` è un intero. In SQL, gli interi non richiedono apici, mentre le stringhe e i caratteri sì. Significa che `SELECT * FROM sezione = A` non compilerà, mentre `SELECT * FROM sezione = 'A'` sì. Perciò, se si trattano valori come stringhe e date (*yyyy-mm-dd*), l'Alias va incapsulato in apici o doppi apici. Se si utilizzano i doppi apici, sarà obbligatorio evadere il termine della stringa come mostrato in precedenza.

### Debug Mode

MotoDB è dotato di una modalità di debug completa e discorsiva, che permette di porre al vaglio ogni azione eseguita dai sistemi del software per identificare possibili problemi. Si consiglia di lasciare attiva la modalità di debug fino alla presentazione del progetto.

![Preview](https://i.gyazo.com/98367f4738dadd2c192bac93b090a7b4.png)

In ogni caso, è possibile disattivare la modalità di debug in qualsiasi momento nel file di configurazione:

```java
  public static final boolean DEBUG_MODE = true;
```


## Build & Deploy

MotoDB è stato creato interamente in Java, rispettando i minimi requisiti di codifica previsti dal progetto. Le interfacce grafiche sono state realizzate tramite [Swing](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html). Questa repository ospita il codice sorgente di MotoDB, nonché quello della [landing page](https://v1enna.github.io/moto-db/#/). In particolare, la repository si articola in tre branch, cioè `master`, `gh-pages-dev` e `gh-pages`.

### `branch: master`
Ospita il codice sorgente in Java di MotoDB. Quando si scarica MotoDB, si sta in effetti scaricando il contenuto del branch `master`. Per una descrizione dettagliata del codice del programma, si invita a consultare in maniera approfondita la [documentazione del progetto](https://github.com/v1enna/moto-db/wiki).

### `branch: gh-pages-dev`
Ospita il codice sorgente della landing page, che è un sito monopagina statico sviluppato in [React](https://it.reactjs.org/). L'applicativo web è stato ideato per essere ospitato su GitHub Pages tramite gli script di deploy di [gh-pages](https://www.npmjs.com/package/gh-pages) e [npm](https://www.npmjs.com/). I template sono costruiti in [JSX](https://facebook.github.io/jsx/).

### `branch: gh-pages`
Questo branch contiene la build static (markup, stilizzazione, interattività in JavaScript) prodotta dal contenuto padre in `gh-pages-dev`. Quello che effettivamente viene mostrato nella landing pages è il contenuto di questo branch. Mentre `gh-pages-dev` può essere considerabile come la versione di sviluppo, `gh-pages` è valutata invece come versione di produzione, e cioè il sito web in sé rilasciato pubblicamento.


## Riferimenti

- [MotoDB Landing Page](https://v1enna.github.io/moto-db/#/)
- [MotoDB Wiki](https://github.com/v1enna/moto-db/wiki)


package debug;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import config.Config;
import debug.DebugFormat.DebugMessageType;

public class DebugFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private static JTextPane content;
    private static ArrayList<String> debugContent;

    public DebugFrame() {
        System.out.println("<Config> Modalità di debug attiva");
        /*
         * Preleva i dati di configurazione e crea un JFrame in funzione dei suddetti
         * dati.
         */
        setTitle(Config.DEBUG_MODE_FRAME_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Config.DEBUG_MODE_FRAME_SIZE[0], Config.DEBUG_MODE_FRAME_SIZE[1]);

        try {
            setIconImage(ImageIO.read(new File(Config.MOTODB_ICON_PATH)));
        } catch (IOException e) {
            System.out.println("<Config> Impossibile trovare l'icona. Ricontrolla la configurazione.");
        }

        /*
        * Crea un JPanel esterno (definito OUTER) per creare un layer di profondità ..
        * .. per il displayer di messaggi. Inoltre, impostane il background e la spaziatura.
        */
        JPanel outer = new JPanel();
        outer.setLayout(new GridLayout(1, 1));
        outer.setBorder(
            new EmptyBorder(
                Config.DEBUG_MODE_OUTER_PADDING[0],
                Config.DEBUG_MODE_OUTER_PADDING[1],
                Config.DEBUG_MODE_OUTER_PADDING[2],
                Config.DEBUG_MODE_OUTER_PADDING[3]
            )
        );

        outer.setBackground( 
            Color.decode(
                Config.DEBUG_MODE_FRAME_OUTER_BACKGROUND
            )
        );

        /*
        * Crea il displayer di messaggi, poi impostane il background e la spaziatura
        */
        content = new JTextPane();
        content.setEditable(false);
        content.setContentType("text/html");

        content.setBackground(
            Color.decode(
                Config.DEBUG_MODE_FRAME_INNER_BACKGROUND
            )
        );

        content.setBorder(
            new EmptyBorder(
                Config.DEBUG_MODE_INNER_PADDING[0],
                Config.DEBUG_MODE_INNER_PADDING[1],
                Config.DEBUG_MODE_INNER_PADDING[2],
                Config.DEBUG_MODE_INNER_PADDING[3]
            )
        );

        /*
        * Popola il JFrame con il displayer; infine, mostra il Debug Frame generato.
        */
        outer.add(content);
        add(outer, BorderLayout.CENTER);

        debugContent = new ArrayList<String>();

        setVisible(true);
    }

    public static void printMessage(String message) {
        DebugMessageType type = DebugMessageType.WAIT;

        switch(message.charAt(0)) {
            /*
            * Operazione fallimentare [..]
            */
            case '!':
                type = DebugMessageType.FAIL;
                break;

            /*
            * In attesa degli attori [..]
            * Lo stato di WAIT è considerato quello di default.
            */
            case '?':
                type = DebugMessageType.WAIT;
                break;

            /*
            * Operazione effettuata con successo [..]
            */
            case ':':
                type = DebugMessageType.SUCCESS;
                break;

            default:
                System.out.println("<DebugFrame> Impossibile stampare l'errore. Ricontrolla la configurazione.");
                System.exit(-1);
                break;
        }

        debugContent.add(new DebugFormat(type, message).getText());

        content.setText(
            getDebugContent()
        );
    }

    private static String getDebugContent() {
        String str = "";
        for(String x : debugContent)
            str += x;
        return str;
    }

}

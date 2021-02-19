package gui;

import endpoint.Actor;
import endpoint.Operation;
import javax.swing.*;
import config.Config;

public class QueryViewer extends Actor {

    private JTextArea result;
    private Operation op;

    public QueryViewer(Operation op, JTextArea result) {
        this.op = op;
        this.result = result;

        new QueryFrame();
    }

    public class QueryFrame extends JFrame {

        private static final long serialVersionUID = 1L;

        public QueryFrame() {
            /*
             * Configurazione di default del MainFrame. Per informazioni relative all'icona
             * del frame, consultare DebugFrame().
             */
            setTitle(Config.QUERY_VIEWER_FRAME_TITLE);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(Config.QUERY_VIEWER_FRAME_SIZE[0], Config.QUERY_VIEWER_FRAME_SIZE[1]);
            setLocationRelativeTo(null);
            setVisible(true);

            debug("?Operazione selezionata: " + op.getDescription());
            debug("?Query grezza indicata: " + op.getQuery());
        }

    }

}

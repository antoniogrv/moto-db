package gui;

import endpoint.Actor;
import endpoint.Operation;
import javax.swing.*;

public class QueryViewer extends Actor {

    private JTextArea result;
    private Operation op;

    public QueryViewer(Operation op, JTextArea result) {
        this.op = op;
        new QueryFrame();
        debug(":QueryViewer creato con successo per l'operazione");
    }

    public class QueryFrame extends JFrame {

        private static final long serialVersionUID = 1L;

        public QueryFrame() {
            setSize(300, 300);
            setVisible(true);
        }

    }

}

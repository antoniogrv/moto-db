package gui;

import endpoint.Actor;
import endpoint.Operation;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import config.Config;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import builder.QueryBuilder;

public class QueryViewer extends Actor {

    private Operation op;
    private QueryBuilder builder;
    private ArrayList<JTextField> inputValues = new ArrayList<JTextField>();
    private QueryFrame frame;

    public QueryViewer(Operation op, JTextPane result) {
        this.op = op;
        this.builder = new QueryBuilder(op.getQuery());

        debug("?Tento di prelevare l'operazione richiesta...");

        this.frame = new QueryFrame();
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

            try {
                setIconImage(ImageIO.read(new File(Config.MOTODB_ICON_PATH)));
            } catch (IOException e) {
                debug("!Impossibile trovare l'icona dell'applicazione. Ricontrolla la configurazione.");
            }

            debug("?Operazione selezionata: " + op.getDescription());
            debug("?Query grezza indicata: " + op.getQuery());

            add(createOperationDescriptionPanel(), BorderLayout.NORTH);
            add(createContainer(), BorderLayout.CENTER);

            setVisible(true);
        }

        public JPanel createOperationDescriptionPanel() {
            /*
             * Crea un'area di testo immutabile per stampare la descrizione dell'operazione.
             */
            JPanel panel = new JPanel(new GridLayout(1, 1));
            panel.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_BACKGROUND));

            JTextPane operationDescription = new JTextPane();
            operationDescription.setContentType("text/html");
            operationDescription.setText(
                    "<center><b><span style='font-size:" + Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT_SIZE
                            + "; font-family:" + Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT + "; color: "
                            + Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT_COLOR + "; '>" + op.getDescription()
                            + "</span></b></center>");
            operationDescription
                    .setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_BACKGROUND));
            operationDescription.setBorder(new EmptyBorder(Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING[0],
                    Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING[1],
                    Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING[2],
                    Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING[3]));
            operationDescription.setEditable(false);

            panel.add(operationDescription);

            return panel;
        }

        public JPanel createContainer() {
            /*
             * Gerarchia: Outer > Inner
             */
            JPanel outer = new JPanel(new GridLayout(1, 1));
            JPanel inner = new JPanel(new BorderLayout());

            outer.setBorder(new EmptyBorder(Config.QUERY_VIEWER_FRAME_OUTER_PADDING[0],
                    Config.QUERY_VIEWER_FRAME_OUTER_PADDING[1], Config.QUERY_VIEWER_FRAME_OUTER_PADDING[2],
                    Config.QUERY_VIEWER_FRAME_OUTER_PADDING[3]));
            outer.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_OUTER_BACKGROUND));

            inner.setBorder(new EmptyBorder(Config.QUERY_VIEWER_FRAME_INNER_PADDING[0],
                    Config.QUERY_VIEWER_FRAME_INNER_PADDING[1], Config.QUERY_VIEWER_FRAME_INNER_PADDING[2],
                    Config.QUERY_VIEWER_FRAME_INNER_PADDING[3]));
            inner.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_INNER_BACKGROUND));

            inner.add(createGrid(), BorderLayout.CENTER);
            inner.add(createEnterButton(), BorderLayout.SOUTH);

            outer.add(createScrollPane(inner));

            return outer;
        }

        public JScrollPane createScrollPane(JPanel inner) {
            /*
             * Routine di stilizzazione della scrollbar. Per stilizzare la scrollbar è stata
             * usata un'API pubblica integrata in Swing, ossia UIManager.
             */
            JScrollPane scrollPane = new JScrollPane(inner);

            UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.decode(Config.SCROLLBAR_THUMB)));
            UIManager.put("ScrollBar.thumbDarkShadow",
                    new ColorUIResource(Color.decode(Config.SCROLLBAR_THUMB_DARK_SHADOW)));
            UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(Color.decode(Config.SCROLLBAR_THUMB_SHADOW)));
            UIManager.put("ScrollBar.thumbHighlight",
                    new ColorUIResource(Color.decode(Config.SCROLLBAR_THUMB_HIGHLIGHT)));
            UIManager.put("ScrollBar.track", new ColorUIResource(Color.decode(Config.SCROLLBAR_TRACK)));

            scrollPane.setBorder(BorderFactory.createLineBorder(Color.decode(Config.SCROLLBAR_BORDER), 2));
            scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
            scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());

            return scrollPane;
        }

        public JPanel createGrid() {
            /*
             * La griglia contiene le righe per l'input e il bottone di esecuzione.
             */
            int rows = (builder.getValuesSize() > Config.QUERY_VIEWER_FRAME_MIN_ROWS) ? builder.getValuesSize()
                    : Config.QUERY_VIEWER_FRAME_MIN_ROWS;

            JPanel grid = new JPanel(new GridLayout(rows, 2));
            grid.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_GRID_BACKGROUND));

            ArrayList<String> aliases = builder.getAliases();

            for (int i = builder.getValuesSize() - 1; i >= 0; i--) {
                grid.add(createRow(aliases.get(i), inputValues));
            }

            return grid;
        }

        public JPanel createRow(String alias, ArrayList<JTextField> inputValues) {
            /*
             * Gerarchia: Row > {Label, Field Container > Field}
             */
            JPanel row = new JPanel(new GridLayout(1, 2));
            JTextField field = new JTextField();
            JLabel label = new JLabel(alias, SwingConstants.CENTER);

            row.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_ROW_BACKGROUND));
            row.setBorder(
                    new EmptyBorder(Config.QUERY_VIEWER_FRAME_ROW_PADDING[0], Config.QUERY_VIEWER_FRAME_ROW_PADDING[1],
                            Config.QUERY_VIEWER_FRAME_ROW_PADDING[2], Config.QUERY_VIEWER_FRAME_ROW_PADDING[3]));

            label.setForeground(Color.decode(Config.QUERY_VIEWER_FRAME_INNER_FIELD_LABEL_FONT_COLOR));
            label.setFont(new Font(Config.QUERY_VIEWER_FRAME_INNER_FIELD_LABEL_FONT, Font.BOLD,
                    Config.QUERY_VIEWER_FRAME_INNER_FIELD_LABEL_FONT_SIZE));

            field.setBorder(new EmptyBorder(Config.QUERY_VIEWER_FRAME_INNER_FIELD_PADDING[0],
                    Config.QUERY_VIEWER_FRAME_INNER_FIELD_PADDING[1], Config.QUERY_VIEWER_FRAME_INNER_FIELD_PADDING[2],
                    Config.QUERY_VIEWER_FRAME_INNER_FIELD_PADDING[3]));

            row.add(label);
            row.add(field);

            inputValues.add(field);

            return row;
        }

        public JPanel createEnterButton() {
            /*
             * Gerarchia: Button > Label
             */
            JPanel enterButton = new JPanel();
            JLabel enterLabel = new JLabel("Esegui");

            enterButton.setBorder(new EmptyBorder(Config.QUERY_VIEWER_FRAME_BUTTON_PADDING[0],
                    Config.QUERY_VIEWER_FRAME_BUTTON_PADDING[1], Config.QUERY_VIEWER_FRAME_BUTTON_PADDING[2],
                    Config.QUERY_VIEWER_FRAME_BUTTON_PADDING[3]));
            enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            enterButton.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_BUTTON_BACKGROUND));
            enterButton.addMouseListener(new EnterButtonListener());
            enterLabel.setForeground(Color.WHITE);
            enterLabel.setFont(new Font(Config.QUERY_VIEWER_FRAME_ENTER_BUTTON_FONT, Font.BOLD,
                    Config.QUERY_VIEWER_FRAME_ENTER_BUTTON_FONT_SIZE));

            enterButton.add(enterLabel);

            return enterButton;
        }

    }

    public class EnterButtonListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int given = 0;

            for (JTextField x : inputValues)
                if (!x.getText().isEmpty())
                    given++;

            if (given == builder.getValuesSize()) {
                builder.setInputValues(inputValues);
                frame.dispose();
                MainViewer.display(":Query lanciata!");
                // IF public queries..
                MainViewer.display(builder.getQuery() + "<br />");
                // new DBHandler() ...
            } else {
                debug("!Non sono ammessi campi non compilati");
                MainViewer.display("!" + Config.MAIN_VIEWER_FRAME_NO_INPUT_TEXT);
            }

        }

        public void mouseEntered(MouseEvent e) {
            Object source = e.getSource();
            JPanel button = (JPanel) source;

            button.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER));
        }

        public void mouseExited(MouseEvent e) {
            Object source = e.getSource();
            JPanel button = (JPanel) source;

            button.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_BUTTON_BACKGROUND));
        }

    }

}

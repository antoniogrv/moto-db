package gui;

import endpoint.Actor;
import endpoint.Operation;
import javax.swing.*;
import javax.swing.JFrame;
import config.Config;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class QueryViewer extends Actor {

    private JTextArea result;
    private Operation op;

    public QueryViewer(Operation op, JTextArea result) {
        this.op = op;
        this.result = result;

        debug("?Tento di prelevare l'operazione richiesta...");

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

            debug("?Operazione selezionata: " + op.getDescription());
            debug("?Query grezza indicata: " + op.getQuery());

            add(createOperationDescriptionPanel(), BorderLayout.NORTH);
            add(createContainer(), BorderLayout.CENTER);

            setVisible(true);
        }

        public JPanel createOperationDescriptionPanel() {
            JPanel panel = new JPanel();
            panel.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_BACKGROUND));

            JLabel operationDescription = new JLabel(op.getDescription());
            operationDescription
                    .setForeground(Color.decode(Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT_COLOR));
            operationDescription.setFont(new Font(Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT, Font.BOLD,
                    Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_FONT_SIZE));
            operationDescription.setBorder(new EmptyBorder(Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING[0],
                    Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING[1],
                    Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING[2],
                    Config.QUERY_VIEWER_FRAME_OPERATION_DESCRIPTION_PADDING[3]));

            panel.add(operationDescription);

            return panel;
        }

        public JPanel createContainer() {

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
            JPanel grid = new JPanel(new GridLayout(10, 2));
            grid.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_GRID_BACKGROUND));

            for (int i = 0; i < 10; i++) {
                grid.add(createRow());
            }

            return grid;
        }

        public JPanel createRow() {
            /*
             * Gerarchia: Outer Row > Inner Row {Label, Field Container > Field}
             */
            JPanel outerRow = new JPanel(new GridLayout(1, 2));
            JPanel innerRow = new JPanel(new GridLayout(1, 1));

            JPanel fieldContainer = new JPanel(new GridLayout(1, 1));
            JTextField field = new JTextField();

            JLabel label = new JLabel("Campo", SwingConstants.CENTER);

            outerRow.setBackground(Color.decode(Config.QUERY_VIEWER_ROW_OUTER_ROW_BACKGROUND));
            outerRow.setBorder(new EmptyBorder(5, 0, 5, 0));

            innerRow.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_INNER_ROW_BACKGROUND));
            innerRow.setBorder(new EmptyBorder(10, 5, 10, 5));

            label.setForeground(Color.decode(Config.QUERY_VIEWER_FIELD_LABEL_FONT_COLOR));
            label.setFont(new Font("Open Sans", Font.BOLD, 15));

            fieldContainer.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_INNER_BACKGROUND));

            field.setBorder(new EmptyBorder(0, 0, 0, 0));

            fieldContainer.add(field);

            innerRow.add(label);
            innerRow.add(fieldContainer);

            outerRow.add(innerRow);

            return outerRow;
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
            enterButton.setBackground(Color.decode(Config.QUERY_VIEWER_FRAME_ENTER_BUTTON_BACKGROUND));
            enterButton.addMouseListener(new EnterButtonListener());
            enterLabel.setForeground(Color.WHITE);
            enterLabel.setFont(new Font(Config.QUERY_VIEWER_ENTER_BUTTON_FONT, Font.BOLD,
                    Config.QUERY_VIEWER_FRAME_ENTER_BUTTON_FONT_SIZE));

            enterButton.add(enterLabel);

            return enterButton;
        }

    }

    public class EnterButtonListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // Something...
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

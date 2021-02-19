package gui;

import javax.swing.JFrame;
import config.Config;
import endpoint.Actor;
import java.awt.event.MouseAdapter;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.io.IOException;

public class MainViewer extends Actor {

    public MainViewer() {
        debug("?Genero il MainFrame...");
        new MainFrame();
    }

    public class MainFrame extends JFrame {

        private JTextArea result;

        private static final long serialVersionUID = 1L;

        public MainFrame() {
            /*
             * Configurazione di default del MainFrame. Per informazioni relative all'icona
             * del frame, consultare DebugFrame().
             */
            setTitle(Config.MAIN_VIEWER_FRAME_TITLE);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(Config.MAIN_VIEWER_FRAME_SIZE[0], Config.MAIN_VIEWER_FRAME_SIZE[1]);
            setLocationRelativeTo(null); // Posiziona centralmente il frame alla creazione

            try {
                setIconImage(ImageIO.read(new File(Config.MOTODB_ICON_PATH)));
            } catch (IOException e) {
                debug("!Impossibile trovare l'icona. Ricontrolla la configurazione.");
            }

            /*
             * Routine di popolamento della GUI. Riferirsi alla documentazione per i singoli
             * componenti. -- Gerarchia: [LeftSide, RightSide] -- [LeftSide]: {Buttons}
             * [RightSide]: {Outer > Scrollbar > TextArea}
             */
            JPanel rightSide = createRightSide();
            JPanel leftSide = createLeftSide();

            add(leftSide, BorderLayout.WEST);
            add(rightSide, BorderLayout.CENTER);

            setVisible(true);

            debug(":MainFrame creato e popolato con successo");
        }

        private JPanel createButton(int id) {
            /*
             * Gerarchia: Container > Button > Label
             */
            JPanel buttonContainer = new JPanel(new GridLayout(1, 1));
            JPanel button = new JPanel();
            JLabel label = new JLabel("Operazione " + id);

            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.setBorder(new EmptyBorder(2, 20, 2, 20));
            button.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND));
            button.addMouseListener(new ButtonListener());

            label.setForeground(Color.WHITE);
            label.setFont(new Font("Open Sans", Font.BOLD, 14));

            button.add(label);

            buttonContainer.add(button);

            return buttonContainer;
        }

        private JPanel createRightSide() {
            /*
             * Elabora il lato destro del MainFrame. In particolare, nella spaziatura viene
             * implementata una scrollbar personalizzata (ScrollPane, sotto forma di
             * JScrollPane) e all'interno di quest'ultima vengono poi inseriti più layer
             * grafici per l'area di testo (resultArea, sotto forma di JPanel) nella quale
             * verranno stampati i risultati delle operazioni.
             */
            JPanel outer = new JPanel();

            outer.setLayout(new GridLayout(1, 1));
            outer.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_OUTER_BACKGROUND));
            outer.setBorder(new EmptyBorder(Config.DEBUG_MODE_OUTER_PADDING[0], Config.DEBUG_MODE_OUTER_PADDING[1],
                    Config.DEBUG_MODE_OUTER_PADDING[2], Config.DEBUG_MODE_OUTER_PADDING[3]));

            outer.add(createScrollPane(), BorderLayout.CENTER);

            return outer;

        }

        private JPanel createLeftSide() {
            /*
             * Gerarchia: Container > Wrapper > TextArea
             */
            JPanel buttonsContainer = new JPanel();
            JPanel buttonsWrapper = new JPanel();

            buttonsContainer.setBorder(new EmptyBorder(10, -4, -4, -5));
            buttonsContainer.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND));

            buttonsWrapper.setLayout(new GridLayout(Config.Operations.size(), 1));

            for (int i = 0; i < Config.Operations.size(); i++)
                buttonsWrapper.add(createButton(i + 1));

            buttonsContainer.add(buttonsWrapper);

            return buttonsContainer;
        }

        private JPanel createResultPanel() {
            /*
             * Gerarchia: Container > Wrapper > TextArea
             */
            JPanel resultContainer = new JPanel(new GridLayout(1, 1));
            JPanel resultWrapper = new JPanel(new GridLayout(1, 1));
            JTextArea result = new JTextArea("Bentornato!");

            resultContainer.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_INNER_BACKGROUND));
            resultContainer.setBorder(new EmptyBorder(15, 15, 15, 15));

            result.setBorder(new EmptyBorder(5, 5, 5, 5));
            result.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_INNER_BACKGROUND));
            result.setForeground(Color.WHITE);
            result.setEditable(false);
            result.setFont(new Font("Open Sans", Font.PLAIN, 14));
            result.setLineWrap(true);
            result.setWrapStyleWord(true);

            if (Config.DEBUG_MODE)
                result.setText(resultDemo());

            resultWrapper.add(result);
            resultContainer.add(resultWrapper);

            this.result = result;

            return resultContainer;
        }

        private JScrollPane createScrollPane() {
            /*
             * Routine di stilizzazione della scrollbar. Per stilizzare la scrollbar è stata
             * usata un'API pubblica integrata in Swing, ossia UIManager.
             */
            JScrollPane scrollPane = new JScrollPane(createResultPanel());

            UIManager.put("ScrollBar.thumb",
                    new ColorUIResource(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER)));
            UIManager.put("ScrollBar.thumbDarkShadow",
                    new ColorUIResource(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER)));
            UIManager.put("ScrollBar.thumbShadow",
                    new ColorUIResource(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER)));
            UIManager.put("ScrollBar.thumbHighlight",
                    new ColorUIResource(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER)));
            UIManager.put("ScrollBar.track",
                    new ColorUIResource(Color.decode(Config.MAIN_VIEWER_FRAME_INNER_BACKGROUND)));

            scrollPane.setBorder(
                    BorderFactory.createLineBorder(Color.decode(Config.MAIN_VIEWER_FRAME_INNER_BACKGROUND), 2));
            scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
            scrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());

            return scrollPane;
        }

        private String resultDemo() {
            /*
             * Questa funzione permette di riempire l'area di testo con contenuto
             * predefinito per finalità di testing. L'area sarà popolata solo ed
             * esclusivamente in debug mode.
             */
            String str = "";
            int j = 50;

            for (int i = 0; i < j; i++)
                str += "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n";

            return str;
        }

    }

    public class ButtonListener extends MouseAdapter {
        /*
         * Logica di creazione del QueryFrame per la rispettiva operazione.
         */

        public void mouseClicked(MouseEvent e) {
            // new QueryViewer ...
        }

        public void mouseEntered(MouseEvent e) {
            Object source = e.getSource();
            JPanel button = (JPanel) source;

            button.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER));
        }

        public void mouseExited(MouseEvent e) {
            Object source = e.getSource();
            JPanel button = (JPanel) source;

            button.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND));
        }

    }

}

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
            setTitle(Config.MAIN_VIEWER_FRAME_TITLE);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(Config.MAIN_VIEWER_FRAME_SIZE[0], Config.MAIN_VIEWER_FRAME_SIZE[1]);

            try {
                setIconImage(ImageIO.read(new File(Config.MOTODB_ICON_PATH)));
            } catch (IOException e) {
                debug("!Impossibile trovare l'icona. Ricontrolla la configurazione.");
            }

            JPanel outer = new JPanel();
            outer.setLayout(new GridLayout(1, 1));
            outer.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_OUTER_BACKGROUND));
            outer.setBorder(new EmptyBorder(Config.DEBUG_MODE_OUTER_PADDING[0], Config.DEBUG_MODE_OUTER_PADDING[1],
                    Config.DEBUG_MODE_OUTER_PADDING[2], Config.DEBUG_MODE_OUTER_PADDING[3]));

            JPanel buttonsContainer = new JPanel();
            buttonsContainer.setBorder(new EmptyBorder(10, -4, -4, -5));
            buttonsContainer.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND));

            JPanel buttonsWrapper = new JPanel();
            buttonsWrapper.setLayout(new GridLayout(Config.Operations.size(), 1));

            for (int i = 0; i < Config.Operations.size(); i++)
                buttonsWrapper.add(createButton(i + 1));

            buttonsContainer.add(buttonsWrapper);

            JPanel resultContainer = new JPanel(new GridLayout(1, 1));
            resultContainer.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_INNER_BACKGROUND));

            /* not here */

            JPanel resultWrapper = new JPanel(new GridLayout(1, 1));
            this.result = new JTextArea("Bentornato!");
            resultContainer.setBorder(new EmptyBorder(15, 15, 15, 15));
            result.setBorder(new EmptyBorder(5, 5, 5, 5));

            result.setBackground(Color.decode(Config.MAIN_VIEWER_FRAME_INNER_BACKGROUND));
            result.setForeground(Color.WHITE);
            result.setEditable(false);
            result.setFont(new Font("Open Sans", Font.PLAIN, 14));
            result.setLineWrap(true);
            result.setWrapStyleWord(true);

            resultWrapper.add(this.result);
            resultContainer.add(resultWrapper);

            /* not here */

            add(buttonsContainer, BorderLayout.WEST);
            outer.add(resultContainer, BorderLayout.CENTER);

            add(outer, BorderLayout.CENTER);

            setLocationRelativeTo(null); // Posiziona centralmente il frame alla creazione
            setVisible(true);

            debug(":MainFrame creato e popolato con successo");
        }

        private JPanel createButton(int id) {
            JPanel buttonContainer = new JPanel(new GridLayout(1, 1));
            JPanel button = new JPanel();
        
            JLabel label = new JLabel("Operazione " + id);

            label.setForeground(Color.WHITE);
            label.setFont(new Font("Open Sans", Font.BOLD, 14));

            button.setBorder(new EmptyBorder(2, 20, 2, 20));
            button.add(label);
            button.setBackground( 
                Color.decode(
                    Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND
                )
            );

            buttonContainer.add(button);

            button.addMouseListener(new ButtonListener());

            return buttonContainer;
        }
        
    }

    public class ButtonListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            // QueryViewer
        }

        public void mouseEntered(MouseEvent e) {
            Object source = e.getSource();
            JPanel button = (JPanel) source;

            button.setBackground(Color.decode(
                Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND_HOVER
            ));
        }

        public void mouseExited(MouseEvent e) {
            Object source = e.getSource();
            JPanel button = (JPanel) source;

            button.setBackground(Color.decode(
                Config.MAIN_VIEWER_FRAME_BUTTON_BACKGROUND
            ));
        }
        
    }

}

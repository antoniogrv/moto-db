package gui;

import javax.swing.JFrame;
import config.Config;
import endpoint.Actor;
import endpoint.Operation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainViewer extends Actor {

    private MainFrame gui;

    public MainViewer() {
        debug("?Genero il MainFrame...");
        this.gui = new MainFrame();
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
            outer.setBackground( 
                Color.decode(
                    Config.DEBUG_MODE_FRAME_OUTER_BACKGROUND
                )
            );
            outer.setBorder(
                new EmptyBorder(
                    Config.DEBUG_MODE_OUTER_PADDING[0],
                    Config.DEBUG_MODE_OUTER_PADDING[1],
                    Config.DEBUG_MODE_OUTER_PADDING[2],
                    Config.DEBUG_MODE_OUTER_PADDING[3]
                )
            );

            JPanel inner = new JPanel();
            inner.setLayout(new BorderLayout());
        
            inner.setBackground(
                Color.decode(
                    Config.DEBUG_MODE_FRAME_INNER_BACKGROUND
                )
            );
    
            inner.setBorder(
                new EmptyBorder(
                    Config.DEBUG_MODE_INNER_PADDING[0],
                    Config.DEBUG_MODE_INNER_PADDING[1],
                    Config.DEBUG_MODE_INNER_PADDING[2],
                    Config.DEBUG_MODE_INNER_PADDING[3]
                )
            );

            JPanel buttonsContainer = new JPanel();

            JPanel buttonsWrapper = new JPanel();
            buttonsWrapper.setLayout(new GridLayout(Config.Operations.size(), 1));
            buttonsWrapper.setBackground(
                Color.decode(
                    Config.DEBUG_MODE_FRAME_INNER_BACKGROUND
                )
            );

            for(int i = 0; i < Config.Operations.size(); i++)
                buttonsWrapper.add(createButton(i+1));

            buttonsContainer.add(buttonsWrapper);

            JPanel resultContainer = new JPanel(new GridLayout(1, 1));
            resultContainer.setBackground( 
                Color.decode(
                    Config.DEBUG_MODE_FRAME_INNER_BACKGROUND
                )
            );
            JPanel resultWrapper = new JPanel(new GridLayout(1, 1));
            this.result = new JTextArea("something");
            resultContainer.setBorder(
                new EmptyBorder(
                    0,
                    Config.DEBUG_MODE_INNER_PADDING[1],
                    0,
                    Config.DEBUG_MODE_INNER_PADDING[3]
                )
            );
            result.setBorder(
                new EmptyBorder(
                    Config.DEBUG_MODE_INNER_PADDING[0],
                    Config.DEBUG_MODE_INNER_PADDING[1],
                    Config.DEBUG_MODE_INNER_PADDING[2],
                    Config.DEBUG_MODE_INNER_PADDING[3]
                )
            );            

            resultWrapper.add(this.result);
            resultContainer.add(resultWrapper);

            inner.add(buttonsContainer, BorderLayout.WEST);
            inner.add(resultContainer, BorderLayout.CENTER);

            outer.add(inner);
            add(outer, BorderLayout.CENTER);

            setLocationRelativeTo(null); // Posiziona centralmente il frame alla creazione
            setVisible(true);

            debug(":MainFrame creato e popolato con successo");
        }

        private JPanel createButton(int id) {
            JPanel button = new JPanel();
            button.add(new JLabel("Operazione " + id));
            button.setBackground(Color.RED);
            return button;
        }

    }

}

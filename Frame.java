import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Frame extends JFrame {
    public Frame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Panel panel = new Panel();
        this.setIconImage(Panel.robotImage.getImage());
        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Robot game ");
        this.pack();
        this.setLocationRelativeTo(null);


    }

}

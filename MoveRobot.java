import javax.sound.sampled.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class MoveRobot {

    static int i = 0;

    static int k = 0;
    static boolean youWon = false;
    static boolean youLost = false;
    File movingFile = new File("Res/moving.wav");
    AudioInputStream movingAudioInputStream;

    Clip movingClip;

    public MoveRobot() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        movingAudioInputStream = AudioSystem.getAudioInputStream(movingFile);
        movingClip = AudioSystem.getClip();
        movingClip.open(movingAudioInputStream);


        if (GamePanel.moves) {


            try {

                if (GamePanel.LDR && i >= GamePanel.index) {
                    Robot.direction = GamePanel.directions2[k];
                    Panel.robot.stepForward();
                    movingClip.start();

                    k++;
                    if (k == 3) {

                        GamePanel.LDR = false;
                        i = GamePanel.index;
                        k = 0;

                    }

                } else if (GamePanel.LDR2 && i >= GamePanel.index) {

                    Robot.direction = GamePanel.directions2[k];
                    Panel.robot.stepForward();
                    movingClip.start();

                    k++;
                    if (k == 3) {
                        GamePanel.LDR2 = false;
                        i = GamePanel.index;
                        k = 0;

                    }


                } else {

                    Robot.direction = GamePanel.directions[i];
                    Panel.robot.stepForward();
                    movingClip.start();


                }

            } catch (Exception e) {

            } finally {


                i++;


            }
        }

        System.out.println(i);

        if (i == GamePanel.directions.length)
            GamePanel.moves = false;

        if (Panel.xRobot == GamePanel.x && Panel.yRobot == GamePanel.y && !GamePanel.moves) {
            youWin();

        } else {
            if (!GamePanel.moves) {


                youLose();


            }


        }

    }

    public void youWin() throws IOException {

        Panel.lvlData++;
        writeData();

        Panel.gameOver = true;
        GamePanel.moves = false;
        youWon = true;
        i = 0;
        k = 0;
    }

    public void youLose() throws IOException {
        if (Panel.lvlData > 1) {
            Panel.lvlData--;
        }
        writeData();


        Panel.gameOver = true;
        youLost = true;

        youWon = false;
        i = 0;
        k = 0;

    }

    public static void writeData() throws IOException {
        BufferedWriter bw2 = new BufferedWriter(new FileWriter("Res/Difficulty_Level"));
        bw2.append(String.valueOf(Panel.lvlData));
        bw2.close();
    }

}
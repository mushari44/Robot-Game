import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class GamePanel extends JPanel {
    static boolean moves = false;

    static int height = 135;

    JLabel rightImageLabel = new JLabel();
    JLabel rightImageLabel2 = new JLabel();


    static boolean left = false;
    static boolean right = false;
    static boolean right2 = false;
    static boolean LDR = false;
    static boolean LDR2 = false;
    static boolean LD = false;
    static boolean LD2 = false;
    static boolean RU = false;
    static boolean RU2 = false;

    static int x = Panel.robot.getX();
    static int y = Panel.robot.getY();

    ImageIcon rightImage = new ImageIcon("Res/directionesPics/right.PNG");
    ImageIcon leftImage = new ImageIcon("Res/directionesPics/left.jpg");
    ImageIcon downImage = new ImageIcon("Res/directionesPics/down.PNG");
    ImageIcon LDRImage = new ImageIcon("Res/directionesPics/LDR.png");
    ImageIcon upImage = new ImageIcon("Res/directionesPics/up.png");

    ImageIcon RUImage = new ImageIcon("Res/directionesPics/RU.png");

    ImageIcon LDImage = new ImageIcon("Res/directionesPics/LD.png");

    static Direction[] directions;
    static Direction[] directions2;
    static Direction[] directions3;

    static int index = 0;

    JLabel leftImageLabel = new JLabel();
    JLabel leftImageLabel2 = new JLabel();

    JLabel downImageLabel = new JLabel();
    JLabel downImageLabel2 = new JLabel();
    JLabel LDRImageLabel = new JLabel();
    JLabel LDRImageLabel2 = new JLabel();

    JLabel upLabel = new JLabel();

    JLabel upLabel2 = new JLabel();

    JLabel RULabel = new JLabel();

    JLabel RULabel2 = new JLabel();
    JLabel LDLabel = new JLabel();
    JLabel LDLabel2 = new JLabel();
    ArrayList<JLabel> imageList = new ArrayList<>();
    ArrayList<JLabel> imageList2 = new ArrayList<>();

    public GamePanel() {


        LDRImageLabel.setIcon(LDRImage);
        LDRImageLabel2.setIcon(LDRImage);
        rightImageLabel.setIcon(rightImage);

        rightImageLabel2.setIcon(rightImage);

        leftImageLabel.setIcon(leftImage);

        leftImageLabel2.setIcon(leftImage);

        downImageLabel.setIcon(downImage);

        downImageLabel2.setIcon(downImage);

        upLabel.setIcon(upImage);
        upLabel2.setIcon(upImage);
        RULabel.setIcon(RUImage);
        RULabel2.setIcon(RUImage);
        LDLabel.setIcon(LDImage);
        LDLabel2.setIcon(LDImage);

        this.setPreferredSize(new Dimension(Panel.screenWidth, 120));
        this.setLayout(new FlowLayout());
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        this.setBackground(new Color(Color.black.darker().getRGB()));
    }

    public void level1() {
        repaint();
        Panel.t.setDelay(1000);

        imageList.removeAll(imageList);
        imageList2.removeAll(imageList2);


        Panel.Timer = 9;
        imageList2.add(upLabel);
        imageList2.add(upLabel2);
        imageList2.add(leftImageLabel);
        imageList2.add(leftImageLabel2);
        imageList2.add(rightImageLabel);
        imageList2.add(rightImageLabel2);
        imageList2.add(downImageLabel);
        imageList2.add(downImageLabel2);
        imageList2.add(LDRImageLabel);
        imageList2.add(LDRImageLabel2);

        Collections.shuffle(imageList2);
        for (int i = 0; i < 4; i++) {
            imageList.add(imageList2.get(i));
        }


        if (LDRImageLabel.isVisible() || LDRImageLabel2.isVisible()) {
            directions2 = new Direction[3];
            directions = new Direction[imageList.size() + directions2.length];
        } else {
            directions = new Direction[imageList.size() + 1];
        }


        this.removeAll();
        repaint();

    }

    void level2() {
        repaint();
        Panel.t.setDelay(1000);

        imageList.removeAll(imageList);
        imageList2.removeAll(imageList2);


        Panel.Timer = 7;
        imageList2.add(upLabel);
        imageList2.add(upLabel2);
        imageList2.add(leftImageLabel);
        imageList2.add(leftImageLabel2);
        imageList2.add(rightImageLabel);
        imageList2.add(rightImageLabel2);
        imageList2.add(downImageLabel);
        imageList2.add(downImageLabel2);
        imageList2.add(LDRImageLabel);
        imageList2.add(LDRImageLabel2);

        Collections.shuffle(imageList2);
        for (int i = 0; i < 5; i++) {
            imageList.add(imageList2.get(i));
        }


        if (LDRImageLabel.isVisible() || LDRImageLabel2.isVisible()) {
            directions2 = new Direction[3];
            directions = new Direction[imageList.size() + directions2.length];
        } else {
            directions = new Direction[imageList.size() + 1];
        }


        this.removeAll();
        repaint();
    }

    void level3() {
        repaint();
        Panel.t.setDelay(1000);

        imageList.removeAll(imageList);
        imageList2.removeAll(imageList2);


        Panel.Timer = 6;
        imageList2.add(upLabel);
        imageList2.add(upLabel2);
        imageList2.add(leftImageLabel);
        imageList2.add(leftImageLabel2);
        imageList2.add(rightImageLabel);
        imageList2.add(rightImageLabel2);
        imageList2.add(downImageLabel);
        imageList2.add(downImageLabel2);
        imageList2.add(LDRImageLabel);
        imageList2.add(LDRImageLabel2);

        Collections.shuffle(imageList2);
        for (int i = 0; i < 7; i++) {
            imageList.add(imageList2.get(i));
        }


        if (LDRImageLabel.isVisible() || LDRImageLabel2.isVisible()) {
            directions2 = new Direction[3];
            directions = new Direction[imageList.size() + directions2.length];
        } else {
            directions = new Direction[imageList.size() + 1];
        }


        this.removeAll();
        repaint();
    }

    void level4() {
        repaint();

        if (MoveRobot.youLost) {
            Panel.t.setDelay(Panel.t.getDelay() + 2);
            MoveRobot.youLost = false;

        } else if (MoveRobot.youWon) {
            Panel.t.setDelay(Panel.t.getDelay() - 2);
            MoveRobot.youWon = false;


        } else Panel.t.setDelay(1000);
        imageList.removeAll(imageList);
        imageList2.removeAll(imageList2);


        Panel.Timer = 5;
        imageList2.add(upLabel);
        imageList2.add(upLabel2);
        imageList2.add(leftImageLabel);
        imageList2.add(leftImageLabel2);
        imageList2.add(rightImageLabel);
        imageList2.add(rightImageLabel2);
        imageList2.add(downImageLabel);
        imageList2.add(downImageLabel2);
        imageList2.add(LDRImageLabel);
        imageList2.add(LDRImageLabel2);

        Collections.shuffle(imageList2);
        for (int i = 0; i < imageList2.size() - 1; i++) {
            imageList.add(imageList2.get(i));
        }


        if (LDRImageLabel.isVisible() || LDRImageLabel2.isVisible()) {
            directions2 = new Direction[3];
            directions = new Direction[imageList.size() + directions2.length];
        } else {
            directions = new Direction[imageList.size() + 1];
        }

        this.removeAll();
        repaint();
    }

    public void imageRandom() throws IOException {
        Panel.difficulty_Level();
        x = Panel.robot.getX();
        y = Panel.robot.getY();

        switch (Panel.lvlData) {
            case 1 -> level1();
            case 2 -> level2();
            case 3 -> level3();
            case 4 -> level4();
            default -> {
                level4();
            }
        }

        Collections.shuffle(imageList);

/*

        for (int i = 0; i < imageList.size(); i++) {
            System.out.println(imageList.get(i));//    newImageList[i]=imageList[(random.nextInt(imageList.length))];

        }
*/

        for (int i = 0; i < imageList.size(); i++) {
            System.out.println(" icno " + imageList.get(i).getIcon());
            if (LDRImageLabel.equals(imageList.get(i))) {

                index = i;
            }
            if (rightImageLabel.equals(imageList.get(i))) {
                this.add(rightImageLabel);

                directions[i] = Direction.RIGHT;
                right = true;
                x += 70;

            } else if (leftImageLabel.equals(imageList.get(i))) {
                this.add(leftImageLabel);
                directions[i] = Direction.LEFT;
                left = true;
                x -= 70;

            } else if (leftImageLabel2.equals(imageList.get(i))) {

                this.add(leftImageLabel2);

                x -= 70;

                directions[i] = Direction.LEFT;

            } else if (rightImageLabel2.equals(imageList.get(i))) {
                this.add(rightImageLabel2);


                directions[i] = Direction.RIGHT;

                x += 70;
                right2 = true;


            } else if (downImageLabel.equals(imageList.get(i))) {

                this.add(downImageLabel);
                y += 70;
                directions[i] = Direction.DOWN;

            } else if (downImageLabel2.equals(imageList.get(i))) {
                this.add(downImageLabel2);
                y += 70;
                directions[i] = Direction.DOWN;

            } else if (upLabel.equals(imageList.get(i))) {
                this.add(upLabel);
                y -= 70;
                directions[i] = Direction.UP;

            } else if (upLabel2.equals(imageList.get(i))) {
                this.add(upLabel2);
                y -= 70;
                directions[i] = Direction.UP;

            } else if (RULabel.equals(imageList.get(i))) {

                RU = true;
                x += 70;
                y -= 70;
                this.add(RULabel);
                directions3[0] = Direction.RIGHT;
                directions3[1] = Direction.UP;
            } else if (RULabel2.equals(imageList.get(i))) {

                RU2 = true;
                x += 70;
                y -= 70;
                directions2[0] = Direction.RIGHT;
                directions2[1] = Direction.UP;
                this.add(RULabel2);
            } else if (LDLabel.equals(imageList.get(i))) {
                LD = true;
                x -= 70;
                y += 70;
                this.add(LDLabel);

                directions3[0] = Direction.LEFT;
                directions3[1] = Direction.DOWN;
            } else if (LDLabel2.equals(imageList.get(i))) {
                this.add(LDLabel2);
                LD2 = true;
                x -= 70;
                y += 70;
                directions2[0] = Direction.LEFT;
                directions2[1] = Direction.DOWN;

            } else if (LDRImageLabel.equals(imageList.get(i))) {
                this.add(LDRImageLabel);


                directions2[0] = Direction.LEFT;
                directions2[1] = Direction.DOWN;
                directions2[2] = Direction.RIGHT;
                LDR = true;

                x -= 70;
                y += 70;
                x += 70;


            } else if (LDRImageLabel2.equals(imageList.get(i))) {

                this.add(LDRImageLabel2);


                directions2[0] = Direction.LEFT;
                directions2[1] = Direction.DOWN;
                directions2[2] = Direction.RIGHT;
                LDR2 = true;

                x -= 70;
                y += 70;
                x += 70;


            }


        }

        repaint();
        for (Direction direction : directions) {
            System.out.println(direction);
        }

    }


}

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.TimerTask;

import static java.lang.String.format;
import static java.lang.String.valueOf;

public class Panel extends JPanel implements ActionListener {
    static ImageIcon robotImage = new ImageIcon("Res/robotImage.png");
    ImageIcon backgroundImage = new ImageIcon("Res/CircuitBackground_DARK.jpg");


    static boolean start = true;
    static int screenWidth = 700;
    int i = 0;

    static int screenHeight = 700;
    static int unit_Size = 70;
    final int gameUnit = (screenWidth * screenHeight) / unit_Size;
    GamePanel gamePanel = new GamePanel();
    static int xRobot = 0;
    static int yRobot = 0;
    static int xx = -1;
    static int yy = -1;
    static MoveRobot moveRobot;
    static Robot robot = new Robot(screenWidth / 2, screenHeight / 2, Direction.STANDING);
    ;
    static int Timer = 10;
    static Timer t;

    Timer timer;
    JLabel countdownLabel = new JLabel("00:00");

    JButton howToPlayButton = new JButton("How to play ");
    boolean howToplayBoolean = false;
    static boolean isStartMenu = true;

    JLabel ll = new JLabel("sdasdasd");
    static boolean gameOver = false;
    static boolean isMoving = GamePanel.moves;
    AudioInputStream audioInputStream;

    Clip bgMusicClip;

    File bgMusicFile = new File("Res/backGroundMusic.wav");


    static int lvlData;

    static boolean reset = false;

    static public void difficulty_Level() throws IOException {

        BufferedReader difficulty_levelBR = new BufferedReader(new FileReader("Res/Difficulty_Level"));
        String data;

        while (((data = difficulty_levelBR.readLine()) != null)) {

            lvlData = Integer.parseInt(data);


        }
        difficulty_levelBR.close();


    }

    public Panel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(bgMusicFile);
        bgMusicClip = AudioSystem.getClip();
        bgMusicClip.open(audioInputStream);
        bgMusicClip.start();
        bgMusicClip.loop(1);
        countdownLabel.setForeground(Color.white.darker());
        countdownLabel.setVisible(true);

        t = new Timer(1000, new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {


                Timer--;
                countdownLabel.setText(format(Timer / 60) + ":" + format(Timer % 60));

                if (Timer <= -1) {
                    Timer = -1;
                    countdownLabel.setText("00:00");
                }
                if (!GamePanel.moves && Timer == 0) {
                    robot = new Robot(350, 350, Direction.STANDING);

                }
            }

        });
        countdownLabel.setPreferredSize(new Dimension(50, 10));

        gamePanel.imageRandom();
        this.add(countdownLabel);
        this.add(gamePanel);
        this.add(howToPlayButton);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black.darker());
        this.setOpaque(true);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        howToPlayButton.addActionListener(this);
        timer = new Timer(200, this);

        timer.start();


    }

    public void draw(Graphics g) throws IOException {
        g.drawImage(robotImage.getImage(), robot.getX(), robot.getY(), null);
        for (int i = 0; i <= screenHeight / unit_Size; i++) {
            g.drawLine(i * unit_Size, 0, i * unit_Size, screenHeight);
        }
        for (int i = 0; i <= screenWidth / unit_Size; i++) {

            g.drawLine(0, i * unit_Size, screenWidth, i * unit_Size);
        }
        g.setFont(new Font(" ", Font.BOLD, 15));
        g.setColor(Color.white);

        g.drawString("Difficulty Level : " + lvlData, 50, 15);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isStartMenu && yy == -1) {


            try {
                startMenu(g);

            } catch (IOException e) {

            }
            gamePanel.setVisible(false);
            howToPlayButton.setVisible(true);

        } else if (xx == 1) {
            howtoPlay(g);

        } else if (gameOver) {
            gameOver(g);

            gamePanel.setVisible(false);

        } else {
            MoveRobot.youWon = false;
            howToPlayButton.setVisible(false);
            gamePanel.setVisible(true);
            try {
                draw(g);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void gameOver(Graphics g) {
        t.stop();


        g.setFont(new Font("a", Font.ITALIC, 50));
        g.setColor(Color.cyan.darker().darker());
        if (MoveRobot.youWon) {


            g.drawString("You Won! ", 250, 100);


        } else if (MoveRobot.youLost) {
            g.drawString("You lost! ", 250, 100);

        }
        g.drawString("Press Enter to continue ", 100, 300);
        MoveRobot.i = 0;
        MoveRobot.k = 0;
        start = false;
        GamePanel.moves = false;
        g.setFont(new Font("f", Font.BOLD, 20));


        g.drawString("Difficulty level : " + Panel.lvlData, 50, 50);
        g.setFont(new Font("f", Font.BOLD, 15));

        g.drawString("Press (R) if you want to reset your difficulty level ", 50, 500);

    }


    public void startMenu(Graphics g) throws IOException {

        t.stop();
        g.drawImage(backgroundImage.getImage(), 0, 0, null);


        MoveRobot.youWon = false;
        gameOver = false;

        g.setColor(new Color(0xFFAAE0FF, true));
        g.setFont(new Font("Ink Free", Font.BOLD, 55));
        FontMetrics fontMetrics3 = getFontMetrics(g.getFont());

        g.drawString("Robot Game ", (screenWidth - fontMetrics3.stringWidth("Robot Game")) / 2, 100);
        g.drawImage(robotImage.getImage(), ((screenWidth - fontMetrics3.stringWidth("Robot Game")) / 2) + 300, 50, null);
        g.setFont(new Font("", Font.PLAIN, 20));
        g.drawString("Press Enter to start the game ", 400, 450);
        g.drawString("Press space to pause the game ", 50, 450);
        g.setFont(new Font("b", Font.PLAIN, 15));
        g.drawString("Press m if you want to mute the music  ", 50, 550);
        g.drawString("Press m if you want to unmute the music  ", 400, 550);

        g.drawString("difculty : " + lvlData, 50, 15);


        howToPlayButton.setFocusable(false);
        howToPlayButton.setBackground(Color.black.darker());
        howToPlayButton.setFont(new Font("", Font.BOLD, 25));
        howToPlayButton.setForeground(Color.DARK_GRAY);
    }


    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    start = true;
                    if (!GamePanel.moves) {
                        xRobot = robot.getX();
                        yRobot = robot.getY();
                        if (t.isRunning())
                            robot = new Robot(350, 350, Direction.STANDING);

                    }
                    if (!isStartMenu && !gameOver) {
                        start = true;
                        GamePanel.moves = true;
                    } else if (gameOver) {
                        robot = new Robot(350, 350, Direction.STANDING);

                    } else {

                        start = false;
                        GamePanel.moves = false;
                    }
                    t.start();

                    isStartMenu = false;
                    if (gameOver) {
                        try {
                            gamePanel.imageRandom();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        isStartMenu = true;


                    }

                    if (isMoving) {
                        start = true;
                        GamePanel.moves = true;
                    }


                    repaint();
                    timer.start();
                    break;
                case KeyEvent.VK_SPACE:

                    timer.stop();
                    start = false;
                    if (!gameOver)
                        isStartMenu = true;
                    repaint();
                    break;
                case KeyEvent.VK_M:
                    if (bgMusicClip.isActive())
                        bgMusicClip.stop();
                    else bgMusicClip.start();

                    break;
                case KeyEvent.VK_S:
                    if (Timer > 0 && !GamePanel.moves)
                        robot.setY(robot.getY() + unit_Size);
                    repaint();
                    break;

                case KeyEvent.VK_W:
                    if (Timer > 0 && !(GamePanel.moves)) {
                        robot.setY(robot.getY() - unit_Size);
                    }
                    repaint();
                    break;

                case KeyEvent.VK_D:
                    if (Timer > 0 && !GamePanel.moves)

                        robot.setX(robot.getX() + unit_Size);
                    repaint();
                    break;
                case KeyEvent.VK_A:
                    if (Timer > 0 && !GamePanel.moves)
                        robot.setX(robot.getX() - unit_Size);
                    repaint();
                    break;
                case KeyEvent.VK_I:
                    System.out.println(robot.getX() + " " + robot.getY() + "  " + robot.getDirection());
                    System.out.println(t.getDelay());
                    System.out.println();
                    System.out.println(xRobot + "   " + GamePanel.x + "  " + yRobot + "   " + GamePanel.y);
                    break;

                case KeyEvent.VK_R:
                    if (gameOver)
                        reset = true;
                    break;
                case KeyEvent.VK_ESCAPE:

                    System.exit(0);
                    break;


            }

        }
    }

    public void move() throws UnsupportedAudioFileException, LineUnavailableException, IOException {


        if (GamePanel.moves) {

            moveRobot = new MoveRobot();

        }




        repaint();



    }


    public void howtoPlay(Graphics g) {
        g.setFont(new Font("font", Font.BOLD, 20));
        g.setColor(Color.white.darker().darker());
        g.drawString("the controls are  W ,A, S ,D ", 50, 100);
        g.drawString("there will be a pictures with a direction you need  ", 50, 200);
        g.drawString(" to move the robot to the same direction before the time end", 50, 250);

        g.drawString("after you moved the robot press Enter to check your answer", 50, 300);


    }

    public void actionPerformed(ActionEvent e) {

        try {
            difficulty_Level();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if (GamePanel.moves) {
            t.stop();
        }

        isMoving = GamePanel.moves;

        if (Timer <= -1 && !gameOver) {
            GamePanel.moves = true;


            try {

                move();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                throw new RuntimeException(ex);
            }

        } else if (start) {
            try {
                move();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                throw new RuntimeException(ex);
            }


        }
        ;

        if (e.getSource().equals(howToPlayButton)) {
            howToplayBoolean = true;
            repaint();


            xx *= -1;
            yy *= -1;
        }


        if (robot.getX() > screenWidth - robotImage.getIconWidth()) {

            robot.setX(screenWidth - robotImage.getIconWidth());

        } else if (robot.getX() < 0) {
            robot.setX(0);
        }
        if (robot.getY() > (screenHeight - robotImage.getIconHeight())) {
            robot.setY(screenHeight - robotImage.getIconHeight());
        } else if (robot.getY() < GamePanel.height) {
            robot.setY(140);
        }
        repaint();


        if (reset) {
            try {

                gamePanel.imageRandom();


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } finally {

                lvlData = 1;
                try {
                    MoveRobot.writeData();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();
                reset = false;

            }
        }
    }

    private static String format(int i) {
        String result = valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;

    }

}
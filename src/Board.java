import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sun.plugin2.util.ColorUtil.ColorRGB;

public class Board extends JPanel implements ActionListener {
    Paddle p1Paddle, p2Paddle;
    Ball p1Ball, p2Ball;
    Timer timer;
   int levelNum = 1;
   Level level;

    //region Colors
  Color red = new Color(255,0,0);
  Color orange = new Color(255,127,0);
  Color yellow = new Color(255,255,0);
  Color lime = new Color(127,255,0);
  Color green = new Color(0,255,0);
  Color teal = new Color(0,255,127);
  Color cyan = new Color(0,255,255);
  Color lightBlue = new Color(0,127,255);
  Color blue = new Color(0,0,255);
//endregion



    public Board(Game game){
      //sets the size JFrame.pack should use if its optimal
      setPreferredSize(new Dimension(600, 800));
      //sets the background color of the panel
      setBackground(Color.BLACK);
      p1Paddle = new Paddle(this, game);
      p2Paddle = new Paddle(this, game);
      p1Ball = new Ball(this);
      p2Ball = new Ball(this);
        level = new Level(levelNum,this);
    timer = new Timer(1000/100, this);
    timer.start();



    }
    public void GameStart(){
    //initial rendering position of graphics
    p1Ball.setPosition(getWidth()/2, getHeight()- p1Ball.diameter);
    p1Paddle.setPosition(0,getHeight()-25);
    p2Paddle.setPosition(0, 25);
    //creates a timer to control rendering graphics and game updates

  }

    public  void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(lightBlue);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 90));
        if(GAMESTATES.isMenu()) {
          g.setFont(new Font("Times New Roman", Font.BOLD, 36));
          printSimpleString("Brick Breaker", getWidth(), 0, (int) getHeight() / 3, g);
          printSimpleString("Press *CONTROL* to change play type.", getWidth(), 0,
              (int) (getHeight() * (2.0 / 3) - 50), g);
          printSimpleString("Game Type: " + GAMESTATES.getGameType() + ".", getWidth(), 0,
              (int) (getHeight() * (2.0 / 3)), g);
          printSimpleString("Press *SPACE* to start.", getWidth(), 0,
              (int) (getHeight() * (2. / 3)) + 50, g);
          //else if(GAMESTATES.isInstruction()){
          // printSimpleString("Instructions", getWidth(), 0, getHeight()/2, g);
          //}
        }
        else if(GAMESTATES.isPause()){
            printSimpleString("Pause", getWidth(), 0, getHeight()/2, g);
        }
        else if(GAMESTATES.isPlay()) {
          //printSimpleString("Play", getWidth(), 0, getHeight()/2, g);
          g.setColor(Color.blue);
          p1Ball.paint(g);
          //p1Paddle.paint(g);
          if (GAMESTATES.isMulti()) {
            g.setColor(lime);
            p2Ball.paint(g);
            p2Paddle.paint(g);
          }
          level.paint(g);




        }
        else{

        }

    }



int ticks = 0;
  @Override
  public void actionPerformed(ActionEvent e) {
      if(GAMESTATES.isPlay()){
        for(int column = 0; column<level.level[0].length; column++) {
          for (int row = 0; row < level.level.length; row++) {
            level.level[row][column].checkCollision(p1Ball);
          }
        }
        p1Ball.checkCollision(level);

        p1Paddle.move();
        p1Ball.move();
        //p1Ball.checkCollisions(p1Paddle);

        if(GAMESTATES.isMulti()) {
            p2Paddle.move2nd();
            p2Ball.move();
        }
        ticks +=1;
        if(ticks%1000==0){
          for(int column = 0; column<level.level[0].length; column++) {
            for (int row = 0; row < level.level.length; row++) {
              level.level[row][column].move();
            }
          }
        }






      }



      repaint();
  }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){

        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();

        int start = width/2 - stringLen/2;

        g2d.drawString(s, start + XPos, YPos);
    }
}

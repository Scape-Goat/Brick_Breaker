import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sun.plugin2.util.ColorUtil.ColorRGB;

public class Board extends JPanel implements ActionListener {
    Paddle p1Paddle, p2Paddle;
    Ball p1Ball, p2Ball;
    Timer timer;
   
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
      setPreferredSize(new Dimension(800, 800));
      //sets the background color of the panel
      setBackground(Color.BLACK);
      p1Paddle = new Paddle(this, game);
      p2Paddle = new Paddle(this, game);
      p1Ball = new Ball(this);
      p2Ball = new Ball(this);
        level = new Level(9,this);
    timer = new Timer(0, this);
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
        g.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        if(GAMESTATES.isMenu()){
            printSimpleString("Menu", getWidth(), 0, getHeight()/2, g);
        }
        //else if(GAMESTATES.isInstruction()){
           // printSimpleString("Instructions", getWidth(), 0, getHeight()/2, g);
        //}

        else if(GAMESTATES.isPause()){
            printSimpleString("Pause", getWidth(), 0, getHeight()/2, g);
        }
        else if(GAMESTATES.isPlay()){
            //printSimpleString("Play", getWidth(), 0, getHeight()/2, g);
          g.setColor(Color.blue);
            //p1Ball.paint(g);
            //p1Paddle.paint(g);
            if(GAMESTATES.isMulti()) {
              g.setColor(lime);
              p2Ball.paint(g);
              p2Paddle.paint(g);
            }
            level.paint(g);


        }
        else{

        }

    }




  @Override
  public void actionPerformed(ActionEvent e) {
      if(GAMESTATES.isPlay()){
        for(int column = 0; column<level.level[0].length; column++) {
          for (int row = 0; row < level.level.length; row++) {
            level.level[row][column].checkCollision(p1Ball);
          }
        }

        p1Paddle.move();
        p1Ball.move();
        if(GAMESTATES.isMulti()) {
            p2Paddle.move2nd();
            p2Ball.move();
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

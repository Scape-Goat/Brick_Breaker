import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    Paddle p1Paddle, p2Paddle;
    Ball p1Ball, p2Ball;
    Timer timer;

    public Board(Game game){
      //sets the size JFrame.pack should use if its optimal
      setPreferredSize(new Dimension(800, 600));
      //sets the background color of the panel
      setBackground(Color.BLACK);
      p1Paddle = new Paddle(this, game);
      p2Paddle = new Paddle(this, game);
      p1Ball = new Ball(this);
      p2Ball = new Ball(this);

    timer = new Timer(1000/60, this);
    timer.start();

    }

    public  void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SERIF, Font.BOLD, 90));
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
            printSimpleString("Play", getWidth(), 0, getHeight()/2, g);
        }
        else{

        }

    }




  @Override
  public void actionPerformed(ActionEvent e) {
    if(GAMESTATES.isPlay()){
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

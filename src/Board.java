import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {
    Paddle p1Paddle, p2Paddle;
    Ball ball;

    public Board(){
      //sets the size JFrame.pack should use if its optimal
      setPreferredSize(new Dimension(800, 600));
      //sets the background color of the panel
      setBackground(Color.BLACK);

      ball = new Ball();
      p1Paddle = new Paddle();
      p2Paddle = new Paddle();
    }





  @Override
  public void actionPerformed(ActionEvent e) {
    p1Paddle.move();
      ball.move();

      repaint();
  }
}

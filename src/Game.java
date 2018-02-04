import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends JFrame implements KeyListener {

  Board board;
  public Game(){
    //enables/disables user ability to change frame size
    setResizable(false);
    //enables/disables whether the frame renders on screen
    //*************************
    setVisible(true);

    //*************************
    //enables/disables whether the frame can be an active window
    setFocusable(true);
    //sets the text in the title bar of the frame
    setTitle("Brick Breaker");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //creates an instance of the Board class
    board = new Board();
    //adds the board panel to the frame
    add(board);
    //add the KeyListener to the frame so its active
    addKeyListener(this);
    //packages all components and determines best layout/size
    pack();
    //centers the frame on the screen
    setLocationRelativeTo(null);
    //board.GameStart();
  }

  public static void main(String[] args){
    // calls a new instance of the game class - runs the constructor
    new Game();
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}

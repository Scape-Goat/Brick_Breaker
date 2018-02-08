import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends JFrame implements KeyListener {

  Board board;
  private boolean leftPressed, rightPressed, aPressed, dPressed;

  public Game(){

    setResizable(false);

    setVisible(true);


    setFocusable(true);

    setTitle("Brick Breaker");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    board = new Board();

    add(board);

    addKeyListener(this);

    pack();

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
    if(e.getKeyCode() == KeyEvent.VK_LEFT) leftPressed = true;

    if(e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = true;

    if(e.getKeyCode() == KeyEvent.VK_A) aPressed = true;

    if(e.getKeyCode() == KeyEvent.VK_D) dPressed = true;

    if(e.getKeyCode() == KeyEvent.VK_ESCAPE)GAMESTATES.startMenu();

      if(e.getKeyCode() == KeyEvent.VK_CONTROL && GAMESTATES.isMenu()) GAMESTATES.toggleGameType();

    if(e.getKeyCode() == KeyEvent.VK_P && (GAMESTATES.isPlay()|| GAMESTATES.isPause())) {
      GAMESTATES.togglePause();
      GAMESTATES.togglePlay();
    }
    if(e.getKeyCode() == KeyEvent.VK_SPACE && (GAMESTATES.isMenu() || GAMESTATES.isEnd())){
      GAMESTATES.startPlay();
      GAMESTATES.stopMenu();
      GAMESTATES.stopPause();
      //board.gameRestart();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_LEFT) leftPressed = false;

    if(e.getKeyCode() == KeyEvent.VK_RIGHT) rightPressed = false;

    if(e.getKeyCode() == KeyEvent.VK_A) aPressed = false;

    if(e.getKeyCode() == KeyEvent.VK_D) dPressed = false;


  }

  public boolean isLeftPressed() {return leftPressed;}
  public boolean isRightPressed() {return rightPressed;}
  public boolean isaPressed() {return aPressed;}
  public boolean isdPressed() {return dPressed;}
}

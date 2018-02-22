import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends JFrame implements KeyListener {

  Board board;
  private boolean leftPressed, rightPressed, left, right, wait;

  public Game(){

    setResizable(false);

    setVisible(true);


    setFocusable(true);

    setTitle("Brick Breaker");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    board = new Board(this);

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

    if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) left = true;

    if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;

    if(e.getKeyCode() == KeyEvent.VK_ESCAPE)GAMESTATES.startMenu();


    if(e.getKeyCode() == KeyEvent.VK_P && (GAMESTATES.isPlay()|| GAMESTATES.isPause())) {
      GAMESTATES.togglePause();
      GAMESTATES.togglePlay();
    }
    if(e.getKeyCode() == KeyEvent.VK_SPACE && (GAMESTATES.isMenu() || GAMESTATES.isEnd())){
      GAMESTATES.startPlay();
      board.GameStart();
      GAMESTATES.stopMenu();
      GAMESTATES.stopPause();
      //board.gameRestart();
    }
    if(e.getKeyCode() == KeyEvent.VK_SPACE && GAMESTATES.isPlay() && wait)
      wait = false;
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) left = false;

    if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;


  }

  public boolean isLeft() {return left;}
  public boolean isRight() {return right;}
  public boolean isWait(){return wait;}


  public void toggleWait(){
    wait = !wait;
  }
}

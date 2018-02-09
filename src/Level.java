import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Level {
  List<Brick> level = new ArrayList<Brick>();


  int rank = 1;

  public Level(Board board) {
  for (int x = 0; x<board.getWidth(); x+=100)
   level.add(new Brick(x, board.getHeight()/2, 1));
    }



  public void paint(Graphics g) {
    for(int i=0; i<level.size(); i++){
      level.get(i).paint(g);
    }
  }
}
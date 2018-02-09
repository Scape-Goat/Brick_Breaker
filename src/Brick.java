import java.awt.Color;
import java.awt.Graphics;

public class Brick {



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
  Color[] colors = {red,orange,yellow,lime,green,teal,cyan, lightBlue,blue};
  //endregion

  int x, y, rank;
   int width = 100;
   int height = 20;

  public Brick(int x, int y, int rank){
    this.x = x;
    this.y=y;
    this.rank = rank;
  }

  public void decreaseRank(){
    rank-=1;
  }

  public void paint(Graphics g){
    g.setColor(colors[rank]);
    g.fillRect(x, y, 100, 20);
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

}

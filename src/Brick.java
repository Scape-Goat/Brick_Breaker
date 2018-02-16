import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Brick {
boolean paint = true, pointsGiven = false;
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
  Color[] colors = {red,orange,yellow,lime,green,teal,cyan, lightBlue,blue};
  //endregion

  int x, y, currentRank, originalRank;
   static int width = 50;
   static int height = 25;

  public Brick(int x, int y, int rank, int width, int height, Level level){
    this.width = width;
    this.height = height;
    this.x = x;
    this.y=y;
    currentRank = rank-1;
    originalRank = rank;
    this.level = level;
  }

  public void decreaseRank(){
    if(y>=0) {
      currentRank -= 1;
      if (currentRank < 0 && !pointsGiven) {
        paint = false;
        pointsGiven = true;
        GAMESTATES.increaseP1Score(originalRank);
      }
    }
  }

  public void paint(Graphics g){
    if(paint) {
      g.setColor(colors[currentRank]);
      g.fillRect(x, y, width, height);
    }
  }

  public void move(){
    y+=height+level.getBrickGap();
  }

  public static int getWidth() {
    return width;
  }

  public static int getHeight() {
    return height;
  }

  public Rectangle getBounds(){
    return new Rectangle(x , y, width, height);
  }

  public void checkCollision(Ball ball){
      if(getBounds().intersects(ball.getBounds())) {
        if(paint) {
            if(ball.x+(ball.diameter*(2.0/3))>x && ball.x+(ball.diameter*(1.0/3))<x+width)
            ball.dy *= -1;
            if(ball.y+(ball.diameter*(2.0/3))>y && ball.y+(ball.diameter*(1.0/3))<y+height)
                ball.dx*=-1;


        }

        decreaseRank();

//k
      }



    }


}

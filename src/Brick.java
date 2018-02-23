import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

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

  int x, y, rank, originalRank;
   static int width;
   static int height = 25;

  public Brick(int x, int y, int rank, int width, int height, Level level){
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;



    this.rank = rank-1;

    originalRank = rank;
    this.level = level;
  }

  public void decreaseRank(Ball ball, ArrayList<Power_Up> PowerUps, Paddle paddle){
    if(y>=0) {
      rank -= 1;
      if (rank < 0 && !pointsGiven) {
        paint = false;
        pointsGiven = true;
        GAMESTATES.increaseP1Score(originalRank);
        if((int)(Math.random()*5)==1)
        PowerUps.add(new Power_Up(paddle,ball,x,y));
      }
    }
  }

  public void paint(Graphics g){
    if(paint && y>=0) {
      g.setColor(colors[rank]);

      g.fillRect(x, y, width, height);
    }
  }

  public void move(){ y+=height+level.getBrickGap(); }

  public static int getWidth() {
    return width;
  }

  public static int getHeight() {
    return height;
  }

  public Rectangle getBounds(){
    return new Rectangle(x , y, width, height);
  }

  public void checkCollision(Ball ball, ArrayList<Power_Up> PowerUps, Paddle paddle){
      if(getBounds().intersects(ball.getBounds())) {
        if(paint && y>=0) {
            if(ball.getBreakingStatus() != "Piercing") {
              if (ball.x + (ball.getDiameter() * (2.0 / 3)) > x
                  && ball.x + (ball.getDiameter() * (1.0 / 3)) < x + width)
                ball.dy *= -1;
              if (ball.y + (ball.getDiameter() * (2.0 / 3)) > y
                  && ball.y + (ball.getDiameter() * (1.0 / 3)) < y + height)
                ball.dx *= -1;
            }
        }
        if(ball.getBreakingStatus() != "Dulled")
          decreaseRank(ball,PowerUps, paddle);
      }
  }

  public void checkLocation(Paddle paddle, Ball ball){
      if(paint && y+height >= paddle.getY()-ball.getDiameter() )
          GAMESTATES.endGame();
  }


}

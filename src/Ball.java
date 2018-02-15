import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
  final double  SPEED = 5;
  double MAXANGLE = 5*Math.PI/12; //70 degrees

int x, y, diameter = 20;
double dx= SPEED, dy=SPEED;
boolean wait = false;

    Board board;
    Game game;


    public Ball(Board board, Game game){
        x = 0;
        y = 0;

        this.board = board;
        this.game = game;
    }

    public void move(Paddle paddle){
        if(!game.isWait()) {
            if (x < 0 || x + diameter > board.getWidth())
                dx *= -1;
            if (y < 0 || y + diameter > board.getHeight())
                dy *= -1;

            x += dx;
            y += dy;
        }
        else{
            x = paddle.x+paddle.width/2-diameter/2;
            y= paddle.y-diameter;
        }
    }

    public void setPosition(int x, int y){
      this.x = x-diameter/2;
      this.y = y-diameter/2;
    }

  public void paint(Graphics g){
    g.fillOval(x, y, diameter, diameter);
  }
  public Rectangle getBounds(){return new Rectangle(x,y,diameter,diameter);}

  public void checkCollision(Level level){
    for(int column = 0; column<level.level[0].length; column++) {
      for (int row = 0; row < level.level.length; row++) {
        double brickX = level.level[row][column].getBounds().getX();
        double brickCenter = level.level[row][column].getBounds().getWidth() / 2;
        double ballx = x;

        double relativeIntersect = (brickX + brickCenter) - ballx;
        double normalIntersect = relativeIntersect / brickCenter;
        double bounceAngle = MAXANGLE * normalIntersect;

        //if(x < level.level[row][column].getWidth()/2)
        //dy *= -1;

        //if ()

        //if(x > board.getWidth()/2)
          //dy = (int)(SPEED*Math.cos(bounceAngle));
        //dx = (int)(SPEED*-Math.sin(bounceAngle));

      }
    }



  }

  public void checkCollisions(Paddle other){

    if(getBounds().intersects(other.getBounds())) {
      double paddleX = other.getBounds().getX();
      double paddleCenter = other.getBounds().getWidth() / 2;
      double ballx = x+diameter/2;

      double relativeIntersect = (paddleX + paddleCenter) - ballx;
      double normalIntersect = relativeIntersect / paddleCenter;
      double bounceAngle = MAXANGLE * normalIntersect;

      //if(x < board.getWidth()/2){
        dy = (int)(-SPEED*Math.cos(bounceAngle));
      //}
      //if(x > board.getWidth()/2){
        //dx = (int)(SPEED*-Math.cos(bounceAngle));
      //}
      dx = (int)(SPEED*-Math.sin(bounceAngle));

    }
  }



  public void checkLocation(Paddle paddle){
        if(paddle.getY()<y)
            game.toggleWait();
  }


}

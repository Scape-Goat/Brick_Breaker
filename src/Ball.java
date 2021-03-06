import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
  double  SPEED = 5;
  double MAXANGLE = 3*Math.PI/12; //70 degrees

int x, y, diameter = 15;
double dx= SPEED, dy=SPEED;
String status = "Normal";

    Board board;
    Game game;


    public Ball(Board board, Game game){
        x = 0;
        y = 0;

        this.board = board;
        this.game = game;
    }

    public void move(Paddle paddle){
        if(!game.isWait() && GAMESTATES.isPlay()) {
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

        dy = (int)(-SPEED*Math.cos(bounceAngle));

        dx = (int)(SPEED*-Math.sin(bounceAngle));

    }
  }

  public void sizeGrow(){
      diameter = 20;
  }
  public void sizeShrink(){
    diameter = 10;
  }
  public void sizeReset(){ diameter = 15; }
  public String getSizeStatus(){
      switch(diameter){
          case 10: return "Small";
          case 15: return "Normal";
          case 20: return "Large";
          default: return "It broke";
      }
  }

  public void piercing(){
      status = "Piercing";
  }
  public void dulled(){
    status = "Dulled";
  }
  public void normal(){
      status = "Normal";
  }
  public String getBreakingStatus(){
      return status;
  }

  public void speedUp(){
      double angleX = (dx/SPEED);
      double angleY = (dy/SPEED);
      SPEED = 6;
      dx = SPEED*angleX;
      dy = SPEED*angleY;

  }
  public void slowDown(){
    double angleX = (dx/SPEED);
    double angleY = (dy/SPEED);
    SPEED = 4;
    dx = SPEED*angleX;
    dy = SPEED*angleY;
  }
  public void speedReset(){
    double angleX = (dx/SPEED);
    double angleY = (dy/SPEED);
    SPEED = 5;
    dx = SPEED*angleX;
    dy = SPEED*angleY;
  }

  public String getSpeedStatus(){
        switch((int)SPEED){
            case 4: return "Slow";
            case 5: return "Normal";
            case 6: return "Fast";
            default: return "It broke";
        }
  }



  public void checkLocation(Paddle paddle) {
      if (paddle.getY()+5 < y + diameter) {
          game.toggleWait();
      }

  }

    public int getDiameter() {
        return diameter;
    }

    public void flipX(){
        dx*=-1;
    }
    public void flipY(){
        dy*=-1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

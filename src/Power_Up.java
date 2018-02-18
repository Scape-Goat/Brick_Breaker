import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Power_Up {

  int x, y, type, width = 50, height = 25;
  boolean paint = true;


  public Power_Up(Paddle paddle, Ball ball, int x, int y){
    type = (int)(Math.random()*9);


    this.x = x;
    this.y = y;


  }

  public void move(){
    if(paint)
    y+=1;
  }

  public void paint(Graphics g){
    if(paint) {
      int[] xPosition = {x, x + width / 2, x + width};
      int[] yPosition = {y, y + height, y};
      g.fillPolygon(xPosition, yPosition, 3);
    }
  }

  public Rectangle getBounds(){
    return new Rectangle(x,y,width,height);
  }


  public void checkCollision(Paddle paddle, Ball ball, Board board){
    if(getBounds().intersects(paddle.getBounds()) && paint){
      switch(type){
        case 0: paddle.sizeGrow(); break;
        case 1: paddle.sizeShrink(); break;

        case 2: paddle.speedUp(); break;
        case 3: paddle.slowDown(); break;

        case 4: ball.sizeGrow(); break;
        case 5: ball.sizeShrink(); break;

        case 6: ball.piercing(); break;
        case 7: ball.dulled(); break;

        case 8: ball.speedUp(); break;
        case 9: ball.slowDown(); break;


        //case 16:  break;
        // case 17:  break;
        //case 18: paddle.sizeReset(); break;

        //case 19:  break;
        //case 20:  break;
        //case 21:

      }
      paint = false;
      board.powerUpTicks[type/2] = board.ticks;
      System.out.println(type);

    }
    if(y>board.getHeight())
      paint = false;


  }




}

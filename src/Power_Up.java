import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Power_Up {

  int x, y, type, width = 50, height = 50;
  boolean paint = true;


  public Power_Up(Paddle paddle, Ball ball, int x, int y){
    type = (int)(Math.random()*15)+1;


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
        case 1: paddle.sizeGrow(); break;
        case 2: paddle.sizeShrink(); break;
        case 3: paddle.sizeReset(); break;

        case 4: paddle.speedUp(); break;
        case 5: paddle.slowDown(); break;
        case 6: paddle.speedReset(); break;

        case 7: ball.sizeGrow(); break;
        case 8: ball.sizeShrink(); break;
        case 9: ball.sizeReset(); break;

        case 10: ball.piercing(); break;
       // case 11: ball.dulled(); break;
        case 12: ball.normal(); break;

        case 13: ball.speedUp(); break;
        case 14: ball.slowDown(); break;
        case 15: ball.speedReset(); break;

        //case 16:  break;
        // case 17:  break;
        //case 18: paddle.sizeReset(); break;

        //case 19:  break;
        //case 20:  break;
        //case 21:

      }
      paint = false;
      System.out.println(type);

    }
    if(y>board.getHeight())
      paint = false;


  }




}

public class Ball {
    int x, y, dx, dy, diameter = 50;

    Board board;
    public Ball(Board board){
        x = 0;
        y = 0;

        this.board = board;
    }

    public void move(){
        if(x<0 || x+diameter>board.getWidth())
            dx*=-1;

    }


}

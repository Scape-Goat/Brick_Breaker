public class GAMESTATES {


	  //booleans that change the state of the game
    private static boolean isPlay = false;
    private static boolean  isPause = false;
    private static boolean  isEnd = false;
    private static boolean  isMenu = true;
    private static String gameOver = "You Win";

  private static Integer
	  p1Score = new Integer(0),
	  life = new Integer(3);

  private static int multiplier = 1;



    public static Integer getP1Score() {
        return p1Score;
    }

    public static void resetScore(){p1Score=0;}

    public static void setMultiplier(int num){
      multiplier = num;
    }

    public static void increaseP1Score(int rank) {
        p1Score+=(rank*50*multiplier);
    }

    public static boolean isPlay() {return isPlay;}
	public static boolean isPause() {return isPause;}
	public static boolean isEnd() {return isEnd;}
	public static boolean isMenu() {return isMenu;}





	public static void togglePlay(){isPlay = !isPlay;}
	public static void togglePause(){isPause = !isPause;}
	public static void toggleMenu(){isMenu = !isMenu;}


    public static void startPlay(){isPlay = true;}
    public static void stopPlay(){isPlay = false;}
    public static void startMenu(){isMenu = true;}
    public static void stopMenu(){isMenu = false;}
    public static void startPause(){isPause = true;}
    public static void stopPause(){isPause = false;}
    public static void endGame(){ isEnd = true; stopPlay();}
    public static void startGame(){isEnd = false;}


    public static String getGameOver() {
        return gameOver;
    }

    public static void lose() {
        gameOver = "You Lose!!!";
    }

    public static void win(){
        gameOver = "You Win!!!";
    }
}

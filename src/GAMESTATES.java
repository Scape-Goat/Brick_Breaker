public class GAMESTATES {


	  //booleans that change the state of the game
    private static boolean isPlay = false;
    private static boolean  isPause = false;
    private static boolean  isEnd = false;
    private static boolean  isMenu = true;
    private static boolean  isMulti = false;
    private  static boolean isInstruction = false;
    private static String gameType = "Player VS AI";

  private static Integer
	  p1Score = new Integer(0),
	  p2Score = new Integer(0),
	  life = new Integer(3),
	  level = new Integer(1);

  private static String GameType = "One Player";

    public static Integer getP1Score() {
        return p1Score;
    }

    public static void increaseP1Score(int rank) {
        p1Score+=(rank*50);
    }

    public static boolean isPlay() {return isPlay;}
	public static boolean isPause() {return isPause;}
	public static boolean isEnd() {return isEnd;}
	public static boolean isMenu() {return isMenu;}
	public static boolean isMulti() {return isMulti;}
    public static boolean isInstruction() {return isInstruction;}

    public static String getGameType() {return gameType;}


	public static void togglePlay(){isPlay = !isPlay;}
	public static void toggleMulti(){isMulti = !isMulti;}
	public static void togglePause(){isPause = !isPause;}
	public static void toggleMenu(){isMenu = !isMenu;}
    public static void toggleInstruction(){isInstruction = !isInstruction;}

    public static void startPlay(){isPlay = true;}
    public static void stopPlay(){isPlay = false;}
    public static void startMenu(){isMenu = true;}
    public static void stopMenu(){isMenu = false;}
    public static void startPause(){isPause = true;}
    public static void stopPause(){isPause = false;}
    public static void endGame(){ isEnd = true;}
    public static void startGame(){isEnd = false;}


    public static void toggleGameType(){
        if(gameType.equals("Player VS AI"))
            gameType = "Player VS Player";
        else
            gameType = "Player VS AI";
        toggleMulti();


    }

}

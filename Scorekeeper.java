/**
 * Keeping score for the Triple game
 * 
 * @JeanZhai
 * 1/9/2025
 */
public class Scorekeeper  
{
    private static int deckSize;
    private static int score;
    private static long startTime = System.currentTimeMillis();
    
    public static void setDeckSize(int size)
    {
        deckSize = size;
    }
    
    public static void updateScore()
    {
        long elapsedTime = System.currentTimeMillis() - startTime;
        score += (120000 - elapsedTime) / 1000;
        startTime = System.currentTimeMillis();
    }
    
    public static int getScore()
    {
        return score;
    }
}

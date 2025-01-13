/**
 * Write a description of class Scorekeeper here.
 * 
 * @Jean Zhai
 * @January 13, 2025
 */
public class Scorekeeper  
{
    private static int deckSize, score;
    private static long startTime= System.currentTimeMillis();

    public static void setDeckSize(int size)
     {
         deckSize = size;
     }
     
    public static void updateScore()
    {
    
        score += Math.abs(27 - (System.currentTimeMillis()-startTime)/1000);
        startTime = System.currentTimeMillis();
    }

    public static int getScore()
    {
        return score;
    }
}

import greenfoot.*;
 /* Animation for Tiples 
 * 
 * @Jean Zhai
 * @January 13
 */
public class Animations  
{
    public static void wobble(Card[] cards)
    {
        Greenfoot.playSound("wobble.wav");
    }
    
    public static void slideAndTurn(Card[] cards)
    {
        Greenfoot.playSound("swoosh.wav");
        for(int i = 0; i < cards.length; i++)
        {
            cards[i].move(-500);
        }
    }
    
}

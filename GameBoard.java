import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Board for Triples
 * 
 * JeanZhai
 * 1/22/2025
 */
public class GameBoard extends World
{
    private final int NUM_CARDS_IN_DECK = 27;
    
    public GameBoard()
    {   
        super(430, 600, 1, false); 
        //new Tester(NUM_CARDS_IN_DECK);
        Dealer dealer = new Dealer(NUM_CARDS_IN_DECK);
        addObject(dealer, -30, -30);
    }
}
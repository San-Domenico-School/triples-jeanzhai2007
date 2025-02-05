import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * A subclass of the Actor class
 * 
 * JeanZhai
 * 1/24/2024
 */
public class Dealer extends Actor
{
    public Deck deck;
    private ArrayList<Card> cardsOnBoard = new ArrayList<Card>();
    private ArrayList<Integer> selectedCardsIndex = new ArrayList<Integer>();
    private Card[] cardsSelected;
    private int numCardsInDeck;
    private int triplesRemaining;
    
    public Dealer(int numCardsInDeck)
    {
        this.numCardsInDeck = numCardsInDeck;
        triplesRemaining = numCardsInDeck / 3;
        deck = new Deck(numCardsInDeck);
        cardsSelected = new Card[3];
    }
    
    public void addedToWorld(World world)
    {
        dealBoard();
        setUI();
    }
    
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.wav");
        for(int row = 1; row <= 5; row++)
        {
            for(int column = 1; column <= 3; column++)
            {
                getWorld().addObject(deck.getTopCard(), column * 127 - 39, row * 75 + 10);
            }
        }
    }
    
    public void setUI()
    {
        Integer cardsRemaining = new Integer(deck.getNumCardsInDeck());
        getWorld().showText(cardsRemaining.toString(), 315, 470);
        Integer score = new Integer(Scorekeeper.getScore());
        getWorld().showText(score.toString(), 315, 505);
    }
    
    public void endGame()
    {
        if(triplesRemaining == 0)
        {
            Greenfoot.stop();
        }
    }
    
    public void checkIfTriple()
    {
        System.out.println(cardsSelected[0]);
        boolean num = ((cardsSelected[0].getNumberOfShapes() + cardsSelected[1].getNumberOfShapes() + cardsSelected[2].getNumberOfShapes()) % 3 == 0);
        boolean color = ((cardsSelected[0].getColor().ordinal() + cardsSelected[1].getColor().ordinal() + cardsSelected[2].getColor().ordinal()) % 3 == 0);
        boolean shape = ((cardsSelected[0].getShape().ordinal() + cardsSelected[1].getShape().ordinal() + cardsSelected[2].getShape().ordinal()) % 3 == 0);
        boolean shading = ((cardsSelected[0].getShading() + cardsSelected[1].getShading() + cardsSelected[2].getShading()) % 3 == 0);
        if(num && color && shape && shading)
        {
            actionIfTriple();
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
    }
    
    public void actionIfTriple()
    {
        for(int i = 0; i < 3; i++)
        {
            getWorld().addObject(deck.getTopCard(), 
                                 cardsSelected[i].getX(), cardsSelected[i].getY());
            getWorld().removeObject(cardsSelected[i]);
        }
        Animations.slideAndTurn(cardsSelected);
        triplesRemaining--;
        Scorekeeper.updateScore();
        setUI();
        endGame();
    }
    
    public void setCardsSelected(ArrayList<Card> cardsOnBoard, Card[] cardArray,ArrayList<Integer> indexList)
    {
        this.cardsOnBoard = cardsOnBoard;
        selectedCardsIndex = indexList;
        cardsSelected = cardArray;
        checkIfTriple();
    }
}

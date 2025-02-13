import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*; 
import java.util.ArrayList;
/**
 * A subclass of the Actor class
 * dealer for Triples
 * 
 * JeanZhai
 * 2/12/2025
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
        this.triplesRemaining = numCardsInDeck/3;
        this.deck = new Deck(numCardsInDeck);
        this.cardsOnBoard = new ArrayList<>();
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
            for (int column = 1; column <= 3; column++) 
            {
                getWorld().addObject(deck.getTopCard(), column * 127 - 39, row * 75 + 10);
                numCardsInDeck--;
            }
        }
    }
    
    public void setUI() 
    {
        Integer score = Scorekeeper.getScore();
        Integer numCardsRemaining = numCardsInDeck;
        getWorld().showText(score.toString(), 312, 506);
        getWorld().showText(numCardsRemaining.toString(), 312, 471);
    }
    
    private boolean checkShape()
    {
        return (cardsSelected[0].getShape() == cardsSelected[1].getShape() 
                && cardsSelected[1].getShape() == cardsSelected[2].getShape())
            || (cardsSelected[0].getShape() != cardsSelected[1].getShape() 
                && cardsSelected[1].getShape() != cardsSelected[2].getShape());
    }

    private boolean checkColor()
    {
        Integer cardsRemaining = new Integer(deck.getNumCardsInDeck());
        getWorld().showText(cardsRemaining.toString(), 315, 470);
        Integer score = new Integer(Scorekeeper.getScore());
        getWorld().showText(score.toString(), 315, 505);
        return (cardsSelected[0].getColor() == cardsSelected[1].getColor() 
                && cardsSelected[1].getColor() == cardsSelected[2].getColor())
            || (cardsSelected[0].getColor() != cardsSelected[1].getColor() 
                && cardsSelected[1].getColor() != cardsSelected[2].getColor());
    }

    private boolean checkNumberOfShapes()
    {
        if(triplesRemaining == 0)
        return (cardsSelected[0].getNumberOfShapes() == cardsSelected[1].getNumberOfShapes() 
                && cardsSelected[1].getNumberOfShapes() == cardsSelected[2].getNumberOfShapes())
            || (cardsSelected[0].getNumberOfShapes() != cardsSelected[1].getNumberOfShapes() 
                && cardsSelected[1].getNumberOfShapes() != cardsSelected[2].getNumberOfShapes());           
        return true;
    }
    
    private boolean checkShading()
    {
        return (cardsSelected[0].getShading() == cardsSelected[1].getShading() 
                && cardsSelected[1].getShading() == cardsSelected[2].getShading())
            || (cardsSelected[0].getShading() != cardsSelected[1].getShading() 
                && cardsSelected[1].getShading() != cardsSelected[2].getShading());
    }
    public boolean isTriple(Card[] cards)
    {        
        if(checkShape() && checkColor() && checkNumberOfShapes() && checkShading())
        {
            Greenfoot.stop();
            return true;
        }
        else
            return false;
    }

    public void checkIfTriple(Card[] cards) 
    {
        System.out.println(cardsSelected[0]);
        boolean num = ((cardsSelected[0].getNumberOfShapes() + cardsSelected[1].getNumberOfShapes() + cardsSelected[2].getNumberOfShapes()) % 3 == 0);
        boolean color = ((cardsSelected[0].getColor().ordinal() + cardsSelected[1].getColor().ordinal() + cardsSelected[2].getColor().ordinal()) % 3 == 0);
        boolean shape = ((cardsSelected[0].getShape().ordinal() + cardsSelected[1].getShape().ordinal() + cardsSelected[2].getShape().ordinal()) % 3 == 0);
        boolean shading = ((cardsSelected[0].getShading() + cardsSelected[1].getShading() + cardsSelected[2].getShading()) % 3 == 0);
        if(num && color && shape && shading)
        if(isTriple(cards))
        {
            actionIfTriple(cards);
        }
        else
        {
            Animations.wobble(cardsSelected);
        }
        
    }
    
    public void actionIfTriple(Card[] card) 
    {
        int[][] cardsLocation = new int[3][2];
        
        for(int i = 0; i < 3; i++)
        {
            getWorld().addObject(deck.getTopCard(), 
                                 cardsSelected[i].getX(), cardsSelected[i].getY());
            getWorld().removeObject(cardsSelected[i]);
            cardsLocation[i][0] = card[i].getX();
            cardsLocation[i][1] = card[i].getY();
        }
        
        Animations.slideAndTurn(cardsSelected);
        for(int i = 0; i < 3; i++)
        {
            if (numCardsInDeck != 0)
            {
                getWorld().addObject(deck.getTopCard(),cardsLocation[i][0], cardsLocation[i][1]);
                numCardsInDeck--;
            }
        }
        
        triplesRemaining--;
        Scorekeeper.updateScore();
        setUI();
        endGame();
    }

    public void endGame() 
    {
        if (triplesRemaining == 0) 
        {
            Greenfoot.stop();
        }
    }
    
    public void setCardsSelected(ArrayList<Card> cardsOnBoard, Card[] cardsSelected, ArrayList<Integer> selectedCardsIndex)
    {
        this.cardsOnBoard = cardsOnBoard;
        this.selectedCardsIndex = selectedCardsIndex;
        this.cardsSelected = cardsSelected;
        checkIfTriple(cardsSelected);
    }
}
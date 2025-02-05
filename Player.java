import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @JeanZhai
 * January 31,2025
 */
public class Player extends Actor
{
    private Dealer dealer;
    private Card[] cardsSelected;
    private ArrayList<Card> cardsOnBoard = new ArrayList<Card>();
    private ArrayList<Integer> selectedCardsIndex = new ArrayList<Integer>();
    
    public Player(Dealer dealer)
    {
        this.dealer = dealer;
        cardsSelected = new Card[3];
        cardsOnBoard = new ArrayList<Card>();
        selectedCardsIndex = new ArrayList<Integer>(); 
    }
    
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        selectCards();
        boolean threeCardsHaveBeenSelected = setCardsSelected();
        if(threeCardsHaveBeenSelected)
        {
            dealer.setCardsSelected(cardsOnBoard,cardsSelected,selectedCardsIndex);
            dealer.checkIfTriple();
            resetCardsSelected();
        }
    }
    
    public void addedToWorld(World world)
    {
         cardsOnBoard = (ArrayList) getWorld().getObjects(Card.class);
    }
    
    private void selectCards()
    { 
        for(int i = 0; i < cardsOnBoard.size(); i++)
        {
            Card card = cardsOnBoard.get(i);
            if (Greenfoot.mouseClicked(card))
            {
                    if (card.getIsSelected()) 
                    {
                        card.setIsSelected(false);
                        card.setImage(card.getCardImage());
                        selectedCardsIndex.remove(i);
                    }

                    else
                    {
                       card.setIsSelected(true);
                       card.setImage(card.getSelectedCardImage());
                       selectedCardsIndex.add(i);
                    }
            }
        }
    }
    
    private void resetCardsSelected()
    {
       for(int i = 0; i < cardsOnBoard.size(); i++)
       {
        cardsOnBoard.get(i).setImage(cardsOnBoard.get(i).getCardImage());
        cardsOnBoard.get(i).setIsSelected(false);
       }
       selectedCardsIndex.clear();
    }
    
    private boolean setCardsSelected()
    {
        if(selectedCardsIndex.size() == 3)
        {
            cardsSelected[0]= cardsOnBoard.get(selectedCardsIndex.get(0));
            cardsSelected[1]= cardsOnBoard.get(selectedCardsIndex.get(1));
            cardsSelected[2]= cardsOnBoard.get(selectedCardsIndex.get(2));
        }
        return selectedCardsIndex.size() == 3;
    }
    
}

import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @Jean Zhai
 * @January 13, 2025
 */

public class Card extends Actor
{
    public enum Shape 
    { 
       TRIANGLE, CIRCLE, SQUARE, NO_SHAPE
    }
    //
    public enum Color
    { 
        RED, GREEN, BLUE, NO_COLOR
    }
    private Shape shape;
    private Color color;
  
    private GreenfootImage cardImage, selectedCardImage;
    private int numberOfShapes, shading;
    private boolean isSelected;
    
    Card(Shape shape, Color color, int numberOfShapes, int shading,
        GreenfootImage cardImage, GreenfootImage selectedCardImage)
    {
        this.numberOfShapes= numberOfShapes;
        this.shading = shading;
        this.shape = shape;
        this.color = color;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
    }
    
    public Shape getShape()
    {
        return shape;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public int getNumberOfShapes()
    {
        return numberOfShapes;
    }
    
    public int getShading()
    {
        return shading;
    }
    
    public boolean getIsSelected()
    {
        return isSelected;
    }
    
    public GreenfootImage getSelectedCardImage()
    {
        return selectedCardImage;
    }
    
    public GreenfootImage getCardImage()
    {
        return cardImage;
    }
    
    public void setIsSelected(boolean howSet)
    {
        isSelected = howSet;
    }
}
    
    



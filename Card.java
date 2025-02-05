import greenfoot.*; 
/**
 * Game Board for Triples
 * 
 * JeanZhai
 * 1/22/2025
 */

public class Card extends Actor
{
   public Shape shape;
   public Color color;
   public boolean isSelected;
   public GreenfootImage cardImage;
   public GreenfootImage selectedCardImage;
   public int numberOfShapes;
   public int shading;
   
   public enum Shape
   {
       TRIANGLE, CIRCLE, SQUARE, NO_SHAPE;
   }
   
   public enum Color
   {
       RED, GREEN, BLUE, NO_COLOR;
   }
   
   public Card (Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage)
   {
       this.shape = shape;
       this.color = color;
       this.numberOfShapes = numberOfShapes;
       this.shading = shading;
       this.cardImage = cardImage;
       this.selectedCardImage = selectedCardImage;
       this.isSelected = false;
       setImage(cardImage);
   }
   
   public Shape getShape()
   {
       return shape;
   }
   
   public Color getColor()
   {
       return color;
   }
   
   public boolean getIsSelected()
   {
       return isSelected;
   }

   public GreenfootImage getCardImage()
   {
       return cardImage;
   }
   
   public GreenfootImage getSelectedCardImage()
   {
       return selectedCardImage;
   }
   
   public int getNumberOfShapes()
   {
       return numberOfShapes;
   }
   
   public int getShading()
   {
       return shading;
   }
   
   public void setIsSelected(boolean isSelected)
   {
       this.isSelected = isSelected;
   }
}   
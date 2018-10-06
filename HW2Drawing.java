
/**
 * This assignment is to practice using DrawingPanel class to
 * make curves from a series of straight lines.
 *
 * @author Nick Coyle
 * @version 10.9.2018
 */

import java.awt.Graphics;
import java.awt.Color;

public class HW2Drawing
{
   public static final int WIDTH = 500;
   public static final int HEIGHT = 500;
   public static final int WIDTH_2 = 400;
   public static final int HEIGHT_2 = 400;
   public static final int STEP = 1;
    
   public static void main(String[] args) {
       drawFigure1();
       drawFigure2();
   }
   
   /**
    * 
    */
   public static void drawFigure1() {
       DrawingPanel canvas = new DrawingPanel(WIDTH, HEIGHT);       
       Color c = new Color(180,200,200);
       canvas.setBackground(getRandomColor());

       Graphics pen = canvas.getGraphics();
       pen.setColor(getRandomColor());
       pen.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT/2);
       
   }
   
   /**
    * 
    */
   public static void drawFigure2() {
       DrawingPanel canvas2 = new DrawingPanel(WIDTH_2, HEIGHT_2);
       
       drawPyramid(canvas2);
   }
   
   public static void drawPyramid(DrawingPanel canvas) {
       Graphics pen2 = canvas.getGraphics();
       pen2.drawLine(0,0,100,100);
   }
   
   /**
    * This function generates and returns a random Color using rgb values
    * clamped between 0 and 255
    */
   public static Color getRandomColor() {
       int r = getRandom();
       int g = getRandom();
       int b = getRandom();
       
       Color c = new Color(r,g,b);
       return c;
   }
   
   /**
    *  This is the algorithm for returning a random number between 0 and 255
    */
   public static int getRandom() {
       return (int)(Math.random() * 255) + 1;
   }
}

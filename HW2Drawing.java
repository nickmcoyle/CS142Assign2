
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
   public static final int STEP = 2;
    
   public static void main(String[] args) {
       drawFigure1();
       drawFigure2();
   }
   
   /**
    * This method draws a curved firgure on the screen
    */
   public static void drawFigure1() {
       DrawingPanel canvas = new DrawingPanel(WIDTH, HEIGHT);       
       Color c = new Color(180,200,200);
       canvas.setBackground(c);

       Graphics pen = canvas.getGraphics();       
       
       int x1 = WIDTH/2, y1 = 0;
       int x2 = WIDTH/2, y2 = HEIGHT/2;
       int y3 = HEIGHT;
       int end = HEIGHT/2;
       
       for(int i = 0; i<end; i = i + 5) {
           //draw largest parabola
           pen.setColor(new Color(230, 66, 244));
           pen.drawLine(x1, y1 + i, x2 + i, y2);
           pen.drawLine(x1, y1 + i, x2 - i, y2);
           pen.drawLine(x1, y3 - i, x2 - i, y2);
           pen.drawLine(x1, y3 - i, x2 + i, y2); 
           
            //draw second largest parabola
           if(i<end/2) {
               pen.setColor(new Color(0, 130, 200));
               pen.drawLine(x1, y1 + i, x2 + i, y2);
               pen.drawLine(x1, y1 + i, x2 - i, y2);
               pen.drawLine(x1, y3 - i, x2 - i, y2);
               pen.drawLine(x1, y3 - i, x2 + i, y2); 
           }
           
           //draw 3rd largest parabola
           if(i<end/4) {
               pen.setColor(new Color(75, 244, 66));
               pen.drawLine(x1, y1 + i, x2 + i, y2);
               pen.drawLine(x1, y1 + i, x2 - i, y2);
               pen.drawLine(x1, y3 - i, x2 - i, y2);
               pen.drawLine(x1, y3 - i, x2 + i, y2); 
           }          
                    
       }
      
   }
   
   /**
    * This method draws a figure of my own design on the screen
    */
   public static void drawFigure2() {
       DrawingPanel canvas2 = new DrawingPanel(WIDTH_2, HEIGHT_2);
       canvas2.setBackground(new Color(0, 200, 255));
       drawPyramid(canvas2);
       drawUFO(canvas2);
       drawAlien(canvas2);
     
   }
   
   public static void drawPyramid(DrawingPanel canvas) {
       Graphics pen2 = canvas.getGraphics();
       
       int x = WIDTH_2/5;
       int y = HEIGHT_2/5;       
       
       pen2.setColor(new Color(255, 208, 0));
        for(int i = 0; i<15; ++i) {
           pen2.fillRect(x - (i*3), y + (i*3), 5 + (i*6), 3);
       }
       
        pen2.setColor(new Color(255, 255, 0));      
       for(int i = 0; i<15; ++i) {
           pen2.drawRect(x - (i*3), y + (i*3), 5 + (i*6), 3);
       } 
   }
   
   public static void drawUFO(DrawingPanel canvas) {
       Graphics pen2 = canvas.getGraphics();
       pen2.setColor(new Color(150, 150, 150));
       
       int x = WIDTH_2* 3/4;
       int y = HEIGHT_2/7;       
             
       pen2.fillOval(x, y, 70, 16);
       pen2.drawLine(x + 15, y + 20, x + 30, y + 15);
       pen2.drawLine(x + 40, y + 15, x + 55, y + 20);
   }
   
    public static void drawAlien(DrawingPanel canvas) {
       Graphics pen2 = canvas.getGraphics();
       pen2.setColor(new Color(110, 255, 60));
       
       int x = WIDTH_2/2;
       int y = HEIGHT_2/2;       
             
       pen2.fillOval(x, y, 80, 60);
       pen2.fillOval(x+10, y, 60, 80);
       
       pen2.setColor(Color.BLACK);
       pen2.fillOval(x + 5, y + 10, 10, 20);
       pen2.fillOval(x + 35, y + 10, 10, 20);
       pen2.drawArc(x + 35, y + 40, 10,20, 0, 25);
       pen2.drawArc(x + 30, y + 35, 10,20, 0, -25);
       
       pen2.drawString("WE ARE ALIENS", x - 5, y - 10);
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

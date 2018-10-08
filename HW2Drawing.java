
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
   public static final int STEP = 5;
    
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
       
       for(int i = 0; i<end; i = i + STEP) {
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
       Graphics pen = canvas2.getGraphics();
       
       pen.setColor(getRandomColor());
       pen.fillRect(0, HEIGHT_2 / 2, WIDTH_2, HEIGHT_2);
       
       drawPyramid(pen);
       drawUFO(pen);
       drawAlien(pen);     
   }
   
   /**
    * This method draws a pyramid upper left of screen
    * @param pen the implement for drawing on the canvas
    */
   public static void drawPyramid(Graphics pen) {       
       pen.setColor(new Color(255, 208, 0));     
       
       int x = WIDTH_2/5;
       int y = HEIGHT_2/5;       
       
       for(int i = 0; i<15; ++i) {
          pen.fillRect(x - (i*3), y + (i*3), 5 + (i*6), 3);
       }                   
       
       pen.setColor(new Color(255, 255, 0));
       
       for(int i = 0; i<15; ++i) {
           pen.drawRect(x - (i*3), y + (i*3), 5 + (i*6), 3);
       } 
   }
   
   /**
    * This method draws a flying saucer upper right of screen
    * @param pen the implement for drawing on the canvas
    */
   public static void drawUFO(Graphics pen) {       
       pen.setColor(new Color(150, 150, 150));
       
       int x = WIDTH_2* 3/4;
       int y = HEIGHT_2/7;       
             
       pen.fillOval(x, y, 70, 16);
       pen.drawLine(x + 15, y + 20, x + 30, y + 15);
       pen.drawLine(x + 40, y + 15, x + 55, y + 20);
   }
   
   /**
    * This method draws an Alien middle of screen and prints some text
    * @param pen the implement for drawing on the canvas
    */
   public static void drawAlien(Graphics pen) {       
       pen.setColor(new Color(110, 255, 60));
             
       int x = WIDTH_2/2;
       int y = HEIGHT_2/2;       

       //draw head     
       pen.fillOval(x, y, 80, 60);
       pen.fillOval(x+10, y, 60, 80);   
       
       //draw body
       pen.fillOval(x + 32, y + 80, 15, 60);       
       
       //draw arms
       pen.drawLine(x + 37, y + 80, x + 20, y + 130);
       pen.drawLine(x + 42, y + 80, x + 59, y + 130);
       
       pen.setColor(Color.BLACK);

       //draw eyes
       pen.fillOval(x + 5, y + 10, 10, 20);
       pen.fillOval(x + 35, y + 10, 10, 20);      
       
       //draw nose
       pen.drawArc(x + 35, y + 40, 10,20, 0, 25);
       pen.drawArc(x + 30, y + 35, 10,20, 0, -25);       
       
       pen.drawString("WE ARE ALIENS", x - 5, y - 10);
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

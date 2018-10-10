
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
   
   //we need these to draw figure 2
   public static DrawingPanel canvas2 = new DrawingPanel(WIDTH_2, HEIGHT_2); 
   public static Graphics pen2 = canvas2.getGraphics();
    
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

       int xMin = 0, yMin = 0;
       int xMax = WIDTH, yMax = HEIGHT;
       int xMid = WIDTH/2, yMid = HEIGHT/2;
       int x1Quarter = WIDTH/4, y1Quarter = HEIGHT/4;
       int x3Quarter = WIDTH*3/4, y3Quarter = HEIGHT*3/4;       
       int end = HEIGHT/2;
       
       for(int i = 0; i<end; i = i + STEP) {
            
           //draw largest parabola           
           pen.setColor(new Color(230, 66, 244));
           pen.drawLine(xMid, yMin + i, xMid + i, yMid);
           pen.drawLine(xMid, yMin + i, xMid - i, yMid);
           pen.drawLine(xMid, yMax - i, xMid - i, yMid);
           pen.drawLine(xMid, yMax - i, xMid + i, yMid);           
           
            //draw green diamond           
           pen.setColor(new Color(75, 244, 66));
           pen.drawLine(xMid, yMin + i/2, xMid + i/4, yMid);
           pen.drawLine(xMid, yMin + i/2, xMid - i/4, yMid);
           pen.drawLine(xMid, yMax - i/2, xMid - i/4, yMid);
           pen.drawLine(xMid, yMax - i/2, xMid + i/4, yMid);
           
           //draw blue diamond                        
           pen.setColor(new Color(0, 130, 200));
           pen.drawLine(xMid, y1Quarter + i/2, x3Quarter - i/2, yMid);
           pen.drawLine(xMid, y1Quarter + i/2, x1Quarter + i/2, yMid);
           pen.drawLine(xMid, y3Quarter - i/2, x3Quarter - i/2, yMid);
           pen.drawLine(xMid, y3Quarter - i/2, x1Quarter + i/2, yMid);                         
       }      
   }
   
   /**
    * This method draws a figure of my own design on the screen
    */
   public static void drawFigure2() {       
       // a fill color for the background of our canvas       
       canvas2.setBackground(new Color(0, 200, 255));       
       // a fill for the foreground of our canvas
       pen2.setColor(getRandomColor());
       pen2.fillRect(0, HEIGHT_2/2, WIDTH_2, HEIGHT_2/2);
       
       //draw some interesting things on the canvas
       drawPyramid(WIDTH_2/6, HEIGHT_2/15, WIDTH_2/50, HEIGHT_2/24, new Color(255, 208, 0));
       drawUFO(WIDTH_2* 3/4, HEIGHT_2/7, WIDTH_2/6, HEIGHT_2/28, new Color(150, 150, 150));
       drawAlien(WIDTH_2/2, HEIGHT_2/2, WIDTH_2/5, HEIGHT_2/6, new Color(110, 255, 60));     
   }
   
   /**
    * This method draws a pyramid upper left of screen
    * @param pen the implement for drawing on the canvas
    */
   public static void drawPyramid(int x, int y, int width, int height, Color color) {                             
       int blockSize = height/5;      
       
       for(int i = 1; i<height; ++i) {
          pen2.setColor(color);
          pen2.fillRect(x - (i*blockSize), y + (i*blockSize), 2*(i*blockSize), blockSize);
          pen2.setColor(new Color(255, 255, 0)); 
          pen2.drawRect(x - (i*blockSize), y + (i*blockSize), 2*(i*blockSize), blockSize);
       }            
   }
   
   /**
    * This method draws a flying saucer upper right of screen
    * @param pen the implement for drawing on the canvas
    */
   public static void drawUFO(int x, int y, int width, int height, Color color) {       
       pen2.setColor(color);             
       pen2.fillOval(x, y, width, height);
       pen2.drawLine(x + width/4, y + height, x, y + height + height/4);
       pen2.drawLine(x + width * 3/4, y + height, x + width, y + height + height/4);
   }
   
   /**
    * This method draws an Alien middle of screen and prints some text
    * @param pen the implement for drawing on the canvas
    */
   public static void drawAlien(int x, int y, int width, int height, Color color) {       
       pen2.setColor(color);            

       //draw head     
       pen2.fillOval(x, y, width, height);
       pen2.fillOval(x + width/6, y, height, width);          
      
       //draw eyes
       pen2.setColor(Color.BLACK);
       pen2.fillOval(x + width/12, y + height/10, width/6, height/4);
       pen2.fillOval(x + width/3, y + height/8, width/6, height/4);      
       
       //draw nose
       pen2.drawArc(x + width/3, y + height/2, 10,20, 0, 25);
       pen2.drawArc(x + width/2, y + height/2, 10,20, 0, -25);       
       
       pen2.drawString("WE ARE ALIENS", x - width/6, y - height/8);
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

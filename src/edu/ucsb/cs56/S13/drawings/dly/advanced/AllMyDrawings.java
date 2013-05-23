package edu.ucsb.cs56.S13.drawings.dly.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad
 * @author Daniel Ly
 * @version for CS56, lab05, Spring 2013
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	Box b1 = new Box(100,250,50,50, 15);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a box that's half the size, 
	// and moved over 150 pixels in x direction

	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a box that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// Draw with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	//Draw two washing machines
	
	WashingMachine wm1 = new WashingMachine(50,350,50,50,25,25);
	WashingMachine wm2 = new WashingMachine(200,125,75,75,20,30);
	
	g2.draw(wm1);
	g2.setColor(new Color(0x8F00FF));
	g2.draw(wm2);
	
	// Sign & Label
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Several Boxes by Daniel Ly", 20,20);
    }


    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {

	Box b1 = new Box(200, 200, 60, 60, 15);
	g2.setColor(Color.BLUE);
	g2.draw(b1);

	WashingMachine wm1 = new WashingMachine(100, 100, 60, 60, 15, 40);
	WashingMachine wm2 = new WashingMachine(100, 10, 40, 40, 10, 30);
	g2.setColor(Color.BLACK);
	g2.draw(wm1);
	g2.draw(wm2);

	Shape b2 = ShapeTransforms.scaledCopyOf(b1, 1.5, 1.5);
	b2 = ShapeTransforms.translatedCopyOf(b2, 100, 100);
	b2 = ShapeTransforms.rotatedCopyOf(b2, 1);
	g2.setColor(Color.RED);
	g2.draw(b2);

	Shape wm3 = ShapeTransforms.translatedCopyOf(wm1, 75, -15);
	wm3 = ShapeTransforms.rotatedCopyOf(wm3, 3.1415);
	g2.draw(wm3);

	// Sign & Label
	g2.setColor(Color.BLACK); 
	g2.drawString("Boxes & Washing Machines by Daniel Ly", 20,20);
    }
  
    /** Draw a different picture of washing machines and boxes
     *  using some translation and rotation
     */

    public static void drawPicture3(Graphics2D g2) {
	//Creates a row of washing machines
	WashingMachine wm1 = new WashingMachine(0,280,100,100,25,75);
	Shape wm2 = ShapeTransforms.translatedCopyOf(wm1, 125, 0);
	Shape wm3 = ShapeTransforms.translatedCopyOf(wm2, 125, 0);
	Shape wm4 = ShapeTransforms.translatedCopyOf(wm3, 125, 0);
	Shape wm5 = ShapeTransforms.translatedCopyOf(wm4, 125, 0);
	g2.setColor(Color.BLACK);
	drawHelper(g2, wm1, wm2, wm3, wm4, wm5);

	//Creates some pattern of a bunch of washing machines
	WashingMachine wm6 = new WashingMachine(240, 100, 75, 75, 20, 50);
	Shape wm7 = ShapeTransforms.rotatedCopyOf(wm6, 3.1415);
	wm7 = ShapeTransforms.translatedCopyOf(wm7, 95, -20);
	Shape wm8 = ShapeTransforms.translatedCopyOf(wm6, 75, 75);
	Shape wm9 = ShapeTransforms.rotatedCopyOf(wm6, 3.1415);
	wm9 = ShapeTransforms.translatedCopyOf(wm9, 20, -95);
	Shape wm10 = ShapeTransforms.rotatedCopyOf(wm6, 3.1415);
	wm10 = ShapeTransforms.translatedCopyOf(wm10, -20, 95);
	Shape wm11 = ShapeTransforms.rotatedCopyOf(wm7, 3.1415);
	wm11 = ShapeTransforms.translatedCopyOf(wm11, 20, -95);
	drawHelper(g2, wm6, wm7, wm8, wm9, wm10, wm11);
	// label the drawing
	
	g2.drawString("Bunch of Washing Machines by Daniel Ly", 20,20);
       
    }
    
    /**
     * Helper function to tell g2 to draw multiple shapes
     * @param g2 Graphics2D object that will draw the shapes
     * @param shapes Shapes to be drawn
     */
    private static void drawHelper(Graphics2D g2, Shape...shapes){
	for (Shape shape: shapes){
	    g2.draw(shape);
	}
    }

}

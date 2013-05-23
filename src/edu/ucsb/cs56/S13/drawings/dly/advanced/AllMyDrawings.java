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
 * @version for CS10, lab06, Spring 2009
 */


public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */

    public static void drawPicture1(Graphics2D g2) {

	Box b1 = new Box(100,250,50,50, 15);
	g2.setColor(Color.CYAN); g2.draw(b1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction

	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig = g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	/*
	// Draw two houses with Windows
	
	HouseWithWindows hw1 = new HouseWithWindows(50,350,40,75);
	HouseWithWindows hw2 = new HouseWithWindows(200,350,200,100);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF));
	g2.draw(hw2);
	*/
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Several Boxes by Phill Conrad", 20,20);
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

	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	//g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Coffee Cups and a few houses by Phill Conrad", 20,20);
    }
  
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of Coffee Cups by Phill Conrad", 20,20);
       
    }
    

}

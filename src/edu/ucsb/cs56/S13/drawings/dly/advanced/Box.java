package edu.ucsb.cs56.S13.drawings.dly.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a box that implements
   the Shape interface.
      
   @author Daniel Ly
   @version for CS56, Spring 2013, UCSB
   
*/
public class Box extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of box
       @param y y coord of lower left corner of box
       @param width width of the box
       @param height of box
     */
    public Box(double x, double y, double width, double height, double depth)
    {

	double frontUpperLeftY = y + height;
       	double sideStartX = x + width;
	double sideEndX = sideStartX + depth;
	double sideBotStartY = frontUpperLeftY + height;
	double sideBotEndY = sideBotStartY - depth;
	double sideTopStartY = frontUpperLeftY;
	double sideTopEndY = sideTopStartY - depth;
	double topEndX = x + depth;
	double topEndY = frontUpperLeftY - depth;
        
        // Create the front of the box
        
        Rectangle2D.Double front = 
            new Rectangle2D.Double(x, frontUpperLeftY,
                          width, height);
                          
	// Create the side of the box
	
	Line2D.Double sideBot =
	    new Line2D.Double(sideStartX, sideBotStartY, sideEndX, sideBotEndY);
	Line2D.Double sideTop =
	    new Line2D.Double(sideStartX, sideTopStartY, sideEndX, sideTopEndY);
	Line2D.Double sideSide =
	    new Line2D.Double(sideEndX, sideBotEndY, sideEndX, sideTopEndY);

	// Creates the top of the box
	
	Line2D.Double topSide =
	    new Line2D.Double(x, frontUpperLeftY, topEndX, topEndY);
	Line2D.Double topTop = 
	    new Line2D.Double(topEndX, topEndY, sideEndX, topEndY);

        // put the whole house together
       
        GeneralPath wholeBox = this.get();
        wholeBox.append(front, false);
	wholeBox.append(sideBot, false);
        wholeBox.append(sideTop, false);
	wholeBox.append(sideSide, false);
	wholeBox.append(topSide, false);
	wholeBox.append(topTop, false);
    }

}

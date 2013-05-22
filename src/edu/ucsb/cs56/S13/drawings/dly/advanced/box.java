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
		double sideEndX = sideBotStartX + depth;
		double sideBotStartY = y;
		double sideBotEndY = sideBotStartY + depth;

        
        // Create the front of the box
        
        Rectangle2D.Double front = 
            new Rectangle2D.Double(x, frontUpperLeftY,
                          width, height);
                          
		// Create the side of the box
		
		Line2D.Double sideBot =
			new Line2D.double(sideStartX, sideBotStartY, sideEndX, sideBotEndY);

        // put the whole house together
       
        GeneralPath wholeHouse = this.get();
        wholeHouse.append(front, false);
        
    }

}
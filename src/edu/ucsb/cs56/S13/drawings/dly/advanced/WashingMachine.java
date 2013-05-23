package edu.ucsb.cs56.S13.drawings.dly.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.S13.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.S13.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a WashingMachine using a box that implements
   the Shape interface.
      
   @author Daniel Ly
   @version for CS56, Spring 2013, UCSB
   
*/
public class WashingMachine extends Box implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of washing machine
       @param y y coord of lower left corner of the washing machine
       @param width width of the washing machine
       @param height height of the washing machine
       @param diameter diameter of the opening of the washing machine
     */
    public WashingMachine(double x, double y, double width, 
			  double height, double depth, double diameter)
    {
	super(x, y, width, height, depth);

	double frontUpperLeftY = y + height;

	double innerDia = diameter*3/4;
	double outerDia = diameter;
        double innerCircleX = x + width/2 - innerDia/2;
	double innerCircleY = frontUpperLeftY + height/2 - innerDia/2;
	double outerCircleX = x + width/2 - outerDia/2;
	double outerCircleY = frontUpperLeftY + height/2 - outerDia/2;

	double topPanelEndX = x + width;
	double topPanelY = frontUpperLeftY + height/8;

	// create the opening of the washing machine at the center of the box
	
	Ellipse2D.Double innerCircle = 
	    new Ellipse2D.Double(innerCircleX, innerCircleY, innerDia, innerDia);
        Ellipse2D.Double outerCircle =
	    new Ellipse2D.Double(outerCircleX, outerCircleY, outerDia, outerDia);

	// creates the panel on the top of the washing machine 1/8 of the height
	// from the top
	Line2D.Double frontPanel = 
	    new Line2D.Double(x, topPanelY, topPanelEndX, topPanelY);

        // put the whole washing machine together
       
        GeneralPath wholeBox = this.get();
        wholeBox.append(innerCircle, false);
	wholeBox.append(outerCircle, false);
	wholeBox.append(frontPanel, false);
    }

}

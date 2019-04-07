/**
 * This program represents a circle, oval, square or fancy balloon based on which option is selected in the ComboBox.
 * Author: Willy Bolly
 * Ver 1.0 Created December 31st, 2017
 * Modified By: Sarah Peng
 * Modified On: March 22nd, 2019
 */

//Imports previously created classes and methods
import java.awt.Color;
import java.awt.Graphics;

//Draws a blue balloon with a radius of 50 that follows the parameters of the selected subclass
public class Balloon
{
	private int xCenter, yCenter, radius;
	private Color color;

	//Creates a balloon that follows the parameters of a center at (0,0), a radius of 50 and a blue color
	public Balloon()
	{
		xCenter = 0;
		yCenter = 0;
		radius = 50;
		color = Color.BLUE;		
	}

	//Creates a balloon that follows the parameters listed below.
	public Balloon(int x, int y, int r, Color c)
	{
		xCenter = x;
		yCenter = y;
		radius = r;
		color = c;
	}

	//Returns the center's x-coordinate.
	public int getX()
	{
		return xCenter;
	}

	//Returns the center's y-coordinate.
	public int getY()
	{
		return yCenter;
	}

	//Returns the balloon's radius.
	public int getRadius()
	{
		return radius;
	}

	//Returns the balloon's color.
	public Color getColor()
	{
		return color;
	}

	//Returns the distance from a point on the shape's border to the center point.
	public double distance(int x, int y)
	{
		double dx = x - xCenter;
		double dy = y - yCenter;
		return Math.sqrt(dx*dx + dy*dy);
	}

	//Moves the balloon's center with reference to the x and y coordinates.
	public void move(int x, int y)
	{
		xCenter = x;
		yCenter = y;
	}

	//Sets r to equal the radius
	public void setRadius(int r)
	{
		radius = r;
	}

	//Tests a point to see if it is in the balloon, returning true if it is, false if it isn't.
	public boolean isInside(int x, int y)
	{
		return distance(x, y) < 0.9 * radius;
	}

	//Tests a point to see if it lies on the balloon's border, returning true if it is, false if it isn't.
	public boolean isOnBorder(int x, int y)
	{
		double d = distance(x, y);
		return d >= 0.9 * radius && d <= 1.1 * radius;
	}

	//Draws a balloon based on the parameters given by the selected subclass.
	public void draw(Graphics g, boolean makeItFilled)
	{
  
	}
}
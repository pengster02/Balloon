/**
 * This program represents a square balloon in the BalloonDraw program.
 * Author: Willy Bolly
 * Ver 1.0 Created December 31st, 2017
 * Modified By: Sarah Peng
 * Modified On: March 22nd, 2019
 */

//Imports previously created classes and methods.
import java.awt.Color;
import java.awt.Graphics;

//Tells the Balloon class to draw a square balloon.
public class SquareBalloon extends Balloon
{
 	//Calls Balloon's constructor.
	public SquareBalloon()
	{
		super();
	}

 	//Calls Balloon's constructor.
	public SquareBalloon(int x, int y, int r, Color c)
	{
		super(x, y, r, c);
	}
  
	//Overrides the distance from a point on the shape's border to the center point set in Balloon.
	public double distance(int x, int y)
	{
		double dx = x - getX();
		double dy = y - getY();
		dx = Math.abs(dx);
		dy = Math.abs(dy);
		return Math.max(dx, dy);
	}
  
 	//Sets parameters to make a square balloon.
	public void draw(Graphics g, boolean makeItFilled)
	{
		g.setColor(getColor());
	    if (makeItFilled)
	    	g.fillRect(getX() - getRadius(),
                 getY() - getRadius(), 2*getRadius(), 2*getRadius());
	    else
	    	g.drawRect(getX() - getRadius(),
                 getY() - getRadius(), 2*getRadius(), 2*getRadius());
	}
}
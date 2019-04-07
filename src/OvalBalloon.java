/**
 * This program represents an oval balloon in the BalloonDraw program.
 * Author: Willy Bolly
 * Ver 1.0 Created December 31st, 2017
 * Modified By: Sarah Peng
 * Modified On: March 22nd, 2019
 */

//Imports previously created classes and methods.
import java.awt.Color;
import java.awt.Graphics;

//Tells the Balloon class to draw an oval balloon.
public class OvalBalloon extends Balloon
{
 	//Calls Balloon's constructor.
	public OvalBalloon()
 	{
 		super();
 	}

 	//Calls Balloon's constructor.
	public OvalBalloon(int x, int y, int r, Color c)
 	{
 		super(x, y, r, c);
 	}
 	
	//Overrides the distance from a point on the shape's border to the center point set in Balloon.
 	public double distance(int x, int y)
 	{
 		double dx = x - getX();
 		dx = 2*dx;
 		double dy = y - getY();
 		return Math.sqrt(dx*dx + dy*dy);
 	}
 	
 	//Sets parameters to make an oval balloon.
 	public void draw(Graphics g, boolean makeItFilled)
 	{
 		g.setColor(getColor());
 		if (makeItFilled)
 		g.fillOval(getX() - getRadius()/2,
                 getY() - getRadius(), getRadius(), 2*getRadius());
 		else
 		g.drawOval(getX() - getRadius()/2,
                 getY() - getRadius(), getRadius(), 2*getRadius());
 	}
}
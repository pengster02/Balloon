/**
 * This program represents a round (circle) balloon in the BalloonDraw program.
 * Author: Willy Bolly
 * Ver 1.0 Created December 31st, 2017
 * Modified By: Sarah Peng
 * Modified On: March 22nd, 2019
 */

//Imports previously created classes and methods.
import java.awt.Color;
import java.awt.Graphics;

//Tells the Balloon class to draw an round (circle) balloon.
public class RoundBalloon extends Balloon
{
 	//Calls Balloon's constructor.
	public RoundBalloon()
	{
		super();
	}
	
 	//Calls Balloon's constructor.
	public RoundBalloon(int x, int y, int r, Color c)
	{
		super(x, y, r, c);
	}
	
 	//Sets parameters to make a round balloon.
	public void draw(Graphics g, boolean makeItFilled)
	{
		g.setColor(getColor());
		if (makeItFilled)
    	g.fillOval(getX() - getRadius(),
                 getY() - getRadius(), 2*getRadius(), 2*getRadius());
		else
		g.drawOval(getX() - getRadius(),
                 getY() - getRadius(), 2*getRadius(), 2*getRadius());
	}
}
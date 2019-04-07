/**
 * This program represents a fancy balloon in the BalloonDraw program.
 * Author: Willy Bolly
 * Ver 1.0 Created December 31st, 2017
 * Modified By: Sarah Peng
 * Modified On: March 22nd, 2019
 */

//Imports previously created classes and methods.
import java.awt.Color;
import java.awt.Graphics;

//Tells the Balloon class to draw a fancy balloon.
public class FancyBalloon extends Balloon
{
 	//Calls Balloon's constructor.
	public FancyBalloon()
	{
		super();
	}

 	//Calls Balloon's constructor.
	public FancyBalloon(int x, int y, int r, Color c)
	{
		super(x, y, r, c);
	}
  
	//Overrides the distance from a point on the shape's border to the center point set in Balloon.
	public double distance(int x, int y)
	{	
		double dx = x - getX() ;
		double dy = y - getY();
		dx = Math.abs(dx/(2.5));
		dy = Math.abs(dy/3);
		return Math.max(dx, dy);
	}
  
 	//Sets parameters to make a fancy balloon.
	public void draw(Graphics g, boolean makeItFilled)
	{
		int X = getX();
		int Y = getY();
		int R = getRadius();
		int x [] = {X, X - 5*(R/2), getX(), X + 5*(R/2)};
		int y [] = {Y - 3*R, Y, Y + 3*R, Y};
      
		if (makeItFilled)
		{
			//Draws and fills a rounded rectangle with a darker shade of the selected colour.
			g.setColor(getColor().darker());
			g.fillRoundRect(X - 5*(R/2), 
				Y - 3*R, 5*R, 6*R, 15, 15);
    	  
			//Draws and fills a diamond with a lighter shade of the selected colour.
			g.setColor(getColor().brighter());
			g.fillPolygon(x, y, 4);
    	  
			//Draws two circles in black then fills them with white, making the body of the snowman.
			g.setColor(Color.BLACK);
			g.drawOval(X - R,
				Y + 1247*(R/6000), 2*R, 2*R);
			g.drawOval(X - 3*(R/4),
				Y + 1247*(R/6000) - 3*(R/2), 3*(R/2), 3*(R/2));
			g.setColor(Color.WHITE);
			g.fillOval(X - R,
                Y + 1247*(R/6000), 2*R, 2*R);
			g.fillOval(X - 3*(R/4),
                Y + 1247*(R/6000) - 3*(R/2), 3*(R/2), 3*(R/2));
          
			//Draws and fills two small circles with black, making the eyes of the snowman.
			g.setColor(Color.BLACK);
			g.fillOval(X - R/4 - R/10,
				Y + 1247*(R/6000) - R, R/4, R/4);
			g.fillOval(X + R/10,
                Y + 1247*(R/6000) - R, R/4, R/4);
 	
			//Draws and fills two rectangles with black, making the hat of the snowman.
			g.fillRect(X - 3*(R/4),
				Y + 1247*(R/6000) - 3*(R/2) - R/1000, 3*(R/2), R/4);
			g.fillRect(X - R/2,
				Y + 1247*(R/6000) - 3*(R/2) -R/1000 - 2*(R/3), R, 2*(R/3)); 
      }
	  else
      {
			//Draws a rounded rectangle with black.
		  	g.setColor(Color.BLACK);
    	  	g.drawRoundRect(X - 5*(R/2), 
    			Y- 3*R, 5*R, 6*R, 15, 15);
		  	
			//Draws a diamond with black.
    	  	g.drawPolygon(x, y, 4); 
    	  	
			//Draws two circles with black, making the body of the snowman.
    	  	g.drawOval(X - R,
                Y + 1247*(R/6000), 2*R, 2*R);
    	  	g.drawOval(X - 3*(R/4),
                Y + 1247*(R/6000) - 3*(R/2), 3*(R/2), 3*(R/2));
     	
			//Draws and fills two small circles with black, making the eyes of the snowman.
    	  	g.fillOval(X - R/4 - R/10,
                Y + 1247*(R/6000) - R, R/4, R/4);
    	  	g.fillOval(X + R/10,
                Y + 1247*(R/6000) - R, R/4, R/4);
     	
			//Draws and fills two rectangles with black, making the hat of the snowman.
    	  	g.fillRect(X - 3*(R/4),
     			Y + 1247*(R/6000) - 3*(R/2) - R/1000, 3*(R/2), R/4);
    	  	g.fillRect(X - R/2,
     			Y + 1247*(R/6000) - 3*(R/2) - R/1000 - 2*(R/3), R, 2*(R/3));
      }
}
}
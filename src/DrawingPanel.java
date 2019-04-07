/**
 * This program represents the drawings shown in BalloonDraw
 * Modified By: Sarah Peng
 * Modified On: March 22nd, 2019
 */

//Imports previously created classes and methods.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import java.util.ArrayList;

//Creates the drawings that are in BalloonDraw
public class DrawingPanel extends JPanel
  	implements MouseListener, MouseMotionListener, KeyListener
{
	private ArrayList<Balloon> balloons;
	private Balloon activeBalloon;
	private Color color;

	private boolean picked, stretching;

	private int offsetX, offsetY;
	private double offsetR;

 	//Sets the initial parameters of DrawingPanel when the program has just loaded
	public DrawingPanel()
	{
		setBackground(Color.WHITE);

		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);

		balloons = new ArrayList<Balloon>();
		activeBalloon = null;
		picked = false;
		stretching = false;

		color = Color.BLUE;
	}

	// Opens ColorChooser when the "Pick Color" button is pressed
	public void pickColor()
	{
		Color pickedColor = JColorChooser.showDialog(this,
                                      "Pick a color", color);
		if (pickedColor != null)
		color = pickedColor;
	}

	// Returns the selected color in the ColorChooser.
	 public Color getColor()
	 {
		 return color;
	 }

	 //Adds a new balloon with a random radius and with the selected color at the center of drawing panel based on which balloon shape was selected in the GroupBox
	 public void addBalloon(int shape)
	 {   
		 int w = getWidth();
		 int h = getHeight();
		 int radius = 10 + (int)(Math.random() * w / 2);
		 switch (shape)
		 {
	 	    case 1: activeBalloon = new RoundBalloon(w/2, h/2, radius, color); break;
	 	 	case 2: activeBalloon = new OvalBalloon(w/2, h/2, radius, color); break;
	 	 	case 3: activeBalloon = new SquareBalloon(w/2, h/2, radius, color); break;
	 	 	case 4: activeBalloon = new FancyBalloon(w/2, h/2, radius, color); break;
	 	 	default: activeBalloon = new RoundBalloon(w/2, h/2, radius, color); break;
		 }
		 balloons.add(activeBalloon);
		 repaint();
	 }

	 // Repaints a new balloon which will be on top of any other previously painted balloons
	 public void paintComponent(Graphics g)
	 {
		 super.paintComponent(g);

		 for (Balloon b : balloons)
		 {
			 if (!picked || b != activeBalloon)
			 b.draw(g, true);
		 }
		 if (picked && activeBalloon != null)
			 activeBalloon.draw(g, false);
	 }

	 //When the mouse is clicked on or within the border of the balloon, it sets the balloon to "active", remembering the offset of the click to the center.
	 public void mousePressed(MouseEvent e)
	 {
		 int x = e.getX();
		 int y = e.getY();

		 picked = false;
		 for (int k = balloons.size() - 1; k >= 0 && !picked; k--)
		 {
			 Balloon b = balloons.get(k);
			 if (b.isInside(x, y))
			 {
				 picked = true;
				 offsetX = x - b.getX();
				 offsetY = y - b.getY();
				 stretching = false;
				 activeBalloon = b;
			 }
			 else if (b.isOnBorder(x, y))
			 {
				 picked = true;
				 offsetR = b.distance(x, y) -
						 	b.getRadius();
				 stretching = true;
				 activeBalloon = b;
			 }
		 }
		 if (picked)
			 repaint();
	 }

	 // When the mouse is released, it "drops" the picked balloon.
	 public void mouseReleased(MouseEvent e)
	 {
		 if (picked)
			 repaint();
		 picked = false;
		 stretching = false;
	 }

	 //When the mouse is dragged it will either move or stretch the "active" balloon based on if the point is on the border of not.
	 public void mouseDragged(MouseEvent e)
	 {
		 if (activeBalloon == null || !picked)
			 return;

		 int x = e.getX();
		 int y = e.getY();

		 if (stretching)
		 {
			 //Stretches the balloon, remembering the offsets.
			 activeBalloon.setRadius((int)(Math.round(activeBalloon.distance(x, y)
                                                    - offsetR)));
		 }
		 else
		 {
			 //Moves the balloon, remembering the offsets.
			 activeBalloon.move(x - offsetX, y - offsetY);
		 }
		 
		 repaint();
	 }

	 //If the ballon is "active", cursor keys move it, or if crtl is down, the cursor keys will stretch it.
	 public void keyPressed (KeyEvent e)
	 {
		 if (activeBalloon == null)
			 return;

		 int dx = 0, dy = 0, dr = 0;

		 switch(e.getKeyCode())
		 {
		 case KeyEvent.VK_UP:
		 case KeyEvent.VK_KP_UP:
			 dy = -1;
			 dr = 1;
			 break;

		 case KeyEvent.VK_DOWN:
		 case KeyEvent.VK_KP_DOWN:
			 dy = 1;
			 dr = -1;
			 break;

		 case KeyEvent.VK_LEFT:
		 case KeyEvent.VK_KP_LEFT:
			 dx = -1;
			 dr = -1;
			 break;

		 case KeyEvent.VK_RIGHT:
		 case KeyEvent.VK_KP_RIGHT:
			 dx = 1;
			 dr = 1;
			 break;
		 }

		 if (dx != 0 || dy != 0 || dr != 0)
		 {
			 if (e.isControlDown())
				 activeBalloon.setRadius(activeBalloon.getRadius() + dr);
			 else
				 activeBalloon.move(activeBalloon.getX() + dx,
						 	activeBalloon.getY() + dy);
			 repaint();
		 }
	 }

	 //Events that are not used.
	 public void mouseEntered(MouseEvent e) {}
	 public void mouseExited(MouseEvent e) {}
	 public void mouseClicked(MouseEvent e) {}
	 public void mouseMoved(MouseEvent e) {}
	 public void keyTyped(KeyEvent e) {}
	 public void keyReleased(KeyEvent e) {}
}

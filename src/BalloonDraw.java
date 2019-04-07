/**
 * This drawing program helps to create multiple shapes in the same picture.
 * Authors: Maria Litvin and Gary Litvin
 * Modified By: Sarah Peng
 * Modified On: March 22nd, 2019
 */

//Imports previously created classes and methods.
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;

//Creates the selected balloon shape.
public class BalloonDraw extends JFrame
{
	//Adds DrawingPanel and ControlPanel to BalloonDraw.
	public BalloonDraw()  
	{
		super("Drawing Editor");

		DrawingPanel canvas = new DrawingPanel();
		ControlPanel controls = new ControlPanel(canvas);
		Container c = getContentPane();
		c.add(canvas, BorderLayout.CENTER);
		c.add(controls, BorderLayout.SOUTH);
	}

	//Sets the JFrame's size and the visibility.
	public static void main(String[] args)
	{
		BalloonDraw window = new BalloonDraw();
		window.setBounds(100, 100, 400, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}

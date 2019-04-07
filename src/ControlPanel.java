/**
 * This program represents the controls in BalloonDraw.
 * Modified By: Sarah Peng
 * Modified On: March 22nd, 2019
 */

//Imports previously created classes and methods.
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

//Creates a GroupBox that has the different Balloon shapes and a Button that will open the ColorChooser.
public class ControlPanel extends JPanel
{
	private DrawingPanel canvas;
	private JButton colorButton, colorDisplay; 
	private JComboBox<String> chooseBalloonShape;

	//Adds the "Pick Color" button, the inactive button that displays the colour and the GroupBox with all the different balloon shapes. 
	public ControlPanel(DrawingPanel canvas)
	{
		this.canvas = canvas;

		colorButton = new JButton("Pick Color");
		colorButton.addActionListener(new ColorButtonListener());

		colorDisplay = new JButton();
		colorDisplay.setBackground(canvas.getColor());
		colorDisplay.setEnabled(false);

		String[] balloonShapeNames = {"Round", "Oval", "Square", "Fancy"};
		chooseBalloonShape = new JComboBox<String>(balloonShapeNames);
		chooseBalloonShape.addActionListener(new BalloonButtonListener());

		add(colorButton);
		add(colorDisplay);
		add(chooseBalloonShape);
	}

	//Sets the colour button display to the colour selected in the ColorChooser
	private class ColorButtonListener
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			canvas.pickColor();
			colorDisplay.setBackground(canvas.getColor());
			canvas.requestFocus();
		}
    }

	//Tells DrawingPanel which balloon shape was selected in the ComboBox
	private class BalloonButtonListener
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			canvas.addBalloon(chooseBalloonShape.getSelectedIndex() + 1);
			canvas.requestFocus();
		}
	}
}

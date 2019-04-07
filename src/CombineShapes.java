import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
 
public class CombineShapes extends Balloon{
 
  
  public void draw(Graphics g) {
 
    // Retrieve the graphics context; this object is used to paint shapes
 
    Graphics2D g2d = (Graphics2D)g;
 
 
    Shape oval = new Ellipse2D.Float(getX() - getRadius(),
            getY() - getRadius(), 2*getRadius(), 2*getRadius());
    Shape oval2 = new Ellipse2D.Float(getX() - 3*(getRadius()/4),
                 getY() - getRadius() - 3*(getRadius()/2), 3*(getRadius()/2), 3*(getRadius()/2));
    Shape oval3 = new Ellipse2D.Float(getX() - getRadius()/4 - getRadius()/10,
                 getY() - getRadius() - getRadius(), getRadius()/4, getRadius()/4);
    Shape oval4 = new Ellipse2D.Float(getX() + getRadius()/10,
            getY() - getRadius() - getRadius(), getRadius()/4, getRadius()/4);
    Shape rectangle = new Rectangle2D.Float(getX() - 3*(getRadius()/4),
			getY() - getRadius() - 3*(getRadius()/2) - getRadius()/1000, 3*(getRadius()/2), getRadius()/4);
 
    Shape rectanglew = new Rectangle2D.Float(getX() - getRadius()/2,
			getY() - getRadius() - 3*(getRadius()/2) -getRadius()/1000 - 2*(getRadius()/3), getRadius(), 2*(getRadius()/3));
 
 
    Area shape = new Area();
 
    shape.add(new Area(oval));
    shape.add(new Area(oval2));
    shape.add(new Area(oval3));
    shape.add(new Area(oval4));
 
    shape.add(new Area(rectangle));
    shape.add(new Area(rectangle));
    
 
    g2d.draw(shape);
 
  }
 
    }
 
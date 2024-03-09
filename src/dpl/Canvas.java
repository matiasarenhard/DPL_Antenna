/**
 * DPL Canvas.java
 * 
 * @author Roberto E. Lopez-Herrejon
 * SEP SPL Course July 2010
 * 
 * @author Wesley K. G. Assunção
 * ERES - FeatureIDE Introduction - October 2018
 */
package dpl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.event.*;
import javax.swing.JComponent;

import java.awt.Point;

@SuppressWarnings("serial")
public class Canvas extends JComponent implements MouseListener, MouseMotionListener {

	Point start, end;
	protected List<Shape> shapes = new LinkedList<Shape>();
	public enum FigureTypes {NONE, LINE, RECT};
	public FigureTypes figureSelected = FigureTypes.NONE;

	/** Sets up the canvas. Do not change */
	public Canvas() {
		this.setDoubleBuffered(true); // for display efficiency
		this.addMouseListener(this); // registers the mouse listener
		this.addMouseMotionListener(this); // registers the mouse motion
											// listener
	}

	/** Sets the selected figure. Do not change. */
	public void selectedFigure(FigureTypes fig) {
		figureSelected = fig;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// refreshes the canvas
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for (Shape s : shapes) {
			s.paint(g);
		}
	}

	// **************** Mouse Handling
	public void mouseClicked(MouseEvent e) {
	}

	// mouseClicked
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse exits a component. Empty implementation. Do not
	 * change.
	 */
	public void mouseExited(MouseEvent e) {
	}

	
	
	
	/** Invoked when a mouse button has been pressed on a component. */
	public void mousePressed(MouseEvent e) {
		// #if Linha
//@		if (figureSelected == FigureTypes.LINE) {
//@			mousePressedLine(e);
//@		}
		// #endif
		
		// #if Retangulo
		if (figureSelected == FigureTypes.RECT) {
			mousePressedRect(e);
		}
		// #endif
	}
	
	
	

	/** Invoked when a mouse button has been released on a component. */
	public void mouseReleased(MouseEvent e) {
		// #if Linha
//@		if (figureSelected == FigureTypes.LINE) {
//@			mouseReleasedLine(e);
//@		}
		// #endif
		
		// #if Retangulo
		if (figureSelected == FigureTypes.RECT) {
			mouseReleasedRect(e);
		}
		// #endif
	}

	/** Invoked when the mouse is dragged over a component */
	public void mouseDragged(MouseEvent e) {
		// #if Linha
//@		if (figureSelected == FigureTypes.LINE) {
//@			mouseDraggedLine(e);
//@		}
		// #endif
		
		// #if Retangulo
		if (figureSelected == FigureTypes.RECT) {
			mouseDraggedRect(e);
		}
		// #endif
	}

	/* Empty implementation. Do not change. */
	public void mouseMoved(MouseEvent e) {
	}

	public void wipe() {
		this.shapes.clear();
		this.repaint();
	}

	protected BasicRectangle newRect = null;

	public void mousePressedRect(MouseEvent e) {
		// If there is no line being created
		if (newRect == null) {
			newRect = new BasicRectangle(e.getX(), e.getY());
			shapes.add(newRect);
		}
	}

	/** Updates the end point coordinates and repaints figure */
	public void mouseDraggedRect(MouseEvent e) {
		newRect.setEnd(e.getX(), e.getY());
		repaint();
	}

	/** Clears the reference to the new line */
	public void mouseReleasedRect(MouseEvent e) {
		newRect = null;
	}

	protected Line newLine = null;

	public void mousePressedLine(MouseEvent e) {
		// If there is no line being created
		if (newLine == null) {
			start = new Point(e.getX(), e.getY());
			newLine = new Line(start);
			shapes.add(newLine);
		}
	}

	/** Updates the end point coordinates and repaints figure */
	public void mouseDraggedLine(MouseEvent e) {
		newLine.setEnd(new Point(e.getX(), e.getY()));
		repaint();
	}

	/** Clears the reference to the new line */
	public void mouseReleasedLine(MouseEvent e) {
		newLine = null;
	}

}

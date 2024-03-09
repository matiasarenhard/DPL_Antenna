/**
 * DPL Line.java
 * 
 * @author Roberto E. Lopez-Herrejon
 * SEP SPL Course July 2010
 * 
 * @author Wesley K. G. Assunção
 * ERES - FeatureIDE Introduction - October 2018
 */
package dpl;

import java.awt.*;

public class Line extends Shape {

	private Point startPoint, endPoint;

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	}

	public Line(Point start) {
		startPoint = start;
	}

	public void setEnd(Point end) {
		endPoint = end;
	}

	public Point getStart() {
		return startPoint;
	}

	public Point getEnd() {
		return endPoint;
	}

}

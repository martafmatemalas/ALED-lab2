package es.upm.aled.lab2.kinematics;

import java.util.List;

// TODO: Implemente la clase
/**
 * Explicación de la clase, no la hago
 * 
 * @author martafmatemalas
 */
public class Segment {
	double length; //en cm
	double angle; //en rad
	List<Segment> children;
	
	/**
	 * Builds a new Segment with its length, angle and list of children
	 * 
	 * @param length Double that sets the length of the segment in cm
	 * @param angle The angle that forms with its father segment, in rad
	 * @param children A list of the children segments
	 */
	public Segment(double length, double angle, List<Segment> children) {
		this.length = length;
		this.angle = angle;
		this.children = children;
	}
	
	/**
	 * Returns the segment's length
	 * 
	 * @return The segment's length
	 */
	public double getLength() {
		return length;
	}
	
	/**
	 * Returns the segment's angle
	 * 
	 * @return The segment's angle
	 */
	public double getAngle() {
		return angle;
	}
	
	/**
	 * Uploads the value of the angle
	 * 
	 * @param angle The angle that is going to be uploaded
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * Returns the list of segment's children
	 * 
	 * @return The segment's children
	 */
	public List<Segment> getChildren() {
		return children;
	}
	
	/**
	 * Adds a new child in the segment's children list
	 * 
	 * @param child The Segment that is going to be added
	 */
	public void addChildren(Segment child) {
		if (!children.contains(child))
			children.add(child);
	}
	
	
}

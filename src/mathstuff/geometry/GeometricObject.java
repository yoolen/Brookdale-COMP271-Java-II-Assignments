package mathstuff.geometry;

import java.util.Date;

abstract class GeometricObject{
// Superclass as defined by UML	
	private String color; //Default value
	private boolean filled;
	private Date dateCreated;
	
// Constructors
	public GeometricObject() {
	// Default constructor generates a White unfilled shape
		this("White",false);
	}

	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
		this.dateCreated = new Date();
	} 
	
// Accessors and Mutators
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

// Output
	@Override
	public String toString(){
		return String.format("Created on %s\nColor: %s, %s.", dateCreated.toString(), color, filled?"Filled":"Not Filled");
	}
}
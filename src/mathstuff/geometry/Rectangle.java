package mathstuff.geometry;

class Rectangle extends GeometricObject implements Comparable<Rectangle>{
	private double width;
	private double height;
	
	public Rectangle(){
		setWidth(0);
		setWidth(0);
		// this(0,0);
	}
	
	public Rectangle(double width, double height) {
		setWidth(width);
		setHeight(height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width < 0)
			width = 0;
		else
			this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height < 0)
			this.height = 0;
		else
			this.height = height;
	}
	
	public double findArea(){
		return this.width * this.height;
	}

	@Override
	public int compareTo(Rectangle r){
		if(r == this){ // reflection
			return 0;
		}
		else if(this.findArea() < r.findArea()){
			return -1;
		}
		else if (this.findArea() == r.findArea()){
			return 0;
		}
		else
			return 1;
	}	
	
	@Override
	public String toString() {
		return "rectangle [width=" + width + ", height=" + height + ", area=" + this.findArea() + "]";
	}

	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(5,4);
		System.out.println(rect1);
	}
}

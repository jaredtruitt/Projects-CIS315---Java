class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
	private double side;

	public Octagon(){
		super();
	}

	public Octagon(double side, String color, boolean filled){
		super(color, filled);
		this.side = side;
	}

	public void setSide(double s){
		side = s;
	}

	public double getSide(){
		return side;
	}

	@Override
	public double getArea(){
		double area = (2+4/Math.sqrt(2))*side*side;
		return area;
	}

	@Override
	public double getPerimeter(){
		return 8 * side;
	}

	@Override
	public int compareTo(Octagon o){
		if(side == o.side){
			return 0;
		}
		else if(side > o.side){
			return 1;
		}
		else{
			return -1;
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException{
		return new Octagon(side, getColor(), isFilled());
	}
}

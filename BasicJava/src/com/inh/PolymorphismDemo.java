package com.inh;

class Box1 {

	public double len, wid, ht;

	public Box1(double len, double wid, double ht) {
		super();
		this.len = len;
		this.wid = wid;
		this.ht = ht;
	}

	public double volume() {
		return len * wid * ht;
	}

	public double surfaceArea() {
		return 2 * (len * wid + wid * ht + ht * len);
	}

	@Override
	public String toString() {
		return "Box [len=" + len + ", wid=" + wid + ", ht=" + ht + "]";
	}

}

class ColoredOpenBox extends Box1 {
	String color;

	public ColoredOpenBox(double len, double wid, double ht, String color) {
		super(len, wid, ht);
		this.color = color;
	}

	public double surfaceArea() {
		return len * wid + 2 * (wid * ht + ht * len);
	}

	@Override
	public String toString() {
		return "ColoredOpenBox [color=" + color + ", len=" + len + ", wid=" + wid + ", ht=" + ht + "]";
	}

}

public class PolymorphismDemo {
	public static void main(String[] args) {
		Box1 b1 = new Box1(4, 5, 6);
		ColoredOpenBox b2 = new ColoredOpenBox(4, 5, 4, "Red");
		Box1 ref = b1;
		ref = b2;
//		ref.color = "blue";

	}
}
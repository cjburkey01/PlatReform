package com.cjburkey.platreform.math;

public class Vector2 {
	
	private double x, y;
	
	public Vector2(double x, double y) { this.x = x; this.y = y; }
	
	public void setX(double x) { this.x = x; }
	public void setY(double y) { this.y = y; }
	
	public double getX() { return x; }
	public double getY() { return y; }
	public Vector2 copy() { return new Vector2(x, y); }
	
	public static final Vector2 zero() { return new Vector2(0, 0); }
	
	public String toString() { return "(" + x + ", " + y + ")"; }
	
}
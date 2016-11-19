package com.cjburkey.platreform.math;

public class Rect {
	
	private double x, y, w, h;
	
	public Rect(double x, double y, double w, double h) { this.x = x; this.y = y; this.w = w; this.h = h; }
	
	public void setX(double x) { this.x = x; }
	public void setY(double y) { this.y = y; }
	public void setW(double w) { this.w = w; }
	public void setH(double h) { this.h = h; }
	
	public double getX() { return x; }
	public double getY() { return y; }
	public double getW() { return w; }
	public double getH() { return h; }
	public double getMaxX() { return x + w; }
	public double getMaxY() { return y + h; }

	public Rect copy() { return new Rect(x, y, w, h); }
	public boolean contains(Vector2 point) { return point.getX() >= x && point.getX() <= getMaxX() && point.getY() >= y && point.getY() <= getMaxY(); }
	
	public Vector2 getPos() { return new Vector2(x, y); }
	public Vector2 getSize() { return new Vector2(w, h); }
	public Vector2 getCenter() {
		double cx = x + (w / 2d);
		double cy = y + (h / 2d);
		return new Vector2(cx, cy);
	}
	
	public static final Rect zero() { return new Rect(0, 0, 0, 0); }
	
	public String toString() { return "(" + x + ", " + y + ") to (" + getMaxX() + ", " + getMaxY() + ")"; }
	
}
package de.rojer.maths.vec;

/**
 * 2-dimensional Vector, components are floats
 * @author Rojer
 * @version 23.03.2019
 */
public class Vec2 {
	
	//Attributes
	
	/**
	 * The components of the vector
	 */
	public float x, y;
	
	//Constructors
	
	/**
	 * Default vector, components are 0
	 */
	public Vec2() {
		x = 0.0f;
		y = 0.0f;
	}
	
	/**
	 * Creates a vector with the specified values
	 * @param x value of the x-component
	 * @param y value of the y-component
	 */
	public Vec2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	//"Destructors"
	
	/**
	 * Destroys this object
	 * @param vector this object
	 */
	public void destroy(Vec2 vector) {
		this.x = 0.0f;
		this.y = 0.0f;
		vector = null;
	}
	
	//Arithmetic
	
	/**
	 * Adds a vector to this vector
	 * @param other the vector to add to this vector
	 * @return this vector for multiple operations "in one line"
	 */
	public Vec2 add(Vec2 other) {
		x += other.x;
		y += other.y;
		return this;
	}
	
	/**
	 * Creates a copy of this instance, then adds a vector to the copy
	 * @param other the vector to add to the copy
	 * @return the copy of this vector
	 */
	public Vec2 cadd(Vec2 other) {
		try {
			Vec2 nvec = (Vec2) this.clone();
			return nvec.add(other);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Subtracts a vector from this vector
	 * @param other the vector to subtract to this vector
	 * @return this vector for multiple operations "in one line"
	 */
	public Vec2 subtract(Vec2 other) {
		x -= other.x;
		y -= other.y;
		return this;
	}
	
	/**
	 * Creates a copy of this instance, then subtracts a vector from the copy
	 * @param other the vector to subtract from the copy
	 * @return the copy of this vector
	 */
	public Vec2 csubtract(Vec2 other) {
		try {
			Vec2 nvec = (Vec2) this.clone();
			return nvec.subtract(other);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Multiplies this vector with another one
	 * @param other the vector to multiply with this vector
	 * @return this vector for multiple operations "in one line"
	 */
	public Vec2 multiply(Vec2 other) {
		x *= other.x;
		y *= other.y;
		return this;
	}
	
	/**
	 * Creates a copy of this instance, then multiplies a vector with the copy
	 * @param other the vector to multiply the copy with
	 * @return the copy of this vector
	 */
	public Vec2 cmultiply(Vec2 other) {
		try {
			Vec2 nvec = (Vec2) this.clone();
			return nvec.multiply(other);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Divides this vector by another vector
	 * @param other the vector to divide this vector with
	 * @return this vector for multiple operations "in one line"
	 */
	public Vec2 divide(Vec2 other) {
		x /= other.x;
		y /= other.y;
		return this;
	}
	
	/**
	 * Creates a copy of this instance, then divides by a vector
	 * @param other the vector to divide the copy with
	 * @return the copy of this vector
	 */
	public Vec2 cdivide(Vec2 other) {
		try {
			Vec2 nvec = (Vec2) this.clone();
			return nvec.divide(other);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Object-inherited methods
	
	/**
	 * Returns the Sting-representation of this vector
	 */
	@Override
	public String toString() {
		return "Vec2: " + x + ", " + y;
	}
	
	/**
	 * Checks if a Vec2, Vec3 or Vec4 is equal to this vector
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof Vec2) {
			Vec2 other = (Vec2)obj;
			if(x == other.x && y == other.y) {
				result = true;
			}
		}else if(obj instanceof Vec3) {
			Vec3 other = (Vec3)obj;
			if(x == other.x && y == other.y) {
				result = true;
			}
		}else if(obj instanceof Vec4) {
			Vec4 other = (Vec4)obj;
			if(x == other.x && y == other.y) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Vec2(x, y);
	}

}

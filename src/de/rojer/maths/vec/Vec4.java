package de.rojer.maths.vec;

/**
 * 4-dimensional Vector, components are floats
 * @author Rojer
 * @version 23.03.2019
 */
public class Vec4 {

	//Attributes
	
	/**
	 * The components of the vector
	 */
	public float x, y, z, w;
	
	//Constructors
	
	/**
	 * Default vector, components are 0
	 */
	public Vec4() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		w = 0.0f;
	}
	
	/**
	 * Creates a vector with the specified values
	 * @param x the value of the x-component
	 * @param y the value of the y-component
	 * @param z the value of the z-component
	 * @param w the value of the w-component
	 */
	public Vec4(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	//"Destructors"
	
	public void destroy(Vec4 vector) {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		this.w = 0.0f;
		vector = null;
	}
	
	//Arithmetic
	
	/**
	 * Adds a vector to this vector
	 * @param other the vector to add to this vector
	 * @return this vector for multiple operations "in one line"
	 */
	public Vec4 add(Vec4 other) {
		x += other.x;
		y += other.y;
		z += other.z;
		w += other.w;
		return this;
	}
	
	/**
	 * Creates a copy of this instance, then adds a vector to the copy
	 * @param other the vector to add to the copy
	 * @return the copy of this vector
	 */
	public Vec4 cadd(Vec4 other) {
		try {
			Vec4 nvec = (Vec4) this.clone();
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
	public Vec4 subtract(Vec4 other) {
		x -= other.x;
		y -= other.y;
		z -= other.z;
		w -= other.w;
		return this;
	}
	
	/**
	 * Creates a copy of this instance, then subtracts a vector from the copy
	 * @param other the vector to subtract from the copy
	 * @return the copy of this vector
	 */
	public Vec4 csubtract(Vec4 other) {
		try {
			Vec4 nvec = (Vec4) this.clone();
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
	public Vec4 multiply(Vec4 other) {
		x *= other.x;
		y *= other.y;
		z *= other.z;
		w *= other.w;
		return this;
	}
	
	/**
	 * Creates a copy of this instance, then multiplies a vector with the copy
	 * @param other the vector to multiply the copy with
	 * @return the copy of this vector
	 */
	public Vec4 cmultiply(Vec4 other) {
		try {
			Vec4 nvec = (Vec4) this.clone();
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
	public Vec4 divide(Vec4 other) {
		x /= other.x;
		y /= other.y;
		z /= other.z;
		w /= other.w;
		return this;
	}
	
	/**
	 * Creates a copy of this instance, then divides by a vector
	 * @param other the vector to divide the copy with
	 * @return the copy of this vector
	 */
	public Vec4 cdivide(Vec4 other) {
		try {
			Vec4 nvec = (Vec4) this.clone();
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
		return "Vec4: " + x + ", " + y + ", " + z + ", " + w;
	}
	
	/**
	 * Checks if a Vec4, Vec3 or Vec4 is equal to this vector
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
			if(x == other.x && y == other.y && z == other.z) {
				result = true;
			}
		}else if(obj instanceof Vec4) {
			Vec4 other = (Vec4)obj;
			if(x == other.x && y == other.y && z == other.z && w == other.w) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Vec4(x, y, z, w);
	}
	
}

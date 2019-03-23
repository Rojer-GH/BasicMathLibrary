package de.rojer.maths.mat;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.tan;
import static java.lang.Math.toRadians;

import de.rojer.maths.vec.Vec3;
import de.rojer.maths.vec.Vec4;

/**
 * 4 * 4 Matrix of float elements, column-major
 * @author Rojer
 * @version 23.03.2019
 */
public class Mat4 {
	
	//Attributes
	
	/**
	 * The elements of the matrix
	 */
	public float elements[];
	
	//Constructors
	
	/**
	 * Creates a matrix with its values being 0
	 */
	public Mat4() {
		elements = new float[16];
		for(int i = 0; i < 16; i++) {
			elements[i] = 0.0f;
		}
	}
	
	/**
	 * Creates a matrix, with its values being 0, while its diagonal can be specified
	 * @param diagonal : the value for the numbers of the diagonal
	 */
	public Mat4(float diagonal) {
		elements = new float[16];
		for(int i = 0; i < 16; i++) {
			elements[i] = 0.0f;
		}
		elements[0 + 0 * 4] = diagonal;
		elements[1 + 1 * 4] = diagonal;
		elements[2 + 2 * 4] = diagonal;
		elements[3 + 3 * 4] = diagonal;
	}
	
	//Arithmetic
	
	/**
	 * Multiplies this matrix with another one
	 * @param other : the matrix to multiply with this matrix
	 * @return this matrix for multiple operations "in one line"
	 */
	public Mat4 multiply(Mat4 other) {
		//Used to store the solutions
		float[] data = new float[16];
		for(int row = 0; row < 4; row++) {
			for(int column = 0; column < 4; column++) {
				float sum = 0.0f;
				for(int e = 0; e < 4; e++) {
					sum += elements[e + row * 4] * other.elements[column + e * 4];
				}
				data[column + row * 4] = sum;
			}
		}
		//Stores the solutions in elements[]
		for(int i = 0; i < 16; i++) {
			elements[i] = data[i];
		}
		return this;
	}
	
	/**
	 * Multiplies a copy of this matrix with another one
	 * @param other : the matrix to multiply with the copy
	 * @return the multiplied copy
	 */
	public Mat4 cmultiply(Mat4 other) {
		try {
			Mat4 matrix = (Mat4)this.clone();
			return matrix.multiply(other);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Multiplies this matrix with a Vec3
	 * @param other : the vector to multiply with this matrix
	 * @return this matrix for multiple operations "in one line"
	 */
	public Vec3 multiply(Vec3 vector) {
		Vec3 result = null;
		try {
			result = (Vec3) vector.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		result.x = elements[0 + 4 * 0] * vector.x + elements[0 + 4 * 1] * vector.y + elements[0 + 4 * 2] * vector.z + elements[0 + 4 * 3];
		result.y = elements[1 + 4 * 0] * vector.x + elements[1 + 4 * 1] * vector.y + elements[1 + 4 * 2] * vector.z + elements[1 + 4 * 3];
		result.z = elements[2 + 4 * 0] * vector.x + elements[2 + 4 * 1] * vector.y + elements[2 + 4 * 2] * vector.z + elements[2 + 4 * 3];
		return result;
	}
	
	/**
	 * Multiplies a copy of this matrix with a Vec3
	 * @param other : the vector to multiply with the copy
	 * @return the multiplied copy
	 */
	public Vec3 cmultiply(Vec3 other) {
		try {
			Mat4 matrix = (Mat4)this.clone();
			return matrix.multiply(other);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Multiplies this matrix with a Vec4
	 * @param other : the vector to multiply with this matrix
	 * @return this matrix for multiple operations "in one line"
	 */
	public Vec4 multiply(Vec4 vector) {
		Vec4 result = null;
		try {
			result = (Vec4) vector.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		result.x = elements[0 + 4 * 0] * vector.x + elements[0 + 4 * 1] * vector.y + elements[0 + 4 * 2] * vector.z + elements[0 + 4 * 3] * vector.w;
		result.y = elements[1 + 4 * 0] * vector.x + elements[1 + 4 * 1] * vector.y + elements[1 + 4 * 2] * vector.z + elements[1 + 4 * 3] * vector.w;
		result.z = elements[2 + 4 * 0] * vector.x + elements[2 + 4 * 1] * vector.y + elements[2 + 4 * 2] * vector.z + elements[2 + 4 * 3] * vector.w;
		result.w = elements[3 + 4 * 0] * vector.x + elements[3 + 4 * 1] * vector.y + elements[3 + 4 * 2] * vector.z + elements[3 + 4 * 3] * vector.w;
		return result;
	}
	
	/**
	 * Multiplies a copy of this matrix with a Vec4
	 * @param other : the vector to multiply with the copy
	 * @return the multiplied copy
	 */
	public Vec4 cmultiply(Vec4 other) {
		try {
			Mat4 matrix = (Mat4)this.clone();
			return matrix.multiply(other);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Static Methods
	
	/**
	 * @return A matrix with its diagonal-values being 1
	 */
	public static Mat4 Identity() {
		return new Mat4(1.0f);
	}
	
	/**
	 * Returns an orthographic matrix
	 * @param left : the left-side of the screen
	 * @param right : the right-side of the screen
	 * @param bottom : the bottom-side of the screen
	 * @param top : the top-side of the screen
	 * @param near : the near-side of the screen
	 * @param far : the far-side of the screen
	 * @return the matrix
	 */
	public static Mat4 Orthographic(float left, float right, float bottom, float top, float near, float far) {
		Mat4 result = new Mat4(1.0f);

		result.elements[0 + 0 * 4] = 2.0f / (right - left);
		result.elements[1 + 1 * 4] = 2.0f / (top - bottom);
		result.elements[2 + 2 * 4] = 2.0f / (near - far);

		result.elements[0 + 3 * 4] = (left + right) / (left - right);
		result.elements[1 + 3 * 4] = (bottom + top) / (bottom - top);
		result.elements[2 + 3 * 4] = (near + far) / (far - near);

		return result;
	}
	
	/**
	 * Returns a perspective matrix
	 * @param fov : the force of view
	 * @param aspectRatio : the aspect-ratio of the screen
	 * @param near : the near-side of the screen
	 * @param far : the far-side of the screen
	 * @return the matrix
	 */
	public static Mat4 Perspective(float fov, float aspectRatio, float near, float far) {
		Mat4 result = new Mat4(1.0f);

		float q = 1.0f / (float)tan(toRadians(0.5f * fov));
		float a = q / aspectRatio;
		float b = (near + far) / (near - far);
		float c = (2.0f * near * far) / (near - far);

		result.elements[0 + 0 * 4] = a;
		result.elements[1 + 1 * 4] = q;
		result.elements[2 + 2 * 4] = b;
		result.elements[3 + 2 * 4] = -1.0f;
		result.elements[2 + 3 * 4] = c;

		return result;
	}
	
	/**
	 * Returns a translation matrix, with which you can "move" objects on the screen
	 * @param translation : a Vec3 containing the translation on the x-, y- and z-axis
	 * @return the matrix
	 */
	public static Mat4 Translation(Vec3 translation) {
		Mat4 result = new Mat4(1.0f);

		result.elements[0 + 3 * 4] = translation.x;
		result.elements[1 + 3 * 4] = translation.y;
		result.elements[2 + 3 * 4] = translation.z;

		return result;
	}
	
	/**
	 * Returns a rotation matrix
	 * @param angle : the angle in degrees
	 * @param axis : the axis
	 * @return the matrix
	 */
	public static Mat4 Rotation(float angleX, float angleY, float angleZ) {
		Mat4 rotationX = new Mat4(1.0f);
		Mat4 rotationY = new Mat4(1.0f);
		Mat4 rotationZ = new Mat4(1.0f);

		float x = (float)toRadians(angleX);
		float xc = (float)cos(x);
		float xs = (float)sin(x);
		
		float y = (float)toRadians(angleY);
		float yc = (float)cos(y);
		float ys = (float)sin(y);
		
		float z = (float)toRadians(angleZ);
		float zc = (float)cos(z);
		float zs = (float)sin(z);
		
		rotationX.elements[1 + 1 * 4] = xc;
		rotationX.elements[2 + 1 * 4] = -xs;
		rotationX.elements[1 + 2 * 4] = xs;
		rotationX.elements[2 + 2 * 4] = xc;
		
		rotationY.elements[0 + 0 * 4] = yc;
		rotationY.elements[2 + 0 * 4] = ys;
		rotationY.elements[0 + 2 * 4] = -ys;
		rotationY.elements[2 + 2 * 4] = yc;
		
		rotationZ.elements[0 + 0 * 4] = zc;
		rotationZ.elements[1 + 0 * 4] = zs;
		rotationZ.elements[0 + 1 * 4] = -zs;
		rotationZ.elements[1 + 1 * 4] = zc;
		
		return rotationZ.multiply(rotationY).multiply(rotationX);
	}
	
	/**
	 * Returns a scale matrix
	 * @param scale : the scaling value
	 * @return the matrix
	 */
	public static Mat4 Scale(Vec3 scale) {
		Mat4 result = new Mat4(1.0f);

		result.elements[0 + 0 * 4] = scale.x;
		result.elements[1 + 1 * 4] = scale.y;
		result.elements[2 + 2 * 4] = scale.z;

		return result;
	}
	
	//Object-inherited methods
	
	@Override
	public String toString() {
		String text = "";
		for(int i = 0; i < 4; i++) {
			text += elements[i + 0 * 4] + " ";
			text += elements[i + 1 * 4] + " ";
			text += elements[i + 2 * 4] + " ";
			text += elements[i + 3 * 4] + "\n";
		}
		return text;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = true;
		for(int i = 0; i < 16; i++) {
			if(elements[i] != ((Mat4)obj).elements[i]) {
				equal = false;
				break;
			}
		}
		return equal;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Mat4 matrix = new Mat4();
		for(int i = 0; i < 16; i++) {
			matrix.elements[i] = elements[i];
		}
		return matrix;
	}

}

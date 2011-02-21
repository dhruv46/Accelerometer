package com.si.accelerometer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Marble {
	// View controlling the marble.
	private View mView;
	// marble attributes
	// x,y are private because we need boundary checking on any new values to
	// make sure they are valid.
	private int mX = 0;
	private int mY = 0;
	private int mRadius = 8;
	private int mColor = Color.WHITE;
	private int mLives = 5;

	/** * Marble constructor. * * @param view * View controlling the marble */
	public Marble(View view) {
		this.mView = view;
		init();
	}

	/** * Setup marble starting co-ords. */
	public void init() {
		mX = mRadius * 6;
		mY = mRadius * 6;
	}

	/**
	 * * Draw the marble. * * @param canvas * Canvas object to draw too. * @param
	 * paint * Paint object used to draw with.
	 */
	public void draw(Canvas canvas, Paint paint) {
		paint.setColor(mColor);
		canvas.drawCircle(mX, mY, mRadius, paint);
	}

	/**
	 * * Attempt to update the marble with a new x value, boundary checking *
	 * enabled to make sure the new co-ordinate is valid. * * @param newX *
	 * Incremental value to add onto current x co-ordinate.
	 */
	public void updateX(float newX) {
		mX += newX;
		// boundary checking, don't want the marble rolling off-screen.
		if (mX + mRadius >= mView.getWidth())
			mX = mView.getWidth() - mRadius;
		else if (mX - mRadius < 0)
			mX = mRadius;
	}

	/**
	 * * Attempt to update the marble with a new y value, boundary checking *
	 * enabled to make sure the new co-ordinate is valid. * * @param newY *
	 * Incremental value to add onto current y co-ordinate.
	 */
	public void updateY(float newY) {
		mY -= newY;
		// boundary checking, don't want the marble rolling
		// off-screen.
		if (mY + mRadius >= mView.getHeight())
			mY = mView.getHeight() - mRadius;
		else if (mY - mRadius < 0)
			mY = mRadius;
	}

	/** * Marble has died */
	public void death() {
		mLives--;
	}

	/** * Set the number of lives for the marble * * @param Number * of lives */
	public void setLives(int val) {
		mLives = val;
	}

	/** * @return Number of lives left */
	public int getLives() {
		return mLives;
	}

	/** * @return Current x co-ordinate. */
	public int getX() {
		return mX;
	}

	/** * @return Current y co-ordinate. */
	public int getY() {
		return mY;
	}
}

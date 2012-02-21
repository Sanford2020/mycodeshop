package com.ai.android.ExerciseSystemIntents;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class MyAnimation extends Animation {
	
	private int width;
	private int height;
	Camera cam = new Camera();

	@Override
	public void initialize(int width, int height, int parentWidth, int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);
		//width = 540, height = 812, parentWidth = 540, parentHeight = 884
		Log.d("d", "width = " + width + ", height = " + height + ", parentWidth = " + parentWidth + ", parentHeight = " + parentHeight);
		this.width = width;
		this.height = height;
		setDuration(3000);
		setFillAfter(true);
//		setInterpolator(new LinearInterpolator());
		setInterpolator(new AccelerateDecelerateInterpolator());
	}
	
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		
		Matrix mx = t.getMatrix();		//每次一次applyTransformation，mx都是全新的，不会在上一次基础上叠加，所以第一个方法调setXxx与postXxx一样效果
		
		//TEST 00.a
//		mx.setScale(interpolatedTime, interpolatedTime);		//Scale: From (0,0) to (1,1)
		
		//TEST 00.b
//		mx.setScale(interpolatedTime, interpolatedTime, width / 4, height / 4);		//Scale: From (0,0) to (1,1)
		
		
		//TEST 01.a
//		mx.setScale(interpolatedTime, interpolatedTime);		//Scale: From 0 to 1
//		mx.postTranslate(interpolatedTime * width / 2, interpolatedTime * height / 2);		//Translate: From (0,0) to (width/2, height/2)
		
		//TEST 01.b
//		mx.setScale(interpolatedTime, interpolatedTime, width / 2, height / 2);		//Param3 and Param4 is initial Translate
//		mx.postTranslate(interpolatedTime * width / 2, interpolatedTime * height / 2);
		
		
		//TEST 02.a
//		mx.setTranslate(interpolatedTime * width / 2, interpolatedTime * height / 2);		
//		mx.postScale(interpolatedTime, interpolatedTime);
		
		//TEST 02.b
//		mx.setTranslate(interpolatedTime * width / 2, interpolatedTime * height / 2);		
//		mx.postScale(interpolatedTime, interpolatedTime, width / 2, height / 2);
		
		
		//TEST 03.a
//		mx.postSkew(interpolatedTime, interpolatedTime);
		
		//TEST 03.b
//		mx.postSkew(interpolatedTime, interpolatedTime, width / 4, height / 4);
		
		
		//TEST 04.a
//		mx.postRotate(interpolatedTime * 360);
		
		//TEST 04.b
//		mx.postRotate(interpolatedTime * 360, width / 2, height / 2);
		
		//TEST 05
//		if(interpolatedTime <= 0.5) {
//			t.setAlpha(interpolatedTime * 2);	
//		} else {
//			t.setAlpha((1 - interpolatedTime) * 2);
//		}
		
		//TEST 06
//		mx.postSkew(0, interpolatedTime, width, height / 2);
//		mx.postSkew(0, interpolatedTime);
//		mx.postSkew(0, interpolatedTime/3, width / 2, height / 2);
//		mx.postSkew(interpolatedTime, 0, width * 2, height / 2);
//		mx.postScale(1 - interpolatedTime, 1, width / 2, 0);
		
		
		cam.save();
//		cam.translate(0.0f, 0.0f, (1300 - 1300.0f * interpolatedTime));	//1300 --> 0
		
		//机位的正向转动引起图片向屏幕里翻转  
        //但是绕Z轴的转动，引起图片平面的旋转（2D效果）  
        cam.rotateZ(45);  
         
        //X引起图片向右移动50（正向朝右）  
        //Y引起图片向上移动50（正向朝上）  
        //Z引起图片缩小（正向指向自己）  
        cam.translate(100f, 0f, 300f);  
        cam.getMatrix(mx);    

        //移到中心点上  
		mx.preTranslate(-width / 2, - height / 2);
		mx.postTranslate(width / 2, height / 2);
		cam.restore();
		
		
	}
	
	
}

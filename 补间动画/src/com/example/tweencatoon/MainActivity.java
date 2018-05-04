package com.example.tweencatoon;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView) findViewById(R.id.iv);
	}
	/**
	 * 
	 * 透明度变化
	 * @param view
	 */
	public void click(View view) {
//		AlphaAnimation animation =new AlphaAnimation(0.0f, 1.0f);
//		animation.setDuration(2000);
//		animation.setRepeatCount(2);
//		animation.setRepeatMode(Animation.REVERSE);
//		iv.startAnimation(animation);
		
		Animation animation =AnimationUtils.loadAnimation(this, R.anim.alpha_item);
		iv.startAnimation(animation);
	}
	/**
	 * 
	 * 缩放
	 * @param view
	 */
	public void click1(View view) {
//		ScaleAnimation animation =new ScaleAnimation(0.2f, 2.0f, 0.2f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//		animation.setDuration(2000);
//		animation.setRepeatCount(2);
//		animation.setRepeatMode(Animation.REVERSE);
//		iv.startAnimation(animation);
		
		
		Animation animation =AnimationUtils.loadAnimation(this, R.anim.scale_item);
		iv.startAnimation(animation);
	}
	/**
	 * 
	 * 旋转
	 * @param view
	 */
	public void click2(View view) {
		//RotateAnimation animation =new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		RotateAnimation animation =new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		animation.setDuration(2000);
		animation.setRepeatCount(2);
		animation.setRepeatMode(Animation.REVERSE);
		iv.startAnimation(animation);
	}
	/**
	 * 
	 * 平移
	 * @param view
	 */
	public void click3(View view) {
		//RotateAnimation animation =new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		TranslateAnimation animation =new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f,Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 1.0f);
		animation.setDuration(2000);
		animation.setRepeatCount(2);
		animation.setRepeatMode(Animation.REVERSE);
		iv.startAnimation(animation);
	}
	/**
	 * 组合
	 * @param view
	 */
	public void click4(View view) {
		AnimationSet set=new AnimationSet(false);
		
		
		TranslateAnimation ta =new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f,Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 1.0f);
		ta.setDuration(2000);
		ta.setRepeatCount(2);
		ta.setRepeatMode(Animation.REVERSE);
		
		RotateAnimation ra =new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		ra.setDuration(2000);
		ra.setRepeatCount(2);
		ra.setRepeatMode(Animation.REVERSE);
		
		ScaleAnimation sa =new ScaleAnimation(0.2f, 2.0f, 0.2f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(2000);
		sa.setRepeatCount(2);
		sa.setRepeatMode(Animation.REVERSE);
		
		set.addAnimation(sa);
		set.addAnimation(ra);
		set.addAnimation(ta);
		 
		iv.startAnimation(set);
	}
	
}

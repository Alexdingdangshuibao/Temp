package com.example.framecatoon;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView  rocketImage;
	private AnimationDrawable rocketAnimation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rocketImage = (ImageView) findViewById(R.id.iv);
		  rocketImage.setBackgroundResource(R.drawable.girl_list);
		  rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
	}
	public void click(View view) {
		rocketAnimation.start();
		
		
	}
}

package com.example.girl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView after;
	private ImageView pre;
	private Bitmap alertbitmap;
	private Canvas canvas;
	private Paint paint;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		after=(ImageView) findViewById(R.id.iv_after);
		pre=(ImageView) findViewById(R.id.iv_pre);
		BitmapFactory.Options opts=new Options();
		opts.inSampleSize=3;
		//只读图片
		Bitmap bitmap_after=BitmapFactory.decodeResource(getResources(), R.drawable.a, opts);
		Bitmap bitmap_pre=BitmapFactory.decodeResource(getResources(), R.drawable.b, opts);
		//可以修改的空白的bitmap
		alertbitmap=Bitmap.createBitmap(bitmap_pre.getWidth(), bitmap_pre.getHeight(), bitmap_pre.getConfig());
		canvas=new Canvas(alertbitmap);
		paint=new Paint();
		paint.setStrokeWidth(10);
		paint.setColor(Color.BLACK);
		canvas.drawBitmap(bitmap_pre, new Matrix(), paint);
		after.setImageBitmap(bitmap_after);
		pre.setImageBitmap(alertbitmap);
		pre.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_MOVE:
					int newx=(int) event.getX();
					int newy=(int) event.getY();
					for(int i=-5;i<5;i++) {
						for(int j=-5;j<5;j++) {
					     alertbitmap.setPixel(i+newx,j+newy, Color.TRANSPARENT);
					     }
						}
					pre.setImageBitmap(alertbitmap);
					break;
				}
				return true;
			}
		});
	}

}

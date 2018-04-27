package com.example.colorimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	private ImageView iv;//定义控件
	private SeekBar red;
	private SeekBar blue;
	private SeekBar green;
	private SeekBar hight;
	private Canvas canvas;
	private Paint paint;
	private Matrix matrix;
	private Bitmap bitmap;
	private Bitmap alertbitmap;
	private ColorMatrix cm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView) findViewById(R.id.iv);//获取控件
		red=(SeekBar) findViewById(R.id.red);
		blue=(SeekBar) findViewById(R.id.blue);
		green=(SeekBar) findViewById(R.id.green);
		hight=(SeekBar) findViewById(R.id.hight);
		//设置控件最大值
		red.setMax(255);
		blue.setMax(255);
		green.setMax(255);
		hight.setMax(255);
		//设置图片
		bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.a);
		alertbitmap=Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
		canvas=new Canvas(alertbitmap);
		paint=new Paint();
		paint.setColor(Color.BLACK);
		matrix=new Matrix();
		cm=new ColorMatrix();
		paint.setColorFilter(new ColorMatrixColorFilter(cm));
		paint.setAntiAlias(true);
		canvas.drawBitmap(bitmap, matrix, paint);
		iv.setImageBitmap(alertbitmap);
		red.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				int progress=seekBar.getProgress();
				cm.set(new float[] {
						progress/128.0f,0,0,0,0,
						0,1,0,0,0,
						0,0,1,0,0,
						0,0,0,1,0
				});
				paint.setColorFilter(new ColorMatrixColorFilter(cm));
				canvas.drawBitmap(bitmap, matrix, paint);
				iv.setImageBitmap(alertbitmap);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
		blue.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				int progress=seekBar.getProgress();
				cm.set(new float[] {
						1,0,0,0,0,
						0,progress/128.0f,0,0,0,
						0,0,1,0,0,
						0,0,0,1,0
				});
				paint.setColorFilter(new ColorMatrixColorFilter(cm));
				canvas.drawBitmap(bitmap, matrix, paint);
				iv.setImageBitmap(alertbitmap);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
		green.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				int progress=seekBar.getProgress();
				cm.set(new float[] {
						1,0,0,0,0,
						0,1,0,0,0,
						0,0,progress/128.0f,0,0,
						0,0,0,1,0
				});
				paint.setColorFilter(new ColorMatrixColorFilter(cm));
				canvas.drawBitmap(bitmap, matrix, paint);
				iv.setImageBitmap(alertbitmap);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
		hight.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				int progress=seekBar.getProgress();
				cm.set(new float[] {
						progress/128.0f,0,0,0,0,
						0,progress/128.0f,0,0,0,
						0,0,progress/128.0f,0,0,
						0,0,0,progress/128.0f,0
				});
				paint.setColorFilter(new ColorMatrixColorFilter(cm));
				canvas.drawBitmap(bitmap, matrix, paint);
				iv.setImageBitmap(alertbitmap);
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}

package com.example.allimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView) findViewById(R.id.iv);
		Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		Bitmap alertbitmap=Bitmap.createBitmap(bitmap.getWidth()+10, bitmap.getHeight()+10, bitmap.getConfig());
		Canvas canvas=new Canvas(alertbitmap);
		Paint paint=new Paint();
		paint.setColor(Color.BLACK);
		Matrix matrix=new Matrix();
		
		//图形的平移
		//matrix.setTranslate(10, 10);
		//matrix.postTranslate(10, 10);
		
		//图形的镜子效果
//		matrix.setScale(-1, 1);
//		matrix.postTranslate(bitmap.getWidth(),0);
		
		//图形的倒影效果
		matrix.setScale(1, -1);
		matrix.postTranslate(0, bitmap.getHeight());
		
		canvas.drawBitmap(bitmap, matrix, paint);
		iv.setImageBitmap(alertbitmap);
		
	}
}

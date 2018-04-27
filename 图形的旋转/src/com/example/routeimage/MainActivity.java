package com.example.routeimage;

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
		Bitmap alertmap=Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
		Canvas canvas=new Canvas(alertmap);
		Paint paint=new Paint(); 
		paint.setColor(Color.BLACK);
		Matrix matrix=new Matrix();
		matrix.setRotate(180, bitmap.getWidth()/2,bitmap.getHeight()/2);
		paint.setAntiAlias(true);
		canvas.drawBitmap(bitmap, matrix, paint);
		iv.setImageBitmap(alertmap);
	}

}

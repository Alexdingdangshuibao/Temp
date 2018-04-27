package com.example.mergeimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=(ImageView) findViewById(R.id.iv);
		//ͼƬ�ĺϳ� �Ȼ�ͼƬA �ٻ�ͼƬB
		Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.b);
		Bitmap ic_launch=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		Bitmap alertbitmap=Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
		Canvas canvas=new Canvas(alertbitmap);
		Paint paint=new Paint();
		//����ͼƬ�ϳɵ�ģʽ
		paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.LIGHTEN));
		paint.setColor(Color.BLACK);
		canvas.drawBitmap(bitmap, new Matrix(), paint);
		canvas.drawBitmap(ic_launch, new Matrix(), paint);
		iv.setImageBitmap(alertbitmap);
	}
}

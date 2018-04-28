package com.example.facedector;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.a);
		FaceDetector detector=new FaceDetector(bitmap.getWidth(), bitmap.getHeight(), 1);
		Face[] face=new Face[1];
		int numface=detector.findFaces(bitmap, face);
		//ʶ��
		if(numface>0) {
			for(int i=0;i<numface;i++) {
				System.out.println("�ҵ�����");
				PointF point=new PointF();
				face[i].getMidPoint(point);
				System.out.println("�����������꣺"+point.x+","+point.y);;
			}
		}else {
				System.out.println("û�ҵ���");
			}
	}
}

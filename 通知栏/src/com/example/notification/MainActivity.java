package com.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public  void click(View view) {
		//1.��ȡ�ֻ�ϵͳ�����֪ͨ������
		NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		//2.ʵ����notification ��ʾͬ־�ľ�������
		Notification notification=new Notification(R.drawable.ic_launcher, "����һ��notification",System.currentTimeMillis());
		
		notification.flags=Notification.FLAG_INSISTENT;
		Intent intent=new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:110"));
		PendingIntent pendingintent=PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, "����notification����", "����notification������",pendingintent);
//		Notification.Builder builder=new Builder(this);
//		builder.setContentTitle("����notification�ı���")
//		.setContentText("����notification������")
//		.setSmallIcon(R.drawable.ic_launcher)
//		.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher,null));
//		Notification notification=builder.build();
		nm.notify(0,notification);
	}
}

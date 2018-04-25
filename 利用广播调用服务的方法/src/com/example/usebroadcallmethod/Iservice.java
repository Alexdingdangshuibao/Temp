package com.example.usebroadcallmethod;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class Iservice extends Service {
	private Myreciever receiver;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	} 
	@Override
	public void onCreate() {
		//采用代码的方式注册一个广播接收者
		receiver=new Myreciever();
		IntentFilter filter=new IntentFilter();
		filter.addAction("com.example.usebroadcallmethod");
		registerReceiver(receiver, filter);
		super.onCreate();
	}
	@Override
	public void onDestroy() {
		unregisterReceiver(receiver);
		receiver=null;
		super.onDestroy();
	}
	private class Myreciever  extends BroadcastReceiver{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			System.out.println("我是service内部的广播接收者");
			method();
		}
		
	}
	 
	public void method() {
		Toast.makeText(this, "我是服务内部方法", 0).show();
	}
}

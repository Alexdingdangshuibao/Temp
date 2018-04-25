package com.example.usepay;

import com.example.alipay.IService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

public class MainActivity extends Activity {
	private Intent intent;
	private IService iservice;
	private Myconn conn=new Myconn();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		intent=new Intent();
		intent.setAction("com.example.pay");
		intent.setPackage("com.example.alipay");
}
	public void bind(View view) {
		bindService(intent,conn, BIND_AUTO_CREATE);
	}
	public class Myconn implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			iservice=IService.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
		}
	}
	public void use(View view) {
			try {
				iservice.callAlipay();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

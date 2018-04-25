package com.example.alipay;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class AlipayService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("远程支付服务被绑定了");
		return new Mybinder();
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		System.out.println("远程支付服务被创建了");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("远程支付服务被销毁了");
		super.onDestroy();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("远程支付服务被解绑了");
		return super.onUnbind(intent);
	}
	public void methodinservie() {
		System.out.println("使用支付");
	}
	private class Mybinder extends IService.Stub{

		@Override
		public void callAlipay() throws RemoteException {
			// TODO Auto-generated method stub
			methodinservie();
		}
		
	}
}

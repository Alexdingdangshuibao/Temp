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
		System.out.println("Զ��֧�����񱻰���");
		return new Mybinder();
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		System.out.println("Զ��֧�����񱻴�����");
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("Զ��֧������������");
		super.onDestroy();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("Զ��֧�����񱻽����");
		return super.onUnbind(intent);
	}
	public void methodinservie() {
		System.out.println("ʹ��֧��");
	}
	private class Mybinder extends IService.Stub{

		@Override
		public void callAlipay() throws RemoteException {
			// TODO Auto-generated method stub
			methodinservie();
		}
		
	}
}

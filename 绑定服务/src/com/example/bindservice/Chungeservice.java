package com.example.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class Chungeservice extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		System.out.println("������񱻳ɹ��İ���");
		//�����Զ���Ĵ����˶���
		//������������ڳɹ��󶨵�ʱ�� ����� onbind���� ����һ��ibinder����
		return new Mybinder();
	}
	private class Mybinder extends Binder implements Iservice{
		//��ӵ����ô����˵����˴���ķ���
		public void callChangeSong(String song) {
			ChangeSong(song);
		}
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("onunbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("���񱻿����ˣ����翪ʼ����");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("���������ˣ�����ֹͣ����");
	}
	/***
	 * ���ĸ���
	 * @param song
	 */
	public void ChangeSong(String song) {
		Toast.makeText(getApplicationContext(), "��ʼ��"+song, 0).show();
	}
}

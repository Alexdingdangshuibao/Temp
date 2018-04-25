package com.example.bindservice;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {
	//�����ģ���activity����õ�����ibinder���������
	/**
	 * 
	 * �󶨷��� ��ӵ��÷�������ķ���
	 * 		   ���diaoyongzheactivity�������ˣ�����Ҳ���������
	 * 			������ͬʱ��������ͬʱ�ң�
	 * �������񣺲����Ե��÷�������ķ���
	 * 		  ���������activity�˳��ˣ������ǻ᳤�ڵ��ں�̨����
	 * 
	 * �������ڣ�
	 * 1.�������� startService����--oncreate
	 * 			stopService����--ondestroy
	 * ------------------------------------
	 * 			bind-��oncreate-��onbind
	 * 			unbind-��onunbind-��ondestroy
	 * 			����ְ�ܱ����һ�Σ���εĽ���󶨷��� Ӧ�ó�������
	 * 
	 *2.��ϵ���
	 *���󣺼�Ҫ��֤�����ڵ��ں�̨���У�����ȥ���÷�������ķ���
	 *���ɣ�1.�ȿ�������2.�󶨷���
	 *���裺1.��������startService����-��oncreat������
	 *    2.�󶨷��� bindService����-��onbind������
	 *    3.�رճ��򣬵������˳������񱻽��
	 *    4.stopservice����ֹͣ����
	 *���ֲ�������Ӧ�ó���
	 *�����߼� ж��service���棨��֤service���ں�̨���У�startService����
	 *��� ���� ��ͣ ��һ�� �����÷������淽���� bindService����
	 *activity�رյ�ʱ�� ����Ҫ���÷��񷽷��� unbindservice����
	 *�رղ�������ʱ�� stopservice����
	 *
	 *
	 */
	private Iservice mybinder;
	private Myconn conn=new Myconn();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		try{unbindService(conn);}
		catch(Exception e) {}
		super.onDestroy();
	}

	public void start(View view) {
		Intent intent=new Intent(this,Chungeservice.class);
		//����api�������񣬷�������Ǳ�ϵͳ����ܣ�new ������
		startService(intent);
	}
	public void destroy(View view) {
		Intent intent=new Intent(this,Chungeservice.class);
		stopService(intent);
	}
	public void bind_start(View view) {
		Intent intent=new Intent(this,Chungeservice.class);
		//intent ����������ͼ
		//conn ������ �м��˶��� ��������������ϵ ����Ϊ��
		//BIND_AUTO_CREATE �ڰ󶨷����ʱ�� ������񲻴��ھ��Զ�����
		//����һ�����ð󶨵ķ�ʽ����һ������
		bindService(intent,conn,BIND_AUTO_CREATE);
	}
	public void unbind_start(View view) {
		unbindService(conn);
	}
	public void change(View view) {
		//����ϵͳ����ڴ��������ʱ�򣬻ᴴ����֮��Ӧ��������
		//����Ĵ�����ֱ��new����
//		Chungeservice service =new Chungeservice();
//		service.ChangeSong("����֮��");
		//�����壺����ibinder�����ӵص����˷�������ķ���
		mybinder.callChangeSong("����֮��");
	}
	public class Myconn implements ServiceConnection{
		//�ڷ��񱻳ɹ��󶨵�ʱ�����
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("����Ѵ����˷�������");
			//�����������񷵻ص�ibinder����ᱻ���ݸ�myconn�Ļٵ�����
			mybinder=(Iservice) service;
		}
		//�ڷ���ʧȥ�󶨵�ʱ����õķ�����ֻ�г����쳣��ֹ��
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

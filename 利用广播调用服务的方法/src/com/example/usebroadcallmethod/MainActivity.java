package com.example.usebroadcallmethod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
/**
 * �Ĵ���� �ص㣺 ������Ҫ���嵥�ļ��н�������
 * activity ���� �û�������UI
 * service  ��̨���е�û�н��� ���ں�̨����  ���Ӧ�ó�������ȼ�
 * broadcast receiver ����ϵͳ�Ĺ㲥�¼�  �Զ���һЩ�㲥������ͨ������ķ�ʽ����ע�ᣬҲ����ͨ���嵥�ļ�����ע�ᣩ
 * content provider ���Լ�˽�е����� ��¶�����Ӧ�ó���
 * 
 * 
 * 
 * 
 * 
 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent=new Intent(this,Iservice.class);
		startService(intent);
	
	}
	public void call(View view) {
		//����һ���㲥
		Intent intent=new Intent();
		intent.setAction("com.example.usebroadcallmethod");
		sendBroadcast(intent);
	}
}

package com.example.alipay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
/**
 *AIDL:android interface definition language ��׿�ӿڶ�������
 *
 *IPC:inter process communication ���̼�ͨѶ
 * 
 * �󶨱��ط��������
 * 1.��activity�е���bindservice����ȥ�󶨷���
 * 		bindservice��intent��new Myconn������BIND_AUTO_CREATE��
 * 		��Ҫ����һ����serviceconnection�Ľӿں����������������ص� �����񱻳ɹ��� ������ʧȥ����
 * 2.�ڷ�������Ҫ��д����onbind�����ڷ��񱻰󶨵�ʱ����÷���һ�������� ����Ҫʵ���������������������Ե��õ�����ķ���
 * 3.��activity��onserviceconnected�õ��м���
 * 4.�����м��˵ķ���
 * 5.�м��˵��÷���ķ���
 * 
 * ��Զ�̷��������aidl
 *
 * 1.��activity�е���bindservice����ȥ�󶨷���
 * 		bindservice��intent��new Myconn������BIND_AUTO_CREATE��
 * 		��Ҫ����һ����serviceconnection�Ľӿں����������������ص� �����񱻳ɹ��� ������ʧȥ����
 * 2.�ڷ�������Ҫ��д����onbind�����ڷ��񱻰󶨵�ʱ����÷���һ��Ibinder�ӿ� ���󣨴����ˣ�  �ӿڶ��� ��Ҫ�ĳ�aidl  ���Զ����ɵ�Iservice.stub
 * 3.��activity��onserviceconnected�õ��м���
 * 4.�����м��˵ķ���  ʹ��aidl�Զ�����Iservice ����IServie.stub.asInterface()
 * 5.�м��˵��÷���ķ���
 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

}

package com.example.androidprocesspriorityandwhyuseservice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
/**
 * 1. ����
 * 2. Ӧ�ó���һ�������activity service povider receiver���ļ���
 * 		һ������£�һ��Ӧ�ó�����Ӧһ�����̡��ص�Ӧ�ã��ص����еĽ��棬�ر����е�activity��
 * 				Ӧ�ó���ý����ǲ��ᱻ�رյ��� ��Ȼ�ں�̨���ڵ�����
 * 
 * ��ȡһ����� ���������Զ��Ĺ������
 * �������ȼ���Ϊ��ͬ�ĵǼǣ�
 * 1.ǰ̨����  �û����Կ��������������ĳһ��activity�Ľ��棬���Բ����������
 * 2.�ɼ�����  �û���Ȼ���Կ���������� ĳ��activity�Ľ��棬���ǲ����Բ����������
 * 3.�������  ���һ��Ӧ�ó��� ��һ�������ں�̨����
 * 4.��̨����  û���κη���Ľ��� ��һ��activity֮�� ����Home�� ��С��
 * 5.�ս���      û���κλ��� ���ڵĽ���
 * 
 * 
 * 
 * 
 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}

package com.example.alipay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
/**
 *AIDL:android interface definition language 安卓接口定义语言
 *
 *IPC:inter process communication 进程间通讯
 * 
 * 绑定本地服务的流程
 * 1.在activity中调用bindservice（）去绑定服务
 * 		bindservice（intent，new Myconn（），BIND_AUTO_CREATE）
 * 		需要传递一个教serviceconnection的接口函数用来返回两个回调 当服务被成功绑定 当服务失去连接
 * 2.在服务里需要重写方法onbind（）在服务被绑定的时候调用返回一个代理人 必须要实现这个方法，这个方法可以调用到服务的方法
 * 3.在activity的onserviceconnected得到中间人
 * 4.调用中间人的方法
 * 5.中间人调用服务的方法
 * 
 * 绑定远程服务的流程aidl
 *
 * 1.在activity中调用bindservice（）去绑定服务
 * 		bindservice（intent，new Myconn（），BIND_AUTO_CREATE）
 * 		需要传递一个教serviceconnection的接口函数用来返回两个回调 当服务被成功绑定 当服务失去连接
 * 2.在服务里需要重写方法onbind（）在服务被绑定的时候调用返回一个Ibinder接口 对象（代理人）  接口定义 需要改成aidl  用自动生成的Iservice.stub
 * 3.在activity的onserviceconnected得到中间人
 * 4.调用中间人的方法  使用aidl自动生成Iservice 利用IServie.stub.asInterface()
 * 5.中间人调用服务的方法
 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

}

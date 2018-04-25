package com.example.usebroadcallmethod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
/**
 * 四大组件 特点： 都是需要在清单文件中进行配置
 * activity 界面 用户交互的UI
 * service  后台运行的没有界面 长期后台存在  提高应用程序的优先级
 * broadcast receiver 接受系统的广播事件  自定义一些广播（可以通过代码的方式进行注册，也可以通过清单文件进行注册）
 * content provider 把自己私有的数据 暴露给别的应用程序
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
		//发送一条广播
		Intent intent=new Intent();
		intent.setAction("com.example.usebroadcallmethod");
		sendBroadcast(intent);
	}
}

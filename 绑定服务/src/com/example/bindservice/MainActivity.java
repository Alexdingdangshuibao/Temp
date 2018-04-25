package com.example.bindservice;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {
	//步骤四：在activity里面得到服务ibinder对象的引用
	/**
	 * 
	 * 绑定服务： 间接调用服务里面的方法
	 * 		   如果diaoyongzheactivity被销毁了，服务也会跟着销毁
	 * 			（不求同时生，但求同时挂）
	 * 开启服务：不可以调用服务里面的方法
	 * 		  如果调用者activity退出了，服务还是会长期的在后台运行
	 * 
	 * 生命周期：
	 * 1.单独调用 startService（）--oncreate
	 * 			stopService（）--ondestroy
	 * ------------------------------------
	 * 			bind-》oncreate-》onbind
	 * 			unbind-》onunbind-》ondestroy
	 * 			服务职能被解绑一次，多次的解除绑定服务 应用程序会出错
	 * 
	 *2.混合调用
	 *需求：既要保证服务长期的在后台运行，又想去调用服务里面的方法
	 *技巧：1.先开启服务2.绑定服务
	 *步骤：1.开启服务startService（）-》oncreat（）；
	 *    2.绑定服务 bindService（）-》onbind（）；
	 *    3.关闭程序，调用者退出，服务被解绑
	 *    4.stopservice（）停止服务
	 *音乐播放器的应用场景
	 *播放逻辑 卸载service里面（保证service长期后台运行）startService（）
	 *快进 快退 暂停 上一曲 （调用服务里面方法） bindService（）
	 *activity关闭的时候 不需要调用服务方法了 unbindservice（）
	 *关闭播放器的时候 stopservice（）
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
		//采用api创建服务，服务对象是被系统（框架）new 出来的
		startService(intent);
	}
	public void destroy(View view) {
		Intent intent=new Intent(this,Chungeservice.class);
		stopService(intent);
	}
	public void bind_start(View view) {
		Intent intent=new Intent(this,Chungeservice.class);
		//intent 激活服务的意图
		//conn 代理人 中间人对象 用来跟服务建立联系 不能为空
		//BIND_AUTO_CREATE 在绑定服务的时候 如果服务不存在就自动创建
		//步骤一：采用绑定的方式开启一个服务
		bindService(intent,conn,BIND_AUTO_CREATE);
	}
	public void unbind_start(View view) {
		unbindService(conn);
	}
	public void change(View view) {
		//由于系统框架在创建服务的时候，会创建与之对应的上下文
		//下面的代码是直接new对象
//		Chungeservice service =new Chungeservice();
//		service.ChangeSong("月亮之上");
		//步骤五：利用ibinder对象间接地调用了服务里面的方法
		mybinder.callChangeSong("月亮之上");
	}
	public class Myconn implements ServiceConnection{
		//在服务被成功绑定的时候调用
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("春哥把代理人返回来了");
			//步骤三：服务返回的ibinder对象会被传递给myconn的毁掉方法
			mybinder=(Iservice) service;
		}
		//在服务失去绑定的时候调用的方法（只有程序异常终止）
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

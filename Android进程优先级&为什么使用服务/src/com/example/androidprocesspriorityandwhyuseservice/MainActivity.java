package com.example.androidprocesspriorityandwhyuseservice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
/**
 * 1. 进程
 * 2. 应用程序：一组组件（activity service povider receiver）的集合
 * 		一般情况下：一个应用程序会对应一个进程。关掉应用（关掉所有的界面，关闭所有的activity）
 * 				应用程序得进程是不会被关闭掉的 仍然在后台长期的运行
 * 
 * 采取一组策略 帮助我们自动的管理进程
 * 按照优先级分为不同的登记：
 * 1.前台进程  用户可以看到这个进程里面某一个activity的界面，可以操作这个界面
 * 2.可见进程  用户仍然可以看到这个进程 某个activity的界面，但是不可以操作这个界面
 * 3.服务进程  如果一个应用程序 有一个服务在后台运行
 * 4.后台进程  没有任何服务的进程 打开一个activity之后 按了Home键 最小化
 * 5.空进程      没有任何活动组件 存在的进程
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

package com.example.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	//动态添加fragment
	//1.判断当前手机朝向
		int width=getWindowManager().getDefaultDisplay().getWidth();
		int height=getWindowManager().getDefaultDisplay().getHeight();
		Fragment1 fragment1=new  Fragment1();
		Fragment2 fragment2=new Fragment2();
		FragmentManager fm=getFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		if(width>height) {
			//水平方向
			ft.replace(android.R.id.content, fragment1);
		}else {
			ft.replace(android.R.id.content, fragment2);
		}
		ft.commit();
	}
}

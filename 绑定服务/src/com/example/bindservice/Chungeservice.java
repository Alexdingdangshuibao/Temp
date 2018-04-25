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
		System.out.println("春哥服务被成功的绑定了");
		//返回自定义的代理人对象
		//步骤二：服务在成功绑定的时候 会调用 onbind方法 返回一个ibinder对象
		return new Mybinder();
	}
	private class Mybinder extends Binder implements Iservice{
		//间接地利用代理人调用了春哥的方法
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
		System.out.println("服务被开启了，春哥开始唱歌");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("服务被销毁了，春哥停止唱歌");
	}
	/***
	 * 更改歌曲
	 * @param song
	 */
	public void ChangeSong(String song) {
		Toast.makeText(getApplicationContext(), "开始唱"+song, 0).show();
	}
}

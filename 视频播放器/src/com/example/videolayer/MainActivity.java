package com.example.videolayer;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnClickListener {
	/**
	 * 分析视频文件的格式  avi  rmvb  mp4
	 * 读取文件里面的数据  把每一帧转化成图片显示到界面上
	 * 
	 * 解析帧-》显示到界面—》解析帧-》显示到界面
	 * 
	 * 双缓冲计算：
	 * 线程A：解析帧--》显示到界面
	 * 线程B：             --》解析帧--》显示到界面
	 * 
	 * surfaceview 内部维护双缓冲  消耗内存资源
	 * 如果发现当前surfaceview 用户可见的时候 创建surfaceview的holder
	 * 如果surfaceview  变成用户不可见的时候呀 销毁surfaceview的holder
	 * 
	 */
	private EditText path;
	private Button play,pause,replay,stop;
	private SurfaceView sv;
	private MediaPlayer mediaplayer;
	private int currentposition;
	private SeekBar sb;
	private boolean isplaying;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		play=(Button) findViewById(R.id.play);
		pause=(Button) findViewById(R.id.pause);
		replay=(Button) findViewById(R.id.replay);
		stop=(Button) findViewById(R.id.stop);
		sb=(SeekBar) findViewById(R.id.sb);
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				int process=seekBar.getProgress();
				if(mediaplayer!=null&&mediaplayer.isPlaying())
					mediaplayer.seekTo(process);
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
		sv=(SurfaceView) findViewById(R.id.sv);
		//低版本手机需要加上下面的参数 制定自己不维护缓冲区
		//设置surface不维护自己的缓冲区，而是等待屏幕的渲染引擎将内容推送到用户界面
		//sv.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		sv.getHolder().addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				System.out.println("holder被销毁了");
				if(mediaplayer!=null&&mediaplayer.isPlaying()) {
				  currentposition=	mediaplayer.getCurrentPosition();	
				  stop();
				}
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				System.out.println("holder被创建了");
				if(currentposition>0) {
					play(currentposition);;
					
				}
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
				// TODO Auto-generated method stub
				System.out.println("holder的大小变化了");
			}
		});
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		replay.setOnClickListener(this);
		stop.setOnClickListener(this);
		pause.setEnabled(false);
		replay.setEnabled(false);
		stop.setEnabled(false);
	
	
	
	
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.play:
			play(0);
			break;
		case R.id.pause:
			pause();
			break;
		case R.id.replay:
			replay();
			break;
		case R.id.stop:
			stop();
			break;
		
		}
		
		
		
	}
	/**
	 * 播放视频
	 */
	public void play(final int currentposition) {
		//String videopath=path.getText().toString().trim();
		String videopath="/data/data/com.example.soundpool/video.mp4";
		try {
			mediaplayer=new MediaPlayer();
			mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			//设置video影片以surfaceholder播放
			mediaplayer.setDisplay(sv.getHolder());
			mediaplayer.setDataSource(videopath);
			mediaplayer.prepareAsync();
			mediaplayer.setOnPreparedListener(new OnPreparedListener() {
				
				@Override
				public void onPrepared(MediaPlayer mp) {
					// TODO Auto-generated method stub
					
					mediaplayer.start();
					int max=mediaplayer.getDuration();
					sb.setMax(max);
					mediaplayer.seekTo(currentposition);
					new Thread() {
							public void run() {
								isplaying=true;
								while(isplaying) {
									int position=mediaplayer.getCurrentPosition();
									sb.setProgress(position);
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
					}.start();
				
				}
			});
			play.setEnabled(false);
			pause.setEnabled(true);
			replay.setEnabled(true);
			stop.setEnabled(true);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 暂停
	 */
	public void pause() {
		if("继续".equals(pause.getText().toString().trim())) {
			mediaplayer.start();
			pause.setText("暂停");
			isplaying=true;
			return;
		}
		if(mediaplayer!=null&&mediaplayer.isPlaying()) {
			mediaplayer.pause();
			pause.setText("继续");
			isplaying=false;
			return;
		}
	}
	/**
	 * 重播
	 */
	public void replay() {
		if(mediaplayer!=null&&mediaplayer.isPlaying()) {
			mediaplayer.seekTo(0);
			mediaplayer.start();
	}
}
	/**
	 * 停止
	 */
	public void stop(){
		if(mediaplayer!=null&&mediaplayer.isPlaying()) {
			mediaplayer.stop();
			mediaplayer.release();
			mediaplayer=null;
			play.setEnabled(true);
			pause.setEnabled(false);
			replay.setEnabled(false);
			stop.setEnabled(false);
			isplaying=false;
		}
		}
}

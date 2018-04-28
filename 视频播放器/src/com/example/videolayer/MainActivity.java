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
	 * ������Ƶ�ļ��ĸ�ʽ  avi  rmvb  mp4
	 * ��ȡ�ļ����������  ��ÿһ֡ת����ͼƬ��ʾ��������
	 * 
	 * ����֡-����ʾ�����桪������֡-����ʾ������
	 * 
	 * ˫������㣺
	 * �߳�A������֡--����ʾ������
	 * �߳�B��             --������֡--����ʾ������
	 * 
	 * surfaceview �ڲ�ά��˫����  �����ڴ���Դ
	 * ������ֵ�ǰsurfaceview �û��ɼ���ʱ�� ����surfaceview��holder
	 * ���surfaceview  ����û����ɼ���ʱ��ѽ ����surfaceview��holder
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
		//�Ͱ汾�ֻ���Ҫ��������Ĳ��� �ƶ��Լ���ά��������
		//����surface��ά���Լ��Ļ����������ǵȴ���Ļ����Ⱦ���潫�������͵��û�����
		//sv.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		sv.getHolder().addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				System.out.println("holder��������");
				if(mediaplayer!=null&&mediaplayer.isPlaying()) {
				  currentposition=	mediaplayer.getCurrentPosition();	
				  stop();
				}
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				System.out.println("holder��������");
				if(currentposition>0) {
					play(currentposition);;
					
				}
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
				// TODO Auto-generated method stub
				System.out.println("holder�Ĵ�С�仯��");
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
	 * ������Ƶ
	 */
	public void play(final int currentposition) {
		//String videopath=path.getText().toString().trim();
		String videopath="/data/data/com.example.soundpool/video.mp4";
		try {
			mediaplayer=new MediaPlayer();
			mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			//����videoӰƬ��surfaceholder����
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
	 * ��ͣ
	 */
	public void pause() {
		if("����".equals(pause.getText().toString().trim())) {
			mediaplayer.start();
			pause.setText("��ͣ");
			isplaying=true;
			return;
		}
		if(mediaplayer!=null&&mediaplayer.isPlaying()) {
			mediaplayer.pause();
			pause.setText("����");
			isplaying=false;
			return;
		}
	}
	/**
	 * �ز�
	 */
	public void replay() {
		if(mediaplayer!=null&&mediaplayer.isPlaying()) {
			mediaplayer.seekTo(0);
			mediaplayer.start();
	}
}
	/**
	 * ֹͣ
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

package com.example.onlinevideolayer;

import java.io.IOException;

import com.example.videolayer.R;

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

public class MainActivity extends Activity implements OnClickListener {
	/**
	 *����������Ƶ  ����Ҫ���ֻ�֧�� ��ǰ�ĸ�ʽ �ſ��Բ���
	 *�ֶε����ط������ϵ���Դ
	 *2.3  2.2  ����ý���Э��֧�ֵĻ������ر�����
	 *4.0+ �Ծ����������ý��Э��֧��
	 *
	 */
	private EditText path;
	private Button play,pause,replay,stop;
	private SurfaceView sv;
	private MediaPlayer mediaplayer;
	private int currentposition;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		play=(Button) findViewById(R.id.play);
		pause=(Button) findViewById(R.id.pause);
		replay=(Button) findViewById(R.id.replay);
		stop=(Button) findViewById(R.id.stop);
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
		String videopath="http://192.168.1.121:8080/Test/video.mp4";
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
					mediaplayer.seekTo(currentposition);
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
			return;
		}
		if(mediaplayer!=null&&mediaplayer.isPlaying()) {
			mediaplayer.pause();
			pause.setText("����");
			return;
		}
	}
	/**
	 * �ز�
	 */
	public void replay() {
		stop();
		play(0);
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
		}
		}
}

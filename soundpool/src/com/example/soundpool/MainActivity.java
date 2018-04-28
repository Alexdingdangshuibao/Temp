package com.example.soundpool;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	private SoundPool soundpool;
	private int soundID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		soundpool=new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		soundID=soundpool.load(this, R.raw.ring,1);
	}
	public void play(View view) {
		soundpool.play(soundID, 1.0f, 1.0f, 0, 0, 1.0f);
	}
}

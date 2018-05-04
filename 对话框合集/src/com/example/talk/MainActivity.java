package com.example.talk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void click1(View view) {
		AlertDialog.Builder builder=new Builder(this);
		builder.setTitle("�Ի������");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setMessage("�Ƿ�����Ӧ�ó���");
		builder.setPositiveButton("ȷ��", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "ȷ���������", 0).show();
			}
		});
		builder.setNegativeButton("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}); 
//		AlertDialog dialog=builder.create();
//		dialog.show();
		builder.show();
	}
	public void click2(View view) { 
		AlertDialog.Builder builder=new Builder(this);
		builder.setTitle("��ѡ�Ի���");
		final String[] items=new String[] {"��Ŀ1","��Ŀ2","��Ŀ3"};
		builder.setSingleChoiceItems(items, 0, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, items[which]+"�������", 0).show();
				dialog.dismiss();
			}
		});
			builder.setNegativeButton("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}); 
		builder.show();
	}
	public void click3(View view) { 
		AlertDialog.Builder builder=new Builder(this);
		builder.setTitle("��ѡ�Ի���");
		final String[] items=new String[] {"��Ŀ1","��Ŀ2","��Ŀ3","��Ŀ4"};
		builder.setMultiChoiceItems(items, new boolean[] {true, false,true,false},new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, items[which]+isChecked, 0).show();
				dialog.dismiss();
			}
		});
			builder.setNegativeButton("ȡ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}); 
		builder.show();
	}
	public void click4(View view) {
		ProgressDialog dialog=new ProgressDialog(this);
		dialog.setTitle("����");
		dialog.setMessage("���ڼ�����...");
		dialog.show();
	}
	public void click5(View view) {
		final ProgressDialog dialog=new ProgressDialog(this);
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setTitle("����");
		dialog.setMessage("���ڼ�����...");
		dialog.setMax(100);
		dialog.show();
		new Thread() {
			public void run() {
				for(int i=0;i<=100;i++) {
					dialog.setProgress(i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				dialog.dismiss();
			};
			
			
		}.start();
	}
}

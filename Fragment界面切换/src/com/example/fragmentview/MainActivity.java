package com.example.fragmentview;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private LinearLayout content;
	private TextView tv1,tv2,tv3,tv4;
	private FragmentManager fm;
	private  FragmentTransaction ft;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//content=(LinearLayout) findViewById(R.id.content);
		tv1=(TextView) findViewById(R.id.tab1);
		tv2=(TextView) findViewById(R.id.tab2);
		tv3=(TextView) findViewById(R.id.tab3);
		tv4=(TextView) findViewById(R.id.tab4);
		
		
		tv1.setOnClickListener(this);
		tv2.setOnClickListener(this);
		tv3.setOnClickListener(this);
		tv4.setOnClickListener(this);
		fm=getFragmentManager();
		ft=fm.beginTransaction();
		ft.replace(R.id.content,new Fragment1());
		ft.commit();
	}
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		ft=fm.beginTransaction();
		switch (view.getId()) {
		
		case R.id.tab1:
			ft.replace(R.id.content,new Fragment1());
			break;
		case R.id.tab2:
			ft.replace(R.id.content,new Fragment2());
			break;
		
		case R.id.tab3:
			ft.replace(R.id.content,new Fragment3());
			break;
		case R.id.tab4:
			ft.replace(R.id.content,new Fragment4());
			break;
		default:
			break;
		}
		ft.commit();
	}
}

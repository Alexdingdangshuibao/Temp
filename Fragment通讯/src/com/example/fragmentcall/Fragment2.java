package com.example.fragmentcall;

import com.example.fragment.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {
	private TextView tv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view =inflater.inflate(R.layout.fragment2, null);
		tv=(TextView) view.findViewById(R.id.text);
		return view;
	}
	public void settext() {
		tv.setText("内容变化了");
		
	}
		
	
}

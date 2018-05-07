package com.example.fragmentcall;

import com.example.fragment.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {
	private Button bt;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment1, null);
		bt=(Button) view.findViewById(R.id.bt);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Fragment2 fragment2=(Fragment2) getActivity().getFragmentManager().findFragmentById(R.id.fragment2);
			
			fragment2.settext();
			}
		});
		return view;
	}
}

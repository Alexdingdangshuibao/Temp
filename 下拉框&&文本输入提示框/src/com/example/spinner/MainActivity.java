package com.example.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends Activity {
	private Spinner spinner;
	private AutoCompleteTextView et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinner=(Spinner) findViewById(R.id.spinner);
		ArrayAdapter<String>  adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter.add("java");
		adapter.add("python");
		adapter.add("basic");
		spinner.setAdapter(adapter);
		
		et=(AutoCompleteTextView) findViewById(R.id.et);
		String[] names=new String[] {"老张","老方","老毕","黎明","李丽","陈江","abb","acc"};
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, names);
		et.setAdapter(adapter1);
	}

}

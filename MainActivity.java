package com.example.organizer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onResume()
	{
		super.onResume();
		Button add = (Button)findViewById(R.id.addtask);
		Button vtask = (Button)findViewById(R.id.viewtask);
		Button etask = (Button)findViewById(R.id.edittask);
		
		add.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent i= new Intent(MainActivity.this, AddTasks.class);
				startActivity(i);
			}
		});
		
		vtask.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
				Intent i=new Intent(MainActivity.this, ViewTasks.class);
				startActivity(i);
			}
		});
		
		etask.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View v)
			{
					Intent i=new Intent(MainActivity.this, EditTasks.class);
					startActivity(i);
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

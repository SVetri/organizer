package com.example.organizer;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ListView;

public class ViewTasks extends Activity {

	ListView tsklist;
	ArrayList<Task> tasks;
	AdapterView.AdapterContextMenuInfo info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_tasks);
	}

	public void onResume()
	{
		super.onResume();
		tsklist= (ListView)findViewById(R.id.listview1);
		tasks= new ArrayList<Task>();
		DBHandler dbHandler = new DBHandler(ViewTasks.this, null, null, 1);
		tasks= dbHandler.gettasks();
		if(tasks==null)
		{
			new AlertDialog.Builder(this).setIcon(R.drawable.ic_launcher).setTitle("You Have No Tasks Right Now!").setPositiveButton("OK",null).show();
		}
		tsklist.setAdapter(new CustomAdapter(tasks, this));
	 }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_tasks, menu);
		return true;
	}

}

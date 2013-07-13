package com.example.organizer;

import java.util.Calendar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddTasks extends Activity {

	static final int DATE_DIALOG_ID = 10;
	private int day;
	private int month;
	private int year;
	TextView tvdate;
	Button changedt;
	Button Savetask;
	EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_tasks);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	@Override
	public void onResume()
	{
		super.onResume();
		changedt= (Button)findViewById(R.id.changedate);
		tvdate= (TextView) findViewById(R.id.textView4);
		Savetask= (Button) findViewById(R.id.savetask);
		et= (EditText) findViewById(R.id.editText1);
		setcurrentdate();
		changedt.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				showDialog(DATE_DIALOG_ID);
			}
		});
		
		Savetask.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				DBHandler dbHandler = new DBHandler(AddTasks.this, null, null, 1);
				Task tsk = new Task(et.getText().toString(), day, month, year);
				dbHandler.addTask(tsk);
				Toast.makeText(AddTasks.this,"Task Succesfully Saved!", Toast.LENGTH_LONG).show();
			}
		});
	}
	
	@Override
	public Dialog onCreateDialog(int id)
	{
		switch(id)
		{
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, datePickerListener, year, month, day);
		}
		return null;
	}
	
	public DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener()
	{
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay)
		{
			year=selectedYear;
			month=selectedMonth;
			day=selectedDay;
			tvdate.setText(new StringBuilder().append(day)
					   .append("-").append(month +1).append("-").append(year)
					   .append(" "));
		}
	};
	
	
	public void setcurrentdate()
	{
		final Calendar c= Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
		tvdate.setText(new StringBuilder()
		.append(day).append("-").append(month +1).append("-")
		.append(year).append(" "));
	}
	
	
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_tasks, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

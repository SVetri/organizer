package com.example.organizer;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHandler extends SQLiteOpenHelper 
{
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "taskDB.db";
	private static final String TABLE_TASKS = "tasks";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_TASKDESCRIPTION = "taskdescription";
	public static final String COLUMN_DAY = "day";
	public static final String COLUMN_MONTH = "month";
	public static final String COLUMN_YEAR = "year";
	
	public DBHandler(Context context, String name,CursorFactory factory, int version) 
	{
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		String CREATE_TASKS_TABLE = "CREATE TABLE "+ TABLE_TASKS + "("
	             + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TASKDESCRIPTION 
	             + " TEXT," + COLUMN_DAY + " INTEGER," + COLUMN_MONTH + " INTEGER," + COLUMN_YEAR + " INTEGER" + ")";
	      db.execSQL(CREATE_TASKS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) 
	{
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
	    onCreate(db);
	}
	
	public void addTask(Task t) 
	{
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASKDESCRIPTION, t.gettaskdescription());
        values.put(COLUMN_DAY, t.getday());
        values.put(COLUMN_MONTH, t.getmonth());
        values.put(COLUMN_YEAR, t.getyear());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_TASKS, null, values);
        db.close();
	}
	
	public ArrayList<Task> gettasks()
	{
		String query = "Select * FROM " + TABLE_TASKS;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		Task t= new Task();
		ArrayList<Task>tsks= new ArrayList<Task>();
		if(cursor.getCount()==0)
		{
			t=null;
			tsks=null;
		}

		else
		{
			cursor.moveToFirst();	
			while(cursor.moveToNext()) 
			{
				t.settaskdescription(cursor.getString(1));
				t.setday(Integer.parseInt(cursor.getString(2)));
				t.setmonth(Integer.parseInt(cursor.getString(3)));
				t.setyear(Integer.parseInt(cursor.getString(4)));
				tsks.add(t);
			}
		}
		cursor.close();
		db.close();
		return tsks;
	}
}

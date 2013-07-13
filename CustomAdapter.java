package com.example.organizer;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	 private ArrayList<Task> _data;
	    Context _c;
	    
	    CustomAdapter (ArrayList<Task> data, Context c){
	        _data = data;
	        _c = c;
	    }
	
	
	@Override
	public int getCount() 
	{	
		 return _data.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return _data.get(position);
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View v = convertView;
        if (v == null)
        {
           LayoutInflater vi = (LayoutInflater)_c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           v = vi.inflate(R.layout.taskrowlayout, null);
        }
        
        TextView taskdesc= (TextView)v.findViewById(R.id.taskname);
        TextView taskdate= (TextView)v.findViewById(R.id.taskdate);
        
        Task t= _data.get(position);
        taskdesc.setText(t.gettaskdescription());
        taskdate.setText("To Be Done By: " + t.getday() + "/" + t.getmonth() + "/" + t.getyear());
        return v;
	}

}

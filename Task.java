package com.example.organizer;

public class Task 
{
	private String taskdescription;
	private int id;
	private int day;
	private int month;
	private int year;
	
	public Task(String s, int d,int m, int y)
	{
		this.taskdescription = s;
		this.day=d;
		this.month=m;
		this.year=y;
	}
	
	public Task()
	{
		
	}
	
	public String gettaskdescription()
	{
		return this.taskdescription;
	}
	
	public int getday()
	{
		return this.day;
	}
	
	public int getmonth()
	{
		return this.month;
	}
	
	public int getyear()
	{
		return this.year;
	}
	
	public int getid()
	{
		return this.id;
	}
	
	public void settaskdescription(String s)
	{
		this.taskdescription=s;
	}
	
	public void setday(int d)
	{
		this.day = d;
	}
	
	public void setmonth(int m)
	{
		this.month = m;
	}
	
	public void setyear(int y)
	{
		this.year=y;
	}
	
	public void setid(int i)
	{
		this.id=i;
	}
}

package com.gmail.s.birchyboy.V6.Engine;

import java.util.ArrayList;

/**
 * @author Birch
 * @deprecated
 * */
public class InstanceTracker{
	private ArrayList<Object> instances;
	
	public InstanceTracker(){
		instances = new ArrayList<Object>();
	}
	public InstanceTracker(Object o){
		instances = new ArrayList<Object>();
		instances.add(o);
		//instances.add(new WeakReference<Object>(o));
	}
	
	public boolean find(Object o){
		if(instances.contains(o)){
			return true;
		}else{
			return false;
		}
	}
	
	public final void add(Object o){
		instances.add(o);
	}
	
	public final void remove(Object o){
		instances.remove(o);
	}
	
	public final ArrayList<Object> getAll(){
		return instances;
	}
	public Object find(int index){
		return instances.get(index);
	}
}

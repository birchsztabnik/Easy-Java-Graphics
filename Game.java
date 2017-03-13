package com.gmail.s.birchyboy.V6.Engine;

import java.util.ArrayList;

import com.gmail.s.birchyboy.V6.Entities.Entity;
import com.gmail.s.birchyboy.V6.Entities.Player;
import com.gmail.s.birchyboy.V6.Particles.Emitter;

/**
 * @author Birch
 * */
public class Game{
	private ArrayList<Entity> objectList;
	private ArrayList<Emitter> emitterList;
	private ArrayList<Entity> toDelete;
	private ArrayList<Emitter> toDeleteEmitter;
	private Player player;
	
	public Game(){
		objectList = new ArrayList<Entity>();
		toDelete = new ArrayList<Entity>();
		
		player = new Player();
		objectList.add(player);
	}
	
	public final void getInput(){
		player.getInput();
	}
	
	public final void update(){
		for(Entity e : objectList){
			if(e.canDelete())
				toDelete.add(e);
			else
				e.update();
		}
		for(Emitter em : emitterList){
			if(em.canDelete())
				toDeleteEmitter.add(em);
			else
				em.render();
		}
		
		for(Entity e : toDelete){
			objectList.remove(e);
			e = null;
		}
		for(Emitter em : toDeleteEmitter){
			emitterList.remove(em);
			em = null;
		}
		
		toDeleteEmitter.clear();
		toDelete.clear();
	}
	
	public final void render(){
		for(Entity e : objectList)
			e.render();
		for(Emitter em : emitterList)
			em.render();
	}
}

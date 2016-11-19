package com.cjburkey.platreform.core;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import com.cjburkey.platreform.PlatReform;
import com.cjburkey.platreform.Util;
import javafx.concurrent.Task;

public class GameLoop {
	
	private boolean running = false;
	private boolean first = true;

	public static final long nansPerSec = 1000000000;
	public static final int TPS = 120;
	
	private static int FPS;
	private static long nansPerTick;
	private static long nansPerFrame;
	
	private Thread thread;
	private Task<Void> task;
	
	public void firstStart() {
		running = true;
		init();
	}
	
	public void start() {
		if(first) firstStart();
		first = false;
		
		thread.start();
	}
	
	public void stop() {
		running = false;
	}
	
	private int i = 0;
	private void setFPSCap() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		FPS = gs[i].getDisplayMode().getRefreshRate();
		if(FPS == DisplayMode.REFRESH_RATE_UNKNOWN || FPS == 0) {
			Util.log("Monitor refresh rate unknown...");
			i ++;
			if(gs.length > i) {
				Util.log("Searching again.");
				setFPSCap();
				return;
			} else {
				Util.log("Defaulting to 60...");
				FPS = 60;
			}
		} else {
			Util.log("Got refresh rate: " + FPS);
		}
		Util.log("FPS cap to: " + FPS);
	}
	
	private void init() {
		setFPSCap();
		
		nansPerTick = nansPerSec / TPS;
		nansPerFrame = nansPerSec / FPS;
		
		task = new Task<Void>() {
			public Void call() {
				Util.defError();
				loop();
				return null;
			}
		};
		thread = new Thread(task);
	}
	
	private void loop() {
		while(running) {
			tickCalc();
			frameCalc();
		}
	}
	
	private long tickLastTime = Util.now();
	private long tickLastTick = Util.now();
	private long lastSec = Util.now();
	private int ticks = 0;
	private void tickCalc() {
		long tickDiff = tickLastTime - tickLastTick;
		long secDiff = tickLastTime - lastSec;
		
		if(tickDiff >= nansPerTick) {
			tick();
			ticks ++;
			tickLastTick = Util.now();
		}
		
		if(secDiff >= nansPerSec) {
			perSec();
			Util.log("TPS: " + ticks + ", FPS: " + frames);
			ticks = 0;
			frames = 0;
			lastSec = Util.now();
		}
		
		tickLastTime = Util.now();
	}
	
	private void tick() {
		PlatReform.getGame().tick();
	}
	
	private long frameLastTime = Util.now();
	private long frameLastFrame = Util.now();
	private int frames = 0;
	private void frameCalc() {
		long frameDiff = frameLastTime - frameLastFrame;
		
		if(frameDiff >= nansPerFrame) {
			render();
			frames ++;
			frameLastFrame = Util.now();
		}
		
		frameLastTime = Util.now();
	}
	
	private void render() {
		PlatReform.getGame().render();
	}
	
	private void perSec() {
		PlatReform.getGame().perSecond();
	}
	
	public boolean isRunning() { return running; }
	public boolean hasRun() { return !first; }
	
}
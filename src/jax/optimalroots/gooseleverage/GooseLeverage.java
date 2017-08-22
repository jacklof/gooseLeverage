package jax.optimalroots.gooseleverage;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import jax.optimalroots.gooseleverage.gfx.GfxManager;

@SuppressWarnings("serial")
public final class GooseLeverage extends Canvas {

	public static GooseLeverage instance;
	
	public GfxManager gfx; // TODO
	public InputManager input; // TODO
	public boolean isRunning;
	
	private BufferedImage image;
	private JFrame frame;
	private int lastTickCount, lastFrameCount;
	private int[] displayPixelArray;
	private boolean isDebug;
	
	public static void main(String[] args) {
		instance = new GooseLeverage("GOOSE LEVERAGE", 240, 160, 4);
		instance.run(60, 20);
	}
	
	public GooseLeverage(String title, int width, int height, int scale) {
		setPreferredSize(new Dimension(width * scale, height * scale));
		gfx = new GfxManager(width, height);
		input = new InputManager();
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		frame = new JFrame(title);
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		displayPixelArray = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		isRunning = true;
		requestFocus();
	}
	
	private void tick() {
		// TODO
	}
	
	private void draw() {
		// TODO
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) { createBufferStrategy(3); return; }
		
		draw();
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	private void run(int targetTps, int targetFps) {
		long initialTime = System.nanoTime();
		final double timeU = 1000000000 / targetTps;
		final double timeF = 1000000000 / targetFps;
		double deltaU = 0, deltaF = 0;
		int ticks = 0, frames = 0;
		long timer = System.currentTimeMillis();
		
		while (isRunning) {
			long currentTime = System.nanoTime();
			deltaU += (currentTime - initialTime) / timeU;
			deltaF += (currentTime - initialTime) / timeF;
			initialTime = currentTime;
			
			if (deltaU >= 1) {
				tick();
				ticks++;
				deltaU--;
			}
			
			if (deltaF >= 1) {
				render();
				frames++;
				deltaF--;
			}
			
			if (System.currentTimeMillis() - timer > 1000) {
				System.out.println(String.format("TpS: %s, Fps: %s", ticks, frames));
				ticks = 0;
				frames = 0;
				timer += 1000;
			}
		}
	}
	
}

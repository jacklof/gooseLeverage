package jax.optimalroots.gooseleverage;

import java.awt.Canvas;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

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
		instance = new GooseLeverage('GOOSE LEVERAGE', 240, 160, 4);
		instance.run(60, 20);
	}
	
	public GooseLeverage(String title, int width, int height, int scale) {
		setPreferredSize(new Dimensions(width * scale, height * scale));
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
		
	}
	
	private void draw() {
		
	}
	
	private void render() {
		
	}
	
}

package jax.optimalroots.gooseleverage.gfx;

public final class GfxManager {

	public int width, height;
	public int[] pixelArray;

	public GfxManager(int width, int height) {
		this.width = width;
		this.height = height;
		pixelArray = new int[width * height];
	}

	public void clear(int color) {
		for (int i = 0; i < pixelArray.length; i++) {
	    		pixelArray[i] = color;
		}
	}
	
}

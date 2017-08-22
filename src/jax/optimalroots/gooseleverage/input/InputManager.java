package jax.optimalroots.gooseleverage.input;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.util.Map;

public final class InputManager implements KeyListener, MouseListener, MouseWheelListener {

	private Map<String, Boolean> buttons;
	
	public InputManager() {
		buttons = new HashMap<String, Boolean>();
		buttons.put("mouseLeft", false);
		buttons.put("mouseMiddle", false);
		buttons.put("mouseRight", false);
	}
	
}

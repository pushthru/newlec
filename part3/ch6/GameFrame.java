package part3.ch6;

import java.awt.Frame;
import java.awt.Graphics;

public class GameFrame extends Frame{

	@Override
	public void paint(Graphics g) {
		g.drawLine(20, 200, 20, 10);
	}
	
}

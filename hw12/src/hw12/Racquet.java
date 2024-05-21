package hw12;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Racquet extends JPanel
{
    int x = 0;
    int xa = 0;
    int step = 10;
    private static final int y = 570; // 新增三個球拍屬性的final變數,因為已經確定下來了不會再改
    private static final int WIDTH = 120;
    private static final int HEIGHT = 30;

    private Window window;

    public Racquet(Window w) { // 建構子
        this.window = w;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

	public void KeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) //往左移動 
			xa = -step;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) //往右移動 
			xa = step;
	}

	public void KeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		xa = 0;
	}
	public void moveRacquet() {
		if (x + xa < window.getWidth() - 120 && x + xa > 0) //移動座標 小於右邊邊界且大於左邊邊界 
			x += xa;
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		// TODO Auto-generated method stub
		return y;
	}
}
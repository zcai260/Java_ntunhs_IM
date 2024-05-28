package hw12;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Ball extends JPanel 
{
    private static final int ballsize = 60;
    int x = 0; // 小球的預設位置
    int y = 0;
    int step = 10;
    int incx = step; // 這是小球要移動的單位
    int incy = step;
    private Window window;

    public Ball(Window w) { // 建構子
        this.window = w;
    }

    public static int getBallsize() {
    	return ballsize;
    }
    
    void moveBall() // 這個方法就是不斷更新小球的位置
    {
    	if (collision())
    	{
	    	incy = -16; //改變y軸的移動方向 
	    	y = window.racquet.getTopY() - ballsize; // 正球的位置,為了防止級導致的舊球和小球,,計分會增加! 
	    	window.score++;
    	}
    	
    	if (x + incx > window.getWidth() - ballsize) // 如果小球移動後的位置超出視窗範圍的話,移動方向就是-1; 再扣掉球的大小
            incx = -step;
        if (x + incx < 0) // 同理
            incx = step;
        if (y + incy > window.getHeight() - ballsize)
            incy = -step;
        if (y + incy < 0)
            incy = step;

        x += incx;
        y += incy;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.darkGray); //設定顏色
        g.fillOval(x, y, ballsize, ballsize); //(x軸, y軸, 球的寬度, 球的高度)
    }
    public Rectangle getbounds() // Rectangle
    {
    	return new Rectangle( x, y, ballsize, ballsize);
    }
    
    private boolean collision()
    {
    	return window.racquet.getBounds().intersects(getbounds()); // 用intersects方法判斷小球是否和球拍相交 
    }
}




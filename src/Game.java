
/**
 * Description	:Engine for the brick game
 * Copyright	:Copyright (c) 2014
 * Company		:Embla Software Innovations (Pvt) Ltd
 * Created on	:2014.09.01
 * @author 		:Chandimal
 * @version 	:1.0
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements KeyListener {

	private static final long serialVersionUID = 1L;

	BufferedImage buffer; // Create the buffer
	Ball ball;
	Bat bat;
	boolean isLeft;
	boolean isRight;
	/**
	 * Create the game using the width and the height specified
	 */
	public Game(Dimension dim) {
		buffer = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_RGB);
		this.setIgnoreRepaint(true); // Ignore repainting as we are doing all
		ball = new Ball(dim.width , dim.height, 0, 0, 15, 15, 1);
		bat = new Bat(dim.width , dim.height, (dim.width -100)/2, 500, 100, 10, 1);
	}

	public void detectCollision() {
		Rectangle rectBall =  new Rectangle(ball.getX(), ball.getY(), ball.getW(),ball.getH());
		Rectangle rectBat =  new Rectangle(bat.getX(), bat.getY(), bat.getW(),bat.getH());
		
		if(rectBall.intersects(rectBat)) {
			ball.reverse();
		}
	}
	/**
	 * Start the game
	 */
	public void Start() {

		while (true) {
			ball.update();
			bat.update();
			// Draw the buffer
			
			detectCollision();
			
			if(this.isLeft) bat.setLeft();
			if(this.isRight) bat.setRight();
			drawBuffer();
			// Paint the buffer on screen
			drawScreen();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Draw the image buffer
	 */
	public void drawBuffer() {
		Graphics2D b = buffer.createGraphics();

		// Black color background
		b.setColor(Color.BLACK);
		b.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
		b.setColor(Color.WHITE);
		b.fillOval(ball.getX(), ball.getY(), ball.getW(), ball.getH());
		b.fillRect(bat.getX(), bat.getY(), bat.getW(), bat.getH());
	}
	


	/**
	 * Update it to the screen
	 */
	public void drawScreen() {
		Graphics2D g = (Graphics2D) this.getGraphics();
		g.drawImage(buffer, 0, 0, this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() ==KeyEvent.VK_LEFT ) {
			this.isLeft = true;
		}
		
		if(e.getKeyCode() ==KeyEvent.VK_RIGHT) {
			this.isRight = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() ==37 ) {
			this.isLeft = false;
		}
		
		if(e.getKeyCode() ==39 ) {
			this.isRight = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}

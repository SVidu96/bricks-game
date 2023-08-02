
public class Ball {

	private int x;
	private int y;
	private int gameW;
	private int gameH;
	private int w;
	private int h;
	private int speed;
	
	private int dy;
	private int dx;

	public Ball(int gameW, int gameH, int startX, int startY, int w, int h, int speed) {
		super();
		this.x = startX;
		this.y = startY;
		this.gameW = gameW;
		this.gameH = gameH;
		this.w = w;
		this.h = h;
		this.speed = speed;
		dx = dy = speed;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void update() {
		if(x + dx + w  > gameW || x + dx < 0) 
			dx = -dx;
		if(y + dy + h > gameH || y + dy < 0)
			dy = -dy;
		
		x +=dx;
		y +=dy;
	}
	
	public void reverse() {
		this.dy= -this.speed;
	}
}

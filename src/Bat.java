
public class Bat {
	private int x;
	private int y;
	private int gameW;
	private int gameH;
	private int w;
	private int h;
	private int speed;
	
	private int dx;
	private int dy;

	public Bat(int gameW, int gameH, int startX, int startY, int w, int h, int speed) {
		super();
		this.x = startX;
		this.y = startY;
		this.gameW = gameW;
		this.gameH = gameH;
		this.w = w;
		this.h = h;
		this.speed = speed;
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
		this.x = this.x + this.dx;
		if(this.x<=0) {
			this.x=0;
		}
		if(this.x>=this.gameW - this.w) {
			this.x=this.gameW - this.w;
		}
		
		this.dx=0;
	}
	
	public void setLeft() {
		this.dx= -1;
	}
	
	public void setRight() {
		this.dx=+1;
	}

}

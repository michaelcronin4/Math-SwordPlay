package FirstAttempt;

import java.awt.Image;
import java.awt.Toolkit;

public class BadGuy {

	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 30;
	private int height = 30;
	private Image img;
	

	
	public BadGuy() {
		
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("myfiles/swordfighter.png");
		}

	
	
	
	

public BadGuy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
		
	}

	/*public void moveSide(int direction, int w, int h) {
		int speed= 20;
		int x = getxCoord();
		int y =getyCoord();
		if (direction == 39) {
			x = x+speed;
			if (x>450) {x = x - speed * 3;}
			setxCoord(x);
			setyCoord(115);
			setImg("myfiles/swordfighter1.png");
			setWidth(240);
			setHeight(240);
		}else if (direction == 37) {
			x = x - speed;
			if (x<-15) {x = x + speed * 3;}
			setxCoord(x);
			setyCoord(150);
			setImg("myfiles/swordfighter.png");
			setWidth(175);
			setHeight(175);
		} else if(direction == 40) {
			y = y + speed;
			if (y<0) {y = y + speed * 3;}
			setyCoord(y);
			setImg("myfiles/swordfighter.png");
			setWidth(175);
			setHeight(175);
		} else if(direction == 38) {
			y = y - speed;
			if (y>h+200) {y = y - speed * 3;}
			setyCoord(y);
			setImg("myfiles/swordfighter.png");
			setWidth(175);
			setHeight(175);
			
		}  
			
	}*/

public Image getImg() {
		return img;
	}


	public void setImg(Image img) {
		this.img = img;
	}


public int getxCoord() {
	return xCoord;
}


public void setxCoord(int xCoord) {
	this.xCoord = xCoord;
}


public int getyCoord() {
	return yCoord;
}


public void setyCoord(int yCoord) {
	this.yCoord = yCoord;
}


public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}


public int getHeight() {
	return height;
}


public void setHeight(int height) {
	this.height = height;
}

public void setImg(String imgpath) {
	this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
}

public Image getImg1() {
	return img;
}







}

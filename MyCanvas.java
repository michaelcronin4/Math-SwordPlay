package FirstAttempt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;

import sun.audio.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
//import java.util.Random;
import java.util.LinkedList;
import java.util.Random;
import java.awt.Rectangle;
//import java.util.Scanner;

//import javax.swing.JTextField;




 


public class MyCanvas extends Canvas implements KeyListener{
	
	
	GoodGuy mii = new GoodGuy(50,150,175,175,"myfiles/swordfighter.png");
	LinkedList badguys = new LinkedList();
	Image background = Toolkit.getDefaultToolkit().createImage("myfiles/background.jpg");
	Image start = Toolkit.getDefaultToolkit().createImage("myfiles/SpaceToStart.png");
	boolean menu = true;
	int score = 0;
	boolean gameover = false;
	Image celebration = Toolkit.getDefaultToolkit().createImage("myfiles/Celebration.gif");
	static int num1 = 0 + (int)(Math.random() * (13-1) + 1);
	static int num2 = 0 + (int)(Math.random() * (13-1) + 1);
	boolean question = false;
	boolean correct = false;
	boolean questionshown = false;
	int product = num1 * num2;
	boolean spawnedhero = false;
	int option1 = 0 + (int)(Math.random() * (144-1) + 1);
	int option2 = 0 + (int)(Math.random() * (144-1) + 1);
	int option3 = 0 + (int)(Math.random() * (144-1) + 1);
	boolean moving = true;
	int[] options = new int[5];
	boolean firstset = true;
	int firstoption = 0 + (int)(Math.random() * (144-1) + 1);
	int lives = 3;
	Image life = Toolkit.getDefaultToolkit().createImage("myfiles/Life.png");
	Image BADGUY = Toolkit.getDefaultToolkit().createImage("myfiles/badmii.png");
	boolean IsEmpty = false;
	boolean hardmode = false;
	LinkedList wronganswers = new LinkedList();
	boolean keypressed = false;
	
		public MyCanvas () {
			this.setSize(600, 400);
			this.addKeyListener(this);
			System.out.println("Number #1 is " + num1 +". Number #2 is " + num2);
			
		
			//Random rand = new Random();
			//int winwidth = this.getWidth()-50;
			for(int i = 0; i<1; i++) {
				//BadGuy bg = new BadGuy(rand.nextInt(winwidth), 115, 225, 225, "myfiles/badmii.png");
				BadGuy bg = new BadGuy(150 + (int)(Math.random() * (400-150) + 1), 115, 225, 225, "myfiles/badmii.png");
				Rectangle r = new Rectangle(100, 100, 30, 30);
				if (r.contains(50, 150)) {
					System.out.println("Badguy Spawned On Hero");
					badguys.remove(i);
					spawnedhero = true;
					i = i - 1;
					
				} else {
			badguys.add(bg);
				}
			}
		} 
		
		public void playIt(String filename) {
			
			try {
				InputStream in = new FileInputStream(filename);
				AudioStream as = new AudioStream(in);
				AudioPlayer.player.start(as);		
			} catch (IOException e) {
				System.out.println(e);
			}
		}	
		
	public void paint (Graphics g) {
		Font font = new Font("Bangers", Font.BOLD, 14);
		g.setFont(font);
		g.setColor(Color.BLACK);
		
		g.drawImage(background,0, 0, 600, 380, this);
		
		if (gameover) {
			
			//playIt("myfiles/Cheering.wav");
			g.drawString("Your Incorrect Answers were " + wronganswers.get(0).toString() + ", ", 120, 260);
			g.drawString(wronganswers.get(1).toString() + ", and ", 390, 260);
			g.drawString(wronganswers.get(2).toString() + ".", 480, 260);
			
			if (!hardmode) {
			g.drawString("Congrats! Your Score is " + score, 180, 200);
			} else {
			
			
				g.drawString("Congrats! Your Score is " + score + " on Hard Mode!", 160, 200);
			}
			g.drawImage(celebration, 0, 0, 600, 400, this);
			
			
			
		} else {
		
		if (menu) {
			g.drawImage(start, 60, 140, 480, 120, this);
			g.drawString("Press Enter for Hard Mode", 210, 300);
		} else { 
			
			if (lives == 3) {
				g.drawImage(life, 20, 20, 30, 30, this);
				g.drawImage(life, 50, 20, 30, 30, this);
				g.drawImage(life, 80, 20, 30, 30, this);
			} else if (lives == 2) {
				g.drawImage(life, 20, 20, 30, 30, this);
				g.drawImage(life, 50, 20, 30, 30, this);
			} else if (lives == 1) {
				g.drawImage(life, 20, 20, 30, 30, this);
			}
			g.drawImage(mii.getImg1(), mii.getxCoord(),mii.getyCoord(), mii.getHeight(), mii.getWidth(),this);
			if (correct) {
				int newxcoord = 50;
				mii.setxCoord(newxcoord);
				g.drawImage(mii.getImg1(), mii.getxCoord(),mii.getyCoord(), mii.getHeight(), mii.getWidth(),this);
			}
		
			if (badguys.isEmpty()) {
				BadGuy bg = new BadGuy(150 + (int)(Math.random() * (400-150) + 1), 115, 225, 225, "myfiles/badmii.png");
				badguys.add(bg);
				g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getHeight(), bg.getWidth(), this);
				
			}
		for(int i = 0; i < badguys.size(); i++) {
			
			BadGuy bg = (BadGuy) badguys.get(i);
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getHeight(), bg.getWidth(), this);
			}
		} 
		g.drawString("Score " + score, 500, 30);
		
		if (!moving) {
			
			Random rand = new Random();
			int op1 = rand.nextInt(3) + 1;
			int op2 = rand.nextInt(3) + 1;
			if (op2 == op1) {
				while (op2 == op1) {
					op2 = rand.nextInt(3) + 1;
				}
			}
			int op3 = rand.nextInt(3) + 1;
			if (op3 == op2 || op3 == op1) {
				while (op3 == op2 || op3 == op1) {
					op3 = rand.nextInt(3) + 1;
				}
			}
			int op4 = rand.nextInt(3) + 1;
			if (op4 == op3 || op4 == op2 || op4 == op1) {
				while (op3 == op2 || op3 == op1 || op4 == op1) {
					op4 = rand.nextInt(3) + 1;
				}
				
			}
			
			
			if (!moving && firstset) {
				if (hardmode) {
					option1 = 0 + (int)(Math.random() * (2500-1) + 1);
					option2 = 0 + (int)(Math.random() * (2500-1) + 1);
					option3 = 0 + (int)(Math.random() * (2500-1) + 1);
				} else {
					option1 = 0 + (int)(Math.random() * (144-1) + 1);
					option2 = 0 + (int)(Math.random() * (144-1) + 1);
					option3 = 0 + (int)(Math.random() * (144-1) + 1);
				}
				
				product = num1 * num2;
			options[op1] = option1;
			options[op2] = option2;
			options[op3] = option3;
			options[op4] = product;
			moving = false;
			firstset = false;
			}
			
			if (!moving) {
			g.drawString("What is " + num1 + " times " + num2 + "?", 200, 20);
			g.drawString("Press the corresponding number of the correct answer", 130, 50);
			g.drawString("1. " + (options[0]+ (firstoption)), 200, 80);
			g.drawString("2. " + options[1], 200, 100);
			g.drawString("3. " + options[2], 200, 120);
			g.drawString("4. " + options[3], 200, 140);
			//g.drawString("5. " + options[4], 200, 160);
			
			product = num1 * num2;
			questionshown = true;
			moving = false;
			
			}
			
			
		}
		} 
		

	}
		
		
		
		public void keyPressed(KeyEvent e) {
			System.out.println(e);
			System.out.println(question);
			if (!questionshown && !menu && moving) {
				
			
				mii.moveSide(e.getKeyCode(), this.getWidth(), this.getHeight());
				
			} 
			
			
			for(int i = 0; i< badguys.size(); i++) {
				BadGuy bg = (BadGuy) badguys.get(i);
				Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
				if (r.contains(mii.getxCoord()+100, mii.getyCoord())) {
					question = true;
					repaint();
					if (moving) {
					playIt("myfiles/crowdoh.wav");
					question = true;
					questionshown = true;
					repaint();
					moving = false;
					}
					
					
			
					int product = num1 * num2;
					if (!moving) {
					
					if (e.getKeyCode() == 50 || e.getKeyCode() == 51 || e.getKeyCode() == 52 || e.getKeyCode() == 49) {
					keypressed = true;
					if (e.getKeyCode() == 50 && options[1] == product) {
						System.out.println("Correct!");
						correct = true;
					} else if (e.getKeyCode() == 51 && options[2] == product ) {
						System.out.println("Correct!");
						correct = true;
					} else if (e.getKeyCode() == 52 && options[3] == product ) {
						System.out.println("Correct!");
						correct = true;
					} else {
						correct = false;
						System.out.println("Your Answer is Incorrect");
						
					}
						System.out.println(correct);
						repaint();
					}
						
					}
					//JTextField input = new JTextField();
					
					//if (MyScreen.isEqualTo(input, product) == true) {
						
					//	String answer = input.getText();
						//correct = true;
						//System.out.println(answer);
					//s} 
					
					
					
					if (correct && !moving) {
					
					 
					System.out.println("Mii Eliminates Opponent");
					badguys.remove(i);
					score = score + 10;
					spawnedhero = false;
					correct = false;
					question = false;
					questionshown = false;
					moving = true;
					firstset = true;
					playIt("myfiles/Cheering.wav");
					mii.setxCoord(50);
					mii.setImg("myfiles/swordfighter.png");
					mii.setHeight(175);
					mii.setWidth(175);
					mii.setyCoord(150);
					keypressed = false;
					if (!hardmode) {
					num1 = 0 + (int)(Math.random() * (13-1) + 1);
					num2 = 0 + (int)(Math.random() * (13-1) + 1);
					product = num1 * num2;
					
					} else {
						num1 = 0 + (int)(Math.random() * (50-1) + 1);
						num2 = 0 + (int)(Math.random() * (50-1) + 1);
						product = num1 * num2;
					}
					
					repaint();
				
					
					} else if (!moving && !correct && keypressed) {
						
						if (!firstset && !gameover) {
						playIt("myfiles/crowdaw.wav");
						System.out.println("The Answer is Incorrect");
						correct = false;
						question = false;
						questionshown = false;
						score = score -5;
						lives = lives -1;
						wronganswers.add(num1 + " x " + num2);
						keypressed = false;
						}
						
						
					}
					
					
					if (lives == 0) {
						gameover = true;
					}
				
					
				} 
					
			} 
			
			if (e.getKeyCode() == 32 && menu == true) {
				menu = false;
				playIt("myfiles/wiisports.wav");
				playIt("myfiles/HereWeGo.wav");
				System.out.println("Game Started");
				score = 0;
			} else if (e.getKeyCode() == 10 && menu == true) {
				menu = false;
				playIt("myfiles/wiisports.wav");
				playIt("myfiles/HereWeGo.wav");
				System.out.println("Hard Mode Started");
				score = 0;
				num1 = 0 + (int)(Math.random() * (50-1) + 1);
				num2 = 0 + (int)(Math.random() * (50-1) + 1);
				option1 = 0 + (int)(Math.random() * (2500-1) + 1);
				option2 = 0 + (int)(Math.random() * (2500-1) + 1);
				option3 = 0 + (int)(Math.random() * (2500-1) + 1);
				firstoption = 0 + (int)(Math.random() * (2500-1) + 1);
				hardmode = true;
			}
			
			
			
			repaint();
			}
		
		
public void keyTyped(KeyEvent e) {
			
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			
			
		}
		
		
}
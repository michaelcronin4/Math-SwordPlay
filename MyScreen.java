package FirstAttempt;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

	public class MyScreen extends JFrame {
		/**
		 * 
		 */
		public MyScreen() {
			
			
			this.setSize(600,400);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
		}
		
		public static void main(String[]args) throws Exception {
				MyScreen screen = new MyScreen();
				MyCanvas canvas = new MyCanvas();
				screen.getContentPane().add(canvas);
				
		}
	}
				
				
				
				/*JTextField input = new JTextField();
				screen.add(input, BorderLayout.NORTH);
				
				
			
				
				
				
				
				KeyListener keylistener = new KeyListener() {

					@Override
					public void keyTyped(KeyEvent e) {
						printIt("Typed", e);
						
					}

					@Override
					public void keyPressed(KeyEvent e) {
						printIt("Pressed", e);
						
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						printIt("Released", e);
						
					}
					
				public void printIt(String title, KeyEvent e) {
					int keyCode = e.getKeyCode();
					String keyText = e.getKeyText(keyCode);
					System.out.println(title + " : " + keyText + " / " + e.getKeyChar());
					
					
				}
				
				
		};
		
		//String answer = input.getText();
		
		
		input.addKeyListener(keylistener);
		
		screen.setSize(600, 428);
		screen.setVisible(true);
		//public static String answer = input.getText();
		}
			static int product = MyCanvas.num1 + MyCanvas.num2;
			//static JTextField d = new JTextField();
			
			
		public static boolean isEqualTo(JTextField input, int product) {
			String answer = input.getText();
			System.out.println("answer");
			if (answer.equals(product)) {
				return true;
			} else {
				return false;
			}
		}
		 
		
	
		

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}	
	
	}
				*/
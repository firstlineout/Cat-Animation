import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CatFrame2 extends JFrame {	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Timer t;
	private CatComponent cat1;
	private JPanel panel;
	//private String title;

	int frameWidth = screenSize.width;
	int frameHeight = screenSize.height;
	// int frameWidth = 800;
	// int frameHeight = 600;
	
	KeyListener k = new KeyAdapter(){
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
				System.exit(0);
			}
		}
	};	
	
	class TimerListener implements ActionListener {		
		public void actionPerformed(ActionEvent event) {
			if (cat1.dir == 1) cat1.moveCatNE();
			if (cat1.dir == 2) cat1.moveCatSE();
			if (cat1.dir == 3) cat1.moveCatNW();
			if (cat1.dir == 4) cat1.moveCatSW();

			if (cat1.getYPosUP()<0 && cat1.dir == 1) {
				cat1.dir = 2;
				cat1.moveCatSE();
				cat1.changeBG();
			}
			
			if (cat1.getYPosUP()<0 && cat1.dir == 3) {
				cat1.dir = 4;
				cat1.moveCatSW();
				cat1.changeBG();
			}

			if (cat1.getXPosRIGHT()>frameWidth && cat1.dir == 2){
				cat1.dir = 4;
				cat1.moveCatSW();
				cat1.changeBG();
			}

			if (cat1.getXPosRIGHT()>frameWidth && cat1.dir == 1){
				cat1.dir = 3;
				cat1.moveCatNW();
				cat1.changeBG();
			}

			if (cat1.getYPosDOWN()>frameHeight && cat1.dir == 4) {
				cat1.dir = 3;
				cat1.moveCatNW();
				cat1.changeBG();
			}
			
			if (cat1.getYPosDOWN()>frameHeight && cat1.dir == 2) {
				cat1.dir = 1;
				cat1.moveCatNE();
				cat1.changeBG();
			}

			if (cat1.getXPosLEFT()<0 && cat1.dir == 3){
				cat1.dir = 1;
				cat1.moveCatNE();
				cat1.changeBG();
			}

			if (cat1.getXPosLEFT()<0 && cat1.dir == 4){
				cat1.dir = 2;
				cat1.moveCatSE();
				cat1.changeBG();
			}		
		}
	}
	
	public CatFrame2() {		
		cat1 = new CatComponent(300, 200, frameWidth, frameWidth);
		createPanel();
		//this.getContentPane().setPreferredSize(new Dimension (800, 600));
		this.addKeyListener(k);
		ActionListener listener = new TimerListener();	
		final int DELAY = 1;
		t = new Timer(DELAY, listener);
		t.restart();		
		System.out.println("Hi, Joel");
	}
	
	public void createPanel() {	
		panel = new JPanel();		
		panel.setLayout(new GridLayout(1, 1));
		panel.add(cat1);
		add(panel);
	}
}

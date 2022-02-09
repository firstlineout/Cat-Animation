import java.awt.*;
import javax.swing.*;

public class CatComponent extends JComponent {	
	int xO;
	int yO;
	int dir;
	int xLeftEar[];
	int yLeftEar[];
	int xRightEar[];
	int yRightEar[];
	int xNose[];
	int yNose[];
	int eyesLR;
	int eyesUD;
	int Pr;
	int Pg;
	int Pb;
	int xFace[];
	int yFace[];
	int height;
	int width;
	Color Plaid;
	boolean blink;

	public CatComponent(int x, int y, int w, int h) {		
		width = w;
		height = h;
		xO = x;
		yO = y;
		dir = 1;
		eyesLR = 8;
		eyesUD = 0;
		Pr = 0;
		Pg = 0;
		Pb = 0;
		blink = false;		
	}
	
	public void paintComponent(Graphics g) {

		//Relative coordinates used to make draw shapes
		xLeftEar = new int[] {xO, xO, xO+10, xO+14};
		yLeftEar = new int[] {yO, yO+30, yO+30, yO+24};
		xRightEar = new int[] {xO+80, xO+80, xO+70, xO+66};
		yRightEar = new int[] {yO, yO+30, yO+30, yO+24};
		xFace = new int[] {xO, xO, xO+80, xO+80, xO+48, xO+32};
		yFace = new int[] {yO, yO+50, yO+50, yO, yO+24, yO+24};
		xNose = new int[] {xO+34, xO+40, xO+41, xO+46};
		yNose = new int[] {yO+56, yO+63, yO+63, yO+56};
		
		//Background
		Plaid = new Color(Pr, Pg, Pb, 100);
		g.setColor(Plaid);
		for (int i = 8; i<width; i = i+82){
			g.fillRect(0 + i, 0, 41, height);
		}		
		for (int j = 5; j<height; j = j+82){
			g.fillRect(0, 0+j, width, 41);
		}
		g.setColor(Color.MAGENTA);		
		for (int k = 28; k<width; k = k+82){
			g.drawLine(0+k, 0, 0+k, height);
		}
		for (int l = 25; l<height; l = l+82){
			g.drawLine(0, 0+l, width, 0+l);
		}

		//Painting cat
		g.setColor(Color.GRAY);
		g.fillPolygon(xFace, yFace, 6);
		g.fillOval(xO, yO+28, 80, 40);
		g.setColor(Color.WHITE);
		g.fillPolygon(xLeftEar, yLeftEar, 4);
		g.fillPolygon(xRightEar, yRightEar, 4);
		g.setColor(Color.YELLOW);
		g.fillOval(xO + 8, yO + 36, 16, 16);
		g.fillOval(xO + (80-16-8), yO + 36, 16, 16);
		g.setColor(Color.BLACK);
		g.drawOval(xO + 8, yO + 36, 16, 16);
		g.drawOval(xO + (80-16-8), yO + 36, 16, 16);
		g.fillPolygon(xNose, yNose, 4);
		g.fillRect(xO+35, yO+63, 10, 1);

		//When she blinks
		if (!blink){
			g.fillOval(xO + 8 + eyesLR, yO + 36 + eyesUD, 8, 8);
			g.fillOval(xO + (80-16-8) + eyesLR, yO + 36 + eyesUD, 8, 8);
		}
	}
	
	//Repainting methods to create animation
	public void moveCatRight(int dx, int dy) {
		xO = xO + dx;
		repaint();
	}	
	public void moveCatLeft(int dx, int dy) {

		xO = xO - dx;
		repaint();
	}
	public void moveCatNE(){
		dir = 1;		
		eyesLR = 8;
		eyesUD = 0;
		xO = xO + 2;
		yO = yO - 2;
		repaint();
	}
	public void moveCatSE(){
		dir = 2;
		eyesLR = 8;
		eyesUD = 8;
		xO = xO + 2;
		yO = yO + 2;
		repaint();
	}
	public void moveCatNW(){
		dir = 3;
		eyesLR = 0;
		eyesUD = 0;
		xO = xO - 2;
		yO = yO - 2;
		repaint();
	}
	public void moveCatSW(){
		dir = 4;
		eyesLR = 0;
		eyesUD = 8;
		xO = xO - 2;
		yO = yO + 2;
		repaint();
	}	
	public int getYPosUP() {		
		return yO;
	}
	public int getYPosDOWN() {		
		return (yO + 65);
	}
	public int getXPosLEFT() {		
		return xO;
	}
	public int getXPosRIGHT() {		
		return (xO + 80);
	}
	public void changeBG() {
		Pr = (int)(Math.random()*1000);
		if (Pr>255) Pr = Pr/4;
		Pg = (int)(Math.random()*1000);
		if (Pg>255) Pg = Pg/4;
		Pb = (int)(Math.random()*1000);
		if (Pb>255) Pb = Pb/4;		
	}
}

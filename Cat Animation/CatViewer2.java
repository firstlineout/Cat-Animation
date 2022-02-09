//Write a program that animates a Cat so that it moves across a frame

import javax.swing.JFrame;
import java.awt.*;


public class CatViewer2 extends JFrame {
	
   public static void main(String[] args) {
      JFrame frame = new CatFrame2();
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      frame.setUndecorated(true);
      frame.setVisible(true);
      // frame.pack();
      // frame.setLocationRelativeTo(null);     
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);      
   }
}

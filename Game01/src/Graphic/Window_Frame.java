package Graphic;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window_Frame extends JFrame 
{
	JLabel label = new JLabel();
	private boolean is_fulllscreen=false;
	Menu_Panel menu;
	Game_Panel game; 
	JPanel panel= new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	public Window_Frame()
	{
	
		setSize(500,500);
		
		menu = new Menu_Panel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
//		panel.setSize(500,5);
		panel.setBackground(Color.RED);
		add(panel);
		panel.add(menu);
		setVisible(true);
		setResizable(false);
		pack();
//			panel.add(menu);
//			panel.add(game);
		menu.setWindow(this);

	}



//	
//	public void setVisible(final boolean b) {
//		super.setVisible(b);
//		switchTo(this.menu);
//	}


	public void FullScreen()
	{
           
    }


	public void switchto() 
	{
		game= new Game_Panel();
		game.Start();
		panel.removeAll();
		panel.add(game);
		game.requestFocusInWindow();
		setLocation(0, 0);	
		pack();
//
//		validate();
//		repaint();
		
	}
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu{
	private JFrame mainMenu;
	private JLabel timeLabel;
	private JLabel charLabel;
	private JPanel backgroundPanel;

	
	public Menu()
	{
		loadMenu();
	}
	
	private void loadMenu()
	{
		mainMenu = new JFrame("Estuary Defenders");
		mainMenu.setLayout(new BorderLayout());		
		mainMenu.setUndecorated(true);
		
		timeLabel = new JLabel("TIME: 0:00", JLabel.CENTER);
		charLabel = new JLabel("Char Selection", JLabel.CENTER);
		
		JPanel charFrame = new JPanel();
		charFrame.setBackground(Color.BLACK);
		charFrame.setSize(200, 500);
		
		JFrame charSel = new JFrame();
		charSel.setUndecorated(true);
		charSel.setSize(200, 200);
		JPanel charSelection = new JPanel();
		charSelection.setLayout(new GridLayout(3, 1));
		charSelection.add(new JLabel("Scientist"));
		charSelection.add(new JLabel("Researcher"));
		charSelection.add(new JLabel("Volunteer"));
		charSel.add(charSelection);
		
		
		
		charFrame.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent me){
				charSel.setLocationRelativeTo(charLabel);
				charSel.setVisible(true);				
			}
		});

		charSel.addMouseListener(new MouseAdapter()
		{
			public void mouseExited(MouseEvent me)
			{
				charSel.setVisible(false);
				mainMenu.revalidate();
			}
		});

		
		charLabel.setSize(900, 100);
		mainMenu.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
			}
		});
		
		
		JPanel timeFrame = new JPanel();
		timeFrame.setBackground(Color.RED);
		timeFrame.setSize(200, 500);
		
		JPanel exitBar = new JPanel();
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBar.add(exit);
		
		backgroundPanel = new JPanel();
		BufferedImage backgroundImage = null;
		try {
			backgroundImage = ImageIO.read(new File("background.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel image = new JLabel(new ImageIcon(backgroundImage));
		backgroundPanel.setSize(800, 800);
		backgroundPanel.add(image);
		charFrame.add(charLabel);
		timeFrame.add(timeLabel);
		
		mainMenu.add(exitBar, BorderLayout.CENTER);
		mainMenu.add(charFrame, BorderLayout.LINE_START);
		mainMenu.add(timeFrame, BorderLayout.LINE_END);
		mainMenu.add(backgroundPanel, BorderLayout.PAGE_END);	


		mainMenu.pack();
		
	}
	void showMenu() {
		mainMenu.setVisible(true);

	}
	
}
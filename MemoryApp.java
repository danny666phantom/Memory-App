package Memory;

/**
 *  Daniel Lorenzo 1410 - 013 / Assignment A05 Memory 
 *            Made with <3.
 *              /)_/)
 *             ( . .) 
 *             C(")(") 
 */

//	Import tools.
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;	// Makes JPanel so you can also add graphics.
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

//	Class name with corresponding class file. The name can only be one word!
//	With corresponding package file to the left folder navigation.
public class MemoryApp extends JFrame {

	// Class Attributes.
	// In java the name for Attributes & Properties is Instance Variables, Class
	// Attributes, Fields, Member Variables.
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	 // Makes JPanel so you can also add graphics.
	private List<Icon> icons = new ArrayList<>(11);
	private Icon blank;
	private JPanel btnPnl;	

	/**
	 * Launch the application.
	 */
	// If your calling any method from the main method then the method your
	// calling has to be static since main is static.
	// Method names start with a lower case letter unless it is a Constructor.
	public static void main(String[] args) { // Start of main.

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryApp frame = new MemoryApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // End of main.

	// MemoryApp Constructor method that gives window title, color, layout, font
	// etc...
	// MemoryApp Constructor also calls the following methods createbtn(),
	// loadImages().
	public MemoryApp() {
		setTitle("Memory App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 519);	// Sets the size of the frame window.// 4th one is tallness // The first two
		// numbers are placement of window where
		// it starts.
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northLblPnl = new JPanel();
		northLblPnl.setBackground(Color.PINK);
		contentPane.add(northLblPnl, BorderLayout.NORTH);

		Label label = new Label("Memory");
		northLblPnl.add(label);
		label.setFont(new Font("Parley Regular", Font.BOLD, 80));
		label.setAlignment(Label.CENTER);

		btnPnl = new JPanel();
		btnPnl.setBackground(Color.PINK);
		contentPane.add(btnPnl, BorderLayout.CENTER);
		btnPnl.setLayout(new GridLayout(3, 4, 15, 15));

		createBtn();
		loadImages();

	} // End of MemoryApp Constructor method.

	// The method createBtn adds the black 6.png image that will serve as the
	// back of the button when not pressed yet.
	// Creates buttons.
	private void createBtn() {
		blank = new ImageIcon(MemoryApp.class.getResource("/Memory/6.png"));
		for (int i = 0; i < 12; i++) {
			JButton a = new JButton("");

			a.setIcon(blank);
			a.addActionListener(new ButtonEventHandler(a, i));
			a.setBounds(31, 106, 100, 100);
			btnPnl.add(a);
		}

	} // End of createBtn method.

	// ButtonEventHandler Class implements from ActionListener and performs a if
	// an Icon has been set already.
	private class ButtonEventHandler implements ActionListener {

		private JButton button;
		private int position;

		public ButtonEventHandler(JButton button, int position) {
			this.button = button;
			this.position = position;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (button.getIcon() == blank) {
				button.setIcon(icons.get(position));
			} else {
				button.setIcon(blank);
			}

		}

	} // End of ButtonEventHandler Class.

	// loadImages method loads the images by using the for loop and ImageIcon
	// method to iterate throughout.
	public void loadImages() {
		for (int i = 0; i <= 5; i++) {
			icons.add(new ImageIcon(MemoryApp.class.getResource("/Memory/" + i
					+ ".png")));
			icons.add(new ImageIcon(MemoryApp.class.getResource("/Memory/" + i
					+ ".png")));
		}
		Collections.shuffle(icons);
	} // End of loadImages method.

} // End of MemoryApp Class.

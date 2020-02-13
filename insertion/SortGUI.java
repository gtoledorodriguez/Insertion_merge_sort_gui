package insertion;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**
 * SortGUI implements the Graphical User Interface
 * @author grace
 * @author gladys
 *
 */
public class SortGUI extends JFrame implements ActionListener {
	// height of the frame
	private static final int DEFAULT_HEIGHT = 584;
	// width of the frame.
	private static final int DEFAULT_WIDTH = 751;
	// creating the panel
	private JPanel panel;
	// These are the buttons (insertion, merge, and reset)
	private JButton btnInsertion;
	private JButton btnMerge;
	private JButton btnReset;
	// Output messages to the user
	private JLabel messageToUser;
	// numbers is the unsorted array of random values
	private JTextArea numbers;
	// numbers2 is where the sorted steps will be shown
	private JTextArea numbers2;
	// numbesr3 will make numbers2 scrollable
	private JScrollPane numbers3;
	// session is the current Session that is running
	private Session session;
	/**
	 * Constructor
	 * @param thisSession is the session that is running on this GUI
	 */
	public SortGUI(Session thisSession) {
		// setting the session
		session = thisSession;
		// setting the GUI to close on exit
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// initializing the display
		initDisplay();
		// repainting the display
		repaint();
	}
	/**
	 * display displays the pane
	 */
	public void display() {
		// Making a new runnable event
		java.awt.EventQueue.invokeLater(new Runnable() {
			// Setting the pane visible
			public void run()
			{
				setVisible(true);
			}
		});
	}
	
	// Setting some colors to be used later
	Color darkGray = new Color(139, 138, 140);
	Color lightGray = new Color(186, 186, 186);
	
	/**
	 * repaint() will repaint the pane every time it is called
	 */
	public void repaint() {
		// This is the message that will be displayed to the user. It is called on the sesion
		messageToUser = new JLabel(session.getMessage());
		// Adding the message to the panel
		panel.add(messageToUser);
		// Setting the font
		messageToUser.setFont(new Font("Tacoma", Font.BOLD, 20));
		// Making it visible
		messageToUser.setOpaque(true);
		// Setting the font color
		messageToUser.setForeground(Color.white);
		// Setting the background color
		messageToUser.setBackground(darkGray);
		// Setting its position
		messageToUser.setBounds(56, 424, 600, 30);
		
		// numbers is set to the random numbers array generated in Session
		numbers = new JTextArea(session.getNumbers());
		// Setting the font
		numbers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		// Making it visible
		numbers.setOpaque(true);
		panel.add(numbers);
		numbers.setEditable(false);
		
		numbers.setBounds(54, 41, 667, 46);
		
		JLabel lblUnsorted = new JLabel("Unsorted: ");
		lblUnsorted.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUnsorted.setBounds(54, 10, 100, 41);
		panel.add(lblUnsorted);
		numbers2 = new JTextArea();
		numbers2.setBounds(56, 99, 600, 281);
		panel.add(numbers2);
		numbers2.setEditable(false);
		
		numbers3 = new JScrollPane(numbers2);
		numbers3.setBounds(78, 99, 557, 281);
		panel.add(numbers3);
		
		
		pack();
	}
	private void initDisplay() {
		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			}
		};
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		
		Color blue = new Color(190, 212, 247);
		Color red = new Color(247, 204, 187);
		Color green = new Color(198, 239, 215);
		Color purple = new Color(221, 206, 239);
		Color orange = new Color(247, 230, 197);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numbers.setText(session.getNumbers());
				numbers2.setText("");
				messageToUser.setText(session.getMessage());
			}
		});
		btnReset.setVisible(false);
		btnReset.setBounds(314, 544, 85, 21);
		btnReset.setForeground(new Color(139, 138, 140));
		btnReset.setBackground(new Color(247, 204, 187));
		panel.add(btnReset);
		
		btnInsertion = new JButton();
		btnInsertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnReset.setVisible(true);
			}
		});
		btnInsertion.setText("Insertion");
		panel.add(btnInsertion);
		btnInsertion.setBounds(239, 464, 100, 30);
		btnInsertion.setForeground(darkGray);
		btnInsertion.setBackground(red);
		btnInsertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ArrayList<int[]> sortedSeq = session.insertion();
				String s = "";
				for (int i = 0; i < sortedSeq.size(); i++) {
					int[] n = sortedSeq.get(i);
					for (int j = 0; j < sortedSeq.get(i).length; j++) {
						s = s + String.valueOf(n[j]);
					}
					s = s +"\n";
					numbers2.setText(s);
				}	
				messageToUser.setText(session.getMessage());
			}
		});
		btnInsertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnReset.setVisible(true);
			}
		});
		btnMerge = new JButton();
		btnMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList sortedSeq = session.merge();
				String s = "";
				for(int i = 0; i<sortedSeq.size(); i++) {
					s = s + sortedSeq.get(i);
					//System.out.println("I: " + i);
				}
				//System.out.println("sortedSeq.size()-1: " + (sortedSeq.size()-1));
				s = s + "\n\nSorted Array: \n" + sortedSeq.get(sortedSeq.size()-1);
				numbers2.setText(s);
				//ArrayList<String> msAL2 = session.merge();
				messageToUser.setText(session.getMessage());
			}
		});
		btnMerge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnReset.setVisible(true);
			}
		});
		btnMerge.setText("Merge");
		btnMerge.setForeground(new Color(139, 138, 140));
		btnMerge.setBackground(new Color(247, 204, 187));
		btnMerge.setBounds(366, 464, 100, 30);
		panel.add(btnMerge);
		
		
		getContentPane().add(panel);
		getRootPane().setDefaultButton(btnInsertion);
		panel.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt) {
		repaint();
	}
	
}

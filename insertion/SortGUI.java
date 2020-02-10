package insertion;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
public class SortGUI extends JFrame implements ActionListener {
	private static final int DEFAULT_HEIGHT = 584;
	// Width of the game frame.
	private static final int DEFAULT_WIDTH = 751;
	// Width of a card.
	private static final int CARD_WIDTH = 73;
	// Height of a card.
	private static final int CARD_HEIGHT = 97;
	// P A N e l
	private JPanel panel;
	// B U T T O N S
	private JButton insertion;
	private JButton merge;
	// Output messages to the user
	private JLabel messageToUser;
	private Session session;
	private String output;
	private boolean inProgress;
	public SortGUI(Session thisSession) {
		session = thisSession;
		output = session.getMessage();
		inProgress = false;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initDisplay();
		repaint();
	}
	public void display() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				setVisible(true);
			}
		});
	}
	Color darkGray = new Color(139, 138, 140);
	Color lightGray = new Color(186, 186, 186);
	public void repaint() {
		messageToUser = new JLabel(session.getMessage());
		panel.add(messageToUser);
		messageToUser.setFont(new Font("Times New Roman", Font.BOLD, 20));
		messageToUser.setOpaque(true);
		messageToUser.setForeground(Color.white);
		messageToUser.setBackground(darkGray);
		messageToUser.setBounds(56, 424, 600, 30);
		
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
		
		JButton btnReset = new JButton("Reset");
		btnReset.setVisible(false);
		btnReset.setBounds(314, 544, 85, 21);
		btnReset.setForeground(new Color(139, 138, 140));
		btnReset.setBackground(new Color(247, 204, 187));
		panel.add(btnReset);
		
		JButton btnStep = new JButton();
		btnStep.setVisible(false);
		btnStep.setText("Step");
		btnStep.setForeground(new Color(139, 138, 140));
		btnStep.setBackground(new Color(247, 204, 187));
		btnStep.setBounds(260, 504, 65, 30);
		panel.add(btnStep);
		
		JButton btnGo = new JButton();
		btnGo.setVisible(false);
		btnGo.setText("Go");
		btnGo.setForeground(new Color(139, 138, 140));
		btnGo.setBackground(new Color(247, 204, 187));
		btnGo.setBounds(392, 504, 53, 30);
		panel.add(btnGo);
		
		insertion = new JButton();
		insertion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnStep.setVisible(true);
				btnGo.setVisible(true);
				btnReset.setVisible(true);
			}
		});
		insertion.setText("Insertion");
		panel.add(insertion);
		insertion.setBounds(239, 464, 100, 30);
		insertion.setForeground(darkGray);
		insertion.setBackground(red);
		insertion.addActionListener(this);
		
		
		JButton btnMerge = new JButton();
		btnMerge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnStep.setVisible(true);
				btnGo.setVisible(true);
				btnReset.setVisible(true);
			}
		});
		btnMerge.setText("Merge");
		btnMerge.setForeground(new Color(139, 138, 140));
		btnMerge.setBackground(new Color(247, 204, 187));
		btnMerge.setBounds(366, 464, 100, 30);
		panel.add(btnMerge);
		
		
		getContentPane().add(panel);
		getRootPane().setDefaultButton(insertion);
		panel.setVisible(true);
	}
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		if (command.equals("Insertion")) {
			//inProgress = session.insertion(inProgress);
			repaint();
		}
	}
}

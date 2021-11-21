import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		setTitle("Instructions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
//				new DemoGui().setVisible(true);
//				
			}
		});
		
		JLabel lblThisis = new JLabel("This is a game based on the movie Bandersnatch. In this the player will get a question ");
		
		JLabel lblInThisThe = new JLabel("and two choices for it. In this the player will get a question and two choices for it. After");
		
		JLabel lblAfterChoosingTheir = new JLabel("choosing their choice, they will again get another question untill they win or loose.If");
		
		JLabel lblQuestionUntillThey = new JLabel("");
		
		JLabel lblQuestionAreWrong = new JLabel("both the choices of that question are wrong then it will automatically take you to ");
		
		JLabel lblPreviousQueston = new JLabel("previous queston.");
		
		JLabel lblDescription = new JLabel("Description.");
		lblDescription.setFont(new Font("Laksaman", Font.BOLD, 20));
		
		JLabel lblInstructionsToPlay = new JLabel("Instructions to Play.");
		lblInstructionsToPlay.setFont(new Font("Lohit Telugu", Font.BOLD, 19));
		
		JLabel lblWithEach = new JLabel("1. With each question you will get two choices,choose ay of the choice by pressing");
		
		JLabel lblLeftDirectionKey = new JLabel("left direction key for left choice, right  key for right choice and up key for previous question.");
		
		JLabel lblOnceYou = new JLabel("2. Once you have reached the correct node of correct path you will win.");
		
		JButton btnStartPlaying = new JButton("Start Playing");
		btnStartPlaying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			Demo d = new Demo();
			DemoGui frame = new DemoGui(d.First);
			frame.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(296)
							.addComponent(lblDescription))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblInstructionsToPlay)
									.addGap(2103)
									.addComponent(btnPlay))
								.addComponent(lblInThisThe)
								.addComponent(lblThisis)
								.addComponent(lblAfterChoosingTheir)
								.addComponent(lblQuestionUntillThey)
								.addComponent(lblQuestionAreWrong)
								.addComponent(lblPreviousQueston)
								.addComponent(lblWithEach)
								.addComponent(lblOnceYou)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(lblLeftDirectionKey))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(260)
							.addComponent(btnStartPlaying)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDescription)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblThisis)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInThisThe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAfterChoosingTheir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblQuestionUntillThey)
							.addGap(64)
							.addComponent(btnPlay))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblQuestionAreWrong)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPreviousQueston)
							.addGap(48)
							.addComponent(lblInstructionsToPlay, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblWithEach)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLeftDirectionKey)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOnceYou)
					.addGap(29)
					.addComponent(btnStartPlaying)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

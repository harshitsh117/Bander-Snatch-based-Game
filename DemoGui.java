import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.util.*;

class TreeNode
{

	String question,LeftChoice,RightChoice;
	boolean End,HasEnd,visited,LeftPathResult,RightPathResult;
	TreeNode Parent,left,right;

	TreeNode(String q,String LChoice, String RChoice,TreeNode P,boolean HE,Boolean E)
	{
		question = q;
		LeftChoice = LChoice; 
		RightChoice = RChoice;
		End = E;
		HasEnd = HE;
		Parent = P;
		visited = false;
	}

	boolean play(TreeNode node)
	{	
		visited = true;
		if(HasEnd==true)
		{
			if(End == true)
			{
				System.out.println("You have won");
				return true;
			}
			else
			{
				System.out.println(question+" is wrong path");
				return false;
			}
		}

		boolean chosen = false;

		if(node.left.visited==true && node.right.visited==true)
		{
			System.out.println("Both the choices for "+node.question+" are already chosen.");
			node.Parent.play(node.Parent);
		}

		System.out.println("\nSelect your choice by typing l or r for : "+node.question+" -> "+node.LeftChoice+" or "+node.RightChoice);
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();

		if(choice=="l" && choice=="r")
		{
			while(chosen!=true)
			{
				System.out.println("Please type l for left and r for right option respectively.");
				choice = sc.nextLine();
				if(choice=="l" || choice=="r")
				{
					chosen=true;
				}
			}
		}
		else{
			chosen=true;
		}


		if(choice.equals("l"))
		{
			if(node.left.visited==true)
			{
				System.out.println("You have already chosen this path.");
			}

			System.out.println("Your choice for "+node.question+" is "+node.left.question);
			node.LeftPathResult = node.left.play(node.left);

			if(node.LeftPathResult==false)
			{
				node.play(node);
			}
		}
		else
		{
			if(node.right.visited==true)
			{
				System.out.println("You have already chosen this path.");
			}
			System.out.println("Your choice for "+node.question+" is "+node.right.question);
			node.RightPathResult = node.right.play(node.right);

			if(node.RightPathResult==false)
			{
				node.play(node);
			}
		}
		return true;
	}

}

class Demo 
{
	public TreeNode First,A,B,A_A,A_B,A_A_A,A_A_B,A_B_A,A_B_B,B_A,B_B,B_A_A,B_A_B,B_B_A,B_B_B;
	Demo()
	{
		First = new TreeNode("First","A","B",null,false,false);
		
		TreeNode A = new TreeNode("A","A.A","A.B",First,false,false);
		TreeNode B = new TreeNode("B","B.A","B.B",First,false,false);
		First.left = A;
		First.right = B;


		TreeNode A_A = new TreeNode("A_A","A_A_A","A_A_B",A,false,false);
		TreeNode A_B = new TreeNode("A_B","A_B_A","A_B_B",A,false,false);
		A.left = A_A;
		A.right = A_B;
		

		TreeNode B_A = new TreeNode("B_A","B_A_A","B_A_B",B,false,false);
		TreeNode B_B = new TreeNode("B_B","B_B_A","B_B_B",B,false,false);
		B.left = B_A;
		B.right = B_B;

		TreeNode A_A_A = new TreeNode("A_A_A",null,null,A_A,true,false);
		TreeNode A_A_B = new TreeNode("A_A_B",null,null,A_A,true,false);
		A_A.left = A_A_A;
		A_A.right = A_A_B;

		TreeNode A_B_A = new TreeNode("A_B_A",null,null,A_B,true,false);
		TreeNode A_B_B = new TreeNode("A_B_B","A","B",A_B,true,false);
		A_B.left = A_B_A;
		A_B.right = A_B_B;

		TreeNode B_A_A = new TreeNode("B_A_A",null,null,B_A,true,false);
		TreeNode B_A_B = new TreeNode("B_A_B",null,null,B_A,true,true);
		B_A.left = B_A_A;
		B_A.right = B_A_B;

		TreeNode B_B_A = new TreeNode("B_B_A",null,null,B_B,true,false);
		TreeNode B_B_B = new TreeNode("B_B_B",null,null,B_B,true,false);
		B_B.left = B_B_A;
		B_B.right = B_B_B;

	}	
}


public class DemoGui extends JFrame implements KeyListener {

	private JPanel contentPane;
	JLabel lblQuestion;
	JLabel lblChoiceLeft;
	JLabel lblChoiceRight;
	TreeNode Question;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					Demo d = new Demo();
					DemoGui frame = new DemoGui(d.First);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DemoGui(TreeNode Node) {
		System.out.println(Node.question);
		setFont(new Font("Dyuthi", Font.BOLD, 14));
		setTitle("Bander Snatch Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		addKeyListener(this);
		setLocationRelativeTo(this);
		
		Question = Node;
		Question.visited = true;
		if(Question.HasEnd==true)
		{
			if(Question.End==true)
			{
				JOptionPane.showMessageDialog(this, "You have won.","Success",JOptionPane.PLAIN_MESSAGE);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Wrong Path","Fail",JOptionPane.PLAIN_MESSAGE);
				dispose();
				DemoGui d = new DemoGui(Question.Parent);
				d.setVisible(true);
			}
		}
		
		boolean choose = false;
		
		if(Question.left.visited==true && Question.right.visited==true)
		{
			JOptionPane.showMessageDialog(this, "Both the choices for Queston : "+Question.question+" are already chosen","Alert",JOptionPane.ERROR_MESSAGE);
			dispose();
			DemoGui d = new DemoGui(Question.Parent);
		    d.setVisible(true);
		}
		
		lblQuestion = new JLabel("Question : "+ Question.question,SwingConstants.CENTER);
		lblQuestion.setBackground(Color.cyan);
		lblChoiceLeft = new JLabel("Choice : "+Question.LeftChoice,SwingConstants.CENTER);
		lblChoiceRight = new JLabel("Choice : "+Question.RightChoice,SwingConstants.CENTER);
		
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(lblChoiceLeft, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(154)
					.addComponent(lblChoiceRight, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(154))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblQuestion, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(lblChoiceLeft, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(lblChoiceRight, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("Key Typed");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		
		switch(keyCode)
		{
		case KeyEvent.VK_UP:
			if(Question.Parent==null)
			{
				JOptionPane.showMessageDialog(this,"No Previous Questions are there.","Error",JOptionPane.WARNING_MESSAGE);
			}
			else {
			
			dispose();
			DemoGui frameParent = new DemoGui(Question.Parent);
			frameParent.setVisible(true);
			}
			break;
			
//		case KeyEvent.VK_DOWN:
//			break;
		case KeyEvent.VK_LEFT:
//			if(Question.HasEnd==true)
//			{
//				if(Question.End==false)
//				{
//					
//				}
//			}
			
			dispose();
			DemoGui frameLeft = new DemoGui(Question.left);
			frameLeft.setVisible(true);
			break;
		
		case KeyEvent.VK_RIGHT:
			dispose();
			DemoGui frameRight = new DemoGui(Question.right);
			frameRight.setVisible(true);
			break;
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Key Released");
		
	}
}
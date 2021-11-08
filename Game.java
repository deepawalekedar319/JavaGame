package kedar.game.simplegame;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
class  Game 
{
	static int score,result,total;
	static String playerName,randomString;
	Game()
	{
		JFrame frame = new JFrame("Game");
		frame.getContentPane().setBackground(new Color(102,0,90));
		Font font = new Font("Arial",Font.PLAIN,20);
		frame.setLayout(null);
		frame.setSize(500,700);
		frame.setVisible(true);
		JLabel entername = new JLabel("Enter player name : ");
		entername.setBounds(10,10,190,190);
		entername.setFont(font);
		entername.setForeground(Color.WHITE);
		frame.add(entername);
		JTextField playername = new JTextField();
		playername.setBounds(190,90,200,40);
		playername.setFont(font);
		frame.add(playername);
		JButton startgame = new JButton(new ImageIcon("D:/Workspaces/Java-Game/play.jpg"));
		startgame.setBounds(140,190,170,50);
		startgame.setFont(font);
		frame.add(startgame);
		startgame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				playerName = playername.getText();
				class GameImplement 
				{
					GameImplement() 
					{
						JFrame innerframe = new JFrame("Game");
						innerframe.setSize(500,700);
						innerframe.getContentPane().setBackground(new Color(102,0,120));
						innerframe.setLayout(null);
						innerframe.setVisible(true);		
						JLabel flow = new JLabel("Welcome " + Game.playerName);
						flow.setFont(font);
						innerframe.add(flow);
						Thread t = new Thread(new Runnable()
						{
							public void run()
							{
								while (true)
								{	
									flow.setForeground(Color.YELLOW);
									for (int x=0;x<=500 ;x=x+2)
									{
										flow.setBounds(x,50,300,40);
										try{Thread.sleep(10);}catch(Exception e){}
									}
									flow.setForeground(Color.CYAN);
									for (int x = 500; x>=50 ;x = x - 2 )
									{
										flow.setBounds(x,50,300,40);
										try{Thread.sleep(10);}catch(Exception e){}
									}
								}
							}
						});
						t.start();
						JButton add = new JButton("Start Addition");
						add.setBounds(120,150,220,50);
						add.setFont(font);
						add.setBackground(Color.BLACK);
						add.setForeground(Color.WHITE);
						innerframe.add(add);
						add.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								addFunction();
							}
						});
						JButton sub = new JButton("Start Subtraction");
						sub.setBounds(120,250,220,50);
						sub.setFont(font);
						sub.setBackground(Color.BLACK);
						sub.setForeground(Color.WHITE);
						innerframe.add(sub);
						sub.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								subtractionFunction();
							}
						});
						JButton mul = new JButton("Start Multiplication");
						mul.setBounds(120,350,220,50);
						mul.setFont(font);
						mul.setBackground(Color.BLACK);
						mul.setForeground(Color.WHITE);
						innerframe.add(mul);
						mul.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								multiplyFunction();
							}
						});
						JButton div = new JButton("Start Division");
						div.setBounds(120,450,220,50);
						div.setBackground(Color.BLACK);
						div.setForeground(Color.WHITE);
						div.setFont(font);
						innerframe.add(div);
						div.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								divisionFunction();
							}
						});
						JButton eng = new JButton("Alphabets Test");
						eng.setBounds(120,550,220,50);
						eng.setFont(font);
						eng.setBackground(Color.BLACK);
						eng.setForeground(Color.WHITE);
						innerframe.add(eng);
						eng.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								alphabetFunction();
							}
						});
					}
				}
				GameImplement gp = new GameImplement();
			}
		});
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	public void addFunction()
	{
		class Add
		{
			Add()
			{	
				JFrame frame = new JFrame("Addition");
				Font font = new Font("Arial",Font.PLAIN,50);
				frame.setSize(500,700);
				frame.getContentPane().setBackground(new Color(102,0,120));
				frame.setLayout(null);
				frame.setVisible(true);	
				Random rand = new Random();
				int x = rand.nextInt(20);
				int y = rand.nextInt(20);
				Game.total = 0;
				Game.total = x+y;
				JLabel add1 = new JLabel(x+"  +");
				add1.setBounds(100,60,190,190);
				add1.setForeground(Color.BLACK);
				add1.setFont(font);
				frame.add(add1);		
				JLabel add2 = new JLabel(""+y+"  =  ");
				add2.setBounds(250,60,190,190);
				add2.setForeground(Color.BLACK);
				add2.setFont(font);
				frame.add(add2);		
				JTextField res = new JTextField();
				res.setBounds(400,120,60,60);
				res.setFont(font);
				frame.add(res);		
				JButton sum = new JButton("Add");
				sum.setBounds(120,280,150,50);
				sum.setBackground(Color.BLACK);
				sum.setForeground(Color.WHITE);
				sum.setFont(new Font("Arial",Font.PLAIN,25));
				frame.add(sum);
				sum.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
							try{result = Integer.parseInt(res.getText());}catch(Exception a){}
							if (Game.total == result)
							{
								int x = rand.nextInt(20);
								int y = rand.nextInt(20);
								add1.setText(x+"  +");
								add2.setText(""+y+"  =  ");
								res.setText("");
								Game.total = x+y;
								Game.score++;
							}
							else 
							{	
								String points = "You answer is incorrect \n correct answer is "+ Game.total+"\nyour score is " + Game.score + " points";
								String[] options = { "Restart", "Quit" };
								int n = JOptionPane.showOptionDialog(frame,points , Game.playerName,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);							
								if(n == JOptionPane.NO_OPTION )System.exit(0);
								else
								{
									int x = rand.nextInt(20);
									int y = rand.nextInt(20);
									add1.setText(x+"  +");
									add2.setText(""+y+"  =  ");
									res.setText("");
									Game.score = 0;
									Game.total = x+y;
									Game.score++;
								}
							}
					}
				});
				
			}
		}
		Add a = new Add();
	}
	public void subtractionFunction()
	{
		class Subtraction
		{
			Subtraction()
			{	
				JFrame frame = new JFrame("Subtraction");
				Font font = new Font("Arial",Font.PLAIN,50);
				frame.getContentPane().setBackground(new Color(102,0,120));
				frame.setSize(500,700);
				frame.setLayout(null);
				frame.setVisible(true);	
				Random rand = new Random();
				int x = rand.nextInt(20);
				int y = rand.nextInt(20);
				Game.total = 0;
				Game.total = x-y;
				JLabel add1 = new JLabel(x+"  -");
				add1.setBounds(100,60,190,190);
				add1.setForeground(Color.BLACK);
				add1.setFont(font);
				frame.add(add1);		
				JLabel add2 = new JLabel(""+y+"  =  ");
				add2.setBounds(250,60,190,190);
				add2.setForeground(Color.BLACK);
				add2.setFont(font);
				frame.add(add2);		
				JTextField res = new JTextField();
				res.setBounds(400,120,60,60);
				res.setFont(font);
				frame.add(res);		
				JButton sum = new JButton("Subtract");
				sum.setBounds(120,280,150,50);
				sum.setBackground(Color.BLACK);
				sum.setForeground(Color.WHITE);
				sum.setFont(new Font("Arial",Font.PLAIN,25));
				frame.add(sum);
				sum.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
							try{result = Integer.parseInt(res.getText());}catch(Exception a){}
							if (Game.total == result)
							{
								int x = rand.nextInt(20);
								int y = rand.nextInt(20);
								add1.setText(x+"  -");
								add2.setText(""+y+"  =  ");
								res.setText("");
								Game.total = x-y;
								Game.score++;
							}
							else 
							{	
								String points = "You answer is incorrect \n Correct answer is "+ Game.total+"\nyour score is " + Game.score + " points";
								String[] options = { "Restart", "Quit" };
								int n = JOptionPane.showOptionDialog(frame,points , Game.playerName,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);							
								if(n == JOptionPane.NO_OPTION )System.exit(0);
								else
								{
									int x = rand.nextInt(20);
									int y = rand.nextInt(20);
									add1.setText(x+"  -");
									add2.setText(""+y+"  =  ");
									res.setText("");
									Game.score = 0;
									Game.total = x-y;
									Game.score++;
								}
							}
					}
				});
				
			}
		}
		Subtraction a = new Subtraction();
	}
	public void multiplyFunction()
	{
		class Multiply
		{
			Multiply()
			{	
				JFrame frame = new JFrame("Multiplication");
				Font font = new Font("Arial",Font.PLAIN,50);
				frame.setSize(500,700);
				frame.getContentPane().setBackground(new Color(102,0,120));
				frame.setLayout(null);
				frame.setVisible(true);	
				Random rand = new Random();
				int x = rand.nextInt(20);
				int y = rand.nextInt(20);
				Game.total = 0;
				Game.total = x*y;
				JLabel add1 = new JLabel(x+"  X");
				add1.setBounds(100,60,190,190);
				add1.setForeground(Color.BLACK);
				add1.setFont(font);
				frame.add(add1);		
				JLabel add2 = new JLabel(""+y+"  =  ");
				add2.setBounds(250,60,190,190);
				add2.setForeground(Color.BLACK);
				add2.setFont(font);
				frame.add(add2);		
				JTextField res = new JTextField();
				res.setBounds(400,120,70,60);
				res.setFont(font);
				frame.add(res);		
				JButton sum = new JButton("Multiply");
				sum.setBounds(120,280,150,50);
				sum.setBackground(Color.BLACK);
				sum.setForeground(Color.WHITE);
				sum.setFont(new Font("Arial",Font.PLAIN,25));
				frame.add(sum);
				sum.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
							try{result = Integer.parseInt(res.getText());}catch(Exception a){}
							if (Game.total == result)
							{
								int x = rand.nextInt(20);
								int y = rand.nextInt(20);
								add1.setText(x+"  X");
								add2.setText(""+y+"  =  ");
								res.setText("");
								Game.total = x*y;
								Game.score++;
							}
							else 
							{	
								String points = "You answer is incorrect \n Correct answer is "+ Game.total+"\nyour score is " + Game.score + " points";
								String[] options = { "Restart", "Quit" };
								int n = JOptionPane.showOptionDialog(frame,points , Game.playerName,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);							
								if(n == JOptionPane.NO_OPTION )System.exit(0);
								else
								{
									int x = rand.nextInt(20);
									int y = rand.nextInt(20);
									add1.setText(x+"  X");
									add2.setText(""+y+"  =  ");
									res.setText("");
									Game.score = 0;
									Game.total = x*y;
									Game.score++;
								}
							}
					}
				});
				
			}
		}
		Multiply a = new Multiply();
	}
	public void divisionFunction()
	{
		class Division
		{
			Division()
			{	
				JFrame frame = new JFrame("Division");
				Font font = new Font("Arial",Font.PLAIN,50);
				frame.getContentPane().setBackground(new Color(102,0,120));
				frame.setSize(500,700);
				frame.setLayout(null);
				frame.setVisible(true);	
				Random rand = new Random();
				int x = rand.nextInt(20);
				int y = rand.nextInt(20);
				Game.total = 0;
				Game.total = x/y;
				JLabel add1 = new JLabel(x+"  /");
				add1.setBounds(100,60,190,190);
				add1.setForeground(Color.BLACK);
				add1.setFont(font);
				frame.add(add1);		
				JLabel add2 = new JLabel(""+y+"  =  ");
				add2.setBounds(250,60,190,190);
				add2.setForeground(Color.BLACK);
				add2.setFont(font);
				frame.add(add2);		
				JTextField res = new JTextField();
				res.setBounds(400,120,70,60);
				res.setFont(font);
				frame.add(res);		
				JButton sum = new JButton("Divide");
				sum.setBounds(120,280,150,50);
				sum.setBackground(Color.BLACK);
				sum.setForeground(Color.WHITE);
				sum.setFont(new Font("Arial",Font.PLAIN,25));
				frame.add(sum);
				sum.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
							try{result = Integer.parseInt(res.getText());}catch(Exception d){}
							if (Game.total == result)
							{
								int x = rand.nextInt(20);
								int y = rand.nextInt(20);
								add1.setText(x+"  /");
								add2.setText(""+y+"  =  ");
								res.setText("");
								try{Game.total = x/y;}catch(Exception a){}
								Game.score++;
							}
							else 
							{	
								String points = "You answer is incorrect \n Correct answer is "+ Game.total+"\nyour score is " + Game.score + " points";
								String[] options = { "Restart", "Quit" };
								int n = JOptionPane.showOptionDialog(frame,points , Game.playerName,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);							
								if(n == JOptionPane.NO_OPTION )System.exit(0);
								else
								{
									int x = rand.nextInt(20);
									int y = rand.nextInt(20);
									add1.setText(x+"  /");
									add2.setText(""+y+"  =  ");
									res.setText("");
									Game.score = 0;
									try{Game.total = x/y;}catch(Exception a){}
									Game.score++;
								}
							}
					}
				});
				
			}
		}
		Division a = new Division();
	}
	public void alphabetFunction()
	{
		class Alphabet
		{
			Alphabet()
			{	
				JFrame frame = new JFrame("Alphabet");
				Font font = new Font("Arial",Font.PLAIN,50);
				frame.getContentPane().setBackground(new Color(102,0,120));
				frame.setSize(500,700);
				frame.setLayout(null);
				frame.setVisible(true);	
				Random rand = new Random();
				String alphas = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz"; 
				StringBuilder sb = new StringBuilder();
				 int length = 1;
				 for(int i = 0; i < length; i++)
				{
					 int index = rand.nextInt(alphas.length());
					char randomChar = alphas.charAt(index);
					sb.append(randomChar);
				}	
				 Game.randomString = sb.toString();
				JLabel add1 = new JLabel(randomString+"  ");
				add1.setBounds(100,60,190,190);
				add1.setForeground(Color.BLACK);
				add1.setFont(font);
				frame.add(add1);		
				JLabel add2 = new JLabel("  =  ");
				add2.setBounds(120,60,190,190);
				add2.setForeground(Color.BLACK);
				add2.setFont(font);
				frame.add(add2);		
				JTextField res = new JTextField();
				res.setBounds(200,120,70,60);
				res.setFont(font);
				frame.add(res);		
				JButton sum = new JButton("Submit");
				sum.setBounds(120,280,150,50);
				sum.setBackground(Color.BLACK);
				sum.setForeground(Color.WHITE);
				sum.setFont(new Font("Arial",Font.PLAIN,25));
				frame.add(sum);
				sum.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
							if (randomString.equals(res.getText()))
							{
								String alphas = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz"; 
								StringBuilder sb = new StringBuilder();
								int length = 1;
								for(int i = 0; i < length; i++)
								{
									 int index = rand.nextInt(alphas.length());
									char randomChar = alphas.charAt(index);
									sb.append(randomChar);
								}	
								 Game.randomString = sb.toString();
								add1.setText(Game.randomString+"  ");
								add2.setText("  =  ");
								res.setText("");
								Game.score++;
							}
							else 
							{	
								String points = "You answer is incorrect \n Correct answer is "+ Game.randomString+"\nyour score is " + Game.score + " points";
								String[] options = { "Restart", "Quit" };
								int n = JOptionPane.showOptionDialog(frame,points , Game.playerName,JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);							
								if(n == JOptionPane.NO_OPTION )System.exit(0);
								else
								{
									add1.setText(Game.randomString+"  ");
									add2.setText("  =  ");
									res.setText("");
									Game.score = 0;
									Game.score++;
								}
							}
					}
				});
				
			}
		}
		Alphabet a = new Alphabet();
	}
	public static void main(String[] args) 
	{
		Game g = new Game();
	}
}


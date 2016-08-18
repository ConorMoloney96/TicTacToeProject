import java.awt.*;
import javax.swing.*; 
import java.awt.Event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;



//The JFrame here is the top level container which will contain the JLabel and JPanel components
public class TicTacToeFrame2 extends JFrame{
    //symbol showing whose turn it is
	private char whoseTurn = 'X';
	//boolean value which indicates of the game is over
	private boolean gameOver = false;
	//multidimensional array of type cell
	private Cell2[][] cells = new Cell2[3][3];
	//JLabel which provides status updates on the game
	private JLabel JLblStatus = new JLabel("X's turn");
	
	public TicTacToeFrame2()
	{ 
		//Creates a panel to hold the Cell objects in a GridLayout format.
		//Panel will placed in the JFrame top level container.
		JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0) );
		
		for(int i=0;i<cells.length;i++)
		{ 
			for(int j=0;j<cells[0].length;j++ )
			{ 
				panel.add(cells[i][j]=new Cell2() );
			}
		}
		panel.setBorder(new LineBorder(Color.blue, 1) );
		JLblStatus.setBorder(new LineBorder(Color.black, 1) );
		
		add(panel, BorderLayout.CENTER );
		add(JLblStatus,BorderLayout.NORTH );
	
	}
	
	public boolean isFull()
	{ 
		for(int i=0;i<cells.length;i++)
		{ 
			for(int j=0;j<cells[i].length;j++ )
			{ 
				if(cells[i][j].getToken()==' ' )
				{ 
					return false;
				}
			}
		}
		return true;
		//if no empty space in the multidimensional array list (which represents the board) has been found then the board is full. 
	}
	
	public boolean isWon(char c)
	{ 
		//checks columns
		for(int i=0;i<cells.length;i++)
		{ 
			if(cells[i][0].getToken()==c&&cells[i][1].getToken()==c&&cells[i][2].getToken()==c )
			{ 
				return true;
			}
		}
		//check rows
		for(int j=0;j<cells[0].length;j++ )
		{ 
			if(cells[0][j].getToken()==c&&cells[1][j].getToken()==c&&cells[2][j].getToken()==c )
			{ 
				return true;
			}
		}
		if(cells[0][0].getToken()==c&&cells[1][1].getToken()==c&&cells[2][2].getToken()==c)
		{ 
			return true;
		}
		if( cells[0][2].getToken()==c&&cells[1][1].getToken()==c&&cells[2][0].getToken()==c )
		{ 
			return true;
		}
		return false;
	}
	
	public class Cell2 extends JPanel
	{ 
		private char token = ' ';
		
		//constructor
		public Cell2()
		{ 
			setBorder(new LineBorder(Color.black, 1) );
			addMouseListener(new myMouseListener() );
			
		}
		
		//returns the current token value in the cell
		public char getToken()
		{ 
			return token;
		}
		
		//sets the token value in a particular cell then repaints the cell to display the token
		public void setToken(char c)
		{ 
			token=c;
			repaint();
		}
		
		@Override
		protected void paintComponent(Graphics g)
		{ 
			super.paintComponent(g); //a call to the paint component method of the superclass (in this case JPanel) should be made to ensure that all of the background information is painted in so that it can "shine through" when the rest of the overriden paintComponent() method is executed. This prevents us from having to write basic background info into the overriden paintComponent method.
		
		    if(token == 'X')
		    { 
		    	g.drawLine(10, 10, getWidth()-10, getHeight()-10 );
		    	g.drawLine(getWidth()-10, 10, 10, getHeight()-10 );
		    }
		    if(token =='0')
		    { 
		    	g.drawOval(10, 10, getWidth()-10, getHeight()-10 );
		    }
		}
		
		/* This listener class extends MouseAdapter. MouseAdapter provides access to all the methods of
		 * the MouseListener interface but they are set to null so that only the methods needed in the application 
		 * (in this case MouseClicked()) need to be overridden. 
		 */
		public class myMouseListener extends MouseAdapter
		{   
			@Override
			public void mouseClicked(MouseEvent e)
			{   
				//if the game is over no action needs to be performed on the clicked cell
				if(gameOver)
				{ 
					return;
				}
				//if the token value in the cell in question is empty and whoseTurn is not blank (i.e. the game is not over)
			    if(token==' ' && whoseTurn!=' ' )
			    { 
			    	setToken(whoseTurn);
			    }
				
				
				
				if(isWon(token) )
			    { 
			    	gameOver=true;
			    	whoseTurn=' ';
			    	JLblStatus.setText(token + " wins. Game over." );
			    }
				
				
				else if(isFull() )
				{ 
					gameOver=true;
					whoseTurn=' ';
					JLblStatus.setText("Draw. Board is full, game over"  );
				}
			    
				else //if the board is not full and no player has 3 in a row
				{ 
					whoseTurn= (whoseTurn=='X')? '0':'X';
					JLblStatus.setText(whoseTurn + "'s turn.");
					
				}
				
			}
		} //end of myMouseListener class
		
	} //end of Cell class
	
} //end of TicTacToeFrame class
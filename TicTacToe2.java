import java.awt.Dimension;
import javax.swing.JFrame;

public class TicTacToe {
       //this is the driver method for the whole program
	   public static void main(String [] args )
       { 
    	   JFrame TicTacToeGame = new TicTacToeFrame2(); //by Polymorphism: In the case of a subclass extending a superclass (i.e. TicTacToeFrame2 extends JFrame) an object of type subclass can also be said to an object of type superclass
    	   TicTacToeGame.setTitle("TicTacToe frame");
    	   TicTacToeGame.setSize(600, 600 );
    	   TicTacToeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    	   TicTacToeGame.setLocationRelativeTo(null);
           TicTacToeGame.setVisible(true);
       }
}

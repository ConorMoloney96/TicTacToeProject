This project was based on the tutorial found at: https://www.youtube.com/watch?v=ftJ66kZhdLk 

This project entailed the writing in java of 2 classes which would allow the user to play a game of TicTacToe 
with the TicTacToe2 class being run in the console to start the game.

TicTacToe2 declares an object of type TicTactToeFrame2. This is the other class which is responsible 
for the creation of the JFrame object which in contains a JLabel component and a JPanel component 
which holds the 9 Cell objects in a GridLayout format of 3 rows and 3 cells.

In the code on which the project was based a JLabel object JLblStatus was used to provide the user with relevant information 
to the game. I changed the display position of this JLabel from the South position (in the GridLayout layout of the JPanel 
object containing and organizing the cells) to the North position.

This project contains a MouseListener function such that when one of the Cells of the frame are clicked with an event 
occurs which triggers the myMouseListener class which fills in the cell that has been clicked on, determines if the game is over
and displays an appropriate message to the end user.

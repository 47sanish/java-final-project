import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {       //GamePanel class extends properties of JPanel class and implements properties of interface ActionListner also

    static final int SCREEN_WIDTH = 600;                          //width of our panel where we set field for our game
    static final int SCREEN_HEIGHT = 600;                       //height of our panel
    static final int UNIT_SIZE = 25;                           //size of each unit
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);     //find the no. of cells
    static final int DELAY = 200;                                  //delay is parameter for timer class that pass the delay in milliseconds.
    final int[] x = new int[GAME_UNITS];                               //declaring an array for x values in our field nd give size as Game_units
    final int[] y = new int[GAME_UNITS];                                  //declaring an array for y values also helps in giving the length and dimensions of our snake
    int snake_length = 6;                             //initially set blocks for snake body
    int foodEaten = 0;  //food items eaten by snake initially set to 0
    int snakeFoodX;                             //x value for snake's food
    int snakeFoodY;                                       //y value for snake's food
    char dir = 'R';                                       //declaring a variable dir for giving our snake direction that is first set to 'R' means our snake initially starts moving to right direction
    boolean running = false;                         //a boolean value for checking condition of our game initially set to false
    Timer timer;                                        //a timer variable from Timer class helps in moving speed of our snake
    Random random;                                        //a random variable from Random function helps in giving the random location for our snake's food

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT)); //set dimensions for our panel
        this.setBackground(Color.darkGray); //set background color
        this.setFocusable(true); //it mainly activate the components inside ur panel by passing boolean value inside it
        this.addKeyListener(new MyKeyAdapter()); //we create a class MyKeyAdapter which extends the properties from KeyAdapter class from java and adds a keylistner which took the response.
        startGame();
    }

   
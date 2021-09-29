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

    public void startGame() {   //startGame class first run newFood class

        newFood();
        running = true; //sets running to true as through running we define the condition of our game
        timer = new Timer(DELAY, this); //Timer is a swing class that takes DELAY as parameter and a listener
        timer.start(); //starts the timer that we create from Timer class
    }

    public void paintComponent(Graphics g) { //we take a parameter g from Graphics class uswd in drawing the graphical structure in java
        super.paintComponent(g); //we create the paintComponent class in which we inherit the method name paintComponent with the help of super keyword nd which perform its function with the help of graphic g that we create and passed in it
        draw(g); //now we call draw method
    }

    public void draw(Graphics g) {

        if (running) {  //this method first checks for runnning status of our game that if it is true then we can mave inside the if block
            /* below for loop is just for understanding the panel via rows and columns you can also keep this in your code or you can run your code without it   

            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {  //this for loop is used for making our panel looks like grid that helps us to then understanding how our program works
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT); //now drawLine is a method in awt.Graphics class that helps us in draw line as it takes for parameter (x1,y1,x2,y2) where x1 and y1 are for initial point and x2 and y2 are for final point
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);  //where it draw line between these two points that we pass in our method as parameters
            }*/
            //now we give colour , dimensions and shape for our snake's food
            g.setColor(Color.red); //setColor method gave our g Graphics an colour
            g.fillOval(snakeFoodX, snakeFoodY, UNIT_SIZE, UNIT_SIZE); //fillOval defines an oval shape for g and then inside fillOVal method we can pass 4 parameters (x-axis value , y-axis value ,width ,height)

package _08_LeagueSnake;

import java.util.Random;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    int startX;
    int startY;
    Segment head;
    int foodX;
    int foodY;
    Random ran = new Random();
    int direction=UP;
    int foods=0;
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        size(HEIGHT	,HEIGHT);
    }

    @Override
    public void setup() {
    	frameRate(20);
    	startX=ran.nextInt(100)*10;
    	startY=ran.nextInt(100)*10;
        head = new Segment(startX,startY);
        dropFood();


    }

    void dropFood() {
        // Set the food in a new random location
    	foodX=ran.nextInt(100)*10;
    	foodY=ran.nextInt(100)*10;
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
    	background(20,20,20);
    	move();
    	eat();
    	drawSnake();
    	drawFood();
    }

    void drawFood() {
        // Draw the food
    	fill(255,0,0);
        rect(foodX,foodY,10,10);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(255,230,184);
        rect(head.x,head.y,10,10);
    }

    void drawTail() {
        // Draw each segment of the tail
        
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
    	if (key == CODED) {
    	    if (keyCode == UP) {
    	    	direction=UP;
    	    } else if (keyCode == DOWN) {
    	    	direction=DOWN;
    	    }
    	    else if (keyCode==LEFT) {
    	    	direction=LEFT;
    	    }
    	    else if (keyCode==RIGHT) {
    	    	direction=RIGHT;
    	    }
    	    }
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (direction == UP) {
            // Move head up
        	head.y-=10;
        } else if (direction == DOWN) {
            // Move head down
            head.y+=10;
        } else if (direction == LEFT) {
            head.x-=10;
        } else if (direction == RIGHT) {
            head.x+=10;
        }
       checkBoundaries();
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(head.x<=-10) {
        	head.x=990;
        }
        if(head.x>=1000) {
        	head.x=0;
        }
        if(head.y<=-10) {
        	head.y=990;
        }
        if(head.y>=1000) {
        	head.y=0;
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
    	if(foodX==head.x&&foodY==head.y) {
            foods++;
            dropFood();	
    	}
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}

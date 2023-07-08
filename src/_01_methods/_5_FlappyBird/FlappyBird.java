package _01_methods._5_FlappyBird;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;

	final int xPos = 200;
	int yPos = 300;
	int yVelocity = -15;
	final int gravity = 1;
	int pipeXPos = WIDTH;
	int upperPipeHight = (int) random(100, 400);
	final int pipeGap = 200;
	int lowerY;
	int groundY = HEIGHT - 20;
	int score;
    PImage back;
    PImage pipeBottom;
    PImage pipeTop;
    PImage bird;




	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
        back = loadImage("flappyBackground.jpg");
        pipeBottom = loadImage("bottomPipe.png");
        pipeTop = loadImage("topPipe.png");
        bird = loadImage("bird.png");
        bird.resize(50,50);
        back.resize( WIDTH, HEIGHT);
   
	}

	@Override
	public void draw() {


		if ( gameOver() ) {


		} else {
			
            background(back);




			teleportPipes();
			
			fill(100, 110, 120);

			//CIRCLE
			stroke(255, 255, 255);
            image (bird, xPos, yPos);

			yVelocity += gravity;

			yPos += yVelocity;

			stroke(200, 255, 200);
			fill(50, 100, 50);
			lowerY = upperPipeHight + pipeGap;
			pipeXPos -= 7;

			//top pipe
			rect(pipeXPos, 0, 100, upperPipeHight);

			//bottom pipe
			rect(pipeXPos, lowerY, 100, HEIGHT - lowerY);


			noStroke();
			fill(100,100,100);

			//ground
			rect(0, groundY, WIDTH, 20);


			fill(255, 255, 255);
			textSize(30);

			text("Score: " + score, 50, 50);

			if ( pipeXPos == xPos - 103) {
				score++;
			}

		}

	}

	public void teleportPipes() {

		if ( pipeXPos <= -100) {
			pipeXPos = WIDTH;
			upperPipeHight = (int) random(100, 400);
		}


	}

	public void mousePressed() {
		if ( yPos > 65) {
			yVelocity = -15;
		}
	}

	public boolean gameOver() {

		if (yPos >= groundY - 10 || (xPos >= pipeXPos && xPos <= pipeXPos + 100) && (yPos < upperPipeHight || yPos > lowerY)) {
			return true;
		}

		return false;

	}

	static public void main(String[] args) {
		PApplet.main(FlappyBird.class.getName());
	}
}

package _01_methods._1_houses;

import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

public class Houses {
	
	Robot rob = new Robot();
		
	public void run() {
		
		Robot.setWindowSize(1000, 600);
		Robot.setWindowColor(20,20,34);
		
		rob.setSpeed(500);
		rob.penDown();
		rob.hide();
		
		stars();
		
		rob.setPenWidth(2);
		rob.setX(2);
		rob.setY(500);
		
		rob.setAngle(90);
		rob.setPenColor(38,77,0);
		rob.move(40);

		while (rob.getX() < 1000) {
			this.drawHouse(
					JOptionPane.showOptionDialog(null, "Do You want a small, medium, or large house?", "House height selector", 0, 0, null, new String[]{"Small", "Medium", "Large"}, "Large"),
					JOptionPane.showOptionDialog(null, "What Color house do you Want", "House color selector", 0, 0, null, new String[]{"reddish pink", "orange", "blueish purple", "white"}, "white")
				);
		}

	}
	
	

	void drawHouse(int height, int color) {
		
		int heightOfHouse = 250;
		
		switch (height){
		
			case 0: heightOfHouse = 60; break;
			case 1: heightOfHouse = 120; break;
			case 2: height = 2; break;
		
		}
		
		switch (color){
		
			case 0: rob.setPenColor(230, 0, 115); break;
			case 1: rob.setPenColor(255, 102, 25); break;
			case 2: rob.setPenColor(100, 100, 200); break;
			case 3: rob.setPenColor(Color.white); break;
			default: rob.setPenColor(Color.white);
			
		}

		rob.setAngle(0);
		rob.move(heightOfHouse);
		
		if (height == 2) {
			drawFlatRoof();
		} else {
			drawPointyRoof();
		}
		
		rob.setAngle(180);
		rob.move(heightOfHouse);
		rob.setAngle(90);
		rob.setPenColor(38,77,0);
		rob.move(25);
		
	}
	
	void drawFlatRoof() {
		rob.setAngle(90);
		rob.move(50);
	}
	
	void drawPointyRoof() {
		rob.setAngle(45);
		rob.move(35);
		rob.setAngle(135);
		rob.move(35);
	}
	
	void stars() {
		
		rob.setPenColor(Color.white);
		rob.setPenWidth(1);
		
		Random r = new Random();
		
		for (int i = 0; i < 25; i++) {
			
			rob.setX(r.nextInt(900) + 50);
			rob.setY(r.nextInt(200) + 50);
			rob.setAngle(r.nextInt(360));
			
			for ( int j = 0; j < 5; j++) {
				rob.turn(180-36);
				rob.move(10);
			}
			
		}
		

	}
	
}



/*
1. Have a robot start on the left side of the window near the bottom.

2. Draw a flat-topped house of height 100 with grass after it (see picture).

3. Extract the piece of code that draws the house into a method. Draw 10 houses.

4. Change the method to take (int height) as a parameter. Draw 9 houses of different heights

5. Make the method take a String instead of an int.

        “small”                 60

        “medium”             120

        “large”                 250

6. Make the method take a color as well as a height. The houses are drawn in that color.

[optional] Set the scene to night by setting the background to black

7. Give the houses peaked roofs

8. Extract that roof code into a method “drawPointyRoof” and create a new method: “drawFlatRoof”.

9. Make large houses have flat roofs
*/
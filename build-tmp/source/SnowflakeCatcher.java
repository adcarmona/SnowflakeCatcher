import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] snowstorm;
int oldMouseX;
int oldMouseY;
public void setup()
{
  //your code here
  frameRate(15);
  size(900,600);
  background(0);
  snowstorm = new SnowFlake[1000];
  for(int i=0; i<snowstorm.length; i++)
 	{
 		snowstorm[i] = new SnowFlake();
 	}
}
public void draw()
{
  //your code here
	for (int i=0; i<snowstorm.length; i++)
 	{
 		snowstorm[i].wrap();
 		snowstorm[i].erase();
 		snowstorm[i].show();
 		snowstorm[i].lookDown();
 		snowstorm[i].move();
 	}
}
public void mouseDragged()
{
  //your code here
  	if (mouseButton == LEFT)
  	{
  		noStroke();
  		fill(255,0,0);
		ellipse(mouseX,mouseY,10,10);
	}
	else if (mouseButton == RIGHT)
	{
		noStroke();
		fill(0);
		ellipse(mouseX,mouseY,10,10);
	}
}

class SnowFlake
{
  //class member variable declarations
	int x;
	int y;
	int snowflakeWidth;
	int snowflakeLength;
	boolean isMoving;
	boolean white;
  SnowFlake()
  {
    //class member variable initializations
    x = (int)(Math.random()*900)+1;
    y = (int)(Math.random()*600)+1;
    snowflakeWidth = (int)(Math.random()*5);
    snowflakeLength = (int)(Math.random()*5);
    white = true;
    isMoving = true;
  }
  public void show()
  {
    //your code here
    if (isMoving == true)
    {
    	if (snowflakeWidth == 5 && white == false)
    	{
    		white = true;
    	}
    	else if (snowflakeWidth == 0 && white == true)
    	{
    		white = false;
    	}
    	if (white == false)
    	{
    		snowflakeWidth = snowflakeWidth + 1;
    	}
    	else if (white == true)
    	{
   	 		snowflakeWidth = snowflakeWidth - 1;
    	}
    	if (snowflakeLength == 5 && white == false)
    	{
    		white = true;
    	}
    	else if (snowflakeLength == 0 && white == true)
    	{
    		white = false;
    	}
    	if (white == false)
    	{
    		snowflakeLength = snowflakeLength + 1;
    	}
    	else if (white == true)
    	{
   	 		snowflakeLength = snowflakeLength - 1;
    	}
	}
    fill(255);
    stroke(0);
    ellipse(x,y,snowflakeWidth,snowflakeLength);
  }
  public void lookDown()
  {
    //your code here
    if(y < 595 && get(x,y+8) == color(255,0,0) || get(x,y+8) == color(255,255,255))
    {
    	isMoving = false;
    }
    else
    {
    	isMoving = true;
    }
  }
  public void erase()
  {
    //your code here
    stroke(0);
    fill(0);
    ellipse(x, y, 7, 7);
  }
  public void move()
  {
    //your code here
    if (isMoving == true)
    {
		y = y + 1;
    }
  }
  public void wrap()
  {
    //your code here
    if (y > 595) 
    {
    	y = (int)(Math.random()*20)-20;
    	x = (int)(Math.random()*900)+1;
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

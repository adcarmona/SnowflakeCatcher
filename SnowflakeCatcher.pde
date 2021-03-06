SnowFlake [] snowstorm;
int oldMouseX;
int oldMouseY;
void setup()
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
void draw()
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
void mouseDragged()
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
  void show()
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
  void lookDown()
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
  void erase()
  {
    //your code here
    stroke(0);
    fill(0);
    ellipse(x, y, 7, 7);
  }
  void move()
  {
    //your code here
    if (isMoving == true)
    {
		y = y + 1;
    }
  }
  void wrap()
  {
    //your code here
    if (y > 595) 
    {
    	y = (int)(Math.random()*20)-20;
    	x = (int)(Math.random()*900)+1;
    }
  }
}
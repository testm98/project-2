  //Matt Testa//
//X5 Collisions//

///Globals//

String title= "Collisions";
String news= "Use 'q' key to reset";
String author= "Matt Testa";

float top, bottom, left, right, center, middle;

float cueX, cueY, cueDX, cueDY;
float redX, redY, redDX, redDY;
float greenX, greenY, greenDX, greenDY;
float yellowX, yellowY, yellowDX, yellowDY;

//setup///
void setup() {
  size (700,500);
  left= 80;
  right= width-50;
  top= 120;
  bottom= height-80;
  middle= width/2;
  reset ();
}
 void reset() {
   cueX=  left + ( right-left )/6;
   cueY=  top + ( bottom-top )/4;
   //Random//
   redX=  random( middle,right );   redY=  random( top, bottom );
   yellowX=  random( middle,right );   yellowY=  random( top, bottom );
   greenX=  random( middle,right );   greenY=  random( top, bottom );
   // Random speeds
   redDX=  random( 1,1 );   redDY=  random( 1,1 );
   yellowDX=  random( 1,1 );   yellowDY=  random( 1,1 );
   greenDX=  random( 2,2 );   greenDY=  random( 2,2 );
 }

//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250,250,200 );
  rectMode( CORNERS );
  table( left, right, top, bottom );
  bounce();
  collisions();
  show();
  messages();
}

//// SCENE:  draw the table with walls
void table( float left, float right, float top, float bottom ) {
  fill( 200, 80, 120 );    //pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( left, top, right, bottom );
  stroke(0);
  strokeWeight(1);
}
 
 //ACTION//
 void bounce() {
   if (redX<left || redX>right) redDX *= -1;
   if (redY<top || redY>bottom) redDY *= -1;
   
   redX += redDX; 
   redY += redDY;
   
   if (yellowX<left || yellowX>right) yellowDX *= -1;
   if (yellowY<top || yellowY>bottom) yellowDY *= -1;
  
   yellowX += yellowDX;
   yellowY += yellowDY;
  
   if (greenX<left || greenX>right) greenDX *= -1;
   if (greenY<top || greenY>bottom) greenDY *= -1;
   
   greenX += greenDX;
   greenY += greenDY; 
   
   cueX += cueDX; if (cueX<left || cueX>right) cueDX *= -1;
   cueY += cueDY; if (cueY<top || cueY>bottom) cueDY *= -1;
 }
 
void collisions() {
  float tmp;
  //elastic impact//
  if ( dist (redX, redY, yellowX, yellowY ) < 50 ) {
    tmp=redDX;  redDX=yellowDX; yellowDX=tmp;
    tmp=redDY; redDY=yellowDY; yellowDY=tmp;
  }
  if ( dist (redX, redY, greenX, greenY ) < 50 ) {
    tmp=redDX;  redDX=greenDX; greenDX=tmp;
    tmp=redDY; redDY=greenDY; greenDY=tmp;
  }
  if ( dist (yellowX, yellowY, greenX, greenY ) < 50 ) {
    tmp=yellowDX;  yellowDX=greenDX; greenDX=tmp;
    tmp=yellowDY; yellowDY=greenDY; greenDY=tmp;
  }
 
}

void show() {
  fill( 255,255,255); ellipse( cueX, cueY, 40,40);
  fill( 255,0,0);  ellipse(redX, redY, 40,40);
  fill(0,255,0); ellipse(greenX, greenY, 40,40);
  fill(230,240,120); ellipse(yellowX, yellowY, 40,40);
}

void messages() {
  fill(0);
  text( title, width/2, 20);
  text( news, width/2, 600);
  text(author, 40, 40);
}

void keyPressed() {
  if (key == 'q') {
    reset();
  }
}

    
   
   
 

ArrayList<Cow> particles;

void setup() {
  frameRate(30);
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 600; i++)
    particles.add(new Cow());
}

void draw() {
  background(200);
  for (Cow c : particles) {
    c.move();
    c.display();
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
   //Read about mouseClicked()/mousePressed() and related methods in the documentation.
   //Right click: add a cow at the mouse location.
   //Left click: call the click of each cow 
   println(mouseX);
   if (mouseButton == LEFT){
     for (int i = 0; i<particles.size(); i++){
       if (Math.pow(mouseX, 2)+Math.pow(mouseY, 2) < Math.pow(particles.get(i).radius, 2)){
         particles.get(i).click();
       }
     }
   }else if (mouseButton == RIGHT){
     Cow add = new Cow();
     add.x = mouseX;
     add.y = mouseY;
     particles.add(add);
   }
}

void keyPressed() {
  //Read about keyPressed() in the documentation.
  //hint:
  //println(keyCode);
  if (keyCode == 32){
    particles.clear();
  }
}

public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding;
  boolean selected;
  
  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    noStroke();
    fill(c);
    ellipse(x, y, radius*2, radius*2);
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, 
   //change the cow...  
   c = color(random(255), random(255), random(255));
  }
  
  void collide(ArrayList<Cow>others){
    
  }
 
}

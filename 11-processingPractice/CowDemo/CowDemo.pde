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
   if (mouseButton == LEFT){
     for (int i = 0; i<particles.size(); i++){
       if (Math.pow(mouseX-particles.get(i).x, 2)+Math.pow(mouseY-particles.get(i).y, 2) < Math.pow(particles.get(i).radius, 2)){
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

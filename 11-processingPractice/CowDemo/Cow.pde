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
    colliding = false;
    selected = false;

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    if (selected && colliding){
      x += 2*dx;
      y += 2*dy;
    }else{
      x += dx;
      y += dy;
    }
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    noStroke();
    this.collide(particles);
    if (!colliding){
      fill(c);
    }else{
      fill(255,0,0, 255/2);
    }
    ellipse(x, y, radius*2, radius*2);
    if (selected){
      fill(0);
      ellipse(x-radius/2, y-radius/4, radius/2, radius/2);
      ellipse(x+radius/2, y-radius/4, radius/2, radius/2);
      textSize(10);
      text("DX: "+this.dx+"\nDY: "+this.dy+"\n"+degrees(atan(dy/dx)),this.x+this.radius,this.y-this.radius);
      fill(255);
      ellipse(x-radius/2, y-radius/4, radius/5, radius/5);
      ellipse(x+radius/2, y-radius/4, radius/5, radius/5);
    }
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, 
   //change the cow...  
   selected = !selected;
  }
  
  void collide(ArrayList<Cow>others){
    for (int i = 0; i<others.size(); i++){
      if (Math.pow(others.get(i).x-this.x,2)+Math.pow(others.get(i).y-this.y,2) < Math.pow(this.radius+others.get(i).radius,2) && (this.c != others.get(i).c && this.x != others.get(i).x && this.y != others.get(i).y && this.radius != others.get(i).radius && this.dx != others.get(i).dx && this.dy != others.get(i).dy)){
        this.colliding = true;
        break;
      }else{
        this.colliding = false;
      }
    }
  }
  
    /*Write a Cow method that will modify the dx and dy
   *such that the cow will change the direction it is moving
   *counter-clockwise by the specified angle (degrees).
   *Test this with any of the existing cow demos. (make the cows turn 30 degrees on click)
   */
  void turn(float angle){
    float d = (float)Math.pow(Math.pow(dy,2)+Math.pow(dx,2), 0.5);
    float newAngle = degrees(atan2(dy, dx))-angle;
    
    dx = d*cos(radians(newAngle));
    dy = d*sin(radians(newAngle));
  }
  /*Write a Cow method that will modify the dx and dy
   *such that the cow will add dv to the magnitude of its velocity 
   *but maintain the same direction.
   *Test this with any of the existing cow demos. (make the cows get 2 units faster on click to test)
   */
  void changeSpeed(float dv){
    float d = (float)Math.pow(Math.pow(dy,2)+Math.pow(dx,2), 0.5);
    d += dv;
    
    float angle = atan2(dy, dx);
    
    dx = d*cos(angle);
    dy = d*sin(angle);
  }
}

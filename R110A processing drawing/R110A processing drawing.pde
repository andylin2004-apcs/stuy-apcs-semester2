void setup(){
 size(800,600);
 background(0);
 
 fill(209);
 ellipseMode(CENTER);
 ellipse(400, 150, 400, 200);
 fill(209);
 noStroke();
 rectMode(CENTER);
 rect(400,325,400,350);
 noStroke();
 fill(0);
 ellipse(400, 150, 400*.95, 200*0.9);
 noStroke();
 fill(0);
 rectMode(0);
 rect(210,150,380/3,200,7);
 noStroke();
 fill(209);
 rectMode(0);
 rect(210+380/3+2-2,150,380/3+2,200,10);
 noStroke();
 fill(0);
 rectMode(0);
 rect(210+380/3*2+2,150,380/3,200,10);
 noStroke();
 fill(230);
 rectMode(0);
 rect((210+380/3+2)+10,153+10,380/3-21,337,10,10,0,0);
 
 fill(255,3,3);
 ellipse(275,400, 20,20);
 
 fill(255);
 ellipse(275,435, 20,20);
 
 fill(255,3,3);
 ellipse(525,400, 20,20);
 
 fill(255);
 ellipse(525,435, 20,20);
 
 rectMode(CENTER);
 fill(40);
 rect(400,105,100,50,5);
 
 rectMode(0);
 fill(40);
 rect(222.5,170,100,150,5);
 
 fill(40);
 rect(360,180,80,150,5);
 
 fill(40);
 rect(477.5,170,100,150,5);
}

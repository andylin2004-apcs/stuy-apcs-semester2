PImage redcar;
PImage redcar2;

public void settings() {
  size(772, 495*2);
}

void setup(){
  redcar = loadImage("redcar.jpg");
  redcar2 = redcar.copy();
  float[][] testKernel = new float[][]{{1,0,-1},{2,0,-2},{1,0,-1}};
  Kernel test = new Kernel(testKernel);
  test.apply(redcar, redcar2);
}

void draw(){
  image(redcar, 0, 0);
  image(redcar2, 0, 496);
}

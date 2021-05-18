class Kernel {
  float[][]kernel;

  /*Constructor takes the kernel that will be applied to the image
    This implementation only allows 3x3 kernels*/
  public Kernel(float[][]init) {
    kernel = init;
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    if (x > 0 && y > 0 && x < kernel.length-1 && y < kernel[0].length-1){
      return color(0,0,0);
    }else{
      float result = 0;
      for (int i = 0; i<kernel.length; i++){
        for (int v = 0; v<kernel[0].length; v++){
          color toEdit = img.get(x-1+i,y-1+i);
          result += toEdit*kernel[i][v];
        }
      }
      return (int)result;
    }
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
  }

}

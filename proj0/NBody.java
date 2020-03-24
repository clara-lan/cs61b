public class NBody{
  /*use static method enable to access it by class name NBody.method(), instead of initialize a new NBody object.*/
  /* define type: Body[]*/
  public static Body[] readBodies(String fileName){
    In in = new In(fileName);
    if (fileName.length() == 0) {
      System.out.println("No file.");
      /*return null to end the code if no file, otherwise it will still go to try/catch and boom.*/
      return null;
    }	
    /*initialize var res outside try/catch loop to access it after the try/catch loop ends.*/
    Body[] res = null;
    try{
      /*read the firs line*/
      int nBodies = in.readInt();
      /*assign the val nBodies(int of the first line) to res*/
      res = new Body[nBodies];
      /*read the second line - not use it*/
      in.readDouble();
      /*start to read inner vals in order from third  to eight line */
      for(int i = 0; i < nBodies; i++) {
        double xPos = in.readDouble();
        double yPos = in.readDouble();
        double xVel = in.readDouble();
        double yVel = in.readDouble();
        double mass = in.readDouble();
        String imgName = in.readString();
        res[i] = new Body(xPos, yPos, xVel, yVel, mass, imgName);
      }
    }
    catch(Exception e) {
      /*print any error details*/
      e.printStackTrace();
      return null;
    }
    return res;
  }

  public static double readRadius(String fileName){
    In in = new In(fileName);
    if (fileName.length() == 0) {
			System.out.println("File is not found.");
      return -1;
    }	
    double radius = 0;
    try{
      in.readInt();
      radius = in.readDouble();
    }catch(Exception e){
      e.printStackTrace();
      return -1;
    }
      return radius;
  }

  // read from command line input, no matter the name of paramas(either args/input works )
  public static void main(String[] input){
    double T = Double.parseDouble(input[0]);
    // System.out.println(T);
    double dt = Double.parseDouble(input[1]);
    // System.out.println(dt);
    String filename = input[2];
    // System.out.println(filename);
    //use classname.method to call a static method
    Body[] bodies = NBody.readBodies(filename);
    //java can not print object
    // System.out.println(bodies);
    double radius = NBody.readRadius(filename);
    // System.out.println(radius);
   
    String imageToDraw = "images/starfield.jpg";
    StdDraw.enableDoubleBuffering();
    StdDraw.setScale(-100, 100);
    StdDraw.clear();
    StdDraw.picture(0, 75, imageToDraw);
		StdDraw.picture(-75, -75, imageToDraw);
    StdDraw.picture(75, -75, imageToDraw);
    StdDraw.show();
    //2000 miliseconds = 2seconds;wait for 2seconds before draw bodies
    StdDraw.pause(2000);
    //radius = universe radius, locate bodies according to ratio of unvierse and bodies(bg and bodies);
    StdDraw.setScale(-radius, radius);
    int i = 0;
    while (i < bodies.length){
      bodies[i].draw();
      i += 1;
    }
    //all drawing takes place on the offscreen canvas. The offscreen canvas is not displayed.
    StdDraw.enableDoubleBuffering();
    double time = 0.0;
    
  }
}
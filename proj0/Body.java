// import java.util.List;
// import java.util.LinkedList;

public class Body {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  // private List<Integer> aList;

  /**If without passing Body b, default constructor as follows*/
  // public Body(){
  //   this.imgFileName = "";
  // }


  /**assign value to constructor*/
  public Body(double xP, double yP, double xV, double yV, double m, String img){
    this.xxPos = xP;
    this.yyPos = yP;
    this.xxVel = xV;
    this.yyVel = yV;
    this.mass = m;
    this.imgFileName = img;
    // this.aList = new LinkedList<>();
    // this.imgFileName = "";
  }

  /** pass params through constructor*/
  public Body(Body b){
    this.xxPos = b.xxPos;
    this.yyPos = b.yyPos;
    this.xxVel = b.xxVel;
    this.yyVel = b.yyVel;
    this.mass = b.mass;
    this.imgFileName = b.imgFileName;
  }

  /** b1.calcForceExertedBy(b2)
   * this refers to b1, the params passed when invoking the method, 
   * b refers to the passed params b2 */
  public double calcDistance(Body b){
    double distance = Math.sqrt(Math.pow(this.xxPos - b.xxPos, 2)
      + Math.pow(this.yyPos - b.yyPos, 2));
    return distance;
  }

  public double calcForceExertedBy(Body b){
    double forceExertedBy = 6.67 * Math.pow(10, -11) * this.mass * b.mass / Math.pow(calcDistance(b),2); 
    return forceExertedBy;
  }

  public double calcForceExertedByX(Body b){
    double forceExertedByX;
    forceExertedByX = calcForceExertedBy(b) * (this.xxPos - b.xxPos) / calcDistance(b);
    if(forceExertedByX<0){
      return forceExertedByX * -1;
    }else{
      return forceExertedByX;
    }
  }  

  public double calcForceExertedByY(Body b){
    double forceExertedByY;
    forceExertedByY = calcForceExertedBy(b) * (this.yyPos - b.yyPos) / calcDistance(b);
    if(forceExertedByY<0){
      return forceExertedByY * -1;
    }else{
    return forceExertedByY;
    }
  }  


  public double calcNetForceExertedByX(Body[] bodies){
    double netForceExertedByX=0;
    for(int i=0; i < bodies.length; i++){
      if(bodies[i] != this){
      netForceExertedByX += calcForceExertedByX(bodies[i]);
      }
    }
    return netForceExertedByX;
  }

  public double calcNetForceExertedByY(Body[] bodies){
    double netForceExertedByY=0;
    for(int i=0; i < bodies.length; i++){
      if(bodies[i] != this){
        netForceExertedByY += calcForceExertedByY(bodies[i]);
      }
    }
    return netForceExertedByY;
  }

  /* No return, use void instead of double*/
  public void update(double dt, double xforce, double yforce){
    double accelX = xforce / this.mass;
    double accely = yforce / this.mass;
    this.xxVel += accelX * dt;
    this.yyVel += accely * dt;
    this.xxPos += this.xxVel * dt;
    this.yyPos += this.yyVel * dt;
  }

  public void draw(){
    StdDraw.enableDoubleBuffering();
    StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
    StdDraw.show();
  }
}






public class MaxMin{
  public static void main(String[] args){
    int max = StdIn.readInt();
    int min = max;
    while(!StdIn.isEmpty()){
      int value = StdIn.readInt();
      if(value > max){
        max = value;
      }else if (value < min){
        min = value;
      }
    }
    System.out.println("maxium: "+max);
    System.out.println("minum: " + min);
  }
}
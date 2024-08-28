public class Main {
    public static void main(String[] args) {

        TestCases.performTests();
    
        AllocatableArray A = new AllocatableArray(1);
    
        // header (x axis;y axis)
        System.out.println("Length (millions);Elapsed Time (nanoseconds)");
    
        for (int i = 0; i <= 100000000; i += 100000){

          long start = System.nanoTime();
    
          A.set(i, 1);
    
          long end = System.nanoTime();
          long elapsedTime = end - start; 
    
          // seiconlon format for sheets
          System.out.println((i / 100000) + ";" + elapsedTime);
        }
    }
}
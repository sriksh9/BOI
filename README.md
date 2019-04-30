import java.io.*;
import java.util.*;

public class HelloWorld{

     public static void main(String []args){
       int dup_count = 0;
       Scanner sc = new Scanner(System.in);
       HashSet <String> h = new HashSet<String>();
       String nums=sc.nextLine();
       while(!nums.equals("")){
           System.out.println(nums);
           if(!h.add(nums))
            dup_count++;
           nums = sc.nextLine();
       }
       System.out.println(dup_count);
     }
}

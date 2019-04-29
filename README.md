
import java.util.Arrays;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int dup_count=0;
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] my_array = new int[n];
        
        System.out.println("Enter the array elements : ");
        for(int i=0; i<n; i++){
            my_array[i]=sc.nextInt();
        }
        
        for (int i = 0; i < my_array.length-1; i++)
        {
            for (int j = i+1; j < my_array.length; j++)
            {
                if ((my_array[i] == my_array[j]) && (i != j))
                {
                    dup_count++;
                }
            }
        }
        System.out.println("Total Duplicate elements int the given array: "+dup_count);
    }    
}

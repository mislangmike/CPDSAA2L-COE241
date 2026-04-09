package BinarySearch;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class BinarySearchName {
	// Function to implement binary search
 
	static int binarySearch(String arr[], int low, int high, String key) {
        if (low > high) 
        {
            return -1;
        }

        int mid = (low + high) / 2;

        int compare = key.compareToIgnoreCase(arr[mid]);

        if (compare == 0) 
        {
            return mid;
        } 
        else if (compare < 0) {
            return binarySearch(arr, low, mid - 1, key);
        } 
        else 
        {
            return binarySearch(arr, mid + 1, high, key);
        }
    }

		
public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args)throws Exception {
		//declaration of variables
		int x,a,b;//counter variables
		
		String name[]=new String[5];
		String nameOrig[]=new String[5];
		String tempT;
		
		int grade[]=new int[5];
		int gradeOrig[]=new int[5];
		int tempNum;
		
		//open the file
				FileWriter fwriter = new FileWriter("ParallelArray.txt",true);//an object to append data to file
				PrintWriter outputFile = new PrintWriter(fwriter);
		
			//date
			Date date = new Date();
			String str = String.format("  Transaction's Date/Time : %tc", date );
			outputFile.println(str);
			
		//enter data on the array
		for(x=0;x<=4;x++)
		{
		System.out.print("Enter name" +(x+1)+": ");
		name[x]=input.nextLine();
		nameOrig[x] = name[x];
		outputFile.println(name[x]);
			do
			{
				System.out.print("Grade: " );
				grade[x]=input.nextInt();
				gradeOrig[x] = grade[x];
				outputFile.println(grade[x]);
				
				if(grade[x]<50||grade[x]>100)
				{
					System.out.print("\tOut of Range???[50 to 100 only] \n" );
				}
			}while(grade[x]<50||grade[x]>100);
			
		input.nextLine();
		}
		
		//Display data on the array-NOT SORTED
		System.out.print("Display data on the array-NOT SORTED\n");
		System.out.printf("%-15s %6s%n", "NAME: " , "GRADE" );
		outputFile.println("Display data on the array-NOT SORTED\n");
		outputFile.printf ("%-15s %6s%n", "NAME: " , "GRADE" );
		
		System.out.println("------------------------------");
		outputFile.println("------------------------------");
		for(x=0;x<=4;x++)
		{
			
			System.out.printf ("%-15s %6s%n",name[x] , grade[x]);
			System.out.println();
			outputFile.printf ("%-15s %6s%n",name[x] , grade[x]);
			outputFile.println();
			
		}
		
		// Selection Sort
        for (int i = 0; i < grade.length - 1; i++) 
        {
            int minIndex = i;

            for (int j = i + 1; j < grade.length; j++) 
            {
                if (name[j].compareToIgnoreCase(name[minIndex])<0) 
                {
                    minIndex = j;
                }
            }

            String temp = name[i];
            name[i] = name[minIndex];
            name[minIndex] = temp;
            
            int tempGrd = grade[i];
            grade[i] = grade[minIndex];
            grade[minIndex] = tempGrd;
        }
		
		//Display data on the array SORTED
				System.out.println("Display data on the array SORTED\n");
				System.out.printf("%-15s %8s   %20s %18s%n ", "NAME",  "GRADE ", "ORIGINAL NAME", "ORIGINAL GRADE" );
				System.out.println("------------------------------");
				
				outputFile.println("Display data on the array SORTED\n");
				outputFile.printf("%-15s %8s   %20s %18s%n ", "NAME",  "GRADE ", "ORIGINAL NAME", "ORIGINAL GRADE" );
				outputFile.println("------------------------------");
				
				for(x=0;x<=4;x++)
				{
					
					System.out.printf ("%-15s %8s   %20s %18s%n ", name[x] , grade[x] ,nameOrig[x] , gradeOrig[x]);
					System.out.println();
					outputFile.printf("%-15s %8s   %20s %18s%n ", name[x] , grade[x] ,nameOrig[x] , gradeOrig[x]);
					outputFile.println();
				}
				
				
				//Binary Search algorithm
				System.out.println("SEARCH: \n" );
				System.out.println("ENTER GRADE TO SEARCH: " );
				String key=input.nextLine(); //where: key variable is the name to search in the array
				int h=grade.length-1;//the size array
				int low=0;
				
				int pos=binarySearch(name, low,h, key);
				
				//DISPLAY THE ELEMENTS
				
					if(pos!=-1)
					{
						System.out.println("NAME "+key + " is found...");
						System.out.println(name[pos] + "\t\t" + grade[pos] );
						System.out.println( "LOCATION : \t\t" + pos);							
						
					}
				
					else
					{
						System.out.println("NAME " + key +" not found...");
					}
					
					input.close();
				
				//close the file
				outputFile.close();
				System.out.print("\nData written to the file");
	}


}


//CABAGUA, MIKE LORENZ M.
//COE 241
//ENGR. MARLON G. BAGARA

package DeleteAlgo;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class DeleteElementSelectName {
	
		static int findElement(String arr[], int grade[], int n, String key)
		{
		int i;
		for (i = 0; i < n; i++)		//=SIZE PF THE ARRAY
		    if (arr[i].equalsIgnoreCase(key))
			    {
		    		return i;
			    }
		    			    
		return -1;
		}
		
		//Function to delete an element
		static int deleteElement(String name[], int grade[], int n, String key)
		{
		
			// Find position of element to be
			// Deleted
			
			int pos = findElement(name, grade, n, key);
			
				if (pos == -1)
					{
						System.out.println("Element not found");
						return n;
				
					}
			
			//Deleting Element
			int i;
			for (i = pos; i< n - 1; i++)
				{
					name[i] = name[i + 1];
					grade[i] = grade[i + 1];
				}
		
			return n - 1;
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
		
		//Step 1 and Step 2- open the file
				FileWriter fwriter = new FileWriter("ParallelArray.txt",true);//an object to append data to file
				PrintWriter outputFile = new PrintWriter(fwriter);
		
			//date
			Date date = new Date();
			String str = String.format("  Transaction's Date/Time : %tc", date );
			outputFile.println(str);
			
		//Step 3- enter data on the array
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
		
		System.out.println("______________________________");
		outputFile.println("______________________________");
		for(x=0;x<=4;x++)
		{
			
			System.out.printf ("%-15s %6s%n",name[x] , grade[x]);
			System.out.println();
			outputFile.printf ("%-15s %6s%n",name[x] , grade[x]);
			outputFile.println();
			
		}

		
		
		
		for (a=0; a<=4;a++)
		{
				for (b=a+1; b<=4;b++)
				{
					if (grade[a]>grade[b])
					{
						tempT=name[a];
						name[a]=name[b];
						name[b]=tempT;
						
						tempNum=grade[a];
						grade[a]=grade[b];
						grade[b]=tempNum;
					}		
				}		
			}
		
		//Display data on the array SORTED
				System.out.println("Display data on the array SORTED\n");
				System.out.printf("%-15s %18s %20s %18s%n", "NAME:", "GRADE: ", "ORIGINAL NAME: ", "ORIGINAL GRADE: ");
				System.out.println("_________________________________________________________________________________|");
				
				outputFile.println("Display data on the array SORTED\n");
				outputFile.printf("%-15s %18s %20s %18s%n", "NAME:", "GRADE: ", "ORIGINAL NAME: ", "ORIGINAL GRADE: ");
				outputFile.println("_________________________________________________________________________________|");
				
				for(x=0;x<=4;x++)
				{
					
					System.out.printf ("%-15s %8s   %20s %18s%n ", name[x] , grade[x] ,nameOrig[x] , gradeOrig[x]);
					System.out.println();
					outputFile.printf("%-15s %8s   %20s %18s%n ", name[x] , grade[x] ,nameOrig[x] , gradeOrig[x]);
					outputFile.println();
				}
				
				//Delete name implementation
				
				System.out.println("\n//  DELETE IMPLEMENTATION ");
				System.out.println("\nENTER NAME TO DELETE: ");
				String key = input.nextLine(); //where: key variable is the name search
				int n=grade.length;		//the n is the size of the array
				n = deleteElement(name, grade, n, key);
				
				System.out.println("_____________________________________________________________________________________________|");
				outputFile.println("_____________________________________________________________________________________________|");
				
				
				int pos = deleteElement(name, grade, n, key);
				
						System.out.println("\n\nArray after deletion");
						for (int i = 0; i<pos; i++)
							System.out.printf("%-15s %18s%n", name[i], grade[i]);
						
						input.close();
						
				
				//Step 4 - close the file
				outputFile.close();
				System.out.print("\nData written to the file");
	}


}


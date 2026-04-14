//CABAGUA, MIKE LORENZ M.
//COE 241
//ENGR. MARLON G. BAGARA


package DeleteAlgo;
import java.io.*;
import java.util.*;

//SELECT GRADE TO DELETE
public class DeleteElementSelectGrade {
	// Function to Implement
		//search operation
			
	static int findElement(String name[], int grade[], int n, int key)
	{
	    int i;
	    for (i = 0; i < n; i++)		//=SIZE PF THE ARRAY
	        if (grade[i] == key)
	        	return i;
	        
	    return -1;
	}
	
	//Function to delete an element
	static int deleteElement(String name[], int grade[], int n, int key)
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

public static void main(String[] args) throws IOException {
		
		
		int x,a,b;
		
		String name[] = new String[5];
		String nameOrig[] = new String[5];
		String tempName;
		
		int grade[] = new int[5];
		int gradeOrig[] = new int [5];
		int tempGrade;
		
		//Open the File
		
		FileWriter fwriter = new FileWriter("DeleteAlgo.txt", true);
		PrintWriter outputFile = new PrintWriter(fwriter);
		
		
		//date
		Date date = new Date();
		String str = String.format("	Transaction's Date/Time: %tc", date);
		
		
		//STEP 3 - Enter Data on the Array
		for(x=0; x<=4; x++)
		{
			System.out.println("Enter Name " + (x+1) + ": ");
			name[x] = input.nextLine();
			nameOrig[x] = name[x];
		
			do {
				System.out.print("Grade: " );
				grade[x] = input.nextInt();
				gradeOrig[x] = grade[x];

				
				if (grade[x]<50||grade[x]>100)
				{
					System.out.println("\tOut of Range [50 to 100 Only!]");
				}
			}while (grade[x]<50||grade[x]>100);
			input.nextLine();
			
		}
		
		//Display data on the array - Not Sorted
		
		System.out.println("==================================================|");
		outputFile.println("==================================================|");

		System.out.print("Display data on the array - Not Sorted \n");
		System.out.printf("%-15s %6s%n", "NAME", "GRADE: ");
		System.out.println("__________________________________________________|");

		
		outputFile.println("Display data on the array - Not Sorted \n");
		outputFile.printf("%-15s %6s%n", "NAME", "GRADE: ");
		outputFile.println("__________________________________________________|");


		for(x=0;x<=4;x++)
		{
			System.out.printf ("%-15s %6d%n", name[x] , grade[x]);

			System.out.println();

			outputFile.printf ("%-15s %6d%n", name[x] , grade[x]);

			outputFile.println();

			
		}
		System.out.println("==================================================|");
		outputFile.println("==================================================|");



		//Sorting
		for (a=0; a<=4;a++)
		{
			for (b=a+1; b<=4; b++)
			{
				if (name[a].compareToIgnoreCase(name[b])>0)
				{
					tempName = name[a];
					name[a] = name[b];
					name[b] = tempName;
					
					tempGrade = grade[a];
					grade[a] = grade[b];
					grade[b] = tempGrade;
				}
			}
		}
		
		//Display data on the array SORTED
		System.out.println("=============================================================================================|");
		outputFile.println("=============================================================================================|");
		
		
		System.out.print("DisplaY data on the array SORTED \t\t  \n");
		System.out.printf("%-15s %18s %20s %18s%n", "NAME:", "GRADE: ", "ORIGINAL NAME: ", "ORIGINAL GRADE: ");
		System.out.println("_________________________________________________________________________________|");
		System.out.println();

		
		outputFile.println("DisplaY data on the array SORTED \t\t  \n");
		outputFile.printf("%-15s %18s %20s %18s%n", "NAME:", "GRADE: ", "ORIGINAL NAME: ", "ORIGINAL GRADE: ");
		outputFile.println("_________________________________________________________________________________|");
		outputFile.println();

		for(x=0;x<=4;x++)
		{
			
			System.out.printf("%-15s %18s %20s %18s%n", name[x],  grade[x], nameOrig[x], gradeOrig[x]);
			System.out.println();

			outputFile.printf("%-15s %18s %20s %18s%n", name[x],  grade[x], nameOrig[x], gradeOrig[x]);
			outputFile.println();


			
		}
		
		//Delete algorithm implementation
		
		System.out.println("DELETE: \n");
		System.out.println("ENTER GRADE TO DELETE: ");
		int key = input.nextInt(); //where: key variable is the name search
		int n=grade.length;		//the n is the size of the array
		
		System.out.println("=============================================================================================|");
		outputFile.println("=============================================================================================|");
		
		
		int pos = deleteElement(name, grade, n, key);
		
				System.out.println("\n\nArray after deletion");
				for (int i = 0; i<pos; i++)
					System.out.printf("%-15s %6s%n", name[i], grade[i]);
				
				input.close();
				

				
				outputFile.close();
				System.out.print("\nData written to the file!");
	}

}




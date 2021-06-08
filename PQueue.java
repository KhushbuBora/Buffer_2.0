package buffer;
import java.util.*; 

public class PQueue {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		PriorityQueue<Person> pq = new PriorityQueue<Person>(10, new PersonComparator());
		
		int sel=0;
		int avail[]=new int[10];
		int cnt[]=new int[10];
		for(int k=0;k<10;k++)
		{
			avail[k]=2;
			cnt[k]=0;
		}


		System.out.println("***** WELCOME TO COWIN PORTAL *****");
		do {

			System.out.println("\nDo you want to?\n1.Check Vaccine Availability.\n2.Book a Slot for Vaccination.\n3.Exit.");
			sel=sc.nextInt();

			switch(sel)
			{

			case 1:
			{
				System.out.println("Vaccine Availability for next 10 days is: \n");
				System.out.println("|_______________|_______________________________|");
				System.out.println("|\tDay\t|\tNumber of Vaccines \t|");
				System.out.println("|_______________|_______________________________|");
				for(int k=0;k<10;k++)
				{
					System.out.println("|\t" + (k+1) + "\t|\t" + (avail[k]-cnt[k]) + "\t\t\t|");
					System.out.println("|_______________|_______________________________|");
				}
			}
			break;

			case 2:
			{
				System.out.println("\nEnter Number of People: ");
				int n = sc.nextInt();
				for(int i=0; i<n; i++)
				{
					Person t = new Person();
					System.out.println("\nEnter Details for Person " + (i+1) + ": ");
					System.out.println();
					t.Accept();
					if(t.age>=60 || (t.age>=45 && t.age<60 && (t.medical==true || t.fam==true)))
					{
						pq.add(t);
						System.out.println("***REGISTRATION SUCCESSFUL!***");
						System.out.println();
					}
				}

				System.out.println("Allocation of Vaccination Slots: \n");
				int in=0;                                                       //index 
				int j=41250;                                                    // just some fancy serial number;)    
				
				System.out.println("|___________________|___________________________________________|_______________________________________|_______________________|___________________|");
				System.out.println("|\tSr. no.\t    |\tRegistration Number \t\t\t|\tAadhar Number  \t\t\t|\tDay Allocated\t|\tDate\t    |");
				System.out.println("|___________________|___________________________________________|_______________________________________|_______________________|___________________|");
				
				while(!pq.isEmpty()) {

					System.out.println("|\t" + (in+1) + "\t    |\tPNQ" + (j+in) + "\t\t\t\t|\t"  + pq.peek().aadhar + "\t\t\t|\t"  + (in/2 + 1) + "\t\t|  " + "\t" + (in/2 + 1) + "/06/2021   |");
					System.out.println("|___________________|___________________________________________|_______________________________________|_______________________|___________________|");
					cnt[in/2]++;
					
					//PNQ= Pune junction code
					in++;
					pq.poll();
				}
			}
			break;
			
			case 3:
			{
				System.out.println("Exiting...\nTHANK YOU!");
			}
			break;
			
			}
		}while(sel!=3);
	}
}

package buffer;

import java.util.Scanner;

public class Person {
	Scanner sc=new  Scanner(System.in);

	String aadhar;
	boolean occupation;
	int age;
	boolean fam;
	boolean medical;

	public Person()
	{
	}

	void Accept() {

		System.out.print("Are you registering for first dose? ");
		char d=sc.next().charAt(0);
		System.out.println();
		sc.nextLine();

		if(d=='y'||d=='Y')
		{
			boolean ac=false;
			System.out.print("Enter Aadhar card number: ");
			while(!ac)
			{
				try{
					aadhar=sc.nextLine();
					System.out.println();
					if(aadhar.length()!=12)
					{
						throw new Excep("Invalid Aadhar Card Number");
					}
					ac=true;
				}catch(Exception e){
					System.out.println("Enter Valid 12-Digit Aadhar card Number");	
				}
			}
			ac=false;

			System.out.print("Are you a frontline worker? ");
			char c=sc.next().charAt(0);
			System.out.println();

			if(c=='y' || c=='Y')
			{
				occupation=true;
				age =150;
			}
			else
			{
				occupation=false;

				System.out.print("Enter age: ");
				while(!ac) {
					try {
						age=sc.nextInt();
						System.out.println();
						if(age<=0)
						{
							throw new Excep("Invalid Age");
						}
						ac=true;
					}
					catch(Exception e) {
						System.out.println("Enter Valid Age");
					}
				}

				sc.nextLine();
				if(age<45) 
				{
					System.out.println("<You are not eligible for vaccine right now>");
					System.out.println();
				}
				else 
				{
					System.out.print("Any other medical condition? ");
					char a=sc.next().charAt(0);
					System.out.println();

					if(a=='y' || a=='Y')
					{
						medical=true;
					}else
					{
						medical=false;
					}

					System.out.print("Does your family have Covid History? ");
					char b=sc.next().charAt(0);
					System.out.println();

					if(b=='y' || b=='Y')
					{
						fam=true;
					}else
					{
						fam=false;
					}

					if(age<60 && (fam==false && medical==false)) {
						System.out.println("<You are not eligible for vaccine right now>");
						System.out.println();
					}
				}
			}


		}else 
		{
			age=200;
			boolean ac=false;

			System.out.print("Enter Aadhar card number: ");
			while(!ac)
			{
				try{
					aadhar=sc.nextLine();
					System.out.println();
					if(aadhar.length()!=12)
					{
						throw new Excep("Invalid Aadhar Card Number");
					}
					ac=true;
				}catch(Exception e){
					System.out.println("Enter Valid 12-Digit Aadhar card Number");	
				}
			}
			ac=false;
		}

	}

	@SuppressWarnings("serial")
	class Excep extends Exception{
		public Excep(String s)
		{
			// Call constructor of parent Exception
			super(s);
		}
	}
}
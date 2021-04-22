import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Rail
{
static String[] S={"again"};
int choice2=0;
int No;
int Price;
boolean checkname;
int checkname2;
int choice3;
int Dest;
int TPrice=0;
int checkage2=1;
String again;
String Name[]=new String[75];
int Age[]=new int[75];
String classes[]=new String[75];
String Subclasses[]=new String[75];
int DestP[]=new int[75];
String Destination[]=new String[75];
int OPrice[]=new int[75];
int PassengerId[]=new int[75];

void book()throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("\nSelect your class");
	System.out.println(" 1. AC \n 2. Reservation \n 3. Generalized \n 4. Back");
	System.out.print("enter your class:");
	try
	{
		choice2=Integer.parseInt(br.readLine());
		do
		{
			switch(choice2)
			{
			case 1:AC();
			break;
			case 2:Reservation();
			break;
			case 3:Generalized();
			break;
			case 4: System.exit(0);;
			break;
			default:System.out.println("please Select valid class to continue!");
			break;
			}
		}while(choice2==4);
	}
	catch(NumberFormatException e)
	{
		System.out.print("invalid class!:");
		System.out.println("Do you want to continue:Y/N");
		again=br.readLine();
		if(again.equals("Y"))
		{
			book();
		}
		else if(again.equals("y"))
		{
			book();
		}
		else
		{
			System.exit(0);;
		}
	}
}

public static boolean isStringOnlyAlphabet(String str) 
{ 
	return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$"))); 
} 


void innerbooking(int No,int Price)throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int no=No;
	int price=Price;
	for(int i=1;i<=no;i++)
	{
		do
		{
			System.out.print("\nEnter the name of "+i+" passenger:");
			Name[i]=br.readLine();
			checkname=isStringOnlyAlphabet(Name[i]);
			if(checkname)
			{
				break;
			}
			else
			{
				System.out.println("enter valid name!");
			}
			checkname2=Boolean.compare(checkname,true);
		}while(checkname2<=0);
		do
		{
			System.out.print("Enter your age:");
			try
			{
				checkage2=1;
				Age[i]=Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("invalid Age!");
				checkage2=0;
			}
		}while(checkage2<=0);
		System.out.println("Select your destination");
		System.out.println("1.Igatpuri \n2.Kalyan \n3.Thane \n4.Mumbai");
		System.out.print("enter your choice:");
		Dest=Integer.parseInt(br.readLine());
		switch(Dest)
			{
			case 1:System.out.println("Igatpuri");
			Destination[i]="Igatpuri";
			DestP[i]=100;
			break;
			case 2:System.out.println("Kalyan");
			Destination[i]="Kalyan";
			DestP[i]=300;
			break;
			case 3:System.out.println("Thane");
			Destination[i]="Thane";
			DestP[i]=500;
			break;
			case 4:System.out.println("Mumbai");
			Destination[i]="Mumbai";
			DestP[i]=700;
			break;
			default:System.out.println("enter correct destination");
			break;
		}
	}
	System.out.print("Confirm your Ticket:Y/N:");
	String Confirm=br.readLine();
	if(Confirm.equals("Y"))
	{
		System.out.println("Ticket Confirmed");
	}
	else if(Confirm.equals("y"))
	{
		System.out.println("Ticket Confirmed");
	}
	else
	{
		System.out.println("Booking Canceled");
		System.exit(0);;
	}
	for(int i=1;i<=no;i++)
	{
		OPrice[i]=(price+DestP[i]);
		TPrice+=OPrice[i];
		PassengerId[i]=i;
		System.out.println("Passenger id:"+PassengerId[i]);
	}
	System.out.println("Total cost:"+TPrice);
}

void AC() throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	do
	{
		try
		{
			System.out.println("\nSelect the sub class of ticket");
			System.out.println(" 1. AC First Class \n 2. AC 2-Tier class\n 3. AC 3-Tier class \n 4. First class \n 5. Exit");
			System.out.print("enter your sub-class:");
			for(int i=0;i<75;i++)
			{
				classes[i]="AC";
			}
			choice3=Integer.parseInt(br.readLine());
			switch(choice3)
			{
				case 1: System.out.println("This is Ac first class");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				Price=3000;
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="Ac first class";
				}
				innerbooking(No,Price);
				break;

				case 2:System.out.println("This is AC 2-Tier class");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				Price=2500;
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="Ac 2-Tier class";
				}
				innerbooking(No,Price);
				break;

				case 3:System.out.println("This is AC 3-Tier class");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				Price=2000;
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="Ac 3-Tier class";
				}
				innerbooking(No,Price);
				break;

				case 4:System.out.println("This is first class");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				Price=3500;
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="first class";
				}
				innerbooking(No,Price);
				break;

				case 5:	System.exit(0);;
				break;
		
				default:System.out.println("please Select valid sub class to continue!");
				break;
			}
		}
		catch(NumberFormatException e)
		{
			System.out.print("invalid class!:");
			System.out.println("Do you want to continue:Y/N");
			String again=br.readLine();
			if(again.equals("Y"))
			{
				AC();
			}
			else if(again.equals("y"))
			{
				AC();
			}
			else
			{
				System.exit(0);;
			}
		}
	}while(choice2==5);
}

void Reservation() throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	do
	{
		try
		{
			System.out.println("\nSelect the class of ticket");
			System.out.println(" 1. Reserved class \n 2. Executive chair Class \n 3. Second seater class \n 4. Exit");
			System.out.print("enter your sub-class:");
			choice3=Integer.parseInt(br.readLine());
			for(int i=0;i<75;i++)
			{
				classes[i]="Reservation class";
			}
			switch(choice3)
			{
				case 1: System.out.println("This is Reserved class ");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="Reserved class";
				}
				Price=1500;
				innerbooking(No,Price);
				break;

				case 2:System.out.println("This is Executive chair class");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				Price=1000;
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="Executive chair class";
				}
				innerbooking(No,Price);
				break;

				case 3:System.out.println("This is Second seater class");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				Price=1200;
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="Second seater class";
				}
				innerbooking(No,Price);
				break;

				case 4: System.exit(0);;
						break;

				default:System.out.println("please Select valid sub class to continue!");
				break;
			}
		}
		catch(NumberFormatException e)
		{
			System.out.print("invalid class!:");
			System.out.println("Do you want to continue:Y/N");
			again=br.readLine();
			if(again.equals("Y"))
			{
				Reservation();
			}
			else if(again.equals("y"))
			{
				Reservation();
			}
			else
			{
				System.exit(0);;
			}
		}
	}while(choice3==4);
}

void Generalized()throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	do
	{
		try
		{
			System.out.println("\nSelect the class of ticket");
			System.out.println(" 1. General class \n 2. Sleeper tier class \n 3. Exit");
			System.out.print("enter your sub-class:");
			choice3=Integer.parseInt(br.readLine());
			for(int i=0;i<75;i++)
			{
				classes[i]="Generalized class";
			}
			switch(choice3)
				{
				case 1: System.out.println("This is General class ");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				Price=500;
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="General class";
				}
				innerbooking(No,Price);
				break;

				case 2:System.out.println("This is Sleeper tier class");
				System.out.print("\nenter number of tickets:");
				No=Integer.parseInt(br.readLine());
				Price=300;
				for(int i=0;i<75;i++)
				{
					Subclasses[i]="sleeper tier class";
				}
				innerbooking(No,Price);break;

				case 3:	System.exit(0);;
				break;
				
				default:System.out.println("please Select valid sub class to continue!");
				break;
			}
		}
		catch(NumberFormatException e)
		{
			System.out.print("invalid class!:");
			System.out.println("Do you want to continue:Y/N");
			again=br.readLine();
			if(again.equals("Y"))
			{
				Generalized();
			}
			else if(again.equals("y"))
			{
				Generalized();
			}
			else
			{
				System.exit(0);;
			}
		}
	}while(choice3==3);
}

void display(int No)
{
	int no=No;
	System.out.println("********Information of all passangers********");
	for(int i=1;i<=no;i++)
	{
		System.out.println("********"+i+"********");
		System.out.println("Name:"+Name[i]);
		System.out.println("Age:"+Age[i]);
		System.out.println("Destination:"+Destination[i]);
		System.out.println("OPrice:"+OPrice[i]);
		System.out.println("Class:"+classes[i]);
		System.out.println("subclass:"+Subclasses[i]);
		System.out.println("PassengerId:"+PassengerId[i]);
	}
}

void cancel(int No) throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.print("enter your passenger Id:");
	int delete=Integer.parseInt(br.readLine());
	int no=No;
	System.out.print("Are you sure Y/N:");
	String Confirm=br.readLine();
	if(Confirm.equals("Y"))
	{
		System.out.println("Ticket Canceled");
	}
	else if(Confirm.equals("y"))
	{
		System.out.println("Ticket Canceled");
	}
	else
	{
		System.out.println("operation Canceled");
		System.exit(0);;
	}
	for(int i=delete;i<=no;i++)
	{
		Name[i]=Name[i+1];
		Age[i]=Age[i+1];
		classes[i]= classes[i+1];
		Subclasses[i]=Subclasses[i+1];
		DestP[i]=DestP[i+1];
		Destination[i]=Destination[i+1];
		OPrice[i]=OPrice[i+1];
		PassengerId[i]=PassengerId[i+1];
	}
}

public static void main(String args[])throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Rail obj= new Rail();
	int choice1;
	do
	{
		try
		{
			System.out.println("******** Railway Reservation System ********");
			System.out.println("1.Booking \n2.Stats \n3.Cancel");
			System.out.print("Enter your choice:");
			choice1=Integer.parseInt(br.readLine());
			switch(choice1)
			{
				case 1:obj.book();
				break;
				case 2:obj.display(obj.No);
				break;
				case 3:obj.cancel(obj.No);
				break;
			}
		}
		catch(NumberFormatException e)
		{
			System.out.print("invalid choice!:");
			System.out.println("Do you want to try again:Y/N");
			String again=br.readLine();
			if(again.equals("Y"))
			{
				main(S);
			}
			else if(again.equals("y"))
			{
				main(S);
			}
			else
			{
			System.exit(0);
			}
			}
	}while(true);
}
}
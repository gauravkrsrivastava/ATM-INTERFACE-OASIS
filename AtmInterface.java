import java.util.Scanner;

class BankApp
{
	String account_no;
	String name;
	String acType;
	Double balance;
	Scanner sc = new Scanner(System.in);

	public void OpenAccount()
	{
		System.out.print("Enter the account Number: ");
		account_no = sc.next();
		System.out.print("Enter the Holder Name: ");
		name = sc.next();
		System.out.print("Enter the Account Type: ");
		acType = sc.next();
		System.out.print("Enter the Balance: ");
		balance = sc.nextDouble();
		System.out.println("Congrats Your Account is Created and your account number is "+account_no);
	}
	public void deposite()
	{
		System.out.print("Enter the amount Do you want to deposite: ");
		double amt = sc.nextDouble();
		balance = balance + amt;
		System.out.print("Your "+amt+" deposited");
	}
	public void withdraw()
	{
		System.out.print("Enter the amount :");
		double amt = sc.nextDouble();
		if(balance>=amt)
		{
			balance = balance - amt;
		    System.out.print("Your "+amt+" Withdraw");
		}else{
			System.out.print("Your balance is less than "+amt+" Transition faild");
		}
	}
	public void transfer()
	{
		System.out.println("Enter the amount Do You Want to Transfer :");
		double amt = sc.nextDouble();
		if(balance>=amt)
		{
			if(amt<=50000)
			{
				balance = balance + amt;
				System.out.println("Your "+amt+" is Successfully Transfer");
			}
			else{
				System.out.println("Sorry...Limit is 50000.0");
			}
		}else{
			System.out.println("Insufficient Balance...");
		}
	}

	public void showAccount()
	{
		System.out.println("----------------------------------------------------------");
		System.out.println("Name of Account Holder: "+name);
		System.out.println("Account Number: "+account_no);
		System.out.println("Account Type: "+acType);
		System.out.println("Balance: "+balance);
		System.out.println("----------------------------------------------------------");
	}
	public boolean search(String ac_no)
	{
		if(account_no.equals(ac_no))
		{
			showAccount();
			return(true);
		}
		return(false);
	}
}
class AtmInterface
{

	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("How Many Number Of Customer Do you want to Input :");
		int n = sc.nextInt();
		BankApp C[] = new BankApp[n];
		for(int i=0;i<C.length;i++)
		{
			C[i] = new BankApp();
			C[i].OpenAccount();
		}
		int choice;
		do
		{
			System.out.println("\n");
			System.out.println("========================");
			System.out.println("Welcome to Atm Interface");
			System.out.println("==========================");
			System.out.println("1.Open Account");
			System.out.println("2.Deposite");
			System.out.println("3.Withdrawal");
			System.out.println("4.Transfer Money");
			System.out.println("5.Transection History");
			System.out.println("0.Exit Atm");
			System.out.print("Enter your choice here: ");
			choice = sc.nextInt();
			if(choice==0)
			{
				break;
			}
			if(choice==1)
			{
				for(int i=0;i<C.length;i++)
				{
					C[i].OpenAccount();
				}
				break;
			}
			else if(choice==2)
			{
				System.out.print("Enter account no: ");
				String ac_no = sc.next();
				boolean found = false;
				for(int i=0;i<C.length;i++)
				{
					found = C[i].search(ac_no);
					if(found)
					{
						C[i].deposite();
					}
				}
				if(!found)
				{
					System.out.println("Account dosent Exit....");
				}
			}
			else if(choice==3)
			{
				System.out.print("Enter account no: ");
				String ac_no = sc.next();
				boolean found = false;
				for(int i=0;i<C.length;i++)
				{
					found = C[i].search(ac_no);
					if(found)
					{
						C[i].withdraw();
					}
				}
				if(!found)
				{
					System.out.println("Account doesnt Exit....");
				}
			}
			else if(choice==4)
			{
				System.out.print("Enter account no: ");
				String ac_no = sc.next();
				boolean found = false;
				for(int i=0;i<C.length;i++)
				{
				found = C[i].search(ac_no);
					if(found)
					{
						C[i].transfer();
					}
				}
				if(!found)
				{
					System.out.println("Account doesnt Exit....");
				}
			}
			else if(choice==5)
			{
				for(int i=0;i<C.length;i++)
				{
					C[i].showAccount();
				}
			}
		}
		while(choice!=0);
	}
}
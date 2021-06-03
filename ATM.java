//Sourcecode to implement the ATM Functionality:



import java.util.Scanner;
public class ATM 
{
// Initializing variables that stores the values of account details
private String [] users = {"Chaithra","Drishya","Arun"};
private String [] password = {"9816","0987","4321"};
private int [] money = {50000,25000,75000};
private String [] phone = {"9526440580","9847179222","9037463473"};
private String yes = "yes";
private int x = 0;

//Method to check whether the username and password are valid
boolean login(String loginusre,String loginpass)
{
for(int i = 0;i<users.length;i++)
{
if(loginusre.equals(users[i])&&loginpass.equals(password[i]))
{
x = (i);
return true;
}
}
return false;
}

// Method to Withdraw an amount
void accbal()
{
Scanner sc5 = new Scanner(System.in);
System.out.print("Please Enter the Amount you want to Withdraw");
int accbal = sc5.nextInt();
if(accbal <= money[x]) 
{
    money[x] = money[x] - accbal;
    System.out.println("Amount Withdrawn is"+accbal);
    System.out.println("The Current Balance is "+money[x]);
}
else 
{
    System.out.println("Insufficient balance!!!Please enter a lesser amount and try again");
}
}

//Function to deposit an amount
void depos() 
{
Scanner sc4 = new Scanner(System.in);
System.out.print("Please enter the amount to deposit:");
int depos = sc4.nextInt();
money[x] = money[x] + depos;
System.out.println("The Amount "+depos+" has been Deposited successfully!");
System.out.println("The Current Balance is:"+money[x]);
}

// Function to Transfer money
void tras()
{
Scanner sc1 = new Scanner(System.in);
System.out.println("Please enter the mobile phone number of the User you have to transfer money:");
String phone1 = sc1.next();
System.out.println("Please enter the Amount to be transfered:");
int c = sc1.nextInt();
for(int i = 0;i<=phone.length;i++)
{
if(phone1.equals(phone[i]))
{
if(i!= x)
{
if(c <= money[x])
{
System.out.println("Please confirm the account Name of the user:"+users[i]);
System.out.println("Are you sure to continue: yes / no?");
String yesNo = sc1.next();
if(yesNo.equals(yes))
{
money[i] = money[i]+c;
System.out.println("Amount Transfer is successful!");
money[x]= money[x]-c;
System.out.println("Your current balance is:"+money[x]);
break;
}
else 
{
System.out.println("!!! Amount Transfer failed !!!");
System.out.println("Your current balance is:"+money[x]);
break;
}
}
else 
{
System.out.println("Transfer has failed due to insufficient balance!!");
break;
}
}
else
{
System.out.println("You Cannot transfer money to yourself! Please enter the phone number of the user whom you have to transfer money.");
break;
}
}
else if(i == 2)
{
System.out.println("The phone number you entered is incorrect or not in the bank directory!Please try with another number.");
break;
}
}
}
// Function to Display balance
void bal() 
{
System.out.println("Your current balance is:"+money[x]);
}
// Main method
public static void main(String[]args)
{
ATM atm = new ATM();
Scanner sc = new Scanner(System.in);
System.out.println(":-:-:-:-:-:-:-:-:-:-:-: Popular Bank :-:-:-:-:-:-:-:-:-:-:-:");
int i;
int number;
try
{
for(i = 1;i <= 3;i++) 
{
System.out.print("Please enter the user name:");
String user= sc.next();
//enter password
System.out.print("Please enter your password:");
String pass= sc.next();
while(atm.login(user, pass))
{
if(atm.login(user, pass))
{
System.out.println("***********************");
System.out.println(" 1. CASH WITHDRAWAL ");
System.out.println(" 2. CASH DEPOSIT ");
System.out.println(" 3. TRANSFER");
System.out.println(" 4. BALANCE INQUIRY ");
System.out.println(" 5. EXIT ");
System.out.println("***********************");
System.out.print("Select any one option:");
number = sc.nextInt();
//Select requirement as per switch condition
switch(number)
{
//calling withdraw function
case 1:atm.accbal();
break;
//calling deposit function
case 2:atm.depos();
break;
//calling transfer function
case 3:atm.tras();
break;
//calling display function
case 4:atm.bal();
break;
// Exit, output statement
case 5:System.out.print("Thank you for visting");
return;
}
}
}
if(i<3)
{
System.out.println("Wrong user name or password.Please re-enter");
}
else{
System.out.println("Sorry!You have entered the wrong credentials 3 times. Please try again later or contact the Bank");
break;
}
}
}
catch(Exception e)
{
System.out.println("Exception "+e);
}
}
}

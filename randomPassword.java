//Program to generate a random password of 8-15 characters that has atleast: one special character, one digit, one upper and one lower case character AND the first character shouldn't be a number.
import java.util.Scanner;
public class randomPassword
{
    int password_length;
    int sp,uc,lc,dig;
    Scanner sc=new Scanner(System.in);
    public void generateValues() 
    {
        int sum=0;
        password_length = (int)(8+(Math.random()*8)); //Calculates length of password
        System.out.print("Would you give preference to-\n1.Lower Case characters\n2.Random characters\n->");
        byte pref=sc.nextByte();
        if(pref==1) //gives prefrence to lower case by allowing a wider probability of getting a higher number of characters
        {
            lc= (int)(1+(Math.random()*(password_length-3)));
            uc = (int)(1+(Math.random()*(password_length-(lc+2))));
            dig = (int)(1+(Math.random()*(password_length-(uc+lc+1))));
            sp = (int)(1+(Math.random()*(password_length-(dig+lc+uc))));
            System.out.println("lowChar:"+ lc +" upChar: "+uc+" dig: "+dig+" spChar: "+ sp);
        }
        else if(pref==2) //gives equal prefence to all until it matches password length
        {
            while(sum!=password_length) {
                lc= (int)(1+(Math.random()*(password_length)));
                uc = (int)(1+(Math.random()*(password_length)));
                dig = (int)(1+(Math.random()*(password_length)));
                sp = (int)(1+(Math.random()*(password_length)));
                sum = lc+uc+dig+sp;
            }
            System.out.println("lc:"+ lc +" uc: "+uc+" dig: "+dig+" sp: "+ sp);
        }
        else
        {
            System.out.println("Wrong Input. Try again.\n");
            String ar[]={};
            main(ar);
            System.exit(0);
        }
    }
    char[] generateChar() 
    {
        char arr[]=new char[password_length];
        int j =0;
        for(int i=0;i<uc;i++) //upper char loop
        {
            arr[j++]=(char)((int)(65+(Math.random()*25)));
        }
        for(int i=0;i<lc;i++) //lower char loop
        {
            arr[j++]=(char)((int)(97+(Math.random()*25)));
        }
        for(int i=0;i<dig;i++) //digit loop
        {
            arr[j++]=(char)(48+(int)(Math.random()*9));
        }
        for(int i=0;i<sp;i++) //SPECIAL char loop
        {
            arr[j++]=specialGenerate();
        }
        return arr;
    }
    void displayPassword(char arr[])
    {   
        int chosenIndex;
        String password="";
        for(int i=0;i<password_length;i++) 
        {
            chosenIndex= (int)(Math.random()*password_length);
            if(arr[chosenIndex]==32) 
            {
                i--;
                continue;
            }
            password+=arr[chosenIndex];
            if(i==0)
            {
                if(Character.isDigit(password.charAt(0)))
                {
                    password="";
                    i--;
                    continue;
                }
            }
            arr[chosenIndex]=32;
        }
        System.out.println("------------------------");
        System.out.print("Your randomly generated strong password is: "+password);
    }
    
    public char specialGenerate()
    {
        char spchar[]= {'!','@','#','$','&','_','.'};
        byte spIndex = (byte)(Math.random()*7);
        return spchar[spIndex];
    }
    
    public static void main(String ar[])
    {
        randomPassword obj = new randomPassword();
        for(boolean loop=true;loop==true;)
        {
            obj.generateValues();
            System.out.println("Password length:"+obj.password_length);
            char arr[]=obj.generateChar();
            obj.displayPassword(arr);
            
            System.out.println("\n------------------------");
            System.out.print("Do you want to generate another password?\n1.Yes\n2.No\n->");
            byte choice=obj.sc.nextByte();
            System.out.println();
            switch(choice)
            {
                case 1:
                    continue;
                case 2:
                    loop=false;
                    obj.sc.close();
                    System.out.print("\nThanks for using our password generator :)\n-Arshiya Sharma and Keya Aggarwal");
                    break;
                default:
                    System.out.print("Invalid input. Try again.\n\n");
            }
        }
    }
}
//By Arshiya Sharma and Keya Aggarwal

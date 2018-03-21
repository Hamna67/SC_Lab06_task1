/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc_lab06_task1;
import java.util.Scanner;
/**
 *
 * @author ABC
 */
public class SC_Lab06_Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //variables for gettting input from user
        String name;
        String regNo;
        String cpga;
        
        //getting input from user
        Scanner input = new Scanner(System.in);
        

        
        String[][] data = new String[6][3];
        initialize(data);
        
        for(int i=0; i< 6; i++)
        {
            System.out.println("----STUDENT #"+i+"----");
            //taking input name
            System.out.println("Enter name:");
            name = input.nextLine();
            data[i][0] = name;
            
            //taking registration number input
            System.out.println("Enter Registration Number:");
            regNo = input.nextLine();
            while(checkDuplicate(data,regNo) == false)
            {
                System.out.println("Registration Number already exists, enter another:");
                regNo = input.nextLine();
                
            }
            
            data[i][1] = regNo;
            
            //taking cgpa input
            System.out.println("Enter CGPA:");
            cpga = input.nextLine();
            while(checkFormatGPA(cpga) == false)
            {
                System.out.println("Invalid CPA, enter anther:");
                cpga = input.nextLine();
            }
            data[i][2] = cpga;
           
        }
        
        print(data);
        System.out.println("Enter name/registration number of a student:");
        String x = input.nextLine();
        Rank(data,x);
     //   

        
    }
    
    public static boolean checkDuplicate(String[][] data,String r)
    {
         boolean result = true;
        for(int i=0; i<6;i++)
        {
            if(data[i][1].equals(r))
            {
                result =false;
                break;
            }
        }
        return result;
        
        
    }
    
    public static void initialize(String[][] data)
    {
        for(int i = 0; i<6; i++)
        {
            for(int j=0; j<3;j++ )
            {
                data[i][j] = "";
            }
        }
    }
    
    public static boolean checkFormatGPA(String g)
    {
        boolean result = true;
        try 
        {
            Double gpa = Double.parseDouble(g);
            if(gpa < 0 || gpa >4.0)
            {
                result = false;
            }
        }
        catch(Exception e)
        {
            result = false;
        }
        
        return result;
    }
    
    public static void print(String[][] data)
    {
        for(int i = 0; i<6;i++)
        {
            System.out.println("-------------Student #"+i+ "-------------");
            
            System.out.println("Name:                " + data[i][0]);
            System.out.println("Registration Number: " + data[i][1]);
            System.out.println("CGPA:                " + data[i][2]);
        }
        
        System.out.println("MINIMUM CPGA: " + minGPA(data));
        System.out.println("MAXIMUM CPGA: " + maxGPA(data));
        System.out.print("AVERAGE CPGA: " );
        System.out.printf("%.2f", avgGPA(data));
        System.out.println();
        printLessAvg(data,avgGPA(data));
       
    }
    
    public static double minGPA(String[][] data)
    {
        double min=4.0;
        double g = 4.0;
        for(int i =0; i<6; i++)
        {
            g=Double.parseDouble(data[i][2]);
            if( g< min)
            {
                min = g;
            }
        }
        return min;
    }
    
    public static double maxGPA(String[][] data)
    {
        double max=0;
        double g = 0;
        for(int i =0; i<6; i++)
        {
            g=Double.parseDouble(data[i][2]);
            if( g> max)
            {
                max = g;
            }
        }
        return max;
    }
    
    public static double avgGPA(String[][] data)
    {
        double sum=0;
        double avg =0;
        for(int i =0; i < 6;i++)
        {
            sum += Double.parseDouble(data[i][2]);
            
        }
        avg = sum/6;
     
        return avg;
        
    }
    
    public static void printLessAvg(String[][] data,double g)
    {
        System.out.println("Students with less than average CGPA are:");
        for(int i =0; i < 6; i++)
        {
            if(Double.parseDouble(data[i][2]) < g)
            {
                   System.out.println(data[i][0]);
            }
        }
    }
    
    public static void Rank(String[][] data,String x)
    {
        boolean result = false;
        for(int i=0; i< 6;i++)
        {
            if(data[i][1].equals(x) || data[i][0].equals(x))
            {
                result = true;
                System.out.println("Student is available!");
                System.out.println("CGPA: " + data[i][2]);
                int count = 0;
                for(int j=0; j < 6 ;j++)
                {
                    if(Double.parseDouble(data[i][2]) < Double.parseDouble(data[j][2]))
                    {
                        count++;
                    }
                }
                count++;
                System.out.println("Student rank is:" + count);
                
                
            }
          
        }
        
        if(result == false)
        {
            System.out.println("Student is NOT available!");

        }
    }

}

import java.io.*;
class CricketPlayer
{
	int no_of_innings;
    int no_times_notout;
    int tot_runs;
    float bat_avg;
    String name;
    
    void avg()
    {
    	try
    	{
        	bat_avg = tot_runs/(no_of_innings - no_times_notout);
        }
        catch(ArithmeticException ae)
        {
        	System.out.println("Cannot divide by zero");
        }
	}
    
    static void sortPlayer(int n,CricketPlayer c[])
    {
    	CricketPlayer temp = new CricketPlayer();
        int i,j;
        for(j=0;j<n;j++)
        {
            for(i=0;i<n;i++)
            {
            	if(c[j].bat_avg>c[i].bat_avg)
                {
                	temp=c[j];
                    c[j]=c[i];
                    c[i]=temp;
				}
			}
		}
	}
    
    void accept()
    {
    	try
    	{
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the following details of player : ");
            System.out.print("Name : ");
            name=br.readLine();
            System.out.print("No. of Innings : ");
            no_of_innings=Integer.parseInt(br.readLine());
            System.out.print("No. of times Not Out : ");
            no_times_notout=Integer.parseInt(br.readLine());
            System.out.print("Total runs : ");
            tot_runs=Integer.parseInt(br.readLine());
            avg();
		}
		catch(Exception e){    }
	}
    
    void display()
    {
    	System.out.println("Details of player are : ");
        System.out.println("Name : "+name);
        System.out.println("No. of innings : "+no_of_innings);
        System.out.println("No. of times notout : "+no_times_notout);
        System.out.println("Total runs : "+tot_runs);
        System.out.println("Bating average : "+bat_avg);
	}
}

public class Slip16_1
{
	public static void main(String[] args) throws IOException
    {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i;
        System.out.print("Enter no of players:");
        int n=Integer.parseInt(br.readLine());
        CricketPlayer cp[]=new CricketPlayer[n];
        for(i=0;i<n;i++)
        {
        	cp[i]=new CricketPlayer();
        }
        for(i=0;i<n;i++)
        {
        	cp[i].accept();
        }
        CricketPlayer.sortPlayer(n,cp);
        for(i=0;i<n;i++)
        {
			cp[i].display();
        }
	}
}


import java.util.*;
import java.io.*;

public class Cosine 
{
	public static void main(String[] args) 
	{
		try 
		{
			int i,j;
			BufferedReader br = new BufferedReader(new FileReader("palak.txt"));
			BufferedReader br1 = new BufferedReader(new FileReader("palak1.txt"));
			
			String s1, s2,p="", q="";
			
			while((s1=br.readLine())!= null) 
			{
				p+=s1;
                p=p.toLowerCase();
			}
			String ars1 [] = p.split(" ");
			
			
			while((s2=br1.readLine())!= null) 
			{
				q+=s2;
                q=q.toLowerCase();
			}
			String ars2 [] = q.split(" ");

			Arrays.sort(ars1);
			Arrays.sort(ars2);
			
			System.out.println("file 1");
			for(i=0;i<ars1.length;i++)
			System.out.println(ars1[i]);
			System.out.println("file 2");
			for(i=0;i<ars2.length;i++)
			System.out.println(ars2[i]);
			
			String an1[] = new String[ars1.length];
			String an2[] = new String [ars2.length];
			int C1[] = new int[ars1.length];
			int C2[] = new int [ars2.length];
			
			System.out.println("\n file1 frequency \n");
			//selection of unique words in file
			int x1=0, i1=0, count=0;
            double xbar=0.0, ybar=0.0, prod=0.0, result=0.0;
			
            try
			{
				while(i1<ars1.length)
				{
					an1[i1]=ars1[x1];
					for(j=x1;j<ars1.length;j++)
					{   
						if(an1[i1].equals(ars1[j]))
						{
							count++;
						}
					}
						C1[i1] = count;
					x1+=count;
					count = 0;
					i1++;
				}	
			}
			catch (Exception e)
			{
				System.out.println("error in f1 "+e);
			}
                        
                        
			System.out.println("\n\n file2 frequency");
			i1=0; x1=0;
			try
			{
				while(i1<ars2.length)
				{
					an2[i1]=ars2[x1];
					for(j=x1;j<ars2.length;j++)
					{
						if(an2[i1].equals(ars2[j]))
						{
							count++;
						}
					}
					C2[i1] = count;
					x1+=count;
					count = 0;
					i1++;
				}
			}
			catch (Exception e)
			{
				System.out.println("file2 exceptions: "+e);
			}
                        
			//printing common words
			System.out.println("file1: ");
			for(i=0;i<an1.length;i++)
			{
				System.out.print("word: "+an1[i]);
				System.out.print("\t count: "+C1[i]+"\n");
				xbar += Math.pow(C1[i], 2);
			}   
			xbar = Math.sqrt(xbar);
			System.out.println("required xbar: "+ xbar);
			
			System.out.println("\n\nfile2: ");
			for(i=0;i<an2.length;i++)
			{
				System.out.print("word: "+an2[i]);
				System.out.print("\t count: "+C2[i]+"\n");
				ybar += Math.pow(C2[i], 2);
			}
			ybar = Math.sqrt(ybar);
			System.out.println("required ybar: "+ ybar);
			
			//numerator of similarity
			int a;
			a = an1.length>an2.length?an2.length:an1.length;
			
			for(i=0;i<a;i++)
			{
				for(j=0;j<a;j++)
				{
					if(an1[i].equals(an2[j]))
					{
						prod += C1[i]*C2[j];
					}       
				}
			}		
			result = prod/(xbar*ybar);
			System.out.println("Required cosine similarity is: "+result);
		}

		catch(Exception e)
		{
		System.out.println(e);
		}
	}
}
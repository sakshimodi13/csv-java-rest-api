package com.example.demo.Reader;

import java.io.*;
import java.util.ArrayList;

public class CSVReaderWriter {
	
	public static void main(String[] args) throws IOException
    {      
    ArrayList<String> list = new ArrayList<String>();
    try
    {
    	BufferedReader br1 = new BufferedReader(new FileReader( "c:\\Assignment\\gaussian.csv"));
    	BufferedReader br2 = new BufferedReader(new FileReader( "c:\\Assignment\\iris.csv"));
    	BufferedReader br3 = new BufferedReader(new FileReader( "c:\\Assignment\\multi.csv"));
         String s1 =null;
         String s2 = null;
         String s3 = null;

                      while ((s1 = br1.readLine()) != null)
                      {                         
                                     list.add(s1);        
                      }
                      while((s2 = br2.readLine()) != null)
                      {    
                                     list.add(s2);    
                      } 
                      while((s3 = br3.readLine()) != null)
                      {    
                                     list.add(s3);    
                      } 
    }
     catch (IOException e)
       {
         e.printStackTrace();
       }

        BufferedWriter writer=null;
        writer = new BufferedWriter(new FileWriter("c:\\Assignment\\final.csv"));
         String listWord;              
                for (int i = 0; i< list.size(); i++)
               {
                     listWord = list.get(i);
                    writer.write(listWord);
                    writer.write("\n");
               }
                     
                        writer.close();    
     }

}

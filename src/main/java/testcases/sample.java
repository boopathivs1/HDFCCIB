package testcases;

import org.hamcrest.core.IsNull;

public class sample {
	
	public static void main(String[] args)
	{
		String reference ="Payment initiated successfully and pending for Authorization -FT104057658728";
		
		String finalvalue="";
		String expected="";
		for(int i=0; i<reference.length();i++)
		{
			char  c = reference.charAt(i);
			
			if(Character.isDigit(c))
			{
				finalvalue=finalvalue+c;
			}
	}
		expected="FT"+finalvalue;
		
		System.out.println(expected);
	}

}

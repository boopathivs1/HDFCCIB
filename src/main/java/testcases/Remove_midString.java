package testcases;

public class Remove_midString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "02319319000070000000000001";
String s = null;
String t=null;
String	p=null;		
try{
//			  s=a.substring(0, a.length() - 2);
	
			  s=a.substring(0,8);
			  t=a.substring(12,26);
			p="abcd";
			
			System.out.println(s);
	  System.out.println(t);
	//  System.out.println(s+p+t);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	
	    
	  
		
		

	}

}

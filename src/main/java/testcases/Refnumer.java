package testcases;

public class Refnumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String a=regvalue("Payments Saved  Successfully -FT103267653205");
	
		
		   System.out.println(a.substring(25,39));//Sachin  

		System.out.println(a);
	}
	
	public static String regvalue(String Accno){
		String Accnumber = null;
		try{
	String userAccNo= Accno;   
	userAccNo = userAccNo.replaceAll("[^a-zA-Z0-9]", " ");  
	Accnumber = userAccNo .replaceAll("\\s","");
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		return Accnumber;
	}


}

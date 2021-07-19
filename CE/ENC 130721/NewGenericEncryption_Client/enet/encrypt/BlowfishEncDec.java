// @author Raguvaran
package enet.encrypt;

import java.security.Security;
import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import java.io.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class BlowfishEncDec
{
    private static Cipher cipher = null;     
    private static SecretKeySpec secretkey256;
    private static final String ALGORITHM = "Blowfish";
    
   /*                              javax.crypto.IllegalBlockException
    *                              javax.crypto.BadPaddingException
    *                              java.securty.InvalidKeyException
    */

   public static String enc(String PlainText) 
   {
   
        String cipherText="";
		 try{          					   
				  Security.addProvider(new com.sun.crypto.provider.SunJCE());
				  
				  KeyGenerator keyGenerator =   KeyGenerator.getInstance(ALGORITHM);
				  keyGenerator.init(256);
				  SecretKey secretKey = keyGenerator.generateKey();
				  
				  secretkey256 	= new SecretKeySpec(("d97ad16d".getBytes()),ALGORITHM);
				  cipher =  Cipher.getInstance("Blowfish/CBC/PKCS5Padding"); 	 
				  
				  byte[] ivBytes = new byte[] { 25, 117, 68, 23, 99, 78, (byte)231, (byte)219 };
				  IvParameterSpec iv = new IvParameterSpec(ivBytes);          	    					   
				  

				  System.out.println("going ENCRYPTION");

				  cipher.init(Cipher.ENCRYPT_MODE, secretkey256,iv);	
				  byte[] bytes=PlainText.getBytes("UTF-8");
				  byte[] cipherBytes = cipher.doFinal(bytes);
				  cipherText = Base64.encode(cipherBytes); 

			 } 
			 catch(Exception e){
 			 System.out.println("going exp");
    	     e.printStackTrace();
			 }
			  return cipherText;
 }
 }
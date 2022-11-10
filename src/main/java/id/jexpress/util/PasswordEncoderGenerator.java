/**
 * 
 */
package id.jexpress.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

/**
 * @author j-express.id - ambrosius
 * 26 Mei 2016
 * @Updated j-express.id - dwiki
 * 14 Des 2017
 */
@Component("encoder")
public class PasswordEncoderGenerator {
	
    public static String getEncodeGen(String password) {
    	String result = "";
        MessageDigest messageDigest;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes("UTF8"));
            byte message[] = messageDigest.digest();

            for (int i = 0; i < message.length; i++) {
                result += Integer.toHexString((0x000000ff & message[i]) | 0xffffff00).substring(6);
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncoderGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PasswordEncoderGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
    public static String getEncodeGenMD5(String password) {
    	
    	MessageDigest md;
    	String passEncode = null;
    	try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes("UTF8"));
		    byte[] digest = md.digest();
		    passEncode = DatatypeConverter.printHexBinary(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PasswordEncoderGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    	
		return passEncode;
    	
    }
}

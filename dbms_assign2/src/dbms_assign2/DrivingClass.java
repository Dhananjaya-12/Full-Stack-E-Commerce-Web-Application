
package dbms_assign2;


import java.sql.*;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException; 
import javax.swing.JOptionPane;

public class DrivingClass {
    
    final int EMAIL_EXIST = 1;
    final int USERID_EXIST = 2;
    final int PHONENUMBER_EXIST = 3;
    final int INVALID_PASSWORD_FORMAT = 6;
    final int PASSWORD_MISSMATCH = 5;
    final int INVALID_PHONENUMBER_FORMAT = 4;
    
    
    
    
    
    protected static Connection con ;
    protected static PreparedStatement st;
    protected static ResultSet rt;
    String firstName;
    String lastName;
    String emailID;
    String userID;
    String phoneNumber;
    String homeAddress;
    String errorMessage;
    
    final int minPasswordLength = 8;
    final int maxPasswordLength = 50;
    
    

    
     static boolean setUpConnection(){
            try{
                JOptionPane.showMessageDialog(null,"Application is starting","Running", JOptionPane.INFORMATION_MESSAGE);

              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tt?autoReconnect=true&useSSL=false","client","Client123!");
              return true;
            }catch(SQLException e){
                  JOptionPane.showMessageDialog(null,"Couldn't Connect to our database, try running MYSQL80 Service","Error", JOptionPane.INFORMATION_MESSAGE);
                  return false;
            }
    }
    
    public static void main(String[] args) throws SQLException{
        
        
       
        if(DrivingClass.setUpConnection()){
        login user = new login();
        user.setVisible(true);
        user.setLocationRelativeTo(null);
        }
        
        
    }
    
   protected boolean validateUser(String username, String password) throws SQLException, NoSuchAlgorithmException{
      
        
        st = con.prepareCall("SELECT * FROM userData WHERE email_addr = ? OR phone_number = ? OR userid = ?");
        st.setString(1, username);
        st.setString(2, username);
        st.setString(3, username);
        rt = st.executeQuery();
        String hashPassword = hashValue(generateHash(password));
        while(rt.next()){
            
            if((rt.getString("email_addr").equals(username) || rt.getString("phone_number").equals(username) || rt.getString("userid").equals(username)) && rt.getString("passcode").equals(hashPassword)){
             this.firstName = rt.getString("first_name").toUpperCase();
             this.lastName = rt.getString("last_name").toUpperCase();
             this.emailID = rt.getString("email_addr");
             this.homeAddress = rt.getString("address");
             this.phoneNumber = rt.getString("phone_number");
             
            return true;
                
            }

        }

        return false;

    }
   public int registerUser(String firstName, String lastName, String emailID, String userID, String password, String rePassword, String phoneNumber, String homeAddress) throws SQLException, NoSuchAlgorithmException{
        int retValue = -1;
         if(!(firstName.equals("") || lastName.equals("")|| emailID.equals("")||userID.equals("")||password.equals("")||rePassword.equals("")||homeAddress.equals("")||phoneNumber.equals(""))){  
         
             retValue = checkUserExist(emailID, userID, phoneNumber);
             if(retValue == -1){
                 
             if(validatePhoneNumber(phoneNumber)){
                     
                     
             if(doesPasswordMatch(password, rePassword)){
                 
                 
                if(validatePassword(password)){
                 
             this.firstName = firstName;
             this.lastName = lastName;
             this.emailID = emailID;
             this.userID = userID;
             this.homeAddress = homeAddress;
             this.phoneNumber = phoneNumber;
                 
                 
                 st = con.prepareCall("INSERT INTO userData (first_name, last_name, email_addr, passcode, address, phone_number, userid) VALUES (?,?,?,?,?,?,?)");
                 st.setString(1, firstName);
                 st.setString(2, lastName);
                 st.setString(3, emailID);
                 st.setString(4, hashValue(generateHash(password)));
                 st.setString(5, homeAddress);
                 st.setString(6, phoneNumber);
                 st.setString(7, userID);
                 
                 st.executeUpdate();
                 
                 return 0;
                }else{
                    retValue = INVALID_PASSWORD_FORMAT;
                    } 
             }else{
                 retValue = PASSWORD_MISSMATCH;
                }
        }else{
            retValue = INVALID_PHONENUMBER_FORMAT;
            }   
            }else{
                 return retValue;
             }
             
         }
            
            return retValue;
         
        

    }
    
 private int checkUserExist(String emailID, String userID, String phoneNumber) throws SQLException{
        
        st =con.prepareCall("SELECT email_addr, userid, phone_number FROM userData");
        
        
        
        rt = st.executeQuery();
        
        
        while(rt.next()){
            
            if(rt.getString("email_addr").equals(emailID))
                return EMAIL_EXIST;
            if(rt.getString("userid").equals(userID))
                return USERID_EXIST;
            if(rt.getString("phone_number").equals(phoneNumber))
                return PHONENUMBER_EXIST;

        }
            
        return -1;
        
        
        
    }
  
  boolean doesPasswordMatch(String password, String rePassword){
      
      return password.equals(rePassword);
      
      
  }
    
public boolean validatePassword(String password){
 
       boolean capsChar = false;
       boolean splChar = false;
       boolean numberExist = false;
       boolean validLength = false;
       String[] passwordArray = password.split("");
        if(password.length() >= minPasswordLength && password.length() <= maxPasswordLength )
            validLength = true;
         for(int i = 0 ;i<password.length();i++){
             if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                 capsChar = true; break;  
             }
         }
         for(int i = 0 ;i<password.length();i++){
             if((password.charAt(i) >= 32 && password.charAt(i) <= 47) || (password.charAt(i) >= 58 && password.charAt(i) <= 64)){
                 splChar = true;
                 break;
         }
         }
   
         
           for (String passwordArray1 : passwordArray) {
               try{
               if (Integer.parseInt(passwordArray1) >= 0 && Integer.parseInt(passwordArray1) <= 9) {
                   numberExist = true;
                   
                   break;
               }
           
           } catch(NumberFormatException e){}
               
           }
 

       return capsChar && splChar && numberExist && validLength;
     

}

public static byte[] generateHash(String input) throws NoSuchAlgorithmException 
    {  
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
    
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String hashValue(byte[] hash) 
    { 
      
        BigInteger number = new BigInteger(1, hash);  
  
 
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  

        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 
  

  
  
  
  
  
 static boolean validatePhoneNumber(String phNumber){
try{
  return Integer.parseInt(Character.toString(phNumber.charAt(0)))>=6 && Integer.parseInt(Character.toString(phNumber.charAt(0)))<=9 && phNumber.length() == 10;
}catch(Exception e){
    return false;
}
 
  
}

 

    
}

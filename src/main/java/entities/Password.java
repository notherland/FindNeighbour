package entities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Password class represents user's password
 */
public class Password {
    /**
     * String representing of hash os password
     */
    private String passHash;

    /**
     * Constructor without parameters
     */
    public Password(){}

    /**
     * Constructor with parameters
     * @param password
     * @param salt
     */
    public Password (String password, String salt){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();

            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    /**
     * Get method returns password as String
     * @return
     */
    public String getPassword(){
        return passHash;
    }

    /**
     * Set method sets password's hash
     * @param PassHash
     */
    public void setPassHash(String PassHash){
        this.passHash = PassHash;
    }

    /**
     * @param password
     * @return true if passwords are equal else false
     */
    public boolean isEqual(Password password){
        if (this.passHash.equals(password.getPassword()))
            return true;
        else return false;
    }
}

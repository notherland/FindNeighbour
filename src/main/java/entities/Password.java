package entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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
    public Password(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update((password + salt).getBytes());
        byte[] bytes = md.digest();

        passHash = Base64.getEncoder().encodeToString(bytes);
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


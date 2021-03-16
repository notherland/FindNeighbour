package entities;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    private String passHash;

    public Password(){}

    public Password (String password, String salt){
        System.out.println("PASSWORD" + " " + password+" "+salt);
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

    public String getPassword(){
        return passHash;
    }

    public void setPassHash(String PassHash){
        this.passHash = PassHash;
    }

    public boolean isEqual(Password password){
        System.out.println(password.getPassword() +" "+ this.passHash);
        if (this.passHash.equals(password.getPassword()))
            return true;
        else return false;
    }
}

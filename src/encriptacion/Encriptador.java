/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptacion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class Encriptador {
    private static Encriptador instancia;
    
    public static Encriptador getInstancia(){
        if(instancia==null)
            instancia = new Encriptador();
        return instancia;
    }
    
    public String SHA256(String password) throws NoSuchAlgorithmException{
            
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-256");
        msdDigest.update(password.getBytes(), 0, password.length());
        password = DatatypeConverter.printHexBinary(msdDigest.digest());
            
        return password;
    }
}

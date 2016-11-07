/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Denilson
 */
public class Criptografia {
    private static String msgCifrada = null;
    private static String msgDecifrada = null;
    private static BigInteger n, d, e;
    private static int bitlen = 200;
    private static SecureRandom r = new SecureRandom();
    private static BigInteger p = new BigInteger(bitlen/2,100, r);
    private static BigInteger q = new BigInteger(bitlen/2,100, r);
    
    public String Cifrar(String mensagem){
        n = p.multiply(q);
        
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
        e = new BigInteger("3");
        while(m.gcd(e).intValue()>1) e = e.add(new BigInteger("2"));
        
        d = e.modInverse(m);
        
        msgCifrada = new BigInteger(mensagem.getBytes()).modPow(e, n).toString();
        return msgCifrada;
    }
}

package yuuyuu244.crypto;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Let's use Java - AES.
 * $Author: yuuyuu244 $
 * 
 * [refference](http://itmemo.net-luck.com/java-aes/)
 *
 */
public class AesCrypto {
    /** 暗号方式 */
    public static final String CRYPT_ALGORITHM_AES = "AES";
    
    /** 変換方式 */
    public static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    
    
    /**
     * encryption by using AES
     * @throws NoSuchPaddingException 
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeyException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws InvalidAlgorithmParameterException 
     */
    public static byte[] encrypto(AesParam param, byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        
        
        
        cipher.init(Cipher.ENCRYPT_MODE, param.getKey());
        //param.setIv(cipher.getIV());
        System.out.println("getIV : "+cipher.getIV());
        return cipher.doFinal(data);
    }
    
    public static byte[] decrypto(AesParam param, byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        
        IvParameterSpec ivSpec = new IvParameterSpec(param.getIv());
        
        
        cipher.init(Cipher.DECRYPT_MODE, param.getKey(), ivSpec);
        return cipher.doFinal(data);

    }
    
 // 暗号化アルゴリズムに応じた鍵を生成する
    public static Key genKey() throws NoSuchAlgorithmException {
      KeyGenerator generator = KeyGenerator.getInstance("AES");
      // 乱数の発生源を作成します 指定できるのはSHA1PRNGのみ
      SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
      // 第一引数にキー長のbit数を指定します
      generator.init(128, random);
      return generator.generateKey();
    }
}

package yuuyuu244.crypto;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
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
    
    private static byte[] iv;
    
    public static void main( String[] args ) {
        
        String data = "i am stupid.";
        
        byte[] encKey = "kagikagikagikiga".getBytes();
        Key key = new SecretKeySpec(encKey, CRYPT_ALGORITHM_AES);
        try {
            byte[] result = encrypto(key, data.getBytes());
            System.out.println(result);
            System.out.println(result.toString());
            System.out.println(AesCrypto.iv);
            
            byte[] dec_result = decrypto(key, result, iv);
            System.out.println(dec_result);
            System.out.println(dec_result.toString());
            
        } catch (InvalidKeyException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }
    
    /**
     * encryption by using AES
     * @throws NoSuchPaddingException 
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeyException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     */
    public static byte[] encrypto(Key key, byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        AesCrypto.iv = cipher.getIV();
        return cipher.doFinal(data);
    }
    
    public static byte[] decrypto(Key key, byte[] data, byte[] iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        AlgorithmParameters algParam = AlgorithmParameters.getInstance(CRYPT_ALGORITHM_AES);
        algParam.init(iv);
        cipher.init(Cipher.DECRYPT_MODE, key, algParam);
        return cipher.doFinal(data);
        
    }
}

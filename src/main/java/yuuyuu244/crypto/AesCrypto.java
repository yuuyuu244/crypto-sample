package yuuyuu244.crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Hello world!
 *
 */
public class AesCrypto {
    /** 暗号方式 */
    public static final String CRYPT_ALGORITHM_AES = "AES";
    
    /** 変換方式 */
    public static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    
    public static void main( String[] args ) {
        
        String data = "i am stupid.";
        
        byte[] encKey = "kagikagikagikiga".getBytes();
        Key key = new SecretKeySpec(encKey, CRYPT_ALGORITHM_AES);
        try {
            byte[] result = encrypto(key, data.getBytes());
            System.out.println(result);
            System.out.println(result.toString());
            
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
        return cipher.doFinal(data);
    }
    
    public static void decrypto() {
        
        
    }
}

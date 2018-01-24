package yuuyuu244.crypto;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class AesCryptoTest extends TestCase {


    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    
    
    @Test
    public void check() throws Exception {
        String data = "i am stupid.";
        
        //String encKey = "kagikagikagikiga";
        //System.out.println(encKey.length());
        //String iv = "iviviviviviviviv";
        AesParam param = new AesParam();
        param.setKey(AesCrypto.genKey());
        byte[] iv = "iv".getBytes();
        System.out.println("iv:"+iv.toString());
        param.setIv(iv);
        
        System.out.println("{String :" + data.toString() + ", byte :" + data.getBytes() + "} ");
        byte[] result = AesCrypto.encrypto(param, data.getBytes());
        
        System.out.println(result);
        System.out.println(result.toString());
        System.out.println("IV(mine)"+param.getIv().toString()+" key:"+param.getKey());
        
        byte[] dec_result = AesCrypto.decrypto(param, result);
        System.out.println(dec_result);
        System.out.println(dec_result.toString());
        
        assertThat(result , is(dec_result));

    }
    
    @Test
    public void check_02() throws Exception {
        
    }
}

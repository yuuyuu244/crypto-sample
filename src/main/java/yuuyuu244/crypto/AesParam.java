package yuuyuu244.crypto;

import java.security.Key;

import lombok.Getter;
import lombok.Setter;

public class AesParam {
    
    @Getter
    @Setter
    private byte[] iv;
    
    @Getter
    @Setter
    private Key key;

}

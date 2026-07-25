import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.sqa.lab.ShiftCipher;


class TestShiftCipher {

    private ShiftCipher cipher;

    @BeforeEach
    void setUp() {
        cipher = new ShiftCipher();
    }

    @ParameterizedTest
    @CsvSource({
        "ATTACK, 0, ATTACK",   
        "HELLO,  17, YVCCF",   
        "WORLD,  -5, RJMGY", 
        "MIND,   30, QMRH" ,
        "attack, 17, RKKRTB"
    })
    void encrypt_validText_validKey_weakRobust(String plainText, int key, String expected) {
        assertEquals(expected, cipher.encrypt(plainText, key));
    }



    @ParameterizedTest
    @ValueSource(strings = {"ATTACK123", "ATTACK$$"})
    void encrypt_nonLetterCharacters_throwsException(String invalidText) {
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt(invalidText, 17));
    }

    @Test
    void encrypt_nullText_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> cipher.encrypt(null, -5));
    }
    
    @Test
    void encryt_nullKey_ThrowsException() {
    	assertThrows(IllegalArgumentException.class, () -> cipher.encrypt("", 17));
    }


    @ParameterizedTest
    @CsvSource({
        "ATTACK, 0, ATTACK",   
        "YVCCF,  17, HELLO",   
        "RJMGY,  -5, WORLD",   
        "QMRH,   30, MIND",
        "rkkrtb, 17, ATTACK"
    })
    void decrypt_validText_validKey_weakNormal(String cipherText, int key, String expected) {
        assertEquals(expected, cipher.decrypt(cipherText, key));
    }


    @ParameterizedTest
    @ValueSource(strings = {"WVCCF4", "HIHI$$"})
    void decrypt_nonLetterCharacters_throwsException(String invalidText) {
        assertThrows(IllegalArgumentException.class, () -> cipher.decrypt(invalidText, 17));
    }


    @Test
    void decrypt_nullText_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> cipher.decrypt(null, 17));
    }


    
}
package com.skilldistillery.caesarcipher;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTests {
  private CaesarCipher cipher;

  @Before
  public void setUp() throws Exception {
    cipher = new CaesarCipher();
  }

  @After
  public void tearDown() throws Exception {
    cipher = null;
  }

  @Test
  public void test_encrypt_with_null_value_returns_null() {
    assertNull(cipher.encrypt(null, 0));
  }
  
  @Test
  public void test_encrypt_with_non_null_value_returns_non_null() {
    assertNotNull(cipher.encrypt("", 0));
  }
  
  @Test
  public void test_decrypt_with_null_value_returns_null() {
    assertNull(cipher.decrypt(null, 0));
  }
  
  @Test
  public void test_decrypt_with_non_null_value_returns_non_null() {
    assertNotNull(cipher.decrypt("", 0));
  }
  
  @Test
  public void test_encrypt_uppercase_shifts_by_correct_amount() {
    String clearText = "ABCDELMNOP";
    int shift = 7;
    String expected = "HIJKLSTUVW";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_encrypt_uppercase_wraps_at_end_of_alphabet() {
    String clearText = "ABCXYZ";
    int shift = 7;
    String expected = "HIJEFG";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_decrypt_uppercase_shifts_by_correct_amount() {
    String cipherText = "RSTYZA";
    int shift = 8;
    String expected = "JKLQRS";
    String result = cipher.decrypt(cipherText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_decrypt_uppercase_wraps_at_beginning_of_alphabet() {
    String cipherText = "CDEIJK";
    int shift = 11;
    String expected = "RSTXYZ";
    String result = cipher.decrypt(cipherText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_encrypt_lowercase_shifts_by_correct_amount() {
    String clearText = "abcdelmnop";
    int shift = 7;
    String expected = "hijklstuvw";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_encrypt_lowercase_wraps_at_end_of_alphabet() {
    String clearText = "abcxyz";
    int shift = 7;
    String expected = "hijefg";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_decrypt_lowercase_shifts_by_correct_amount() {
    String cipherText = "rstyza";
    int shift = 8;
    String expected = "jklqrs";
    String result = cipher.decrypt(cipherText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_decrypt_lowercase_wraps_at_beginning_of_alphabet() {
    String cipherText = "cdeijk";
    int shift = 11;
    String expected = "rstxyz";
    String result = cipher.decrypt(cipherText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_encrypt_mixedcase_shifts_by_correct_amount() {
    String clearText = "abCdeLMnoP";
    int shift = 7;
    String expected = "hiJklSTuvW";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_encrypt_mixedcase_wraps_at_end_of_alphabet() {
    String clearText = "aBcxyZ";
    int shift = 7;
    String expected = "hIjefG";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_decrypt_mixedcase_shifts_by_correct_amount() {
    String cipherText = "rSTyzA";
    int shift = 8;
    String expected = "jKLqrS";
    String result = cipher.decrypt(cipherText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_decrypt_mixedcase_wraps_at_beginning_of_alphabet() {
    String cipherText = "CdeiJk";
    int shift = 11;
    String expected = "RstxYz";
    String result = cipher.decrypt(cipherText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_encrypt_mixedcase_handles_excess_shift() {
    String clearText = "abCdeLMnoP";
    int shift = 377;
    String expected = "noPqrYZabC";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_decrypt_mixedcase_handles_excess_shift() {
    String clearText = "xyZabIJklM";
    int shift = 231;
    String expected = "abCdeLMnoP";
    String result = cipher.decrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_encrypt_phrase_preserves_spaces() {
    String clearText = "Cat Dog   Frog";
    int shift = 9;
    String expected = "Ljc Mxp   Oaxp";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_decrypt_phrase_preserves_spaces() {
    String cipherText = "Ljc Mxp   Oaxp";
    int shift = 9;
    String expected = "Cat Dog   Frog";
    String result = cipher.decrypt(cipherText, shift);
    assertEquals(expected, result);
  }

  @Test
  public void test_encrypt_phrase_preserves_non_alpha() {
    String clearText = "Hello - This message is \"encrypted\": good luck!";
    int shift = 12;
    String expected = "Tqxxa - Ftue yqeemsq ue \"qzodkbfqp\": saap xgow!";
    String result = cipher.encrypt(clearText, shift);
    assertEquals(expected, result);
  }
  @Test
  public void test_decrypt_phrase_preserves_non_alpha() {
    String cipherText = "Tqxxa - Ftue yqeemsq ue \"qzodkbfqp\": saap xgow!";
    int shift = 12;
    String expected = "Hello - This message is \"encrypted\": good luck!";
    String result = cipher.decrypt(cipherText, shift);
    assertEquals(expected, result);
  }

}

//package com.thoughtworks.training.HuangYanyan.todoserice;
//
//import org.junit.Test;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import static junit.framework.TestCase.assertTrue;
//
//public class PasswordTest {
//    @Test
//    public void shouldEncrypPassword(){
//         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//         String encodePassword = encoder.encode("password");
//
//        System.out.println(encoder.encode("password"));
//        System.out.println(encoder.encode("password"));
//        System.out.println(encoder.encode("password"));
//        System.out.println(encoder.encode("password"));
//
//
//        assertTrue(encoder.matches("password",encodePassword));
//        assertTrue(encoder.matches("password","$2a$10$6eDac3.a2W4BhPE43aErKOx7ab1AiX3Y3DCBtrqQWIrgtoIKfLG4y"));
//    }
//}

package com.ting.tingspring.utils;



import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA加密解密
 *
 * @author LISHUANG
 * @date 2019/12/20
 */
public class RSAUtils {

    /**
     * 公钥
     */
    public static final String PUBLIC_KEY = "publickey";

    /**
     * 私钥
     */
    public static final String PRIVATE_KEY = "privatekey";

    public static void main(String[] args) throws Exception {

        String data = "Hello world";
        RSAUtils rsaUtils = new RSAUtils();
        //加密 encrypt
        String encrypt = rsaUtils.encrypt(data, PUBLIC_KEY);
        System.out.println("加密后的密文：" + encrypt);

        // 解密后的明文


    }

    /**
     * 加密数据
     *
     * @param data      加密的数据
     * @param publicKey 加密的公钥
     * @return 加密后的私文
     * @throws Exception 加密失败的异常
     */
    private String encrypt(String data, String publicKey) throws Exception {
        byte[] bytes = Base64.decodeBase64(publicKey);
        RSAPublicKey rsaPublicKey = null;
        String encryptData = null;

        rsaPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytes));
        Cipher rsa = Cipher.getInstance("RSA");

        // 加密模式
        rsa.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
        encryptData = Base64.encodeBase64String(rsa.doFinal(data.getBytes("UTF-8")));


        return encryptData;
    }


    /**
     * 解密数据
     *
     * @param encryptData 需要解密的数据
     * @param privateKey  私钥
     * @return 解密后的数据
     * @throws Exception 解密失败的异常
     */
    public String decrypt(String encryptData, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(encryptData.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;

    }

}

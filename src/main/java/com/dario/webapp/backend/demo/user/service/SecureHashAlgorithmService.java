package com.dario.webapp.backend.demo.user.service;


import com.dario.webapp.backend.demo.utls.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Slf4j
public class SecureHashAlgorithmService {

    public MessageDigest getSHA256Instance(String algorithm) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }

    public String encryptPassword(MessageDigest digest, String plainPassword) {
        byte[] hash = digest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));
        return StringUtils.convertByteArrayToHexString(hash);
    }
}
